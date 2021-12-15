package taskService;

import java.util.*;

public class TaskService {
	private final List<Task> listOfTask = new ArrayList<>();
	
	//creates task id randomly
	public String newTaskID() {
		return UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
		}
	
	//checks task id exist
	public Task searchForTask(String tid) {
		int index = 0;
		Task localList = null;
		while (index < listOfTask.size()) {
			
			if (tid.equals(listOfTask.get(index).getTaskId())) {
				localList = listOfTask.get(index);
				}
			
			index++;
			}		
		return localList;
		}
	
	public void addTask(String nm, String desc) {
		Task task = new Task(newTaskID(), nm, desc);
		listOfTask.add(task);
		}
	
	public void deleteTask(String tid) throws Exception {
		listOfTask.remove(searchForTask(tid));
		}

	//updating the name or description
	public void updateName(String tid, String nm) throws Exception {
		searchForTask(tid).setName(nm);
		}
	
	public void updateDescription(String tid, String desc)throws Exception {
		searchForTask(tid).setDescription(desc);
		}
	
	public List<Task> getlistOfTask() {
		return listOfTask;
		}
	}