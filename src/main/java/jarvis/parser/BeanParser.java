package jarvis.parser;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * 用于pojo之间的转换
 *
 * @author yehao
 * @date 2019-12-04
 */
public class BeanParser {

    /**
     * 将T1类型的实例t1 转换为 T2类型的t2实例
     *
     * @param t1      需要被转换的实例
     * @param t2Class 需要转换的目标类型
     * @return T2类型的实例
     * @author yehao
     * @date 2019-12-04
     */
    public static <T1, T2> T2 parse(T1 t1, Class<T2> t2Class) {
        try {
            T2 t2 = t2Class.newInstance();
            org.apache.commons.beanutils.BeanUtils.copyProperties(t2, t1);
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
    public static <T1, T2> List<T2> parseList(List<T1> t1, Class<T2> t2Class) {
        List<T2> list = new ArrayList<>();
        for (T1 temp : t1) {
            list.add(parse(temp, t2Class));
        }

        return list;
    }
}
