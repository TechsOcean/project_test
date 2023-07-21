package com.repository;

import java.util.List;

import com.entity.Project;
import com.entity.Task;

public interface ProjectRepository {
	
	public List<Task> createProject(Project project, List<Task> tasks);
	
	public List<Task> getTasksOfProject(Project project);
	
	public List<Project> getProjects();
	
}
