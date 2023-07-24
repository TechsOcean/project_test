package com.repository.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.entity.Project;
import com.entity.Task;
import com.repository.TaskRepository;

public class TaskRepositoryImpl implements TaskRepository{

	private List<Task> tasks = new ArrayList<>();
	
	@Override
	public List<Task> getTasks() {
		Collections.sort(tasks);
		return tasks;
	}

	@Override
	public Task createTask(Task task) {
		tasks.add(task);
		int lastIndexOf = tasks.lastIndexOf(task);
		Task task2 = tasks.get(lastIndexOf);
		return task2;
	}
	
	@Override
	public int getTaskIndex(Task task) {
		int taskIndex = tasks.indexOf(task);
		return taskIndex;
	}

	@Override
	public void updateTask(int index, Task task) {
		tasks.set(index, task);
	}
	
	
	
}
