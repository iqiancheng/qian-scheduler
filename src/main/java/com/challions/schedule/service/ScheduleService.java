package com.challions.schedule.service;

import com.challions.schedule.vo.CronCreateForm;

public interface ScheduleService {

	boolean scheduleTask(CronCreateForm form);
}
