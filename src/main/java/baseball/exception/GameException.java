package baseball.exception;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class GameException {
    private static final String ERROR = "[ERROR] ";
    private static final String USER_INPUT_ERROR = "입력은 1~9의 숫자 3개로 이뤄져야합니다.";
    private static final String NEXT_GAME_INPUT_ERROR = "입력은 1과 2 둘 중 하나만 입력이 가능합니다.";

    public void validateUserNumberInput(String input) {
        validateUserNumbersContainsOnlyNumbers(input, USER_INPUT_ERROR);
        validateUserNumbersPermittedSize(input, USER_INPUT_ERROR);
        validateIsSame(input);
        validateUserNumbersPermittedRange(input, USER_INPUT_ERROR);
    }

    public void validateNextGameStatusInput(String input) {
        validateUserNumbersContainsOnlyNumbers(input, NEXT_GAME_INPUT_ERROR);
        validateNextGameStatusInputSize(input, NEXT_GAME_INPUT_ERROR);
        validateNextGameStatusNumberRange(input, NEXT_GAME_INPUT_ERROR);
    }

    private void validateUserNumbersContainsOnlyNumbers(String input, String message) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                exception(message);
            }
        }
    }

    private void validateIsSame(String input) {
        Set<String> set = Arrays.stream(input.split("")).collect(Collectors.toSet());
        if (set.size() != 3) {
            exception("중복 안됨");
        }
    }

    private void validateUserNumbersPermittedSize(String input, String message) {
        if (input.length() != 3) {
            exception(message);
        }
    }

    private void validateNextGameStatusInputSize(String input, String message) {
        if (input.length() != 1) {
            exception(message);
        }
    }

    private void validateUserNumbersPermittedRange(String input, String message) {
        for (int i = 0; i < input.length(); i++) {
            int number = input.charAt(i) - '0';
            if (!(number >= 1 && number <= 9)) {
                exception(message);
            }
        }
    }

    private void validateNextGameStatusNumberRange(String input, String message) {
        for (int i = 0; i < input.length(); i++) {
            int number = input.charAt(i) - '0';
            if (!(number >= 1 && number <= 2)) {
                exception(message);
            }
        }
    }

    private void exception(String message) {
        throw new IllegalArgumentException(ERROR + message);
    }
}
