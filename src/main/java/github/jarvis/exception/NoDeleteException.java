package github.jarvis.exception;

/**
 * Created by yehao on 16/8/30.
 * 没有记录被删除异常
 * 如果jdbc执行delete语句,返回的值为0,可以使用此异常
 */
public class NoDeleteException extends CustomRuntimeException {

    public static final String DEFAULT_MSG = "没有记录被删除!";
    private static final long serialVersionUID = -2814392250307706558L;

    /**
     * create a default no delete exception
     *
     * @author yehao
     */
    public NoDeleteException() {
        super(DEFAULT_MSG);
    }

    /**
     * by specified a message to create a no delete exception
     *
     * @param msg exception message
     * @author yehao
     */
    public NoDeleteException(String msg) {
        super(msg);
    }

    /**
     * by specified a code to create a no delete exception
     *
     * @param code exception code
     * @author yehao
     */
    public NoDeleteException(Integer code) {
        super(code);
    }

    /**
     * by specified a message and code to create a no delete exception
     *
     * @param msg  exception message
     * @param code exception code
     * @author yehao
     */
    public NoDeleteException(String msg, Integer code) {
        super(msg,code);
    }
}
