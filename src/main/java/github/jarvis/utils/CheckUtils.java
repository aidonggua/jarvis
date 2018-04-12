package github.jarvis.utils;

public class CheckUtils {

    /**
     * 检查一批参数{params}其中是否存在空
     *
     * @param params -
     * @return boolean
     * @author yehao
     * @since 2018/4/12
     */
    public static boolean containsEmpty(Object... params) {
        for (Object o : params) {
            if (o == null) {
                return true;
            }
            if (o instanceof String && StringUtils.isEmpty(String.valueOf(o))) {
                return true;
            }
        }

        return false;
    }

    //    public static void main(String[] args) {
    //        System.out.println(containsEmpty("a", 1, " "));
    //    }
}
