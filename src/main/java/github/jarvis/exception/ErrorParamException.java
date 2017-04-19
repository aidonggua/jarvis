package github.jarvis.exception;

/**
 * Created by yehao on 16/11/16.
 * 参数错误异常
 * 检查参数是否错误时可以使用此异常
 */
public class ErrorParamException extends CustomRuntimeException {

    public static final  String DEFAULT_MSG      = "参数错误!";
    private static final long   serialVersionUID = 9020292621606756510L;

    /**
     * create a default error param exception
     *
     * @author yehao
     */
    public ErrorParamException() {
        super(DEFAULT_MSG);
    }

    /**
     * by specified a message to create a error param exception
     *
     * @param msg exception message
     * @author yehao
     */
    public ErrorParamException(String msg) {
        super(msg);
    }

    /**
     * create a error param exception with formatted message
     *
     * @param msg    exception message
     * @param params formatted object
     * @author yehao
     * @date 17/4/19 下午4:51
     */
    public ErrorParamException(String msg, Object... params) {
        super(msg, params);
    }

    /**
     * by specified a code to create a error param exception
     *
     * @param code exception code
     * @author yehao
     */
    public ErrorParamException(Integer code) {
        super(DEFAULT_MSG, code);
    }

    /**
     * by specified a message and code to create a error param exception
     *
     * @param msg  exception message
     * @param code exception code
     * @author yehao
     */
    public ErrorParamException(String msg, Integer code) {
        super(msg, code);
    }

    /**
     * create a error param exception with formatted message
     *
     * @param msg    exception message
     * @param params formatted object
     * @param code   exception code
     * @author yehao
     * @date 17/4/19 下午4:51
     */
    public ErrorParamException(String msg, Integer code, Object... params) {
        super(msg, code, params);
    }
}
