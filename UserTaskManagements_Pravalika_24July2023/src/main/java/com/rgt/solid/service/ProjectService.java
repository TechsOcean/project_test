package com.rgt.solid.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rgt.solid.entity.Project;
import com.rgt.solid.entity.Task;

@Service
public interface ProjectService {

	void createProject(Project project);

	void updateProject(Project project);

	void deleteProject(Project project);

	List<Project> getAllProjects();

	void addTaskToProject(Project project, Task taskToAdd);

	List<Task> getTasksByProject(Project nameOfProject);
}
