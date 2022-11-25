package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.util.ComputerNumbersGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {
    private static final int NEXT_GAME_NUMBER = 1;
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final ComputerNumbersGenerator computerNumbersGenerator = new ComputerNumbersGenerator();

    public void startGame() {
        outputView.printStartGame();
        Computer computer = new Computer(computerNumbersGenerator.makeComputerNumbers());
        User user = new User();
        runGame(computer, user);
    }

    public void runGame(Computer computer, User user) {
        while (!user.isGameDone()) {
            setUserNumbers(user);
            computer.compareNumbers(user.getUserNumbers());
            outputView.printGameCount(computer);
            handleGameResult(computer, user);
        }
    }

    private void setUserNumbers(User user) {
        outputView.printRequestUserNumbers();
        List<Integer> userNumbers = inputView.inputUserNumbers();
        user.setUserNumbers(userNumbers);
    }

    private void handleGameResult(Computer computer, User user) {
        if (computer.isThreeStrike()) {
            outputView.printThreeStrike();
            int nextGameStatus = inputView.inputNextGameStatus();
            setGameStatus(computer, user, nextGameStatus);
        }
    }

    private void setGameStatus(Computer computer, User user, int nextGameStatus) {
        if (nextGameStatus == NEXT_GAME_NUMBER) {
            computer.resetGame(computerNumbersGenerator.makeComputerNumbers());
            return;
        }
        user.finishGame();
    }
}
