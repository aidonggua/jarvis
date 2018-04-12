package github.jarvis.format;

import github.jarvis.utils.StringUtils;

/**
 * Created by yehao on 17/4/19.
 */
public class Formatter {

    public static final String KEY = "{}";

    /**
     * count [key] from msg
     *
     * @param msg the string included the [key]
     * @return the number of [key]
     * @author yehao
     */
    public static int countKey(String msg) {
        if (StringUtils.isEmpty(msg)) {
            return 0;
        }
        return countKey(msg, KEY);
    }

    /**
     * count [key] from msg
     *
     * @param msg the string included the [key]
     * @param key the string to be counted
     * @return the number of [key]
     * @author yehao
     */
    public static int countKey(String msg, String key) {
        if (StringUtils.isEmpty(msg)) {
            return 0;
        }
        return countKey(msg, key, 0, 0);
    }

    /**
     * count [key] from msg
     * begin at the position of [index]
     * ++count when the [key] found
     *
     * @param msg   the string included the [key]
     * @param key   the string to be counted
     * @param index the beginning of msg
     * @param count count number
     * @return @author yehao
     */
    private static int countKey(String msg, String key, int index, int count) {
        index = msg.indexOf(key, index);
        if (index == -1) {
            return count;
        }
        return countKey(msg, key, index + key.length(), ++count);
    }

    /**
     * format msg
     *
     * @param msg    the string to be formatted
     * @param format the string array to be replace the [KEY]
     * @return formatted string
     * @author yehao
     */
    public static String format(String msg, Object... format) {
        return format2(msg, KEY, format);
    }

    /**
     * format msg
     *
     * @param msg    -
     * @param key    -
     * @param format the string array to be replace the [key]
     * @return formatted string
     * @author yehao
     */
    public static String format2(String msg, String key, Object... format) {
        if (StringUtils.isEmpty(msg)) {
            return msg;
        }

        int count = countKey(msg, key);
        if (count == 0) {
            return msg;
        } else if (count > format.length) {
            count = format.length;
        }

        //        StringBuilder builder = new StringBuilder();
        //        String[]      msgs    = msg.split(key);
        //
        //        for (int i = 0; i < count; i++) {
        //            builder.append(msgs[i]);
        //            builder.append(format[i]);
        //        }
        //        return builder.toString();

        String regexKey = regexTransform(key);

        for (int i = 0; i < count; i++) {
            if (format[i] == null) {
                format[i] = "NULL";
            }
            msg = msg.replaceFirst(regexKey, format[i].toString());
        }
        return msg;
    }

    /**
     * transform the key word of regex
     *
     * @param key key word of regex
     * @return formatted key word
     * @author yehao
     */
    private static String regexTransform(String key) {
        return key.replaceAll("\\{", "\\\\{");
    }

    public static void main(String[] args) {
        System.out.println(format("abc{}def", "d"));
        System.out.println(format("aa{}cc{}ee{},{}{}{}{}{}{}{}{}", "bb", "dd", "ff"));
        System.out.println(format("aa{}cc", "bb", "dd", "ff"));
    }
}
