package github.jarvis.str;

/**
 * Created by yehao on 16/8/29.
 * 字符串相关工具类
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
     */
    public static boolean isBlank(String str) {
        /*这个是其他地方的写法
        int strLen;
        if (null == str || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
        */

        //自己想的写法
        String s = str.trim();
        return isEmpty(s);
    }

    /**
     * 大小写转换
     * <pre>
     *     swapCase("aBc")      = "Abc"
     *     swapCase("abc")      = "ABC"
     *     swapCase("ABC")      = "abc"
     * </pre>
     */
    public static String swapCase(String str) {
        int strLen;
        if (null == str || (strLen = str.length()) == 0) {
            return str;
        }

        StringBuffer sb = new StringBuffer();
        char ch = 0;
        for (int i = 0; i < strLen; i++) {
            ch = str.charAt(i);
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
}
