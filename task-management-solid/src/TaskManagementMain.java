import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import com.entity.Project;
import com.entity.Task;
import com.service.Helper;
import com.service.ProjectService;
import com.service.TaskService;
import com.service.impl.HelperImpl;
import com.service.impl.ProjectServiceImpl;
import com.service.impl.TaskServiceImpl;

public class TaskManagementMain {
	
	static Helper helperService=new HelperImpl();
	static TaskService taskService = new TaskServiceImpl();
	static ProjectService projectService = new ProjectServiceImpl();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Integer mainMenuChoice;

		do {
			mainMenuChoice= helperService.showMainMenu();
			
			switch(mainMenuChoice) {
			
			//create project.
			case 1:
				Project project = helperService.inputProjectData();
				boolean addTask = helperService.wantToAddTasks();
				
				if(addTask) {
					List<Task> projectTasks = taskService.addTaskInProject(project);
					projectService.createProject(project, projectTasks);
				}
				else {
					projectService.createProject(project, null);
				}
				helperService.showSuccess("project");
				break;
				
			//create task
			case 2:
				//sc.nextLine();
				Task taskData = helperService.getTask();
				Task createdTask = taskService.createTask(taskData);
				helperService.showSuccess("Task");
				break;
				
			//show tasks (priority sorted).
			case 3:
				List<Task> tasks = taskService.getTasks();
				helperService.printTasks(tasks);
				break;
			
			//show tasks of a particular project.
			case 4:
				List<Project> projects = projectService.getProjects();
				Project selectedProject = helperService.selectProject(projects);
				List<Task> tasksOfProject = projectService.getTaskOfProject(selectedProject);
				helperService.printTasks(tasksOfProject);
				break;
				
			//marking a task done.
			case 5:
				
				break;
				
			//exit.
			case 6:
				System.out.println("exit successful");
				break;
			}
		}
		while(mainMenuChoice != 6);
		
		
		
		
	}
}
