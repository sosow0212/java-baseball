package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputUserNumbers() {
        String userNumbers = Console.readLine();
        // 예외 처리
        return userNumbers;
    }

    public String inputNextGameStatus() {
        String nextGameStatus = Console.readLine();
        // 예외 처리
        return nextGameStatus;
    }
}
