package tk.springboot.simple.exceptions;

/**
 * @author zhou
 * @Description:
 * @date 2017/1/19 10:20
 * @jdk v1.8
 */
public class BizException extends Exception {
    public BizException() {
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Throwable cause) {
        super(cause);
    }
}
