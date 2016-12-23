package github.jarvis.exception;

/**
 * Created by yehao on 16/8/30.
 * 没有记录被更新异常
 * 如果jdbc执行update语句,返回的值为0,可以使用此异常
 */
public class NoUpdateException extends CustomRuntimeException {

    public static final String DEFAULT_MSG = "没有记录被更新!";
    private static final long serialVersionUID = -5091581218841940663L;

    /**
     * create a default no update exception
     *
     * @author yehao
     */
    public NoUpdateException() {
        super(DEFAULT_MSG);
    }

    /**
     * by specified a message to create a no update exception
     *
     * @param msg exception message
     * @author yehao
     */
    public NoUpdateException(String msg) {
        super(msg);
    }

    /**
     * by specified a code to create a no update exception
     *
     * @param code exception code
     * @author yehao
     */
    public NoUpdateException(Integer code) {
        super(code);
    }

    /**
     * by specified a message and code to create a no update exception
     *
     * @param msg  exception message
     * @param code exception code
     * @author yehao
     */
    public NoUpdateException(String msg, Integer code) {
        super(msg,code);
    }
}
