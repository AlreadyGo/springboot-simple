package tk.comm.exception;

/**
 * @author zhou
 * @Description:① APP应用异常
 * @date 2016/7/26 14:51
 */
public class AppBizException extends RuntimeException {
    private String exceptionCode;

    public AppBizException(String exceptionMsg, String exceptionCode) {
        super(exceptionMsg);
        this.exceptionCode = exceptionCode;
    }

    public String getCode() {
        return exceptionCode;
    }
}
