package jarvis.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.function.Function;

/**
 * 一系列对bean的操作
 *
 * @author yehao
 * @date 2019-09-24
 */
public class BeanUtils {

    /**
     * 将Collection转化为Map
     *
     * @param collection 需要转换成map的集合
     * @param function   用于构造Map的key的函数
     * @author yehao
     * @date 2019-09-24
     */
    public static <V, K> HashMap<K, V> CollectionToHashMap(Collection<V> collection, Function<V, K> function) {
        if (collection == null || collection.size() == 0) {
            return null;
        }

        HashMap<K, V> map = new HashMap<>();
        for (V v : collection) {
            map.put(function.apply(v), v);
        }
        return map;
    }
}
