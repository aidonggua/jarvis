package github.jarvis.num;

/**
 * Created by yehao on 16/9/5.
 * 生成随机数工具类
 */
public class RandomUtils {


    /**
     * 生成指定位数的随机数
     *
     * @param digit 随机数位数
     * @return 随机数字符串
     */
    public static String random(int digit) {
        int base = (int) Math.pow(10, digit - 1);
        int operand = (int) (9 * Math.pow(10, digit - 1));
        return String.valueOf((int) (Math.random() * operand + base));
    }
}
