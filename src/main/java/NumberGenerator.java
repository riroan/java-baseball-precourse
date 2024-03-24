import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class NumberGenerator {
    private final Random random;

    NumberGenerator() {
        this.random = new Random();
    }

    // [lo, hi] 범위의 난수 하나 생성
    private int generateOneNumber(int lo, int hi) {
        return random.nextInt(hi - lo + 1) + lo;
    }

    // [lo, hi] 범위의 난수 length개 생성
    public int[] generateNumbers(int length, int lo, int hi) {
        int[] result = new int[length];
        Set<Integer> existNumberSet = new HashSet<>();
        int ix = 0;
        while (ix < length) {
            int number = generateOneNumber(lo, hi);
            if (!existNumberSet.contains(number)) {
                result[ix] = number;
                existNumberSet.add(number);
                ix++;
            }
        }
        return result;
    }
}
