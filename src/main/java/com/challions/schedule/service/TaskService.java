package com.challions.schedule.service;

import com.challions.schedule.vo.CronCreateForm;

public interface TaskService {

	boolean createTask(CronCreateForm form);
}
