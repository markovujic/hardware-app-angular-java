package hr.tvz.vujic.hardwareapp.hardware.service;

import hr.tvz.vujic.hardwareapp.hardware.Hardware;
import hr.tvz.vujic.hardwareapp.hardware.HardwareCommand;
import hr.tvz.vujic.hardwareapp.hardware.HardwareDTO;
import hr.tvz.vujic.hardwareapp.hardware.repository.HardwareRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HardwareServiceImpl implements HardwareService {

    private final HardwareRepository hardwareRepository;

    public HardwareServiceImpl(HardwareRepository hardwareRepository) {
        this.hardwareRepository = hardwareRepository;
    }

    @Override
    public List<HardwareDTO> findAll() {
        return hardwareRepository.findAll().stream().map(this::mapHardwareToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<HardwareDTO> findByCode(String code) {
        return hardwareRepository.findByCode(code).map(this::mapHardwareToDTO);
    }

    @Override
    public Optional<HardwareDTO> save(final HardwareCommand hardwareCommand) {
        return hardwareRepository.save(mapCommandToHardware(hardwareCommand)).map(this::mapHardwareToDTO);
    }

    @Override
    public Optional<HardwareDTO> update(final String code, final HardwareCommand updatedHardwareCommand) {
        return hardwareRepository.update(code, mapCommandToHardware(updatedHardwareCommand))
                                 .map(this::mapHardwareToDTO);
    }

    @Override
    public void deleteByCode(final String code) {
        hardwareRepository.deleteByCode(code);
    }


    private HardwareDTO mapHardwareToDTO(final Hardware hardware) {
        return new HardwareDTO(hardware.getCode(), hardware.getName(), hardware.getPrice(),
                hardware.getType(), hardware.getStock());
    }

    private Hardware mapCommandToHardware(final HardwareCommand hardwareCommand) {
        return new Hardware(hardwareCommand.getName(), hardwareCommand.getCode(), hardwareCommand.getPrice(),
                hardwareCommand.getType(), hardwareCommand.getStock());
    }
}
