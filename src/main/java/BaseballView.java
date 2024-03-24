import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseballView {
    private final Scanner scanner;
    private final String inputMessage = "숫자를 입력해주세요: ";
    private final String errorMessage = "[ERROR] 잘못된 값을 입력하셨습니다.";
    private final String winMessage = "%d개의 숫자를 모두 맞히셨습니다! 게임 끝\n";
    private final String continueMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";

    BaseballView() {
        scanner = new Scanner(System.in);
    }

    String inputUserNumber() {
        System.out.print(inputMessage);
        String userNumber = scanner.nextLine();

        return userNumber;
    }

    boolean validateUserNumber(String userNumber, int length) {
        return true;
    }

    int[] refineUserNumber(String userNumber) {
        int length = userNumber.length();
        int[] userNumbers = new int[length];
        for (int i = 0; i < length; i++) {
            userNumbers[i] = userNumber.charAt(i) - '0';
        }
        return userNumbers;
    }

    void printResult(BaseballScore score) {
        List<String> arr = new ArrayList<>();
        int strikeCount = score.getStrikeCount();
        int ballCount = score.getBallCount();
        if (strikeCount > 0) {
            arr.add(strikeCount + "스트라이크");
        }
        if (ballCount > 0) {
            arr.add(ballCount + "볼");
        }
        String message = String.join(" ", arr);
        if (message.isEmpty()) {
            message = "틀렸습니다.";
        }
        System.out.println(message);
    }

    void printError() {
        System.out.println(errorMessage);
    }

    void printWinMessage(int number) {
        System.out.printf(winMessage, number);
    }

    boolean askGameEnd() {
        System.out.println(continueMessage);
        String gameEnd = scanner.nextLine();

        return true;
    }

    boolean validateGameEnd(String gameEnd) {
        return true;
    }
}
