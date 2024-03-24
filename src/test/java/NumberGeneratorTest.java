import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberGeneratorTest {
    NumberGenerator numberGenerator = new NumberGenerator();
    final int LENGTH = 10;
    final int EPOCH = 10000;
    final int LO = 10;
    final int HI = 100;

    @Test
    @DisplayName("숫자가 범위 안에 들어오는지 확인")
    void generateOneNumberOnBound() {
        for(int epoch = 0; epoch < EPOCH; epoch++) {
            int number = numberGenerator.generateOneNumber(LO, HI);
            assertThat(number >= LO && number <= HI);
        }
    }

    @Test
    @DisplayName("중복되지 않는지 확인")
    void generateMultipleNumberDistinct() {
        int[] numbers = numberGenerator.generateNumbers(LENGTH, LO, HI);

        assertThat(numbers.length == LENGTH);
        Set<Integer> numberSet = new HashSet<>();
        for(int number : numbers){
            assertThat(!numberSet.contains(number));
            assertThat(number >= LO && number <= HI);

            numberSet.add(number);
        }
    }
}
