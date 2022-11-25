package baseball.view;

import baseball.domain.Computer;

public class OutputView {
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼 ";

    public void printStartGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printRequestUserNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printGameCount(Computer computer) {
        if (canPrintBallAndStrikeCount(computer)) {
            System.out.println(computer.getBallCount() + BALL_MESSAGE + computer.getStrikeCount() + STRIKE_MESSAGE);
        }
        if (canPrintOnlyStrikeCount(computer)) {
            System.out.println(computer.getStrikeCount() + STRIKE_MESSAGE);
        }
        if (canPrintOnlyBallCount(computer)) {
            System.out.println(computer.getBallCount() + BALL_MESSAGE);
        }
    }

    public boolean canPrintBallAndStrikeCount(Computer computer) {
        if (computer.getStrikeCount() != 0 && computer.getBallCount() != 0) {
            return true;
        }
        return false;
    }

    public boolean canPrintOnlyBallCount(Computer computer) {
        if (computer.getBallCount() != 0 && computer.getStrikeCount() == 0) {
            return true;
        }
        return false;
    }

    public boolean canPrintOnlyStrikeCount(Computer computer) {
        if (computer.getBallCount() == 0 && computer.getStrikeCount() != 0) {
            return true;
        }
        return false;
    }

    public void printThreeStrike() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
