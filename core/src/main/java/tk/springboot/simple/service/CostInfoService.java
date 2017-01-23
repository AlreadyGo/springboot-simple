package tk.springboot.simple.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.springboot.simple.exceptions.BizException;
import tk.springboot.simple.mapper.CostInfoMapper;
import tk.springboot.simple.model.CostInfo;
import tk.springboot.simple.model.enums.CostStatus;

import java.util.Date;
import java.util.List;

/**
 * Created by zhou on 2017/1/17.
 */
@Service
public class CostInfoService extends BaseService{
    @Autowired
    private CostInfoMapper costInfoMapper;
    @Autowired
    private OrderService orderService;
    public List<CostInfo> getAll(CostInfo CostInfo) throws Exception{
        String sort=CostInfo.getSort(),order=CostInfo.getOrder(),orderNum=CostInfo.getOrderNum(),orderNumCondition="";
        Integer dateRange=CostInfo.getDateRange();
        if(!StringUtils.isEmpty(orderNum)){
            if(orderService.getOrderInfoByNum(orderNum)==null) throw new Exception("该订单不存在");
            orderNumCondition=String.format("order_num='%s'",orderNum);
        }
        return costInfoMapper.selectByExample(createDateRangeExample(CostInfo.class,order,sort,dateRange,orderNumCondition));
    }

    public int getCount(CostInfo CostInfo){
        return costInfoMapper.selectCount(CostInfo);
    }

    public CostInfo getById(Integer id) {
        return costInfoMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id) {
        costInfoMapper.deleteByPrimaryKey(id);
    }

    public void save(CostInfo costInfo) {
        if (costInfo.getId() != null) {
            costInfo.setUpdateDate(new Date());
            costInfoMapper.updateByPrimaryKey(costInfo);
        } else {
            Date date=new Date();
            costInfo.setCreateDate(date);
            costInfo.setUpdateDate(date);
            if(StringUtils.isEmpty(costInfo.getCostStatus()))
            costInfo.setCostStatus(CostStatus.可修改);
            costInfoMapper.insert(costInfo);
        }
    }

    public void rejectCostStatus(CostInfo costInfo) throws BizException {
        updateCostStatus(CostStatus.待提交,costInfo,"只能拒绝待提交的记录");
    }

    public void submitCostStatus(CostInfo costInfo) throws BizException {
        updateCostStatus(CostStatus.待提交,costInfo,"不允许重复的提交");
    }

    public void applyCostStatus(CostInfo costInfo) throws BizException {
        updateCostStatus(CostStatus.已提交,costInfo,"不允许重复申请");
    }

    public void checkCostStatus(CostInfo costInfo) throws BizException {
        updateCostStatus(CostStatus.已申请,costInfo,"不允许重复的审批");
    }

    private void updateCostStatus(CostStatus exist,CostInfo costInfo,String message) throws BizException {
        CostInfo existed=costInfoMapper.selectByPrimaryKey(costInfo);
        if(existed!=null && existed.getCostStatus().equals(exist)) {
            costInfoMapper.updateByPrimaryKeySelective(costInfo);
        }else{
            throw new BizException(message);
        }
    }
}

