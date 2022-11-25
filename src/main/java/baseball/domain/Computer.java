package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computerNumbers;
    private int strikeCount;
    private int ballCount;

    public Computer() {
        this.computerNumbers = makeComputerNumbers();
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public void resetGame() {
        this.computerNumbers = makeComputerNumbers();
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    private List<Integer> makeComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return makeComputerNumbers();
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isThreeStrike() {
        if (this.strikeCount == 3) {
            return true;
        }
        return false;
    }

    public void compareNumbers(List<Integer> userNumbers) {
        initCountOfBallAndStrike();
        getCountOfBallAndStrikeCount(userNumbers);
    }

    private void initCountOfBallAndStrike() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    private void getCountOfBallAndStrikeCount(List<Integer> userNumbers) {
        for (int i = 0; i < userNumbers.size(); i++) {
            calculateStrikeCount(userNumbers.get(i), computerNumbers.get(i));
            calculateBallCount(userNumbers.get(i), computerNumbers.get(i));
        }
    }

    private void calculateStrikeCount(int userNumber, int computerNumber) {
        if (userNumber == computerNumber) {
            strikeCount++;
        }
    }

    private void calculateBallCount(int userNumber, int computerNumber) {
        if (computerNumbers.contains(userNumber) && computerNumber != userNumber) {
            ballCount++;
        }
    }
}
