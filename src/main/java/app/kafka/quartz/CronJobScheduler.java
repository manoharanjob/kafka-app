package app.kafka.quartz;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.kafka.constants.KafkaConfig;

@Component
public class CronJobScheduler {

	@Autowired
	private Scheduler scheduler;
	@Autowired
	private CronJobService cronJobService;

	@PostConstruct
	public void createSchedule() throws SchedulerException {
		 JobKey jobKey = new JobKey("KAFKA_JOB", "DATA_PUSH_TO_KAFKA_PRODUCER");
		 Map<String, Object> jobMap = new HashMap<String, Object>();
	     jobMap.put("cronjobservice", cronJobService);
	     JobDataMap dataMap = new JobDataMap(jobMap)
	    		  ;
		 JobDetail jobDetail = JobBuilder.newJob(CronJobExecuter.class)
				 .withDescription("Data push to Kafka producer")
				 .withIdentity(jobKey)
				 .setJobData(dataMap)
				 .build();
		 
		 Trigger trigger = TriggerBuilder.newTrigger()
	                .forJob(jobDetail)
	                .withIdentity("trigger-" + "EmailJob", "DATA_PUSH_TO_KAFKA_PRODUCER")
	        		.startNow()
	        		.withSchedule(CronScheduleBuilder.cronSchedule(KafkaConfig.CRON_EXPRESSION))
	                .build();
		 scheduler.scheduleJob(jobDetail, trigger);
		 System.out.println("Cron Job Sceduled");
	}

	@PreDestroy
	public void preDestroy() throws SchedulerException {
		scheduler.shutdown(true);
		System.out.println("Cron Job shutdown");
	}
}