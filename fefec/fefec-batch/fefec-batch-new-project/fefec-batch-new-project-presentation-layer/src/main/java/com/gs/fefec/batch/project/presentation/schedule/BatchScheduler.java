package com.gs.fefec.batch.project.presentation.schedule;



import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;


public class BatchScheduler {

	private static Logger log = Logger.getLogger(BatchScheduler.class) ; 
	@Autowired
	private JobLauncher launcher;
	
	@Autowired
	private Job job;
		
	private JobExecution execution;
	
	public void run(){	
		try {
			JobParametersBuilder builder = new JobParametersBuilder();
			builder.addDate("date", new Date());
			execution = launcher.run(job, builder.toJobParameters());
			log.info("Execution status: "+ execution.getStatus());
		} catch (JobExecutionAlreadyRunningException e) {
			e.printStackTrace();
		} catch (JobRestartException e) {			
			e.printStackTrace();
		} catch (JobInstanceAlreadyCompleteException e) {			
			e.printStackTrace();
		} catch (JobParametersInvalidException e) {			
			e.printStackTrace();
		}
	}
}

