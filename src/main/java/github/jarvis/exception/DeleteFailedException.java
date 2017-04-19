package github.jarvis.exception;

/**
 * Created by yehao on 16/8/30.
 * 记录删除失败异常
 * 如果jdbc执行delete语句,返回的值为0,可以使用此异常
 */
public class DeleteFailedException extends CustomRuntimeException {

    public static final  String DEFAULT_MSG      = "记录删除失败!";
    private static final long   serialVersionUID = -2814392250307706558L;

    /**
     * create a default DeleteFaildException
     *
     * @author yehao
     */
    public DeleteFailedException() {
        super(DEFAULT_MSG);
    }

    /**
     * by specified a message to create a DeleteFailedException
     *
     * @param msg exception message
     * @author yehao
     */
    public DeleteFailedException(String msg) {
        super(msg);
    }

    /**
     * create a DeleteFailedException with formatted message
     *
     * @param msg    exception message
     * @param params formatted object
     * @author yehao
     * @date 17/4/19 下午4:51
     */
    public DeleteFailedException(String msg, Object... params) {
        super(msg, params);
    }

    /**
     * by specified a code to create a DeleteFailedException
     *
     * @param code exception code
     * @author yehao
     */
    public DeleteFailedException(Integer code) {
        super(code);
    }

    /**
     * by specified a message and code to create a DeleteFailedException
     *
     * @param msg  exception message
     * @param code exception code
     * @author yehao
     */
    public DeleteFailedException(String msg, Integer code) {
        super(msg, code);
    }

    /**
     * create a DeleteFailedException with formatted message
     *
     * @param msg    exception message
     * @param params formatted object
     * @param code   exception code
     * @author yehao
     * @date 17/4/19 下午4:51
     */
    public DeleteFailedException(String msg, Integer code, Object... params) {
        super(msg, code, params);
    }
}
