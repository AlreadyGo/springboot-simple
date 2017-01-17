package tk.springboot.simple.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public List<CostInfo> getAll(CostInfo CostInfo) {
        String sort=CostInfo.getSort(),order=CostInfo.getOrder();
        Integer dateRange=CostInfo.getDateRange();
        return CostInfoMapper.selectByExample(createDateRangeExample(CostInfo.class,order,sort,dateRange));
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

