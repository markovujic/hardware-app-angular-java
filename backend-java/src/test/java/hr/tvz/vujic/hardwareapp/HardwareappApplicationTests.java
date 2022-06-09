package hr.tvz.vujic.hardwareapp;

import hr.tvz.vujic.hardwareapp.controllers.AuthenticationController;
import hr.tvz.vujic.hardwareapp.controllers.HardwareController;
import hr.tvz.vujic.hardwareapp.controllers.ReviewController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HardwareappApplicationTests {

    @Autowired
    private AuthenticationController authenticationController;

    @Autowired
    private HardwareController hardwareController;

    @Autowired
    private ReviewController reviewController;

    @Test
    void contextLoads() {
        Assertions.assertThat(authenticationController).isNotNull();
        Assertions.assertThat(hardwareController).isNotNull();
        Assertions.assertThat(reviewController).isNotNull();
    }

}
