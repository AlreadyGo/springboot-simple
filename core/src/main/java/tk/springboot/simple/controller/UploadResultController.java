package tk.springboot.simple.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.springboot.simple.model.UploadResult;
import tk.springboot.simple.model.RespInfo;
import tk.springboot.simple.model.enums.UploadType;
import tk.springboot.simple.service.UploadResultService;
import tk.springboot.simple.util.Consts;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/uploadResult")
public class UploadResultController extends BaseController{

    @Autowired
    private UploadResultService uploadResultService;

    @RequestMapping("/all")
    public List<UploadResult> getAll(UploadResult uploadResult) {
        return uploadResultService.getAll(uploadResult);
    }

    @RequestMapping(value = "/view/{uploadType}")
    public Object view(@PathVariable UploadType uploadType,UploadResult uploadResultView) {
        List<JSONObject> list=new ArrayList<>();
        uploadResultView.setUploadType(uploadType);
        List<UploadResult> uploadResults = uploadResultService.getByType(uploadResultView);
        if(uploadResults.size()>0){
            for(UploadResult uploadResult:uploadResults){
                Date date=uploadResult.getCreateDate();
                JSON.parseArray(uploadResult.getDetail()).stream().forEach(o->{
                    JSONObject per=(JSONObject)o;
                    per.put("createDate",date);
                    list.add(per);
                });

            }
        }
        return list;
    }


}
