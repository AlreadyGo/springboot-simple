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
public class FundsStatisticsInfoService extends BaseService {
    @Autowired
    private FundsStatisticsInfoMapper fundsStatisticsInfoMapper;
    @Autowired
    private OrderService orderService;

    public List<FundsStatisticsInfo> getAll(FundsStatisticsInfo FundsStatisticsInfo) throws Exception {
        String sort = FundsStatisticsInfo.getSort(), order = FundsStatisticsInfo.getOrder();
        Integer dateRange = FundsStatisticsInfo.getDateRange();

        return fundsStatisticsInfoMapper.selectByExample(createDateRangeExample(FundsStatisticsInfo.class, order, sort, dateRange));
    }

    public int getCount(FundsStatisticsInfo FundsStatisticsInfo) {
        return fundsStatisticsInfoMapper.selectCount(FundsStatisticsInfo);
    }

    public FundsStatisticsInfo getById(Integer id) {
        return fundsStatisticsInfoMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id) {
        fundsStatisticsInfoMapper.deleteByPrimaryKey(id);
    }

    public void save(FundsStatisticsInfo fundsStatisticsInfo) {
        if (fundsStatisticsInfo.getId() != null) {
            fundsStatisticsInfo.setUpdateDate(new Date());
            fundsStatisticsInfoMapper.updateByPrimaryKey(fundsStatisticsInfo);
        } else {
            Date date = new Date();
            fundsStatisticsInfo.setCreateDate(date);
            fundsStatisticsInfo.setUpdateDate(date);
            fundsStatisticsInfoMapper.insert(fundsStatisticsInfo);
        }
    }
}

