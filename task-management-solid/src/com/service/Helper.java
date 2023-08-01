package com.service;

import java.text.ParseException;
import java.util.List;

import com.entity.Project;
import com.entity.Task;

/**
 * @author Bharat
 *
 *Helper interface is implemented by HelperImpl class.
 *contains methods for inputing and printing result.
 */

public interface Helper {
	public Task inputTaskData();
	
	public Task getTask();
	
	public Project inputProjectData();
	
	public boolean wantToAddTasks();
	
	public boolean wantToAddMoreTask();
	
	public Integer showMainMenu();

	public void showSuccess(String string);
	
	public void printTasks(List<Task> tasks);
	
	public Project selectProject(List<Project> projects);
	
	public Task selectTask(List<Task> tasks);
}
