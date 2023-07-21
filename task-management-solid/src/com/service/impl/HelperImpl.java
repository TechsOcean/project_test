package com.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.entity.Project;
import com.entity.Task;
import com.repository.TaskRepository;
import com.service.Helper;

public class HelperImpl implements Helper {

	Scanner sc = new Scanner(System.in);
	
	// input the task data from user;
	@Override
	public Task getTask() {
		sc.nextLine();
		Task inputTaskData = inputTaskData();
		return inputTaskData;
	}
	
	
	//input title,desc,dueDate,priority from user.
	@Override
	public Task inputTaskData() {
		Task task= new Task();
		
		try {
			System.out.println("!! Creating a new task !!");
			System.out.print("Task Title: ");
			String title = sc.nextLine();
			System.out.print("Task Description: ");
			String desc = sc.nextLine();
			System.out.print("priority (1-10): ");
			Integer priority = sc.nextInt();
			System.out.print("Task Due date (DD-MM-YYYY) : ");
			String dateString = sc.next();
			Date date = new SimpleDateFormat("dd-MM-yyyy").parse(dateString);
			dateString = new SimpleDateFormat("dd MMMM yyyy").format(date);
			
			//setting fields of task entity.
			task.setTitle(title);
			task.setDescription(desc);
			task.setPriority(priority);
			task.setDueDate(dateString);
			task.setStatus(true);
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
		return task;
	}

	//inputing user input for project entity.
	@Override
	public Project inputProjectData() {
		Project project = new Project();
		try {
			sc.nextLine();
			System.out.println("!! Creating New Project !!");
			System.out.print("Project name: ");
			String projectName=sc.nextLine();
			System.out.print("Project Description: ");
			String projectDesc = sc.nextLine();
			
			System.out.println("project title:"+projectName+" projectDesc:"+projectDesc);
			
			project.setProjectTitle(projectName);
			project.setProjectDescription(projectDesc);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return project;
	}

	
	/*
	 * ->accept a list of project as argument.
	 * ->display all the available projects.
	 * ->and give option to user to select one project out of that list.
	 * ->and return the selected project.
	 */
	@Override
	public Project selectProject(List<Project> projects) {
		int idx=1;
		int choice;
		if(projects.size() == 0) {
			System.out.println("No project available to display.");
			return null;
		}
		else {
			for(Project project : projects) {
				System.out.println(idx++ + ".) "+project.getProjectTitle());
			}
			System.out.print("Enter choice:");
			choice = sc.nextInt();
		}
		if(choice<=projects.size() && choice>0)
		{
			Project project = projects.get(choice-1);
			System.out.println("selected project"+project);
			return project;
		}
		else return null;
	}

	
	/*
	 * return a boolean yes or no based on, whether user wants to add tasks to project or not.
	 */
	@Override
	public boolean wantToAddTasks() {
		boolean addTask;
		Integer opt;
		System.out.println("would you like to add tasks in this project");
		System.out.println("    1.) yes");
		System.out.println("    2.) No");
		System.out.print("enter choice: ");
		opt = sc.nextInt();
		addTask = opt==1?true:false;
		return addTask;
	}

	
	//return yes or no, based on whether user want to add more tasks in the project or not.
	@Override
	public boolean wantToAddMoreTask() {
		Integer choice;
		System.out.println("1.) add more tasks into this project");
		System.out.println("2.) enough");
		System.out.print("enter choice: ");
		choice = sc.nextInt();
		sc.nextLine();
		return choice==1?true:false;
	}


	//show available options and return the selected option.
	@Override
	public Integer showMainMenu() {
		Integer choice;
		System.out.println("!!! Main Menu !!!");
		System.out.println("1.) Add Project");
		System.out.println("2.) Add Task");
		System.out.println("3.) Show Task with with high priority.");
		System.out.println("4.) show tasks of a project.");
		System.out.println("5.) mark a task done.");
		System.out.println("5.) exit");
		System.out.print("Enter choice: ");
		choice = sc.nextInt();
		return choice;
	}


	/*
	 * accept and print a list of tasks
	 */
	@Override
	public void printTasks(List<Task> tasks) {
		if(tasks==null || tasks.size() == 0) {
			System.out.println("no task to display.");
			return;
		}
		else {
			for(int i=0; i<tasks.size();i++)
			{
				System.out.println(tasks.get(i));
			}
		}
		
	}

	//show successfully added message.
	@Override
	public void showSuccess(String string) {
		System.out.println(string + " added successfully");
		System.out.println();
	}
	
	
}
