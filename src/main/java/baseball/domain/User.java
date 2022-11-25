package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Integer> userNumbers;
    private boolean isGameDone;

    public User() {
        this.userNumbers = new ArrayList<>();
        isGameDone = false;
    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }

    public void setUserNumbers(List<Integer> userNumbers) {
        this.userNumbers = userNumbers;
    }

    public void finishGame() {
        this.isGameDone = true;
    }

    public boolean isGameDone() {
        return this.isGameDone;
    }
}
