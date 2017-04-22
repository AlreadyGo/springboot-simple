package tk.springboot.simple.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.springboot.simple.mapper.UploadResultMapper;
import tk.springboot.simple.model.UploadResult;

import java.util.List;

/**
 * @author zhou
 * @Description:
 * @date 2016/12/26 15:05
 * @jdk v1.8
 */
@Service
public class UploadResultService extends BaseService {
    @Autowired
    private UploadResultMapper uploadResultMapper;

    public List<UploadResult> getAll(UploadResult uploadResult) {

        return uploadResultMapper.selectAll();
    }

    public UploadResult getById(Integer id) {
        return uploadResultMapper.selectByPrimaryKey(id);
    }

    public List<UploadResult> getByType(UploadResult uploadResult) {
        String sort = uploadResult.getSort(), order = uploadResult.getOrder();
        Integer dateRange = uploadResult.getDateRange();
        Example example = createDateRangeExample(UploadResult.class, order, sort, dateRange, "upload_type=" + uploadResult.getUploadType().ordinal());
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
