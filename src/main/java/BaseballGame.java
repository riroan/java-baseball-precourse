public class BaseballGame {
    private final int LENGTH = 3;
    private final int MIN_VALUE = 1;
    private final int MAX_VALUE = 9;
    private final NumberGenerator numberGenerator;
    private final BaseballView baseballView;
    private boolean isTerminated;
    private int[] answerNumbers;

    BaseballGame(NumberGenerator numberGenerator, BaseballView baseballView) {
        this.numberGenerator = numberGenerator;
        this.baseballView = baseballView;

        this.isTerminated = false;
    }

    public void run() {
        initialize();
        while (!isTerminated) {
            String userNumber = baseballView.inputUserNumber();
            if (!baseballView.validateUserNumber(userNumber, LENGTH)) {
                baseballView.printError();
                continue;
            }
            int[] userNumbers = baseballView.refineUserNumber(userNumber);

            int strike = calculateStrike(userNumbers);
            int ball = calculateBall(userNumbers);
            baseballView.printResult(strike, ball);

            if (checkGameEnd(strike)) {
                handleGameEnd();
            }
        }
    }

    void handleGameEnd() {
        baseballView.printWinMessage(LENGTH);
        isTerminated = baseballView.askGameEnd();
        if (!isTerminated) {
            initialize();
        }
    }

    void initialize() {
        answerNumbers = numberGenerator.generateNumbers(LENGTH, MIN_VALUE, MAX_VALUE);
    }

    boolean checkGameEnd(int strike) {
        return strike == LENGTH;
    }


    int calculateStrike(int[] userNumbers) {
        if (userNumbers[0] == 0) {
            return 3;
        }
        return 0;
    }

    int calculateBall(int[] userNumbers) {
        return 0;
    }
}
