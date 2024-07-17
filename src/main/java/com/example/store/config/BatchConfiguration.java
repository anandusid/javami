package com.example.store.config;

import java.time.LocalDateTime;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.store.component.ApplicationStatusScheduler;
import com.example.store.entity.ApplicationStatus;
import com.example.store.repo.ApplicationStatusRepo;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private ApplicationStatusRepo applicationStatusRepository;

	@Bean
	public Job applicationStatusJob() {
		return jobBuilderFactory.get("applicationStatusJob").incrementer(new RunIdIncrementer())
				.start(applicationStatusStep()).build();
	}

	@Bean
	public Step applicationStatusStep() {
		return stepBuilderFactory.get("applicationStatusStep").tasklet(applicationStatusTasklet()).build();
	}

	@Bean
	public Tasklet applicationStatusTasklet() {
		return (contribution, chunkContext) -> {
			final String status = "Sample Status"; // Example status message
			final ApplicationStatus applicationStatus = new ApplicationStatus();
			applicationStatus.setTime(LocalDateTime.now());
			applicationStatus.setStatus(status);
			applicationStatusRepository.save(applicationStatus);
			return RepeatStatus.FINISHED;
		};
	}

	@Bean
	public ApplicationStatusScheduler applicationStatusScheduler() {
		return new ApplicationStatusScheduler(jobLauncher, applicationStatusJob());
	}
}
