package github.jarvis.exception;

/**
 * Created by yehao on 16/8/30.
 * 系统错误异常
 * 如果代码执行出现错误,则可以使用此异常
 */
public class SystemException extends CustomRuntimeException {

    public static final String DEFAULT_MSG = "系统错误!";
    private static final long serialVersionUID = 9041354888235910832L;

    /**
     * create a default system exception
     *
     * @author yehao
     */
    public SystemException() {
        super(DEFAULT_MSG);
    }

    /**
     * by specified a message to create a system exception
     *
     * @param msg exception message
     * @author yehao
     */
    public SystemException(String msg) {
        super(msg);
    }

    /**
     * by specified a code to create a system exception
     *
     * @param code exception code
     * @author yehao
     */
    public SystemException(Integer code) {
        super(code);
    }

    /**
     * by specified a message and code to create a system exception
     *
     * @param msg  exception message
     * @param code exception code
     * @author yehao
     */
    public SystemException(String msg, Integer code) {
        super(msg, code);
    }
}
