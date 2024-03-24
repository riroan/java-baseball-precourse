import java.util.Random;

public class NumberGenerator {
    private final Random random;

    NumberGenerator() {
        this.random = new Random();
    }

    // [lo, hi] 범위의 난수 하나 생성
    public int generateOneNumber(int lo, int hi) {
        return random.nextInt(hi - lo + 1) + lo;
    }

    // [lo, hi] 범위의 난수 length개 생성
    public int[] generateNumbers(int length, int lo, int hi) {
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = generateOneNumber(lo, hi);
        }
        return result;
    }
}
