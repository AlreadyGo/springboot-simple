package tk.common.test;

import org.junit.Test;
import tk.comm.model.MailAuthentication;
import tk.comm.model.MailInfo;
import tk.comm.utils.MailUtil;

import java.io.File;

/**
 * Created by Already on 2017/3/16.
 */
public class MailTest {
    @Test
    public void sendMail() {
        try {
            MailInfo mailInfo = new MailInfo();
            mailInfo.setTo(new String[]{"xxx@qq.com"});
            mailInfo.setSubject("请不要回复");
            mailInfo.setContent("<img src='http://cimg2.163.com/help/vip/img/vipvsfree03.jpg' border='0' title='升级VIP邮箱，尊享20多项特权'>");
            File[] files = new File[1];
            files[0] = new File("d:\\1.jpg");
            mailInfo.setAttachments(files);
            MailAuthentication mailAuthentication = new MailAuthentication();
            mailAuthentication.setEmailSMTPHost("smtp.163.com");
            mailAuthentication.setEmailAccount("xxx@163.com");
            mailAuthentication.setEmailPassword("xxx");
            MailUtil.send(mailInfo, mailAuthentication);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
