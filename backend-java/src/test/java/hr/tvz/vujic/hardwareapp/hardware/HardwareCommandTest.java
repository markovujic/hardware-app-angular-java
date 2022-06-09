package hr.tvz.vujic.hardwareapp.hardware;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HardwareCommandTest {

    @Test
    void isHardwareCommandEmpty() {
        HardwareCommand hardwareCommand = new HardwareCommand();

        Assertions.assertNull(hardwareCommand.getName());
        Assertions.assertNull(hardwareCommand.getCode());
        Assertions.assertNull(hardwareCommand.getPrice());
        Assertions.assertNull(hardwareCommand.getType());
        Assertions.assertNull(hardwareCommand.getStock());
    }

}