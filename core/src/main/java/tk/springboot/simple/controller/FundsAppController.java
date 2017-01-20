package tk.springboot.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tk.springboot.simple.exceptions.BizException;
import tk.springboot.simple.model.CostInfo;
import tk.springboot.simple.model.FundsStatisticsInfo;
import tk.springboot.simple.model.RespInfo;
import tk.springboot.simple.service.CostInfoService;
import tk.springboot.simple.service.FundsStatisticsInfoService;
import tk.springboot.simple.util.Consts;

/**
 * Created by Administrator on 2017/1/17.
 */
@RestController
@RequestMapping("/fundsApp")
public class FundsAppController extends BaseController {

    @Autowired
    private CostInfoService costInfoService;
    @Autowired
    private FundsStatisticsInfoService fundsStatisticsInfoService;

    @RequestMapping(value = "/applyCostStatus", method = RequestMethod.POST)
    public RespInfo applyCostStatus(@RequestBody CostInfo costInfo) throws BizException {
        costInfoService.applyCostStatus(costInfo);
        return new RespInfo(Consts.SUCCESS_CODE, costInfo, "申请成功");
    }

    @RequestMapping(value = "/checkCostStatus", method = RequestMethod.POST)
    public RespInfo checkCostStatus(@RequestBody CostInfo costInfo) throws BizException {
        FundsStatisticsInfo fsi=new FundsStatisticsInfo();
        fsi.setOrderNum(costInfo.getOrderNum());
        fundsStatisticsInfoService.save(fsi);
        costInfoService.checkCostStatus(costInfo);

        return new RespInfo(Consts.SUCCESS_CODE, costInfo, "审批成功");
    }

    @RequestMapping(value = "/submitCostStatus", method = RequestMethod.POST)
    public RespInfo submitCostStatus(@RequestBody CostInfo costInfo) throws BizException {
        costInfoService.submitCostStatus(costInfo);
        return new RespInfo(Consts.SUCCESS_CODE, costInfo, "提交成功");
    }

}
