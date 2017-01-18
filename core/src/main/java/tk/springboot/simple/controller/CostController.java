package tk.springboot.simple.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.springboot.simple.model.CostInfo;
import tk.springboot.simple.model.RespInfo;
import tk.springboot.simple.service.CostInfoService;
import tk.springboot.simple.util.Consts;

/**
 * Created by Administrator on 2017/1/17.
 */
@RestController
@RequestMapping("/costMaintainInfo")
public class CostController extends BaseController{

    @Autowired
    private CostInfoService CostInfoService;



    @RequestMapping("/all")
    public RespInfo getAll(CostInfo CostInfo) throws Exception {
        RespInfo res=new RespInfo(Consts.SUCCESS_CODE, CostInfoService.getAll(CostInfo));

        return res;

    }

    @RequestMapping(value = "/view/{id}")
    public RespInfo view(@PathVariable Integer id) {
        CostInfo CostInfo = CostInfoService.getById(id);
        return new RespInfo(Consts.SUCCESS_CODE,CostInfo);
    }

    @RequestMapping(value = "/delete/{id}")
    public RespInfo delete(@PathVariable Integer id){
        CostInfoService.deleteById(id);
        return new RespInfo(Consts.SUCCESS_CODE,null,"删除成功");
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public RespInfo save(@RequestBody CostInfo CostInfo) {
        String msg = CostInfo.getId() == null ? "添加成功" : "修改成功";
        CostInfoService.save(CostInfo);
        return new RespInfo(Consts.SUCCESS_CODE,CostInfo,msg);
    }



    public void saveUploadResult(JSONArray jsonArray,CostInfo CostInfo,String result){
        JSONObject jsonObject= (JSONObject) JSON.toJSON(CostInfo);
        jsonObject.put("status",result);
        jsonArray.add(jsonObject);
    } 
}
