import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

    @Test
    public void testComputeIfAbsent() {
        Map<String, Object> map = new HashMap<>();
        System.out.println(map.computeIfAbsent("a", Boolean -> System.currentTimeMillis() > 0));
        System.out.println(map.computeIfAbsent("a", Boolean -> System.currentTimeMillis() < 0));
    }
}
