package com.challions.schedule.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import com.challions.schedule.model.TaskEntity;
import com.challions.schedule.schedule.ScheduledTask;

@Configuration
@EnableScheduling
public class AppConfig implements SchedulingConfigurer {

	// define task
	@Bean
	public ScheduledTask task() {
		return new ScheduledTask(new TaskEntity());
	}

	// register task scheduler
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.setScheduler(taskScheduler());
	}
	
	// define task scheduler
	@Bean(destroyMethod = "shutdown")
	public ThreadPoolTaskScheduler taskScheduler() {
		ThreadPoolTaskScheduler pool = new ThreadPoolTaskScheduler();
		pool.setPoolSize(3);
		pool.setWaitForTasksToCompleteOnShutdown(true);
		
		return pool;		
	}
}
