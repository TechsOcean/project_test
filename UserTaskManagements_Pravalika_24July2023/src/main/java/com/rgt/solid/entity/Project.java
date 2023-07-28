package com.rgt.solid.entity;

import java.util.ArrayList;
import java.util.List;

public class Project {

	private String projectName;
	private List<Task> tasks;

	public Project(String projectName) {
		this.projectName = projectName;
		this.tasks = new ArrayList<>();
	}

	public Project() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return projectName;
	}

	public void setName(String name) {
		this.projectName = name;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

}
