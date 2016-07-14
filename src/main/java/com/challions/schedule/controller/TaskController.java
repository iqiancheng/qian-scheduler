package com.challions.schedule.controller;

import com.challions.schedule.service.ScheduleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

@Controller
@RequestMapping(value = "/tasks")
public class TaskController {

	@Autowired
	private ThreadPoolTaskScheduler taskScheduler;

    @Autowired
    private ScheduleService scheduleService;

    /**
     * create new cron task
     * 
     * @return view name
     */
    @RequestMapping
    public String list() {
        ScheduledExecutorService scheduler = taskScheduler.getScheduledExecutor();
        ScheduledThreadPoolExecutor executor =  taskScheduler.getScheduledThreadPoolExecutor();
        BlockingQueue<Runnable> queue = executor.getQueue();
//        scheduleService.;

        return "tasks";
    }

}
