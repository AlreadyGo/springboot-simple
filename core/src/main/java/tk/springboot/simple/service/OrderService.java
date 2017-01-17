package tk.springboot.simple.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.springboot.simple.mapper.OrderMapper;
import tk.springboot.simple.model.OrderInfo;

import java.util.Date;
import java.util.List;

/**
 * @author zhou
 * @Description:
 * @date 2016/12/26 15:05
 */
@Service
public class OrderService extends BaseService{
    @Autowired
    private OrderMapper orderBeanMapper;

    public List<OrderInfo> getAll(OrderInfo orderBean) {
        String sort=orderBean.getSort(),order=orderBean.getOrder(),orderNum=orderBean.getOrderNum(),orderNumCondition="";
        Integer dateRange=orderBean.getDateRange();
        if(!StringUtils.isEmpty(orderNum)){
            orderNumCondition=String.format("order_num='%s'",orderNum);
        }
        return orderBeanMapper.selectByExample(createDateRangeExample(OrderInfo.class,order,sort,dateRange,orderNumCondition));
    }

    public OrderInfo getById(Integer id) {
        return orderBeanMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id) {
        orderBeanMapper.deleteByPrimaryKey(id);
    }

    public void save(OrderInfo orderBean) {
        Date date=new Date();
        orderBean.setUpdateDate(date);
        if (orderBean.getId() != null) {
            orderBeanMapper.updateByPrimaryKey(orderBean);
        } else {
            orderBean.setCreateDate(date);
            orderBeanMapper.insert(orderBean);
        }
    }
    public int getCount(OrderInfo orderBean){
        return orderBeanMapper.selectCount(orderBean);
    }

    public OrderInfo getOrderInfoByNum(String orderNum){
        OrderInfo orderInfo=new OrderInfo();orderInfo.setOrderNum(orderNum);
        return orderBeanMapper.selectOne(orderInfo);
    }
}
