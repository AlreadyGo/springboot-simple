package tk.comm.exception;

/**
 * @author zhou
 * @Description:① APP应用异常
 */
public class BaseSupportException extends RuntimeException {
    private String exceptionCode;

    public BaseSupportException(String exceptionMsg, String exceptionCode) {
        super(exceptionMsg);
        this.exceptionCode = exceptionCode;
    }

    public String getCode() {
        return exceptionCode;
    }
}
