package jarvis.converter;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * 用于pojo之间的转换
 *
 * @author yehao
 * @date 2019-12-04
 */
public class BeanConverter {

    /**
     * 将bean转换成map
     *
     * @author yehao
     * @date 2020/4/10
     */
    public static <T1> Map<String, Object> convertToMap(T1 data) {
        Map<String, Object> beanMap = new HashMap<>();
        for (Field declaredField : data.getClass()
                                       .getDeclaredFields()) {
            try {
                beanMap.put(declaredField.getName(), declaredField.get(data));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return beanMap;
    }

    /**
     * 将bean转换成map
     *
     * @author yehao
     * @date 2020/4/10
     */
    public static <T1> Map<String, Object> convertToMap(T1 data, Function<String, String> function) {
        Map<String, Object> beanMap = new HashMap<>();
        for (Field declaredField : data.getClass()
                                       .getDeclaredFields()) {
            try {
                beanMap.put(function.apply(declaredField.getName()), declaredField.get(data));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return beanMap;
    }

    /**
     * 将T1类型的实例t1 转换为 T2类型的t2实例
     *
     * @param t1      需要被转换的实例
     * @param t2Class 需要转换的目标类型
     * @return T2类型的实例
     * @author yehao
     * @date 2019-12-04
     */
    public static <T1, T2> T2 convert(T1 t1, Class<T2> t2Class) {
        try {
            T2 t2 = t2Class.newInstance();
            BeanUtils.copyProperties(t2, t1);
            return t2;
        } catch (InvocationTargetException | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将T1类型的List转换成T2类型的List
     *
     * @param t1      需要被转换的List
     * @param t2Class 需要转换的目标类型
     * @return T2类型的List
     * @author yehao
     * @date 2019-12-25
     */
    public static <T1, T2> List<T2> convertList(List<T1> t1, Class<T2> t2Class) {
        List<T2> list = new ArrayList<>();
        for (T1 temp : t1) {
            list.add(convert(temp, t2Class));
        }

        return list;
    }
}
