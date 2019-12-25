package jarvis.exception;

public class NullParamException extends RuntimeException {

    private Integer code;

    private String msg;

    public NullParamException() {
        super();
    }

    public NullParamException(Integer code) {
        super();
        this.code = code;
    }

    public NullParamException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public NullParamException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
