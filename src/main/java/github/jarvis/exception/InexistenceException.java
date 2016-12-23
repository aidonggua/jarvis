package github.jarvis.exception;

/**
 * Created by yehao on 16/8/30.
 * 没有查询到信息异常
 * 如果jdbc执行select语句,或则操作其他数据源,返回的值为null,可以使用此异常
 */
public class InexistenceException extends CustomRuntimeException {

    public static final String DEFAULT_MSG = "没有查询到信息!";
    private static final long serialVersionUID = -7862589467337500628L;

    /**
     * create a default no found exception
     *
     * @author yehao
     */
    public InexistenceException() {
        super(DEFAULT_MSG);
    }

    /**
     * by specified a message to create a no found exception
     *
     * @param msg exception message
     * @author yehao
     */
    public InexistenceException(String msg) {
        super(msg);
    }

    /**
     * by specified a code to create a no found exception
     *
     * @param code exception code
     * @author yehao
     */
    public InexistenceException(Integer code) {
        super(code);
    }

    /**
     * by specified a message and code to create a no found exception
     *
     * @param msg  exception message
     * @param code exception code
     * @author yehao
     */
    public InexistenceException(String msg, Integer code) {
        super(msg, code);
    }
}
