package jarvis.utils;

/**
 * 校验工具类
 *
 * @author yehao
 * @date 2019-09-24
 */
public class ValidUtils {

    /**
     * 检查一批参数{params}其中是否存在空
     *
     * @return boolean
     * @author yehao
     * @since 2018/4/12
     */
    public static <T> boolean containsEmpty(T... params) {
        for (T o : params) {
            if (o == null) {
                return true;
            }
            if (o instanceof String && ((String) o).isEmpty()) {
                return true;
            }
        }

        return false;
    }
}
