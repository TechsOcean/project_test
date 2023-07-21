package com.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.entity.Project;
import com.entity.Task;
import com.repository.ProjectRepository;

public class ProjectRepositoryImpl implements ProjectRepository {

	private Map<Project, List<Task>> dataBase = new HashMap<>();
	
	@Override
	public List<Task> createProject(Project project, List<Task> tasks) {
		dataBase.put(project, tasks);
		return dataBase.get(project);
	}

	@Override
	public List<Task> getTasksOfProject(Project project) {
		List<Task> tasks;
		if(project == null) return null;
		if(dataBase.containsKey(project)) 
		{
			tasks = dataBase.get(project);
		}
		else tasks = null;
		return tasks;
	}

	@Override
	public List<Project> getProjects() {
		return new ArrayList<>(dataBase.keySet());
	}
	
	
}
