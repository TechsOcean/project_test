package com.rgt.solid.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.rgt.solid.entity.Priority;
import com.rgt.solid.entity.Project;
import com.rgt.solid.entity.Task;

@Repository
public class InMemoryTaskRepository implements TaskRepository {
	private List<Task> tasks = new ArrayList<>();

	@Override
	public void addTask(Task task) {
		tasks.add(task);
	}

	@Override
	public void updateTask(Task task) {
		// Find the task in the list by ID & update its details.
		int index = findTaskIndexById(task.getId());
		if (index != -1) {
			tasks.set(index, task);
		}
	}

	@Override
	public void deleteTask(Task task) {
		// Find the task in the list by ID & remove it.
		int index = findTaskIndexById(task.getId());
		if (index != -1) {
			tasks.remove(index);
		}
	}

	@Override
	public List<Task> getAllTasks() {
		return tasks;
	}

	@Override
	public List<Task> getTasksByProject(Project project) {
		List<Task> tasksByProject = new ArrayList<>();
		for (Task task : tasks) {
			if (task.getProject().equals(project)) {
				tasksByProject.add(task);
			}
		}
		return tasksByProject;
	}

	@Override
	public List<Task> getTasksByPriority(Priority priority) {
		List<Task> taskByPriority = new ArrayList<>();
		for (Task task : tasks) {
			taskByPriority.add(task);
		}
		return taskByPriority;
	}

	private int findTaskIndexById(int taskId) {
		for (int i = 0; i < tasks.size(); i++) {
			if (tasks.get(i).getId() == taskId) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public Task getTaskByTitle(String title) {
		for (Task task : tasks) {
			if (task.getTitle().equals(title)) {
				return task;
			}
		}
		return null;
	}
}
