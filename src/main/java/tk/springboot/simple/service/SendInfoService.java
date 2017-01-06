package tk.springboot.simple.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.springboot.simple.mapper.SendInfoMapper;
import tk.springboot.simple.model.SendInfo;

import java.util.List;

/**
 * @author zhou
 * @version V1.0
 * @Description:
 * @date 2016/12/26 15:05
 * @jdk v1.7
 * @tomcat v7.0
 */
@Service
public class SendInfoService {
    @Autowired
    private SendInfoMapper sendInfoMapper;

    public List<SendInfo> getAll(SendInfo sendInfo) {
        return sendInfoMapper.selectAll();
    }

    public SendInfo getById(Integer id) {
        return sendInfoMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id) {
        sendInfoMapper.deleteByPrimaryKey(id);
    }

    public void save(SendInfo sendInfo) {
        if (sendInfo.getId() != null) {
            sendInfoMapper.updateByPrimaryKey(sendInfo);
        } else {
            sendInfoMapper.insert(sendInfo);
        }
    }
}
