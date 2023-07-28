package com.rgt.solid.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rgt.solid.entity.Project;
import com.rgt.solid.entity.Task;
import com.rgt.solid.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

	private ProjectRepository projectRepository;

	public ProjectServiceImpl(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	@Override
	public void createProject(Project project) {
		projectRepository.addProject(project);
	}

	@Override
	public void updateProject(Project project) {
		projectRepository.updateProject(project);
	}

	@Override
	public void deleteProject(Project project) {
		projectRepository.deleteProject(project);
	}

	@Override
	public List<Project> getAllProjects() {
		return projectRepository.getAllProjects();
	}

	@Override
	public void addTaskToProject(Project project, Task taskToAdd) {
		project.getTasks().add(taskToAdd);
	}

	@Override
	public List<Task> getTasksByProject(Project project) {
		return project.getTasks();
	}
}