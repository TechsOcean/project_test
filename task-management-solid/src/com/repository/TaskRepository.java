package com.repository;

import java.util.List;

import com.entity.Task;

/**
 * 
 * @author Bharat
 *
 *TaskRepository contains methods to store and retrieve tasks.
 */

public interface TaskRepository {
	
	public Task createTask(Task task);
	
	public List<Task> getTasks();
	
	public int getTaskIndex(Task task);
	
	public void updateTask(int index, Task task);
}
