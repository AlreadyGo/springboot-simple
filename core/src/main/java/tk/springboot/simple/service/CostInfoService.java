package tk.springboot.simple.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.springboot.simple.mapper.CostInfoMapper;
import tk.springboot.simple.model.CostInfo;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/1/17.
 */
@Service
public class CostInfoService extends BaseService{
    @Autowired
    private CostInfoMapper CostInfoMapper;
    @Autowired
    private OrderService orderService;
    public List<CostInfo> getAll(CostInfo CostInfo) throws Exception{
        String sort=CostInfo.getSort(),order=CostInfo.getOrder(),orderNum=CostInfo.getOrderNum(),orderNumCondition="";
        Integer dateRange=CostInfo.getDateRange();
        if(!StringUtils.isEmpty(orderNum)){
            if(orderService.getOrderInfoByNum(orderNum)==null) throw new Exception("该订单不存在");
            orderNumCondition=String.format("order_num='%s'",orderNum);
        }
        return CostInfoMapper.selectByExample(createDateRangeExample(CostInfo.class,order,sort,dateRange,orderNumCondition));
    }

    public int getCount(CostInfo CostInfo){
        return CostInfoMapper.selectCount(CostInfo);
    }

    public CostInfo getById(Integer id) {
        return CostInfoMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id) {
        CostInfoMapper.deleteByPrimaryKey(id);
    }

    public void save(CostInfo CostInfo) {
        if (CostInfo.getId() != null) {
            CostInfo.setUpdateDate(new Date());
            CostInfoMapper.updateByPrimaryKey(CostInfo);
        } else {
            Date date=new Date();
            CostInfo.setCreateDate(date);
            CostInfo.setUpdateDate(date);
            CostInfoMapper.insert(CostInfo);
        }
    }
}

