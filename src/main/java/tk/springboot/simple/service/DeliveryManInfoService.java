package tk.springboot.simple.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.springboot.simple.mapper.DeliveryManInfoMapper;
import tk.springboot.simple.model.DeliveryManInfo;

import java.util.Date;
import java.util.List;

/**
 * @author zhou
 * @Description:
 * @date 2016/12/26 15:05
 */
@Service
public class DeliveryManInfoService {
    @Autowired
    private DeliveryManInfoMapper deliveryManInfoMapper;

    public List<DeliveryManInfo> getAll(DeliveryManInfo deliveryManInfo) {
        return deliveryManInfoMapper.selectAll();
    }

    public DeliveryManInfo getById(Integer id) {
        return deliveryManInfoMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id) {
        deliveryManInfoMapper.deleteByPrimaryKey(id);
    }

    public void save(DeliveryManInfo deliveryManInfo) {
        Date date=new Date();
        if (deliveryManInfo.getId() != null) {
            deliveryManInfo.setUpdateDate(date);
            deliveryManInfoMapper.updateByPrimaryKey(deliveryManInfo);
        } else {
            deliveryManInfo.setCreateDate(date);
            deliveryManInfo.setUpdateDate(date);
            deliveryManInfoMapper.insert(deliveryManInfo);
        }
    }
    public int getCount(DeliveryManInfo deliveryManInfo){
        return deliveryManInfoMapper.selectCount(deliveryManInfo);
    }
}
