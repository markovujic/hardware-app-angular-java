package hr.tvz.vujic.hardwareapp.hardware.repository;

import hr.tvz.vujic.hardwareapp.hardware.Hardware;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HardwareRepositoryTest {

    @Autowired
    HardwareRepository hardwareRepository;

    @Test
    void findAll() {
        List<Hardware> hardwareList = hardwareRepository.findAll();

        Assertions.assertNotNull(hardwareList);
        Assertions.assertEquals(hardwareList.size(), 3);
    }

    @Test
    void findByCode() {
        Optional<Hardware> hardware = hardwareRepository.findByCode("7731");

        Assertions.assertNotNull(hardware);
        Assertions.assertTrue(hardware.isPresent());
    }

    @Transactional
    @DirtiesContext
    @Test
    void save() {
        Optional<Hardware> hardware = hardwareRepository.save(
                new Hardware(4L,
                        "Patriot Memory Viper 4 Series 3000MHz 8GB",
                        "5566", 86.99, "RAM", 7));

        Assertions.assertNotNull(hardware);
        Assertions.assertTrue(hardware.isPresent());
    }

    @Transactional
    @DirtiesContext
    @Test
    void update() {
        Optional<Hardware> hardware = hardwareRepository.update("7731",
                new Hardware("Asus TUF RTX 3080", "7731", 1599.0, "GPU", 10));

        Assertions.assertNotNull(hardware);
        Assertions.assertTrue(hardware.isPresent());
    }

    @Transactional
    @DirtiesContext
    @Test
    void deleteByCode() {
        hardwareRepository.deleteByCode("7731");
        Optional<Hardware> hardware = hardwareRepository.findByCode("7731");

        Assertions.assertNotNull(hardware);
        Assertions.assertTrue(hardware.isEmpty());
    }
}