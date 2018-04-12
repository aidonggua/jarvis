package github.jarvis.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by yehao on 16/8/30.
 * 日期工具类
 */
public class DateUtils {

    //1秒 = 1000毫秒
    public static final long SECOND = 1000;

    //1分 = 60秒
    public static final long MINUTE = 60 * SECOND;

    //1小时 = 60分
    public static final long HOUR = 60 * MINUTE;

    //1天 = 24小时
    public static final long DAY = 24 * HOUR;

    /**
     * 给日期{date}加上天数{day}
     * <pre>
     *     Date date = new Date();
     *
     *     date                 = Tue Aug 30 10:21:21 CST 2016
     *     operate(date,1)      = Wed Aug 31 10:21:21 CST 2016
     * </pre>
     *
     * @param date -
     * @param day  -
     * @return Date
     * @author yehao
     * @since 2018/4/12
     */
    public static Date add(Date date,
                           long day) {
        if (date == null) {
            return null;
        }
        return new Date(date.getTime() + day * DAY);
    }

    /**
     * 获取日期{date}的英文星期字符串
     *
     * @param date -
     * @return String
     * @author yehao
     * @since 2018/4/12
     */
    public static String getDateEnWeekString(Date date) {
        return getEnWeekString(getDateWeek(date));
    }

    /**
     * 获取日期{date}的星期数
     *
     * @param date -
     * @return int
     * @author yehao
     * @since 2018/4/12
     */
    public static int getDateWeek(Date date) {
        if (null == date) {
            return -1;
        }

        Calendar c = Calendar.getInstance();
        c.setTime(date);

        // calendar中 星期天 == 1
        // 这里将星期天设置为7
        // 星期1~星期6为2-7,这里减1
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            return 7;
        } else {
            return c.get(Calendar.DAY_OF_WEEK) - 1;
        }
    }

    /**
     * 获取星期{week}的英文缩写
     *
     * @param week [1-7]
     * @return String
     * @author yehao
     * @since 2018/4/12
     */
    public static String getEnWeekString(int week) {
        switch (week) {
            case 1:
                return "mon";
            case 2:
                return "tue";
            case 3:
                return "wed";
            case 4:
                return "thu";
            case 5:
                return "fri";
            case 6:
                return "sat";
            case 7:
                return "sun";
        }
        return null;
    }

    /**
     * 获取星期{week}的数字形式
     *
     * @param week [mon-sun]
     * @return int
     * @author yehao
     * @since 2018/4/12
     */
    public static int getWeekNum(String week) {
        if ("mon".equals(week)) {
            return 1;
        } else if ("tue".equals(week)) {
            return 2;
        } else if ("wed".equals(week)) {
            return 3;
        } else if ("thu".equals(week)) {
            return 4;
        } else if ("fri".equals(week)) {
            return 5;
        } else if ("sat".equals(week)) {
            return 6;
        } else if ("sun".equals(week)) {
            return 7;
        } else {
            return 0;
        }
    }

    /**
     * 获取星期{week}的字符形式
     *
     * @param week [mon-sun]
     * @return char
     * @author yehao
     * @since 2018/4/12
     */
    public static char getWeekChar(String week) {
        if ("mon".equals(week)) {
            return '1';
        } else if ("tue".equals(week)) {
            return '2';
        } else if ("wed".equals(week)) {
            return '3';
        } else if ("thu".equals(week)) {
            return '4';
        } else if ("fri".equals(week)) {
            return '5';
        } else if ("sat".equals(week)) {
            return '6';
        } else if ("sun".equals(week)) {
            return '7';
        } else {
            return '0';
        }
    }

    /**
     * 获取星期{week}的中文字符串
     *
     * @param week [1-7]
     * @return String
     * @author yehao
     * @since 2018/4/12
     */
    public static String getZhWeekString(int week) {
        switch (week) {
            case 1:
                return "星期一";
            case 2:
                return "星期二";
            case 3:
                return "星期三";
            case 4:
                return "星期四";
            case 5:
                return "星期五";
            case 6:
                return "星期六";
            case 7:
                return "星期日";
        }
        return null;
    }
}
