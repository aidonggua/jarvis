package github.jarvis.bytes;

/**
 * Created by yehao on 16/12/13.
 */
public class BytesUtils {

    /**
     * Returns the values from each provided array combined into a single array.
     * For example, {@code concat(new byte[] {a, b}, new byte[] {}, new
     * byte[] {c}} returns the array {@code {a, b, c}}.
     *
     * @param arrays zero or more {@code byte} arrays
     * @return a single array containing all the values from the source arrays, in
     * order
     */
    public static byte[] concat(byte[]... arrays) {
        int length = 0;
        for (byte[] array : arrays) {
            length += array.length;
        }
        byte[] result = new byte[length];
        int pos = 0;
        for (byte[] array : arrays) {
            System.arraycopy(array, 0, result, pos, array.length);
            pos += array.length;
        }
        return result;
    }
}
