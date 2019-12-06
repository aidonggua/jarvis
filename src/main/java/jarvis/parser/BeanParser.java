package jarvis.parser;

import java.lang.reflect.InvocationTargetException;

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
}
