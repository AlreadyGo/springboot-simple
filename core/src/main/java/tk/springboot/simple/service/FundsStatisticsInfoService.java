package tk.springboot.simple.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.springboot.simple.mapper.FundsStatisticsInfoMapper;
import tk.springboot.simple.model.FundsStatisticsInfo;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/1/17.
 */
@Service
public class FundsStatisticsInfoService extends BaseService{
    @Autowired
    private FundsStatisticsInfoMapper FundsStatisticsInfoMapper;
    @Autowired
    private OrderService orderService;
    public List<FundsStatisticsInfo> getAll(FundsStatisticsInfo FundsStatisticsInfo) throws Exception{
        String sort=FundsStatisticsInfo.getSort(),order=FundsStatisticsInfo.getOrder();
        Integer dateRange=FundsStatisticsInfo.getDateRange();

        return FundsStatisticsInfoMapper.selectByExample(createDateRangeExample(FundsStatisticsInfo.class,order,sort,dateRange));
    }

    public int getCount(FundsStatisticsInfo FundsStatisticsInfo){
        return FundsStatisticsInfoMapper.selectCount(FundsStatisticsInfo);
    }

    public FundsStatisticsInfo getById(Integer id) {
        return FundsStatisticsInfoMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id) {
        FundsStatisticsInfoMapper.deleteByPrimaryKey(id);
    }

    public void save(FundsStatisticsInfo FundsStatisticsInfo) {
        if (FundsStatisticsInfo.getId() != null) {
            FundsStatisticsInfo.setUpdateDate(new Date());
            FundsStatisticsInfoMapper.updateByPrimaryKey(FundsStatisticsInfo);
        } else {
            Date date=new Date();
            FundsStatisticsInfo.setCreateDate(date);
            FundsStatisticsInfo.setUpdateDate(date);
            FundsStatisticsInfoMapper.insert(FundsStatisticsInfo);
        }
    }
}

