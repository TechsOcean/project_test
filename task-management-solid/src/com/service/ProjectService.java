package com.service;

import java.util.List;

import com.entity.Project;
import com.entity.Task;

public interface ProjectService {

	public Project createProject(Project project, List<Task> tasks);
	
	public List<Task> getTaskOfProject(Project project);
	
	public List<Project> getProjects();
}
	
	
