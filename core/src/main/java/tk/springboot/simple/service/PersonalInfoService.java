package tk.springboot.simple.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.springboot.simple.mapper.PersonalInfoMapper;
import tk.springboot.simple.model.PersonalInfo;

import java.util.Date;
import java.util.List;

/**
 * @author zhou
 * @Description:
 * @date 2016/12/26 15:05
 */
@Service
public class PersonalInfoService extends BaseService {
    @Autowired
    private PersonalInfoMapper personalInfoMapper;

    public List<PersonalInfo> getAll(PersonalInfo personalInfo) {
        String sort = personalInfo.getSort(), order = personalInfo.getOrder();
        Integer dateRange = personalInfo.getDateRange();
        return personalInfoMapper.selectByExample(createDateRangeExample(PersonalInfo.class, order, sort, dateRange));
    }

    public PersonalInfo getById(Integer id) {
        return personalInfoMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id) {
        personalInfoMapper.deleteByPrimaryKey(id);
    }

    public void save(PersonalInfo personalInfo) {
        Date date = new Date();
        personalInfo.setUpdateDate(date);
        if (personalInfo.getId() != null) {
            personalInfoMapper.updateByPrimaryKey(personalInfo);
        } else {
            personalInfo.setCreateDate(date);
            personalInfoMapper.insert(personalInfo);
        }
    }

    public int getCount(PersonalInfo personalInfo) {
        return personalInfoMapper.selectCount(personalInfo);
    }
}
