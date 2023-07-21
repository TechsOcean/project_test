package com.entity;

import java.util.List;
import java.util.Set;

public class Project {
	private String projectTitle;
	private String projectDescription;
	private List<Task> tasks;
	
	
	//getters and setters;
	public String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	public String getProjectDescription() {
		return projectDescription;
	}
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	
	//to string method.
	@Override
	public String toString() {
		return "Project [projectTitle=" + projectTitle + ", projectDescription=" + projectDescription + ", tasks="
				+ tasks + "]";
	}
	
	
}
