package tk.comm.model;

/**
 * @author zhou
 * @Description:① APP应用异常
 * @date 2016/7/26 14:51
 */
public class MailAuthentication {
    private String emailAccount;

    private String emailPassword;
    // 发件人邮箱的 SMTP 服务器地址, 必须准确, 不同邮件服务器地址不同, 一般格式为: smtp.xxx.com
    // 163的 SMTP 服务器地址为: smtp.163.net
    private String emailSMTPHost;

    public String getEmailAccount() {
        return emailAccount;
    }

    public void setEmailAccount(String emailAccount) {
        this.emailAccount = emailAccount;
    }

    public String getEmailPassword() {
        return emailPassword;
    }

    public void setEmailPassword(String emailPassword) {
        this.emailPassword = emailPassword;
    }

    public String getEmailSMTPHost() {
        return emailSMTPHost;
    }

    public void setEmailSMTPHost(String emailSMTPHost) {
        this.emailSMTPHost = emailSMTPHost;
    }
}
