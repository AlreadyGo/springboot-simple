package tk.springboot.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.springboot.simple.exceptions.BizException;
import tk.springboot.simple.model.CostInfo;
import tk.springboot.simple.model.RespInfo;
import tk.springboot.simple.service.CostInfoService;
import tk.springboot.simple.util.Consts;

/**
 * Created by Administrator on 2017/1/17.
 */
@RestController
@RequestMapping("/fundsApp")
public class FundsAppController extends BaseController{

    @Autowired
    private CostInfoService CostInfoService;


    @RequestMapping(value = "/applyCostStatus", method = RequestMethod.POST)
    public RespInfo applyCostStatus(@RequestBody CostInfo CostInfo) throws BizException {
        CostInfoService.applyCostStatus(CostInfo);
        return new RespInfo(Consts.SUCCESS_CODE,CostInfo,"申请成功");
    }

    @RequestMapping(value = "/checkCostStatus", method = RequestMethod.POST)
    public RespInfo checkCostStatus(@RequestBody CostInfo CostInfo) throws BizException {
        CostInfoService.checkCostStatus(CostInfo);
        return new RespInfo(Consts.SUCCESS_CODE,CostInfo,"审批成功");
    }

    @RequestMapping(value = "/submitCostStatus", method = RequestMethod.POST)
    public RespInfo submitCostStatus(@RequestBody CostInfo CostInfo) throws BizException {
        CostInfoService.submitCostStatus(CostInfo);
        return new RespInfo(Consts.SUCCESS_CODE,CostInfo,"提交成功");
    }

}
