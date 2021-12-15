package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import taskService.TaskService;

class TaskServiceTest {
	private String testTaskName = "Code";
	private String testFailTaskName = "Complete CS-320-T2646 Software Test Automation& QA 21EW2";
	private String testDescription = "Write a code and test";
	private String testFailDescription = "Write a complete code with zero errors that passes all tests on the first try";

	@Test
	void addTaskTest() throws Exception {
		TaskService service = new TaskService();
		service.addTask(testTaskName, testDescription);
		Assertions.assertEquals(service.getlistOfTask().get(0).getName(), testTaskName);
		Assertions.assertEquals(service.getlistOfTask().get(0).getDescription(), testDescription);
		}
	
	//Test to confirm values are set correctly
	@Test
	void newTaskTest() {
		TaskService service = new TaskService();
		service.addTask(testTaskName, testDescription);
		Assertions.assertNotNull(service.getlistOfTask().get(0).getTaskId());
		Assertions.assertNotEquals("INITIAL", service.getlistOfTask().get(0).getTaskId());
		}
	
	@Test
	void newTaskNameTest() {
		TaskService service = new TaskService();
		service.addTask(testTaskName, testDescription);
		Assertions.assertNotNull(service.getlistOfTask().get(0).getName());
		Assertions.assertEquals(testTaskName, service.getlistOfTask().get(0).getName());
		}
	
	@Test
	void newTaskDescriptionTest() {
		TaskService service = new TaskService();
		service.addTask(testTaskName, testDescription);
		Assertions.assertNotNull(service.getlistOfTask().get(0).getDescription());
		Assertions.assertEquals(testDescription, service.getlistOfTask().get(0).getDescription());
		}

	@Test
	void searchForTaskTest() {
		TaskService service = new TaskService();
		service.addTask(testTaskName, testDescription);
		Assertions.assertNotNull(service.getlistOfTask().get(0).getTaskId());
		Assertions.assertEquals(service.searchForTask(service.getlistOfTask().get(0).getTaskId()), service.getlistOfTask().get(0));
		}
	
	//Test Fail cases of values
	@Test
	void searchForTaskFailTest() {
		TaskService service = new TaskService();
		@SuppressWarnings("unused")
		IndexOutOfBoundsException thrown = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> 
		service.searchForTask(service.getlistOfTask().get(0).getTaskId()));
	}
	
	@Test
	void newTaskFailNameTest() {
		TaskService service = new TaskService();
		IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> 
		service.addTask(testFailTaskName, testDescription), "Invalid name - null or length > 20");
		Assertions.assertEquals("Invalid name - null or length > 20", thrown.getMessage());
	}
	
	@Test
	void newTaskFailDescriptionTest() {
		TaskService service = new TaskService();
		IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> 
		service.addTask(testTaskName, testFailDescription), "Invalid description - null or length > 50");
		Assertions.assertEquals("Invalid description - null or length > 50", thrown.getMessage());
	}
	
	//Test Null cases of values
		@Test
		void newTaskNullNameTest() {
			TaskService service = new TaskService();
			IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> 
			service.addTask(null, testDescription), "Invalid name - null or length > 20");
			Assertions.assertEquals("Invalid name - null or length > 20", thrown.getMessage());
		}
		
		@Test
		void newTaskNullDescriptionTest() {
			TaskService service = new TaskService();
			IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> 
			service.addTask(testTaskName, null), "Invalid description - null or length > 50");
			Assertions.assertEquals("Invalid description - null or length > 50", thrown.getMessage());
		}
	
	//Test update function for Values
	@Test
	void updateTaskNameTest() throws Exception {
		TaskService service = new TaskService();
		service.addTask(testTaskName, testDescription);
		service.updateName(service.getlistOfTask().get(0).getTaskId(), testTaskName);
		Assertions.assertEquals(service.getlistOfTask().get(0).getName(), testTaskName);
	}
	
	@Test
	void updateDescriptionTest() throws Exception {
		TaskService service = new TaskService();
		service.addTask(testTaskName, testDescription);
		service.updateDescription(service.getlistOfTask().get(0).getTaskId(), testDescription);
		Assertions.assertEquals(service.getlistOfTask().get(0).getDescription(), testDescription);
	}
	
	//Delete Task Test
	@Test
	void deleteTaskTest() throws Exception {
		TaskService service = new TaskService();
		service.addTask(testTaskName, testDescription);
		service.deleteTask(service.getlistOfTask().get(0).getTaskId());
		Assertions.assertEquals(service.getlistOfTask().size(),0);
		}
	
	@RepeatedTest(4)
	void UuidTest() {
		TaskService service = new TaskService();
		service.addTask(testTaskName, testDescription);
		service.addTask(testTaskName, testDescription);
		service.addTask(testTaskName, testDescription);
		assertEquals(3, service.getlistOfTask().size());
		assertNotEquals(service.getlistOfTask().get(0).getTaskId(), service.getlistOfTask().get(1).getTaskId());
		assertNotEquals(service.getlistOfTask().get(0).getTaskId(), service.getlistOfTask().get(2).getTaskId());
		assertNotEquals(service.getlistOfTask().get(1).getTaskId(), service.getlistOfTask().get(2).getTaskId());
		}
	}