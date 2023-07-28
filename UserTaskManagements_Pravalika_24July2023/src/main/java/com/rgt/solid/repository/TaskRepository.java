package com.rgt.solid.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rgt.solid.entity.Priority;
import com.rgt.solid.entity.Project;
import com.rgt.solid.entity.Task;

@Repository
public interface TaskRepository {

	void addTask(Task task);

	void updateTask(Task task);

	void deleteTask(Task task);

	List<Task> getAllTasks();

	List<Task> getTasksByProject(Project project);

	List<Task> getTasksByPriority(Priority priority);

	Task getTaskByTitle(String title);

	//Task getTaskById(int taskId);
}
