package tk.springboot.simple.service;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.springboot.simple.mapper.SendInfoMapper;
import tk.springboot.simple.model.SendInfo;

import java.util.Date;
import java.util.List;

/**
 * @author zhou
 * @Description:
 * @date 2016/12/26 15:05
 */
@Service
public class SendInfoService {
    @Autowired
    private SendInfoMapper sendInfoMapper;

    public List<SendInfo> getAll(SendInfo sendInfo) {
        if (sendInfo.getLimit() != null && sendInfo.getOffset() != null) {
            PageHelper.startPage(sendInfo.getOffset(), sendInfo.getLimit());
        }
        Example example=new Example(SendInfo.class);
        StringBuffer stringBuffer=new StringBuffer("order by ");
        example.setOrderByClause(stringBuffer.append(sendInfo.getSort()).append(" ").append(sendInfo.getOrder()).toString());
        return sendInfoMapper.selectByExample(example);
    }

    public int getCount(SendInfo sendInfo){
        return sendInfoMapper.selectCount(sendInfo);
    }

    public SendInfo getById(Integer id) {
        return sendInfoMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id) {
        sendInfoMapper.deleteByPrimaryKey(id);
    }

    public void save(SendInfo sendInfo) {
        if (sendInfo.getId() != null) {
            sendInfo.setUpdateDate(new Date());
            sendInfoMapper.updateByPrimaryKey(sendInfo);
        } else {
            Date date=new Date();
            sendInfo.setCreateDate(date);
            sendInfo.setUpdateDate(date);
            sendInfoMapper.insert(sendInfo);
        }
    }
}
