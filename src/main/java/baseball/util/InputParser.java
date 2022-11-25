package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
    public List<Integer> userNumberParser(String input) {
        List<Integer> userNumbers = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            userNumbers.add(input.charAt(i) - '0');
        }
        return userNumbers;
    }

    public int nextGameStatusParser(String input) {
        return Integer.valueOf(input);
    }
}
