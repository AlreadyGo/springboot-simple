package tk.comm.utils;

import org.apache.log4j.Logger;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import tk.comm.exception.BaseSupportException;
import tk.comm.model.UploadFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zhou
 * @version V1.0
 * @Description:上传下载工具类,需要配置<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver"/>
 * @date 2016/7/26 14:01
 */
public class DownUploadUtil {
    private static Logger logger = Logger.getLogger(DownUploadUtil.class);

    /**
     * 上传
     *
     * @param request servlet容器中HttpServletRequest对象
     * @return 上传对象列表
     * @throws BaseSupportException
     */
    public static List<UploadFile> upload(HttpServletRequest request) throws BaseSupportException {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        List<UploadFile> files = new ArrayList<UploadFile>();
        if (multipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            MultiValueMap<String, MultipartFile> multiValueMap = multiRequest.getMultiFileMap();

            if (multiValueMap != null && multiValueMap.size() > 0) {

                for (Map.Entry<String, List<MultipartFile>> entry : multiValueMap.entrySet()) {
                    List<MultipartFile> multipartFiles = entry.getValue();
                    if (multipartFiles != null && multipartFiles.size() > 0) {
                        for (MultipartFile file : multipartFiles)
                            files.add(new UploadFile(file));
                    }
                }

            }
        } else {
            throw new BaseSupportException("request is not multipart", "");
        }
        return files;
    }

    public static void download(HttpServletResponse response, String fileName, InputStream inputStream) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName="
                + fileName);
        OutputStream os = response.getOutputStream();
        byte[] b = new byte[2048];
        int length;
        while ((length = inputStream.read(b)) > 0) {
            os.write(b, 0, length);
        }

        os.close();

        inputStream.close();
    }
}
