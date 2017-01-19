package tk.springboot.simple.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tk.springboot.simple.exceptions.BizException;
import tk.springboot.simple.model.RespInfo;
import tk.springboot.simple.util.Consts;

/**
 * @author zhou
 * @Description:
 * @date 2017/1/10 15:29
 * @jdk v1.8
 */
public class BaseController {

    private Logger logger=Logger.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    public RespInfo handleIOException(Exception ex) {
        logger.error("inner error:",ex);
        String message="内部错误";
        if(ex instanceof BizException){
            message=ex.getMessage();
        }
        return new RespInfo(Consts.ERROR_CODE,ex.getMessage(),message);
    }
}
