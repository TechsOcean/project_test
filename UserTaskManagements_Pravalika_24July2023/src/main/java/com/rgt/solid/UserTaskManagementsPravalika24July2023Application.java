package com.rgt.solid;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rgt.solid.entity.Priority;
import com.rgt.solid.entity.Project;
import com.rgt.solid.entity.Task;
import com.rgt.solid.repository.InMemoryProjectRepository;
import com.rgt.solid.repository.InMemoryTaskRepository;
import com.rgt.solid.repository.ProjectRepository;
import com.rgt.solid.repository.TaskRepository;
import com.rgt.solid.service.ProjectService;
import com.rgt.solid.service.ProjectServiceImpl;
import com.rgt.solid.service.TaskService;
import com.rgt.solid.service.TaskServiceImpl;

@SpringBootApplication
public class UserTaskManagementsPravalika24July2023Application {

	public static void main(String[] args) {
		TaskRepository taskRepository = new InMemoryTaskRepository();
		TaskService taskService = new TaskServiceImpl(taskRepository);
		ProjectRepository projectRepository = new InMemoryProjectRepository();
		ProjectService projectService = new ProjectServiceImpl(projectRepository);
		Scanner scanner = new Scanner(System.in);
		Project project = null;

		while (true) {
			System.out.println("--------Project Management System------");
			System.out.println("1. Create Project");
			System.out.println("2. View All Projects");
			System.out.println("3. Create Task");
			System.out.println("4. View All Tasks");
			System.out.println("5. Mark Task as Completed");
			System.out.println("6. Add Task to Project");
			System.out.println("7. View Tasks by Project");
			System.out.println("8. View Tasks by Priority");
			System.out.println("9. Exit");
			System.out.print("Choose an option: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				System.out.print("Enter project name: ");
				String projectName = scanner.nextLine();
				project = new Project(projectName);
				projectService.createProject(project);
				System.out.println("project created successfully");
				break;
			case 2:
				List<Project> allProjects = projectService.getAllProjects();
				for (Project p : allProjects) {
					System.out.println("Project Name: " + p.getName());
				}
				break;
			case 3:
				System.out.print("Enter the task id :");
				int id = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter task title: ");
				String title = scanner.nextLine();
				System.out.print("Enter task description: ");
				String description = scanner.nextLine();
				System.out.print("Enter task due date (YYYY-MM-DD): ");
				String dueDateString = scanner.nextLine();
				LocalDate dueDate = LocalDate.parse(dueDateString);
				System.out.print("enter priority ");
				System.out.print("Enter priority (LOW, NORMAL, HIGH, or URGENT)");
				String priorities = scanner.nextLine();
				Priority priority = Priority.valueOf(priorities.toUpperCase());
				taskService.createTask(id, title, description, dueDate, priority);
				System.out.println("task created successfully");
				break;
			case 4:
				List<Task> allTasks = taskService.getAllTasks();
				for (Task t : allTasks) {
					System.out.println("Task Title: " + t.getTitle() + ", Description: " + t.getDescription());
				}
				break;
			case 5:
				System.out.print("Enter Task Title: ");
				String tasktitle = scanner.nextLine();
				scanner.nextLine();
				Task task = taskRepository.getTaskByTitle(tasktitle);
				if (task != null) {
					taskService.completeTask(task);
					System.out.println("Task marked as completed!");
				} else {
					System.out.println("Task not found!");
				}
				break;
			case 6:
				System.out.print("Enter Project Name: ");
				String projectNames = scanner.nextLine();
				System.out.print("Enter Title Name: ");
				String tasks = scanner.nextLine();
				Project projects = projectRepository.getProjectByName(projectNames);
				Task taskToAdd = taskRepository.getTaskByTitle(tasks);
				if (project != null && taskToAdd != null) {
					projectService.addTaskToProject(project, taskToAdd);
					System.out.println("Task added to project successfully");
				} else {
					System.out.println("Project or Task not found!");
				}
				break;

			case 7:
				System.out.print("Enter Project Name: ");
				String name = scanner.nextLine();
				Project projectToFind = projectRepository.getProjectByName(name);
				if (projectToFind != null) {
					List<Task> tasksInProject = projectService.getTasksByProject(projectToFind);
					if (!tasksInProject.isEmpty()) {
						System.out.println("Tasks in " + projectToFind.getName() + ": ");
						for (Task taskInProject : tasksInProject) {
							printTaskDetails(taskInProject);
						}
					} else {
						System.out.println("No tasks found for " + projectToFind.getName());
					}
				} else {
					System.out.println("No project found with the name: " + name);
				}
				break;
			case 8:
				System.out.print("Enter priority (LOW, NORMAL, HIGH, or URGENT): ");
				String priorityToView = scanner.nextLine();
				Priority prioritys = Priority.valueOf(priorityToView.toUpperCase());
				List<Task> tasksByPriority = taskService.getTasksByPriority(prioritys);
				for (Task t : tasksByPriority) {
					System.out.println("Task Title: " + t.getTitle() + ", Description: " + t.getDescription());
				}
				break;
			case 9:
				System.out.println("Goodbye!");
				scanner.close();
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice, Please try again...");
			}
			System.out.println("...closed....");
		}
	}

	private static void printTaskDetails(Task task) {
		System.out.println("Title: " + task.getTitle());
		System.out.println("Description: " + task.getDescription());
		System.out.println("Due Date: " + task.getDueDate());
		System.out.println("Priority: " + task.getPriority());
		System.out.println("Completed: " + (task.isCompleted() ? "Yes" : "No"));
		System.out.println("----------------------");
	}
}
