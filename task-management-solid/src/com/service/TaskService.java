package com.service;

import java.util.List;

import com.entity.Project;
import com.entity.Task;

public interface TaskService {
	public Task createTask(Task task);
	
	public List<Task> addTaskInProject(Project project);
	
	public List<Task> getTasks();
	
	public Task updateTask(Task task);
}
