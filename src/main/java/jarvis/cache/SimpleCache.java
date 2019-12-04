package jarvis.cache;

/**
 * 简单缓存服务接口
 *
 * @author yehao
 * @date 2019-10-17
 */
public interface SimpleCache {

    /**
     * 设置缓存
     *
     * @param key      key
     * @param value    value
     * @param duration 持续时间(单位毫秒)
     * @author yehao
     * @date 2019-10-17
     */
    void put(String key, Object value, Long duration);

    /**
     * 获取缓存
     *
     * @author yehao
     * @date 2019-10-17
     */
    Object get(String key);

    /**
     * 获取缓存
     *
     * @param refresh 是否刷新过期时间
     * @author yehao
     * @date 2019-10-17
     */
    Object get(String key, boolean refresh);
}
