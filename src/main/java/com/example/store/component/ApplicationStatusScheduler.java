package com.example.store.component;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;

public class ApplicationStatusScheduler {

	private final JobLauncher jobLauncher;
	private final Job applicationStatusJob;

	public ApplicationStatusScheduler(final JobLauncher jobLauncher, final Job applicationStatusJob) {
		this.jobLauncher = jobLauncher;
		this.applicationStatusJob = applicationStatusJob;
	}

	@Scheduled(cron = "0 * * * * *") // Runs every minute
	public void performApplicationStatusJob() throws Exception {
		final JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
				.toJobParameters();
		jobLauncher.run(applicationStatusJob, jobParameters);
	}
}
