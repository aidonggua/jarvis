package jarvis.cache;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultSimpleCache implements SimpleCache {

    private ConcurrentHashMap<String, CacheElement> cachePool = new ConcurrentHashMap<>();

    @Override
    public void put(String key, Object value, Long duration) {
        CacheElement cacheElement = new CacheElement();
        cacheElement.setKey(key);
        cacheElement.setValue(value);
        cacheElement.setDuration(duration);
        cacheElement.setLastAccessTime(System.currentTimeMillis());
        cachePool.put(key, cacheElement);
    }

    @Override
    public Object get(String key) {
        return get(key, true);
    }

    @Override
    public Object get(String key, boolean refresh) {
        long         now          = System.currentTimeMillis();
        CacheElement cacheElement = cachePool.get(key);
        if (Objects.isNull(cacheElement)) {
            return null;
        }

        if (Objects.nonNull(cacheElement.getDuration())) {
            if (cacheElement.getLastAccessTime() + cacheElement.getDuration() < now) {
                cachePool.remove(key);
                return null;
            }
        }

        if (refresh) {
            cacheElement.setLastAccessTime(now);
        }
        return cacheElement;
    }

    static class CacheElement {
        private String key;

        private Object value;

        private Long duration;

        private Long lastAccessTime;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Long getDuration() {
            return duration;
        }

        public void setDuration(Long duration) {
            this.duration = duration;
        }

        public Long getLastAccessTime() {
            return lastAccessTime;
        }

        public void setLastAccessTime(Long lastAccessTime) {
            this.lastAccessTime = lastAccessTime;
        }
    }
}
