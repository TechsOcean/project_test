package com.service.impl;

import java.util.Collections;
import java.util.List;

import com.entity.Project;
import com.entity.Task;
import com.repository.ProjectRepository;
import com.repository.impl.ProjectRepositoryImpl;
import com.service.ProjectService;

public class ProjectServiceImpl implements ProjectService {
	ProjectRepository projectRepo = new ProjectRepositoryImpl();
	
	@Override
	public List<Task> getTaskOfProject(Project project) {
		List<Task> projectTasks = projectRepo.getTasksOfProject(project);
		if(projectTasks == null) return null;
		Collections.sort(projectTasks);
		return projectTasks;
	}
	
	@Override
	public Project createProject(Project project, List<Task> tasks) {
		projectRepo.createProject(project,tasks);
		return null;
	}

	@Override
	public List<Project> getProjects() {
		List<Project> projects = projectRepo.getProjects();
		return projects;
	}

}
