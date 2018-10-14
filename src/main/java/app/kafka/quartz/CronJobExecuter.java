package app.kafka.quartz;

import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class CronJobExecuter extends QuartzJobBean {

	@Override
	protected void executeInternal(JobExecutionContext jobContext) throws JobExecutionException {
		JobDetail jobDetail = jobContext.getJobDetail();
		System.out.println("Job start: " + jobContext.getFireTime());

	    JobDataMap jobMap = jobDetail.getJobDataMap();
	    CronJobService cronJobService = (CronJobService) jobMap.get("cronjobservice");
	    
	    cronJobService.executeJob();
		
		System.out.println("Job next scheduled time: " + jobContext.getNextFireTime());
	}

}