package baseball.view;

import baseball.exception.GameException;
import baseball.util.InputParser;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    private final GameException gameException = new GameException();
    private final InputParser inputParser = new InputParser();

    public List<Integer> inputUserNumbers() {
        try {
            String userNumbers = Console.readLine();
            gameException.validateUserNumberInput(userNumbers);
            return inputParser.userNumberParser(userNumbers);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputUserNumbers();
        }
    }

    public int inputNextGameStatus() {
        try {
            String nextGameStatus = Console.readLine();
            gameException.validateNextGameStatusInput(nextGameStatus);
            return inputParser.nextGameStatusParser(nextGameStatus);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputNextGameStatus();
        }
    }
}
