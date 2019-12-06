import jarvis.parser.CollectionParser;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BeanUtilsTest {

    static class TestObject {
        private String field1;

        public TestObject(String field1) {
            this.field1 = field1;
        }

        public String getField1() {
            return field1;
        }

        public void setField1(String field1) {
            this.field1 = field1;
        }
    }

    @Test
    public void testCollectionToHashMap() {
        List<TestObject> as = new ArrayList<>();
        as.add(new TestObject("a"));
        as.add(new TestObject("b"));
        as.add(new TestObject("c"));

        System.out.println(CollectionParser.toMap(as, TestObject::getField1));
    }
}
