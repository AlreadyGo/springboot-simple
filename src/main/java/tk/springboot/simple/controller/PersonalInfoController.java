package tk.springboot.simple.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.comm.model.SheetBean;
import tk.comm.model.UploadFile;
import tk.comm.utils.DownUploadUtil;
import tk.comm.utils.ExcelUtil;
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

import static tk.springboot.simple.util.Consts.STATUS_FAILURE;
import static tk.springboot.simple.util.Consts.STATUS_SUCCESS;

@RestController
@RequestMapping("/personalInfo")
public class PersonalInfoController extends BaseController{

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
        return new RespInfo(Consts.SUCCESS_CODE,personalInfo);
    }

    @RequestMapping(value = "/delete/{id}")
    public RespInfo delete(@PathVariable Integer id) {
        personalInfoService.deleteById(id);
        return new RespInfo(Consts.SUCCESS_CODE,null,"删除成功");
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public RespInfo save(@RequestBody PersonalInfo personalInfo) {
        String msg = personalInfo.getId() == null ? "添加成功" : "修改成功";
        personalInfoService.save(personalInfo);
        return new RespInfo(Consts.SUCCESS_CODE,personalInfo,msg);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public RespInfo upload(HttpServletRequest request) {
        List<UploadFile> files= DownUploadUtil.upload(request);
        RespInfo respInfo=new RespInfo(Consts.SUCCESS_CODE,null,"上传成功");
        JSONArray jsonArray=new JSONArray();
        boolean isPartFailed=false;
        for(UploadFile file:files){
            try {
                String originalName=file.getOriginalFilename();
                List<SheetBean> sheetBeans= ExcelUtil.readExcel(file.getInputStream(),originalName.substring(originalName.lastIndexOf(".")+1));
                List<PersonalInfo> personalInfos=UploadExcelRules.parsePersonalInfos(sheetBeans);
                if(personalInfos.size()>0){
                    for(PersonalInfo personalInfo:personalInfos){
                        String status;
                        try{
                            personalInfoService.save(personalInfo);
                            status=STATUS_SUCCESS;
                        } catch (Exception ex){
                            status=STATUS_FAILURE;
                            if(!isPartFailed){
                                isPartFailed=true;
                            }
                        }
                        saveUploadResult(jsonArray,personalInfo,status);
                    }
                }else{
                    respInfo.setStatus(Consts.ERROR_CODE);
                    respInfo.setMessage("上传失败");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(jsonArray.size()>0){
            uploadResultService.save(new UploadResult(new Date(),jsonArray.toJSONString(),UploadType.PERSONALINFO));
        }
        if(isPartFailed){
            respInfo.setMessage("部分上传失败");
            respInfo.setStatus(Consts.ERROR_CODE);
        }
        return respInfo;
    }

    public void saveUploadResult(JSONArray jsonArray,PersonalInfo personalInfo,String result){
        JSONObject jsonObject= (JSONObject) JSON.toJSON(personalInfo);
        jsonObject.put("status",result);
        jsonArray.add(jsonObject);
    }
}
