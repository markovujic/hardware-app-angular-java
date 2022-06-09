package hr.tvz.vujic.hardwareapp.quartz;

import hr.tvz.vujic.hardwareapp.hardware.Hardware;
import hr.tvz.vujic.hardwareapp.hardware.HardwareDTO;
import hr.tvz.vujic.hardwareapp.hardware.repository.HardwareRepository;
import hr.tvz.vujic.hardwareapp.hardware.service.HardwareService;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;
import java.util.stream.Collectors;

public class HardwareStockJob extends QuartzJobBean {

    @Autowired
    private HardwareService hardwareService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

        List<HardwareDTO> hardwareList = hardwareService.findAll();

        System.out.println("Ovo su trenutno dostupni hardveri");

        System.out.println("------------------------------------------------");

        hardwareList.stream().filter(hardwareDTO -> hardwareDTO.getStock() > 0).toList().forEach((hardwareDTO -> {
            System.out.println(hardwareDTO.getName() + " - " + hardwareDTO.getStock());
        }));

        System.out.println("------------------------------------------------");
    }
}
