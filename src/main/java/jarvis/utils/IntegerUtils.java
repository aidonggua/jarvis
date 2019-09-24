package jarvis.utils;

/**
 * Created by yehao on 17/2/14.
 */
public class IntegerUtils {

    /**
     * 校验数值知否在一个区间里
     *
     * @param value 需要校验的值
     * @param min   区间的左边
     * @param max   区间的右边
     * @return boolean
     * @author yehao
     * @since 17/2/14
     */
    public static boolean in(Integer value,
                             int min,
                             int max) {
        if (value == null) {
            return false;
        }
        if (value < min || value > max) {
            return false;
        }
        return true;
    }
}
