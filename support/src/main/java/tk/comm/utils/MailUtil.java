package tk.comm.utils;

import tk.comm.model.MailAuthentication;
import tk.comm.model.MailInfo;
import org.apache.log4j.Logger;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Properties;

/**
 * @author zhou
 * @version V1.0
 * @Description:
 * @date 2016/8/24 15:25
 * @jdk v1.7
 * @tomcat v7.0
 */
public class MailUtil {
    private static String encoding = "GBK";
    private static Logger logger = Logger.getLogger(MailUtil.class);

    public static void send(MailInfo mailInfo, MailAuthentication mailAuthentication) throws Exception {
        String account = mailAuthentication.getEmailAccount();
        String password = mailAuthentication.getEmailPassword();
        String smtpHost = mailAuthentication.getEmailSMTPHost();

        Properties props = new Properties();                    // 参数配置
        props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.host", smtpHost);        // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", "true");            // 请求认证，参数名称与具体实现有关

        Session session = Session.getDefaultInstance(props);
//        session.setDebug(true);// 设置为debug模式, 可以查看详细的发送 log

        logger.info("init mail session");

        MimeMessage message = createMimeMessage(mailInfo,
                session, account);

        logger.info("create mail mime message");

        Transport transport = session.getTransport();

        transport.connect(account, password);

        transport.sendMessage(message, message.getAllRecipients());

        logger.info("send mail successfully");

        transport.close();
    }

    public static MimeMessage createMimeMessage(MailInfo mailInfo, Session session, String from) throws Exception {
        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress(from));

        String[] toes = mailInfo.getTo();
        String[] ccs = mailInfo.getCc();
        String[] bccs = mailInfo.getBcc();
        File[] attachments = mailInfo.getAttachments();
        MimeMultipart parts = new MimeMultipart();
        if (toes != null && toes.length > 0) {
            for (String to : toes)
                message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
        }

        if (ccs != null && ccs.length > 0) {
            for (String cc : ccs)
                message.addRecipient(MimeMessage.RecipientType.CC, new InternetAddress(cc));
        }

        if (bccs != null && bccs.length > 0) {
            for (String bcc : bccs)
                message.addRecipient(MimeMessage.RecipientType.BCC, new InternetAddress(bcc));
        }
        MimeBodyPart part;
        if (attachments != null && attachments.length > 0) {
            for (File file : attachments) {
                if(file!=null){
                    part = new MimeBodyPart();
                    part.attachFile(file);
                    part.setFileName(file.getName());
                    parts.addBodyPart(part);
                }
            }
        }
        part = new MimeBodyPart();
        part.setContent(mailInfo.getContent(), "text/html;charset=GBK");
        parts.addBodyPart(part);
        message.setContent(parts);
        message.setSubject(mailInfo.getSubject(), getEncoding());


        message.setSentDate(mailInfo.getCreateTime());

        message.saveChanges();

        return message;
    }

    public static String getEncoding() {
        return encoding;
    }

    public static void setEncoding(String encoding) {
        MailUtil.encoding = encoding;
    }

}