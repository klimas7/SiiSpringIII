package pl.sii.spring.boot;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTask {
    private static Log log = LogFactory.getLog(ScheduledTask.class);
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRateString = "${scheduled.time}")
    public void reportCurrentTime() {
        log.info("The time is now: " + DATE_FORMAT.format(new Date()));
    }

    @Scheduled(cron = "${scheduled.cron}")
    public void crone() {
        log.info("Cron: The time is now: " + DATE_FORMAT.format(new Date()));
    }
}
