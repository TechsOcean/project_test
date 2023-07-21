package com.entity;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Task implements Comparable<Task>{
	
	private String title;
	private String description;
	private String dueDate;
	private Integer priority;
	private boolean status;
	private Project project;
	
	
	//getters and setters
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	//to string method.
	@Override
	public String toString() {
		return "title=" + title + ", description=" + description + ", dueDate=" + dueDate + ", priority="
				+ priority ;
	}
	
	
	//compareTo method returns tasks based on their priority (descending order).
	@Override
	public int compareTo(Task o) {
		if(this.getPriority() < o.getPriority()) return 1;
		else if(this.getPriority() > o.getPriority()) return -1;
		return 0;
	}
}
