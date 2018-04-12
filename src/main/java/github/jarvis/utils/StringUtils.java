package github.jarvis.utils;

/**
 * Created by yehao on 16/8/29.
 * 字符串工具类
 */
public class StringUtils {

    /**
     * 判断字符串是否为空
     * <pre>
     *     StringUtils.isEmpty(null)      = true
     *     StringUtils.isEmpty("")        = true
     *     StringUtils.isEmpty(" ")       = false
     *     StringUtils.isEmpty(" ")       = false
     *     StringUtils.isEmpty("bob")     = false
     *     StringUtils.isEmpty("  bob  ") = false
     * </pre>
     *
     * @return boolean
     * @author yehao
     * @since 2018/4/12
     */
    public static boolean isEmpty(String str) {
        return null == str || str.length() == 0;
    }

    /**
     * 判断字符串是否为空，并且不为 "null" 或 "nil"
     * <pre>
     *     StringUtils.isEmpty("null")      = true
     *     StringUtils.isEmpty("nil")       = true
     *     StringUtils.isEmpty("")          = true
     *     StringUtils.isEmpty(null)        = true
     * </pre>
     *
     * @return boolean
     * @author yehao
     * @since 2018/4/12
     */
    public static boolean isEmpty2(String str) {
        return isEmpty(str) || "null".equalsIgnoreCase(str) || "nil".equalsIgnoreCase(str);
    }

    /**
     * 判断字符串是否为空，或者只有空格
     * <pre>
     *     StringUtils.isBlank(null)      = true
     *     StringUtils.isBlank("")        = true
     *     StringUtils.isBlank(" ")       = true
     *     StringUtils.isBlank("bob")     = false
     *     StringUtils.isBlank("  bob  ") = false
     * </pre>
     *
     * @return String
     * @author yehao
     * @since 2018/4/12
     */
    public static boolean isBlank(String str) {
        int strLen;
        if (null == str || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((!Character.isWhitespace(str.charAt(i)))) {
                return false;
            }
        }
        return true;
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

        StringBuffer sb = new StringBuffer();
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

