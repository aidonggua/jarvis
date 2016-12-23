package github.jarvis.json;

/**
 * Created by yehao on 2016/3/28.
 */
public class JsonView {

    public static final String DEFAULT_SUCCESS_MSG = "SUCCESS!";
    public static final Integer DEFAULT_SUCCESS_CODE = 0;
    public static final String DEFAULT_FAIL_MSG = "FAILED!";
    public static final String DEFAULT_SYSTEM_FAIL_MSG = "ERROR!";
    public static final Integer DEFAULT_SYSTEM_FAIL_CODE = 500;

    private Integer code;

    private String msg;

    private Object result;

    public JsonView() {
    }

    public JsonView(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JsonView(Integer code, String msg, Object result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public static JsonView success() {
        return new JsonView(DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MSG);
    }

    public static JsonView success(Object result) {
        return new JsonView(DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MSG, result);
    }

    public static JsonView error(Integer code) {
        return new JsonView(code, DEFAULT_FAIL_MSG);
    }

    public static JsonView error(Integer code, String msg) {
        return new JsonView(code, msg);
    }

    public static JsonView systemError() {
        return new JsonView(DEFAULT_SYSTEM_FAIL_CODE, DEFAULT_SYSTEM_FAIL_MSG);
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

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
