package github.jarvis.exception;

import github.jarvis.str.MessageFormatter;

/**
 * Created by yehao on 16/11/16.
 * 自定义异常
 * 使用自定义异常时,可以用此异常作为基类
 */
public class CustomRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1291253822324604122L;

    public static final int    DEFAULT_CODE = 0;
    public static final String DEFAULT_MSG  = "自定义异常!";

    private String  message = DEFAULT_MSG;
    private Integer code    = DEFAULT_CODE;

    /**
     * create a default custom exception
     *
     * @author yehao
     */
    public CustomRuntimeException() {
        super(DEFAULT_MSG);
    }

    /**
     * by specified a message to create a custom exception
     *
     * @param message exception message
     * @author yehao
     */
    public CustomRuntimeException(String message) {
        super(message);
        this.message = message;
    }

    /**
     * create a custom runtime exception with formatted message
     *
     * @param msg    exception message
     * @param params formatted object
     * @author yehao
     * @date 17/4/19 下午4:51
     */
    public CustomRuntimeException(String msg, Object... params) {
        this(MessageFormatter.format(msg, params));
    }

    /**
     * by specified a code to create a custom exception
     *
     * @param code exception code
     * @author yehao
     */
    public CustomRuntimeException(Integer code) {
        super(DEFAULT_MSG);
        this.code = code;
    }

    /**
     * by specified a message and code to create a custom exception
     *
     * @param message exception message
     * @param code    exception code
     * @author yehao
     */
    public CustomRuntimeException(String message, Integer code) {
        super(message);
        this.message = message;
        this.code = code;
    }

    /**
     * create a custom runtime exception with formatted message
     *
     * @param msg    exception message
     * @param params formatted object
     * @param code   exception code
     * @author yehao
     * @date 17/4/19 下午4:51
     */
    public CustomRuntimeException(String msg, Integer code, Object... params) {
        this(MessageFormatter.format(msg, params), code);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
