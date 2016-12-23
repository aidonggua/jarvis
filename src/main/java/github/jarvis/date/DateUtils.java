package github.jarvis.date;

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
     * 加上 n 天后的时间
     * <pre>
     *     Date date = new Date();
     *
     *     date                 = Tue Aug 30 10:21:21 CST 2016
     *     operate(date,1)      = Wed Aug 31 10:21:21 CST 2016
     * </pre>
     *
     * @param date initial date
     * @param day  the number of days that be used to increase to
     * @return date by given date increase given days
     * @author yehao
     */
    public static Date add(Date date, long day) {
        if (date == null) {
            return null;
        }
        return new Date(date.getTime() + day * DAY);
    }


    /**
     * 获取日期的星期字符串
     *
     * @param date 指定日期
     * @return week string of given date,if given date is null return null
     * @author yehao
     */
    public static String getDateEnWeekString(Date date) {
        return getEnWeekString(getDateWeek(date));
    }


    /**
     * 获取指定日期的星期数
     *
     * @param date 指定日期
     * @return week of given date,,if given date is null return -1
     * @author yehao
     */
    public static int getDateWeek(Date date) {

        /**check*/
        if (null == date) {
            return -1;
        }

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        /**1=星期天,这里将星期天设置为7,星期1~星期6为1-6*/
        int dateWeek = 0;
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            dateWeek = 7;
        } else {
            dateWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return dateWeek;
    }

    /**
     * 获取英文星期字符串
     *
     * @param week 星期一 ~ 星期天 = 1 ~ 7
     * @return 英文星期字符串, 如果week不为1 ~ 7,返回null
     * @author yehao
     */
    public static String getEnWeekString(int week) {

        /**将星期转换成星期字符串*/
        String weekStr = null;
        switch (week) {
            case 1:
                weekStr = "mon";
                break;
            case 2:
                weekStr = "tue";
                break;
            case 3:
                weekStr = "wed";
                break;
            case 4:
                weekStr = "thu";
                break;
            case 5:
                weekStr = "fri";
                break;
            case 6:
                weekStr = "sat";
                break;
            case 7:
                weekStr = "sun";
                break;
        }
        return weekStr;
    }

    /**
     * 获取中文星期字符串
     *
     * @param week 星期一 ~ 星期天 = 1 ~ 7
     * @return 中文星期字符串, 如果week不为1 ~ 7,返回null
     * @author yehao
     */
    public static String getZhWeekString(int week) {

        /**将星期转换成星期字符串*/
        String weekStr = null;
        switch (week) {
            case 1:
                weekStr = "星期一";
                break;
            case 2:
                weekStr = "星期二";
                break;
            case 3:
                weekStr = "星期三";
                break;
            case 4:
                weekStr = "星期四";
                break;
            case 5:
                weekStr = "星期五";
                break;
            case 6:
                weekStr = "星期六";
                break;
            case 7:
                weekStr = "星期日";
                break;
        }
        return weekStr;
    }
}
