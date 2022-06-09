package hr.tvz.vujic.hardwareapp.hardware.service;

import com.github.fge.jsonpatch.JsonPatch;
import hr.tvz.vujic.hardwareapp.hardware.Hardware;
import hr.tvz.vujic.hardwareapp.hardware.HardwareCommand;
import hr.tvz.vujic.hardwareapp.hardware.HardwareDTO;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface HardwareService {

    List<HardwareDTO> findAll();

    Optional<HardwareDTO> findByCode(String code);

    Optional<HardwareDTO> save(HardwareCommand hardwareCommand);

    Optional<HardwareDTO> update(String code, HardwareCommand updatedHardwareCommand);

    void deleteByCode(String code);

}
