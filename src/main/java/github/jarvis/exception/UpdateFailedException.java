package github.jarvis.exception;

/**
 * Created by yehao on 16/8/30.
 * 更新记录失败异常
 * 如果jdbc执行update语句,返回的值为0,可以使用此异常
 */
public class UpdateFailedException extends CustomRuntimeException {

    public static final  String DEFAULT_MSG      = "没有记录被更新!";
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
}
