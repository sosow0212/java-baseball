package baseball.exception;

public class GameException {
    private static final String ERROR = "[ERROR] ";
    private static final String USER_INPUT_ERROR = "입력은 1~9의 숫자 3개로 이뤄져야합니다.";
    private static final String NEXT_GAME_INPUT_ERROR = "입력은 1과 2 둘 중 하나만 입력이 가능합니다.";

    public void validateUserNumberInput(String input) {
        validateUserNumbersContainsOnlyNumbers(input, USER_INPUT_ERROR);
        validateUserNumbersPermittedSize(input, USER_INPUT_ERROR);
        validateUserNumbersPermittedRange(input, USER_INPUT_ERROR);
    }

    public void validateNextGameStatusInput(String input) {
        validateUserNumbersContainsOnlyNumbers(input, NEXT_GAME_INPUT_ERROR);
        validateNextGameStatusInputSize(input, NEXT_GAME_INPUT_ERROR);
        validateNextGameStatusNumberRange(input, NEXT_GAME_INPUT_ERROR);
    }

    public void validateUserNumbersContainsOnlyNumbers(String input, String message) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                exception(message);
            }
        }
    }

    public void validateUserNumbersPermittedSize(String input, String message) {
        if (input.length() != 3) {
            exception(message);
        }
    }

    public void validateNextGameStatusInputSize(String input, String message) {
        if (input.length() != 1) {
            exception(message);
        }
    }

    public void validateUserNumbersPermittedRange(String input, String message) {
        for (int i = 0; i < input.length(); i++) {
            int number = input.charAt(i) - '0';
            if (!(number >= 1 && number <= 9)) {
                exception(message);
            }
        }
    }

    public void validateNextGameStatusNumberRange(String input, String message) {
        for (int i = 0; i < input.length(); i++) {
            int number = input.charAt(i) - '0';
            if (!(number >= 1 && number <= 2)) {
                exception(message);
            }
        }
    }

    public void exception(String message) {
        throw new IllegalArgumentException(ERROR + message);
    }
}
