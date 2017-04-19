package github.jarvis.exception;

/**
 * Created by yehao on 16/8/30.
 * 参数为空异常
 * 检查参数是否为空时可以使用此异常
 */
public class NullParamException extends CustomRuntimeException {

    public static final  String DEFAULT_MSG      = "参数为空!";
    private static final long   serialVersionUID = -7539361859316387092L;

    /**
     * create a default null param exception
     *
     * @author yehao
     */
    public NullParamException() {
        super(DEFAULT_MSG);
    }

    /**
     * by specified a message to create a null param exception
     *
     * @param msg exception message
     * @author yehao
     */
    public NullParamException(String msg) {
        super(msg);
    }

    /**
     * create a null param exception with formatted message
     *
     * @param msg    exception message
     * @param params formatted object
     * @author yehao
     * @date 17/4/19 下午4:51
     */
    public NullParamException(String msg, Object... params) {
        super(msg, params);
    }

    /**
     * by specified a code to create a null param exception
     *
     * @param code exception code
     * @author yehao
     */
    public NullParamException(Integer code) {
        super(code);
    }

    /**
     * by specified a message and code to create a null param exception
     *
     * @param msg  exception message
     * @param code exception code
     * @author yehao
     */
    public NullParamException(String msg, Integer code) {
        super(msg, code);
    }

    /**
     * create a null param exception with formatted message
     *
     * @param msg    exception message
     * @param params formatted object
     * @param code   exception code
     * @author yehao
     * @date 17/4/19 下午4:51
     */
    public NullParamException(String msg, Integer code, Object... params) {
        super(msg, code, params);
    }
}
