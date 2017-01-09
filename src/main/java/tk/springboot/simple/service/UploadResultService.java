package tk.springboot.simple.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.springboot.simple.mapper.UploadResultMapper;
import tk.springboot.simple.model.UploadResult;
import tk.springboot.simple.model.enums.UploadType;

import java.util.List;

/**
 * @author zhou
 * @Description:
 * @date 2016/12/26 15:05
 * @jdk v1.8
 */
@Service
public class UploadResultService {
    @Autowired
    private UploadResultMapper uploadResultMapper;

    public List<UploadResult> getAll(UploadResult uploadResult) {
        return uploadResultMapper.selectAll();
    }

    public UploadResult getById(Integer id) {
        return uploadResultMapper.selectByPrimaryKey(id);
    }

    public List<UploadResult> getByType(UploadType uploadType) {
        Example example=new Example(UploadResult.class);
        example.createCriteria().andCondition("upload_type=",uploadType.ordinal());
        return uploadResultMapper.selectByExample(example);
    }

    public void deleteById(Integer id) {
        uploadResultMapper.deleteByPrimaryKey(id);
    }

    public void save(UploadResult uploadResult) {
        if (uploadResult.getId() != null) {
            uploadResultMapper.updateByPrimaryKey(uploadResult);
        } else {
            uploadResultMapper.insert(uploadResult);
        }
    }

    public void saveList(List<UploadResult> uploadResults) {
            uploadResultMapper.insertList(uploadResults);
    }


}
