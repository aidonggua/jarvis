package github.jarvis.exception;

/**
 * Created by yehao on 16/8/30.
 * 操作受限
 * 限制用户操作时,可以使用此异常
 */
public class OperateLimitException extends CustomRuntimeException {

    public static final String DEFAULT_MSG = "操作受限!";
    private static final long serialVersionUID = 338357868503322015L;

    /**
     * create a default operate limit exception
     *
     * @author yehao
     */
    public OperateLimitException() {
        super(DEFAULT_MSG);
    }

    /**
     * by specified a message to create a operate limit exception
     *
     * @param msg exception message
     * @author yehao
     */
    public OperateLimitException(String msg) {
        super(msg);
    }

    /**
     * by specified a code to create a operate limit exception
     *
     * @param code exception code
     * @author yehao
     */
    public OperateLimitException(Integer code) {
        super(code);
    }

    /**
     * by specified a message and code to create a operate limit exception
     *
     * @param msg  exception message
     * @param code exception code
     * @author yehao
     */
    public OperateLimitException(String msg, Integer code) {
        super(msg, code);
    }
}
