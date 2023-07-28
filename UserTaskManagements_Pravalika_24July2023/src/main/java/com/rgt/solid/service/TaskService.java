package com.rgt.solid.service;

import java.time.LocalDate;
import java.util.List;

import com.rgt.solid.entity.Priority;
import com.rgt.solid.entity.Project;
import com.rgt.solid.entity.Task;

public interface TaskService {

	void createTask(int id, String title, String description, LocalDate dueDate, Priority priority);

	void updateTask(Task task);

	void markTaskAsCompleted(Task task);

	List<Task> getAllTasks();

	List<Task> getTasksByProject(Project project);

	List<Task> getTasksByPriority(Priority priority);

	void completeTask(Task task);
}
