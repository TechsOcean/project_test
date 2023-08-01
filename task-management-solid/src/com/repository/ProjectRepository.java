package com.repository;

import java.util.List;

import com.entity.Project;
import com.entity.Task;

/**
 * @author Bharat
 *
 *projectRepository is implemented in ProjectRepositoryImpl class.
 *projectRepository contains methods to store and retrieve projects and list of tasks associated with each project.
 */

public interface ProjectRepository {
	
	public List<Task> createProject(Project project, List<Task> tasks);
	
	public List<Task> getTasksOfProject(Project project);
	
	public List<Project> getProjects();
	
}
