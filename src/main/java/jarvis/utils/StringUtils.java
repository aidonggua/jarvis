package jarvis.utils;

/**
 * Created by yehao on 16/8/29.
 * 字符串工具类
 */
public class StringUtils {

    /**
     * 统计字符串里，某个字符的数量
     *
     * @author yehao
     * @date 2019/12/27
     */
    public static int countChar(String str, char c) {
        int count = 0;
        for (char tempC : str.toCharArray()) {
            if (tempC == c) {
                count++;
            }
        }
        return count;
    }

    /**
     * 大小写转换
     * <pre>
     *     swapCase("aBc")      = "Abc"
     *     swapCase("abc")      = "ABC"
     *     swapCase("ABC")      = "abc"
     * </pre>
     *
     * @return String
     * @author yehao
     * @since 2018/4/12
     */
    public static String swapCase(String str) {
        int strLen;
        if (null == str || (strLen = str.length()) == 0) {
            return str;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strLen; i++) {
            char ch = str.charAt(i);
            //大写换小写，小写换大写
            if (Character.isLowerCase(ch)) {
                ch = Character.toUpperCase(ch);
            } else if (Character.isUpperCase(ch)) {
                ch = Character.toLowerCase(ch);
            }
            sb.append(ch);
        }
        return sb.toString();
    }

    /**
     * 将数组的字符串元素连接到一起
     *
     * @param strArray  需要连接的字符串数组
     * @param separator 连接符
     * @param begin     字符串数组中,需要连接部分的起始下标
     * @param end       字符串数组中,需要连接部分的截止(不包含)下标
     * @return String
     * @author yehao
     * @since 2018/4/12
     */
    public static String join(String[] strArray,
                              String separator,
                              int begin,
                              int end) {
        if (strArray == null || end < begin) {
            return null;
        }
        if (begin < 0) {
            begin = 0;
        }
        if (end > strArray.length) {
            end = strArray.length;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = begin; i <= end; i++) {
            sb.append(strArray[i]);
            if (i != end) {
                sb.append(separator);
            }
        }
        return sb.toString();
    }

    /**
     * 将字符串数组的所有字符串元素连接到一起
     *
     * @param strArray  需要连接的字符串数组
     * @param separator 连接符
     * @return String
     * @author yehao
     * @since 2018/4/12
     */
    public static String join(String[] strArray,
                              String separator) {
        return join(strArray, separator, 0, strArray.length - 1);
    }

    /**
     * 将字符串数组的所有字符串元素通过逗号连接到一起
     *
     * @param strArray 需要连接的字符串数组
     * @return String
     * @author yehao
     * @since 2018/4/12
     */
    public static String join(String[] strArray) {
        return join(strArray, ",", 0, strArray.length - 1);
    }
}

