package github.jarvis.exception;

/**
 * Created by yehao on 16/8/30.
 * 没有记录被插入异常
 * 如果jdbc执行insert into语句,返回的值为0,可以使用此异常
 */
public class InsertFailedException extends CustomRuntimeException {

    public static final  String DEFAULT_MSG      = "记录插入失败!";
    private static final long   serialVersionUID = 1038166018030531768L;

    /**
     * create a default InsertFailedException
     *
     * @author yehao
     */
    public InsertFailedException() {
        super(DEFAULT_MSG);
    }

    /**
     * by specified a message to create a InsertFailedException
     *
     * @param msg exception message
     * @author yehao
     */
    public InsertFailedException(String msg) {
        super(msg);
    }

    /**
     * create a InsertFailedException with formatted message
     *
     * @param msg    exception message
     * @param params formatted object
     * @author yehao
     * @date 17/4/19 下午4:51
     */
    public InsertFailedException(String msg, Object... params) {
        super(msg, params);
    }

    /**
     * by specified a code to create a InsertFailedException
     *
     * @param code exception code
     * @author yehao
     */
    public InsertFailedException(Integer code) {
        super(code);
    }

    /**
     * by specified a message and code to create a InsertFailedException
     *
     * @param msg  exception message
     * @param code exception code
     * @author yehao
     */
    public InsertFailedException(String msg, Integer code) {
        super(msg, code);
    }

    /**
     * create a InsertFailedException with formatted message
     *
     * @param msg    exception message
     * @param params formatted object
     * @param code   exception code
     * @author yehao
     * @date 17/4/19 下午4:51
     */
    public InsertFailedException(String msg, Integer code, Object... params) {
        super(msg, code, params);
    }
}
