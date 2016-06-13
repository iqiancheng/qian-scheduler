package com.challions.schedule.service;

import com.challions.schedule.model.TaskEntity;
import com.challions.schedule.schedule.ScheduledTask;
import com.challions.schedule.vo.CronCreateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.ScheduledFuture;

@Service
public class CronScheduleService implements ScheduleService {

	@Autowired
	private TaskScheduler taskScheduler;
	
	@Autowired
	private ScheduledTask scheduledTask;
	
	public boolean scheduleTask(CronCreateForm form) {
		boolean result = true;
		
		if(form != null) {
			// create task
			TaskEntity task = new TaskEntity();
			task.setName(form.getName());
			task.setCronExpression(form.getCron());
			task.setCreated(new Date());

			scheduledTask.setTask(task);
			
			// schedule task
			ScheduledFuture<?> sched = taskScheduler.schedule(scheduledTask, new CronTrigger(task.getCronExpression()));
			if(sched == null) {
				result = false;
			}
			// TODO work with scheduled feature 
			
		} else {
			result = false;
		}
		
		return result;
	}

}
