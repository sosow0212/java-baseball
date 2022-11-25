package baseball.view;

import baseball.domain.Computer;

public class OutputView {
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼 ";
    private static final String NOTHING_MESSAGE = "낫싱";

    public void printStartGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printRequestUserNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printGameCount(Computer computer) {
        checkHasBallAndStrikeCount(computer);
        checkHasOnlyStrikeCount(computer);
        checkHasOnlyBallCount(computer);
        checkHasNothing(computer);
    }

    public void checkHasBallAndStrikeCount(Computer computer) {
        if (computer.hasBallAndStrikeCount()) {
            System.out.println(computer.getBallCount() + BALL_MESSAGE + computer.getStrikeCount() + STRIKE_MESSAGE);
        }
    }

    public void checkHasOnlyStrikeCount(Computer computer) {
        if (computer.hasComputerOnlyStrikeCount()) {
            System.out.println(computer.getStrikeCount() + STRIKE_MESSAGE);
        }
    }

    public void checkHasOnlyBallCount(Computer computer) {
        if (computer.hasComputerOnlyBallCount()) {
            System.out.println(computer.getBallCount() + BALL_MESSAGE);
        }
    }

    public void checkHasNothing(Computer computer) {
        if (computer.hasComputerNothingCount()) {
            System.out.println(NOTHING_MESSAGE);
        }
    }

    public void printThreeStrike() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
