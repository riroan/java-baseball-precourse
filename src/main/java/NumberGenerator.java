import java.util.Random;

public class NumberGenerator {
    private final Random random;

    NumberGenerator() {
        this.random = new Random();
    }

    public int generateOneNumber(int lo, int hi) {
        // [lo, hi] 범위의 정수 하나 생성
        return random.nextInt() % (hi - lo + 1) + lo;
    }

    public int[] generateNumbers(int length, int lo, int hi) {
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = generateOneNumber(lo, hi);
        }
        return result;
    }
}
