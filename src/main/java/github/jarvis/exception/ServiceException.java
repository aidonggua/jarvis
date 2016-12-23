package github.jarvis.exception;

/**
 * Created by yehao on 16/8/30.
 * 业务错误异常
 * 业务流程出错时,可以使用此异常
 */
public class ServiceException extends CustomRuntimeException {

    public static final String DEFAULT_MSG = "业务错误!";
    private static final long serialVersionUID = 7245411649562897686L;

    /**
     * create a default service exception
     *
     * @author yehao
     */
    public ServiceException() {
        super(DEFAULT_MSG);
    }

    /**
     * by specified a message to create a service exception
     *
     * @param msg exception message
     * @author yehao
     */
    public ServiceException(String msg) {
        super(msg);
    }

    /**
     * by specified a code to create a service exception
     *
     * @param code exception code
     * @author yehao
     */
    public ServiceException(Integer code) {
        super(code);
    }

    /**
     * by specified a message and code to create a service exception
     *
     * @param msg  exception message
     * @param code exception code
     * @author yehao
     */
    public ServiceException(String msg, Integer code) {
        super(msg,code);
    }
}
