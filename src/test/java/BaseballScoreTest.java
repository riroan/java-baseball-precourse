import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballScoreTest {
    final int LENGTH = 3;
    int[] answerNumbers;

    @BeforeEach
    void beforeEach() {
        answerNumbers = new int[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            answerNumbers[i] = i + 1;
        }
    }

    @Test
    @DisplayName("점수 계산 1")
    void calculateScoreCase1() {
        int[] userNumbers = {1, 2, 3};
        BaseballScore score = BaseballScore.calculateScore(userNumbers, answerNumbers);
        
        assertThat(score.getStrikeCount() == 3);
        assertThat(score.getBallCount() == 0);
    }

    @Test
    @DisplayName("점수 계산 2")
    void calculateScoreCase2(){
        int[] userNumbers = {3, 1, 2};
        BaseballScore score = BaseballScore.calculateScore(userNumbers, answerNumbers);

        assertThat(score.getStrikeCount() == 0);
        assertThat(score.getBallCount() == 3);
    }

    @Test
    @DisplayName("점수 계산 3")
    void calculateScoreCase3(){
        int[] userNumbers = {7, 8, 9};
        BaseballScore score = BaseballScore.calculateScore(userNumbers, answerNumbers);

        assertThat(score.getStrikeCount() == 0);
        assertThat(score.getBallCount() == 0);
    }

    @Test
    @DisplayName("점수 계산 4")
    void calculateScoreCase4(){
        int[] userNumbers = {3, 2, 1};
        BaseballScore score = BaseballScore.calculateScore(userNumbers, answerNumbers);

        assertThat(score.getStrikeCount() == 1);
        assertThat(score.getBallCount() == 2);
    }
}
