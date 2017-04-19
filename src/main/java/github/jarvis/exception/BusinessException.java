package github.jarvis.exception;

import github.jarvis.str.MessageFormatter;

/**
 * Created by yehao on 16/8/30.
 * 业务错误异常
 * 业务流程出错时,可以使用此异常
 */
public class BusinessException extends CustomRuntimeException {

    public static final  String DEFAULT_MSG      = "业务错误!";
    private static final long   serialVersionUID = 7245411649562897686L;

    /**
     * create a default business exception
     *
     * @author yehao
     */
    public BusinessException() {
        super(DEFAULT_MSG);
    }

    /**
     * by specified a message to create a business exception
     *
     * @param msg exception message
     * @author yehao
     */
    public BusinessException(String msg) {
        super(msg);
    }

    /**
     * create a business exception with formatted message
     *
     * @param msg    exception message
     * @param params formatted object
     * @author yehao
     * @date 17/4/19 下午4:51
     */
    public BusinessException(String msg, Object... params) {
        this(MessageFormatter.format(msg, params));
    }

    /**
     * by specified a code to create a business exception
     *
     * @param code exception code
     * @author yehao
     */
    public BusinessException(Integer code) {
        super(code);
    }

    /**
     * by specified a message and code to create a business exception
     *
     * @param msg  exception message
     * @param code exception code
     * @author yehao
     */
    public BusinessException(String msg, Integer code) {
        super(msg, code);
    }

    /**
     * create a business exception with formatted message
     *
     * @param msg    exception message
     * @param params formatted object
     * @param code   exception code
     * @author yehao
     * @date 17/4/19 下午4:51
     */
    public BusinessException(String msg, Integer code, Object... params) {
        this(MessageFormatter.format(msg, params), code);
    }
}
