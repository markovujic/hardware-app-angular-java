package hr.tvz.vujic.hardwareapp.hardware.service;

import hr.tvz.vujic.hardwareapp.hardware.Hardware;
import hr.tvz.vujic.hardwareapp.hardware.HardwareCommand;
import hr.tvz.vujic.hardwareapp.hardware.HardwareDTO;
import hr.tvz.vujic.hardwareapp.hardware.repository.HardwareRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class HardwareServiceTest {

    @Autowired
    HardwareService hardwareService;

    @MockBean
    HardwareRepository hardwareRepository;

    @MockBean
    HardwareCommand hardwareCommand;

    @Test
    void findByCode() {

        when(hardwareRepository.findByCode("3344")).thenReturn(
                Optional.of(new Hardware(
                        1L, "Primjer hardwarea", "3344",
                        109.89, "OTHER", 6))
        );

        HardwareDTO hardwareDTO = hardwareService.findByCode("3344").orElse(null);
        Assertions.assertNotNull(hardwareDTO);
        Assertions.assertEquals(hardwareDTO.getCode(), "3344");
    }

    @Test
    void save() {

        when(hardwareRepository.save(new Hardware(1L,
                hardwareCommand.getName(),
                hardwareCommand.getCode(),
                hardwareCommand.getPrice(),
                hardwareCommand.getType(),
                hardwareCommand.getStock()))).thenReturn(
                Optional.of(new Hardware(
                        1L, "Primjer hardwarea", "3344",
                        109.89, "OTHER", 6))
        );

        Optional<HardwareDTO> hardwareDTO = hardwareService.save(hardwareCommand);
        Assertions.assertNotNull(hardwareDTO);
        Assertions.assertEquals(hardwareDTO, Optional.empty());
    }


    @Test
    void deleteByCode() {
        hardwareService.deleteByCode("1234");

        verify(hardwareRepository).deleteByCode("1234");
    }


}