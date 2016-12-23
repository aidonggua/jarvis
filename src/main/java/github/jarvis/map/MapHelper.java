package github.jarvis.map;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * Created by yehao on 16/9/23.
 * 便利操作map
 */
public class MapHelper extends HashMap {

    private static final long serialVersionUID = 8369009754902845172L;

    /**
     * 获取对象返回值
     */
    public Object getObject(String key) {
        return get(key);
    }

    /**
     * 获取字符串返回值
     */
    public String getString(String key) {
        Object o = getObject(key);
        if (o == null) {
            return null;
        }
        return String.valueOf(o);
    }

    /**
     * 获取Byte返回值
     */
    public Byte getByte(String key) {
        return Byte.valueOf(getString(key));
    }

    /**
     * 获取Integer返回值
     */
    public Integer getInteger(String key) {
        return Integer.valueOf(getString(key));
    }

    /**
     * 获取Long返回值
     */
    public Long getLong(String key) {
        return Long.valueOf(getString(key));
    }

    /**
     * 获取Double返回值
     */
    public Double getDouble(String key) {
        return Double.valueOf(getString(key));
    }

    /**
     * 获取BigDecimal返回值
     */
    public BigDecimal getBigDecimal(String key) {
        Double value = getDouble(key);
        if (value == null) {
            return null;
        }
        return BigDecimal.valueOf(value.doubleValue());
    }
}
