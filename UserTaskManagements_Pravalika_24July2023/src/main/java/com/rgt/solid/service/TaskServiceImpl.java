package com.rgt.solid.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rgt.solid.entity.Project;
import com.rgt.solid.entity.Task;
import com.rgt.solid.repository.TaskRepository;

import com.rgt.solid.entity.Priority;

@Service
public class TaskServiceImpl implements TaskService {
	private TaskRepository taskRepository;

	public TaskServiceImpl(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	@Override
	public void createTask(int id,String title, String description, LocalDate dueDate, Priority priority) {
		Task tasks = new Task(id, title, description, dueDate, priority);
		taskRepository.addTask(tasks);
	}

	@Override
	public void updateTask(Task task) {
		taskRepository.updateTask(task);
	}

	@Override
	public void markTaskAsCompleted(Task task) {
		task.setCompleted(true);
		taskRepository.updateTask(task);
	}

	@Override
	public List<Task> getAllTasks() {
		return taskRepository.getAllTasks();
	}

	@Override
	public List<Task> getTasksByProject(Project project) {
		return taskRepository.getTasksByProject(project);
	}

	@Override
	public List<Task> getTasksByPriority(Priority priority) {
		return taskRepository.getTasksByPriority(priority);
	}

	@Override
	public void completeTask(Task task) 
	{
		task.setCompleted(true);	
	}
}