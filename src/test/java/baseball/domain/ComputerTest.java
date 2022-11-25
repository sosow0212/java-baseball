package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComputerTest {
    public Computer createComputer() {
        Computer computer = new Computer(List.of(1,2,3));
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
        Computer computer =  createComputer();

        // when
        boolean result = computer.isThreeStrike();

        // then
        assertThat(result).isEqualTo(false);
    }

    @DisplayName("볼과 스트라이크의 수를 구해주는 기능 테스트")
    @Test
    public void calculateStrikeCountTest() {
        // given
        Computer computer = createComputer();
        List<Integer> userNumbers = List.of(1,2,3);

        // when
        computer.compareNumbers(userNumbers);

        // then
        assertThat(computer.isThreeStrike()).isEqualTo(true);
        assertThat(computer.getBallCount()).isEqualTo(0);
    }

    @DisplayName("볼과 스트라이크의 수를 구해주는 기능 테스트2")
    @Test
    public void calculateStrikeCountTest2() {
        // given
        Computer computer = createComputer();
        List<Integer> userNumbers = List.of(2,1,3); // 1스트라이크 2볼

        // when
        computer.compareNumbers(userNumbers);

        // then
        assertThat(computer.isThreeStrike()).isEqualTo(false);
        assertThat(computer.getStrikeCount()).isEqualTo(1);
        assertThat(computer.getBallCount()).isEqualTo(2);
    }
}
