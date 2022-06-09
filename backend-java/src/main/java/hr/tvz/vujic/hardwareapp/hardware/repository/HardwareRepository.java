package hr.tvz.vujic.hardwareapp.hardware.repository;

import hr.tvz.vujic.hardwareapp.hardware.Hardware;
import hr.tvz.vujic.hardwareapp.hardware.HardwareDTO;

import java.util.List;
import java.util.Optional;

public interface HardwareRepository {

    List<Hardware> findAll();

    Optional<Hardware> findByCode(final String code);

    Optional<Hardware> save(Hardware hardware);

    Optional<Hardware> update(String code, Hardware updatedStudent);

    void deleteByCode(String code);

}
