package github.jarvis.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class SequenceUtils {

    private String day;

    private AtomicInteger atomicInteger;

    private int incrementAndGet() {
        SimpleDateFormat sdf        = new SimpleDateFormat("yyyyMMdd");
        String           dateString = sdf.format(new Date());

        if (atomicInteger == null || !dateString.equals(day)) {
            day = dateString;
            atomicInteger = new AtomicInteger();
        }

        return atomicInteger.incrementAndGet();
    }

    /**
     * 获取日期序列号
     * 可以配置前缀{prefix}
     *
     * @param prefix 前缀
     * @return String
     * @author yehao
     * @since 2018/4/12
     */
    public String getDailyOrderNo(String prefix) {
        int seq = incrementAndGet();
        return prefix + day + String.format("%05d", seq);
    }
}

