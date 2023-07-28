package com.rgt.solid.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.rgt.solid.entity.Project;

@Repository
public class InMemoryProjectRepository implements ProjectRepository {
	private List<Project> projects = new ArrayList<>();

	@Override
	public void addProject(Project project) {
		projects.add(project);
	}

	@Override
	public void updateProject(Project project) {
		// projects.updateProject(project);
	}

	@Override
	public void deleteProject(Project project) {
		projects.remove(project);
	}

	@Override
	public List<Project> getAllProjects() {
		return projects;
	}

	@Override
	public Project getProjectByName(String name) {
		for (Project project : projects) {
			if (project.getName().equals(name)) {
				return project;
			}
		}
		return null;
	}

}