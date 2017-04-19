package github.jarvis.exception;

import github.jarvis.str.MessageFormatter;

/**
 * Created by yehao on 16/8/30.
 * 没有查询到信息异常
 * 如果jdbc执行select语句,或则操作其他数据源,返回的值为null,可以使用此异常
 */
public class NotFoundException extends CustomRuntimeException {

    public static final  String DEFAULT_MSG      = "没有查询到信息!";
    private static final long   serialVersionUID = -7862589467337500628L;

    /**
     * create a default not found exception
     *
     * @author yehao
     */
    public NotFoundException() {
        super(DEFAULT_MSG);
    }

    /**
     * by specified a message to create a not found exception
     *
     * @param msg exception message
     * @author yehao
     */
    public NotFoundException(String msg) {
        super(msg);
    }

    /**
     * create a not found exception with formatted message
     *
     * @param msg    exception message
     * @param params formatted object
     * @author yehao
     * @date 17/4/19 下午4:51
     */
    public NotFoundException(String msg, Object... params) {
        this(MessageFormatter.format(msg, params));
    }

    /**
     * by specified a code to create a not found exception
     *
     * @param code exception code
     * @author yehao
     */
    public NotFoundException(Integer code) {
        super(code);
    }

    /**
     * by specified a message and code to create a not found exception
     *
     * @param msg  exception message
     * @param code exception code
     * @author yehao
     */
    public NotFoundException(String msg, Integer code) {
        super(msg, code);
    }

    /**
     * create a not found exception with formatted message
     *
     * @param msg    exception message
     * @param params formatted object
     * @param code   exception code
     * @author yehao
     * @date 17/4/19 下午4:51
     */
    public NotFoundException(String msg, Integer code, Object... params) {
        this(MessageFormatter.format(msg, params), code);
    }
}
