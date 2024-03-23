public class NumberGenerator {
    public int[] generate(int length) {
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = i;
        }
        return result;
    }
}
