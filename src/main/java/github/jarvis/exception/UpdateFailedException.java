package github.jarvis.exception;

import github.jarvis.str.MessageFormatter;

/**
 * Created by yehao on 16/8/30.
 * 更新记录失败异常
 * 如果jdbc执行update语句,返回的值为0,可以使用此异常
 */
public class UpdateFailedException extends CustomRuntimeException {

    public static final  String DEFAULT_MSG      = "更新失败!";
    private static final long   serialVersionUID = -5091581218841940663L;

    /**
     * create a default UpdateFailedException
     *
     * @author yehao
     */
    public UpdateFailedException() {
        super(DEFAULT_MSG);
    }

    /**
     * by specified a message to create a UpdateFailedException
     *
     * @param msg exception message
     * @author yehao
     */
    public UpdateFailedException(String msg) {
        super(msg);
    }

    /**
     * create a UpdateFailedException with formatted message
     *
     * @param msg    exception message
     * @param params formatted object
     * @author yehao
     * @date 17/4/19 下午4:51
     */
    public UpdateFailedException(String msg, Object... params) {
        this(MessageFormatter.format(msg, params));
    }

    /**
     * by specified a code to create a UpdateFailedException
     *
     * @param code exception code
     * @author yehao
     */
    public UpdateFailedException(Integer code) {
        super(code);
    }

    /**
     * by specified a message and code to create a UpdateFailedException
     *
     * @param msg  exception message
     * @param code exception code
     * @author yehao
     */
    public UpdateFailedException(String msg, Integer code) {
        super(msg, code);
    }

    /**
     * create a UpdateFailedException with formatted message
     *
     * @param msg    exception message
     * @param params formatted object
     * @param code   exception code
     * @author yehao
     * @date 17/4/19 下午4:51
     */
    public UpdateFailedException(String msg, Integer code, Object... params) {
        this(MessageFormatter.format(msg, params), code);
    }
}
