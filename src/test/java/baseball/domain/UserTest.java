package baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {

    @DisplayName("setUserNumbers 테스트")
    @Test
    public void setUserNumbersTest() {
        // given
        User user = new User();

        // when
        user.setUserNumbers(List.of(1, 2, 3));

        // then
        assertThat(user.getUserNumbers()).isEqualTo(List.of(1, 2, 3));
    }

    @DisplayName("finishGame 테스트")
    @Test
    public void finishGameTest() {
        // given
        User user = new User();

        // when
        user.finishGame();

        // then
        assertThat(user.isGameDone()).isEqualTo(true);
    }
}
