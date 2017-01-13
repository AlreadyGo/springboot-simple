package tk.comm.model;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

/**
 * @author dell
 * @version V1.0
 * @Description:
 * @date 2016/7/26 14:30
 * @jdk v1.7
 * @tomcat v7.0
 */
public class UploadFile implements Serializable {
    private MultipartFile multipartFile;

    public UploadFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public String getName(){
        return multipartFile.getName();
    }//参数名

    public String getOriginalFilename(){
        return multipartFile.getOriginalFilename();
    }//上传文件名

    public String getContentType(){
        return multipartFile.getContentType();
    }//获取文件正文类型

    public boolean isEmpty(){
        return multipartFile.isEmpty();
    }//文件是否为空

    public long getSize(){
        return multipartFile.getSize();
    }//获取文件大小

    public byte[] getBytes() throws IOException{
        return multipartFile.getBytes();
    }

    public InputStream getInputStream() throws IOException{
        return multipartFile.getInputStream();
    }

    public void transferTo(File dest) throws IOException, IllegalStateException{
        multipartFile.transferTo(dest);
    }
}
