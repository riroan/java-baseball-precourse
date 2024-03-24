import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballViewTest {
    BaseballView baseballView = new BaseballView();
    final int LENGTH = 3;
    final int LO = 1;
    final int HI = 9;

    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789", "149", "237"})
    @DisplayName("사용자 입력 유효성 통과 테스트")
    void validateUserInputSuccess(String userInput) {
        assertThat(baseballView.validateUserNumber(userInput, LENGTH, LO, HI));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1233", "019", "abc", "130"})
    @DisplayName("사용자 입력 유효성 실패 테스트")
    void validateUserInputFail(String userInput) {
        assertThat(baseballView.validateUserNumber(userInput, LENGTH, LO, HI));
    }
}
