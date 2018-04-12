package github.jarvis.utils;

import java.util.Random;

/**
 * Created by yehao on 16/9/5.
 * 随机数工具类
 */
public class RandomUtils {

    /**
     * 生成指定宽度{bit}的数字字符串
     *
     * @param bit -
     * @return String
     * @author yehao
     * @since 2018/4/12
     */
    public static String rand(int bit) {
        if (bit < 1) {
            return "";
        }

        Random random     = new Random();
        Double randNumber = random.nextDouble();
        return randNumber.toString().split("\\.")[1].substring(0, bit);
    }
}
