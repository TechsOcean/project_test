package com.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.entity.Project;
import com.entity.Task;
import com.repository.TaskRepository;
import com.repository.impl.TaskRepositoryImpl;
import com.service.Helper;
import com.service.TaskService;

public class TaskServiceImpl implements TaskService {

	TaskRepository taskRepo = new TaskRepositoryImpl();
	Helper helperService = new HelperImpl();
	
	@Override
	public Task createTask(Task task) {
		Task createdTask = taskRepo.createTask(task);
		return createdTask;
	}
	
	@Override
	public List<Task> getTasks() {
		List<Task> tasks = this.taskRepo.getTasks();
		return tasks;
	}

	@Override
	public List<Task> addTaskInProject(Project project) {
		List<Task> projectTasks = new ArrayList<>();
		boolean addMore;
		do {
			Task taskData = helperService.inputTaskData();
			taskData.setProject(project);
			Task createdTask = this.taskRepo.createTask(taskData);
			projectTasks.add(createdTask);
			addMore  = helperService.wantToAddMoreTask();
		}
		while(addMore);
		for(Task task : projectTasks) System.out.println(task);
		return projectTasks;
	}
	
	@Override
	public Task updateTask(Task task) {
		int taskIndex = taskRepo.getTaskIndex(task);
		if(taskIndex < 0)
		{
			System.out.println("please select an existing task to update");
			return null;
		}
		else {
			task.setStatus(true);
			taskRepo.updateTask(taskIndex, task);
		}
		return null;
	}
}
