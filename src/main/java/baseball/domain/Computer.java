package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computerNumbers;
    private int strikeCount;
    private int ballCount;

    public Computer() {
        makeComputerNumbers();
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }

    public void resetGame() {
        makeComputerNumbers();
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    private void makeComputerNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        this.computerNumbers = numbers;
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

    public boolean hasBallAndStrikeCount() {
        if (strikeCount != 0 && ballCount != 0) {
            return true;
        }
        return false;
    }

    public boolean hasComputerOnlyStrikeCount() {
        if (strikeCount != 0 && ballCount == 0) {
            return true;
        }
        return false;
    }

    public boolean hasComputerOnlyBallCount() {
        if (strikeCount == 0 && ballCount != 0) {
            return true;
        }
        return false;
    }

    public boolean hasComputerNothingCount() {
        if (strikeCount == 0 && ballCount == 0) {
            return true;
        }
        return false;
    }

}
