package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComputerTest {
    public Computer createComputer() {
        Computer computer = new Computer(List.of(1, 2, 3));
        return computer;
    }

    @DisplayName("생성자 테스트")
    @Test
    public void computerConstructorTest() {
        // when
        Computer computer = createComputer();

        // then
        assertThat(computer.getBallCount()).isEqualTo(0);
        assertThat(computer.getStrikeCount()).isEqualTo(0);
    }

    @DisplayName("3스트라이크인지 확인해주는 기능 테스트")
    @Test
    public void isThreeStrikeTest() {
        // given
        Computer computer = createComputer();

        // when
        boolean result = computer.isThreeStrike();

        // then
        assertThat(result).isEqualTo(false);
    }

    @DisplayName("볼, 스트라이크의 수를 구해주는 compareNumbers 테스트")
    @Test
    public void compareNumbersTest() {
        // given
        Computer computer = createComputer();
        List<Integer> userNumbers = List.of(1, 3, 2); // 1스트라이크, 2볼

        // when
        computer.compareNumbers(userNumbers);

        // then
        assertThat(computer.getStrikeCount()).isEqualTo(1);
        assertThat(computer.getBallCount()).isEqualTo(2);
    }

    @DisplayName("스트라이크, 볼 카운터가 모두 있는 경우")
    @Test
    public void hasBallAndStrikeCountTest() {
        // given
        Computer computer = createComputer();
        List<Integer> userNumbers = List.of(1, 3, 2); // 1스트라이크, 2볼
        computer.compareNumbers(userNumbers);

        // when
        boolean result = computer.hasBallAndStrikeCount();

        // then
        assertThat(result).isEqualTo(true);
    }

    @DisplayName("스트라이크 카운터만 있는 경우")
    @Test
    public void hasComputerOnlyStrikeCountTest() {
        // given
        Computer computer = createComputer();
        List<Integer> userNumbers = List.of(1, 2, 3); // 1스트라이크, 2볼
        computer.compareNumbers(userNumbers);

        // when
        boolean result = computer.hasComputerOnlyStrikeCount();

        // then
        assertThat(result).isEqualTo(true);
    }

    @DisplayName("볼 카운터만 있는 경우")
    @Test
    public void hasComputerOnlyBallCount() {
        // given
        Computer computer = createComputer();
        List<Integer> userNumbers = List.of(3, 1, 2); // 1스트라이크, 2볼
        computer.compareNumbers(userNumbers);

        // when
        boolean result = computer.hasComputerOnlyBallCount();

        // then
        assertThat(result).isEqualTo(true);
    }

    @DisplayName("낫싱인 경우")
    @Test
    public void hasComputerNothingCount() {
        // given
        Computer computer = createComputer();
        List<Integer> userNumbers = List.of(5, 6, 7); // 1스트라이크, 2볼
        computer.compareNumbers(userNumbers);

        // when
        boolean result = computer.hasComputerNothingCount();

        // then
        assertThat(result).isEqualTo(true);
    }

}
