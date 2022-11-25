package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComputerTest {
    public Computer createComputer() {
        Computer computer = new Computer();
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
}
