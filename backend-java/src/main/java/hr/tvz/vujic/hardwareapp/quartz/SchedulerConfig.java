package hr.tvz.vujic.hardwareapp.quartz;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchedulerConfig {

    @Bean
    public JobDetail hardwareStockJobDetail() {
        return JobBuilder
                .newJob(HardwareStockJob.class)
                .withIdentity("hardware-stock-job")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger hardwareStockJobTrigger() {

        SimpleScheduleBuilder scheduleBuilder =
                SimpleScheduleBuilder.simpleSchedule()
                                     .withIntervalInSeconds(10)
                                     .repeatForever();

        return TriggerBuilder
                .newTrigger()
                .forJob(hardwareStockJobDetail())
                .withIdentity("hardware-stock-trigger")
                .withSchedule(scheduleBuilder).build();

    }


}
