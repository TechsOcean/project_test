package com.rgt.solid.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rgt.solid.entity.Project;

@Repository
public interface ProjectRepository {

	void addProject(Project project);

	void updateProject(Project project);

	void deleteProject(Project project);

	List<Project> getAllProjects();

	Project getProjectByName(String name);
}
