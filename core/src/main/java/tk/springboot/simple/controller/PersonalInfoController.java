package tk.springboot.simple.controller;

import com.alibaba.fastjson.JSONArray;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.comm.model.SheetBean;
import tk.comm.model.UploadFile;
import tk.comm.utils.DownUploadUtil;
import tk.comm.utils.ExcelUtil;
import tk.springboot.simple.exceptions.BizException;
import tk.springboot.simple.model.PersonalInfo;
import tk.springboot.simple.model.RespInfo;
import tk.springboot.simple.model.UploadResult;
import tk.springboot.simple.model.enums.UploadType;
import tk.springboot.simple.service.PersonalInfoService;
import tk.springboot.simple.service.UploadResultService;
import tk.springboot.simple.util.Consts;
import tk.springboot.simple.util.UploadExcelRules;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

import static tk.springboot.simple.util.Consts.*;

@RestController
@RequestMapping("/personalInfo")
public class PersonalInfoController extends BaseController {

    @Autowired
    private PersonalInfoService personalInfoService;

    @Autowired
    private UploadResultService uploadResultService;

    @RequestMapping("/all")
    public List<PersonalInfo> getAll(PersonalInfo personalInfo) {
        return personalInfoService.getAll(personalInfo);
    }

    @RequestMapping(value = "/view/{id}")
    public RespInfo view(@PathVariable Integer id) {
        PersonalInfo personalInfo = personalInfoService.getById(id);
        return new RespInfo(Consts.SUCCESS_CODE, personalInfo);
    }

    @RequestMapping(value = "/delete/{id}")
    public RespInfo delete(@PathVariable Integer id) {
        personalInfoService.deleteById(id);
        return new RespInfo(Consts.SUCCESS_CODE, null, "删除成功");
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public RespInfo save(@RequestBody PersonalInfo personalInfo) {
        String msg = personalInfo.getId() == null ? "添加成功" : "修改成功";
        personalInfoService.save(personalInfo);
        return new RespInfo(Consts.SUCCESS_CODE, personalInfo, msg);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public RespInfo upload(HttpServletRequest request) throws Exception {
        List<UploadFile> files = DownUploadUtil.upload(request);
        RespInfo respInfo = new RespInfo(Consts.SUCCESS_CODE, null, "上传成功");
        JSONArray jsonArray = new JSONArray();
        boolean isPartSuccess = false, isPartFailed = false;
        for (UploadFile file : files) {
            String originalName = file.getOriginalFilename();
            List<SheetBean> sheetBeans = ExcelUtil.readExcel(file.getInputStream(), originalName.substring(originalName.lastIndexOf(".") + 1));
            List<PersonalInfo> personalInfos = UploadExcelRules.parsePersonalInfos(sheetBeans);
            if (personalInfos.size() > 0) {
                for (PersonalInfo personalInfo : personalInfos) {
                    String status;
                    String errorReason = null;
                    try {
                        doValid(personalInfo);
                        personalInfoService.save(personalInfo);
                        status = STATUS_SUCCESS;
                        isPartSuccess = true;
                    } catch (Exception ex) {
                        status = STATUS_FAILURE;
                        if (!isPartFailed) {
                            isPartFailed = true;
                        }
                        errorReason = DUPLICATED_MESSAGE;
                        ex.printStackTrace();
                        if (ex instanceof BizException) {
                            errorReason = ex.getMessage();
                        }
                    }
                    saveUploadResult(jsonArray, personalInfo, status, errorReason);
                }
            } else {
                respInfo.setStatus(Consts.ERROR_CODE);
                respInfo.setMessage("上传失败");
            }
        }
        if (jsonArray.size() > 0) {
            uploadResultService.save(new UploadResult(new Date(), jsonArray.toJSONString(), UploadType.PERSONALINFO));
        }
        if (isPartSuccess && isPartFailed) {
            respInfo.setMessage("部分上传成功");
        }
        if (!isPartSuccess && isPartFailed) {
            respInfo.setMessage("上传失败");
            respInfo.setStatus(Consts.ERROR_CODE);
        }
        return respInfo;
    }

    private void doValid(PersonalInfo personalInfo) throws BizException {
        if (StringUtils.isEmpty(personalInfo.getDriverName())) throw new BizException("司机名不能为空");
    }

}
