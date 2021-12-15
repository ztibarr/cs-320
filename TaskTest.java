package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import taskService.Task;

class TaskTest {
	private String testTaskId = "0123456789";
	private String tesFailTaskId = "01234567890123456789";
	private String testName = "This name will pass";
	private String testFailName = "This name will definitely fail";
	private String testDescription = "This description will pass with 32";
	private String testFailDescription = "This description undeniably fail every single time with 58";
	
	//Test get ID
	@Test
	void testGetTaskId() {
		Task task = new Task(testTaskId, testName, testDescription);
		assertEquals(testTaskId, task.getTaskId());
		}
	
	//Test set Setting Values
	@Test
	void testSetTaskID() {
		Task task = new Task(testTaskId, testName, testDescription);
		task.setTaskId(testTaskId);
		assertEquals(testTaskId, task.getTaskId());
		}
	
	@Test
	void testSetTaskName() {
		Task task = new Task(testTaskId, testName, testDescription);
		task.setName(testName);
		assertEquals(testName, task.getName());
		}
	
	@Test
	void testSetDescription() {
		Task task = new Task(testTaskId, testName, testDescription);
		task.setDescription(testDescription);
		assertEquals(testDescription, task.getDescription());
		}
	
	// Test getters of values
		@Test
		void testGetTaskName() {
			Task task = new Task(testTaskId, testName, testDescription);
			assertNotNull(task.getName());
			assertEquals(testName, task.getName());
			}
		
		@Test
		void testGetDescription() {
			Task task = new Task(testTaskId, testName, testDescription);
			assertNotNull(task.getDescription());
			assertEquals(testDescription, task.getDescription());
			}
	
	//Test Fail case of Values
	@Test
	void tesFailTaskId() {
		IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, 
				() -> new Task(tesFailTaskId, testName, testDescription), "Invalid task id - null or length > 10");
		Assertions.assertEquals("Invalid task id - null or length > 10", thrown.getMessage());
		}
	
	@Test
	void testFailTaskName() {
		IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, 
				() -> new Task(testTaskId, testFailName, testDescription), "Invalid name - null or length > 20");
		Assertions.assertEquals("Invalid name - null or length > 20", thrown.getMessage());
		}
	
	@Test
	void testFailDescription() {
		IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, 
				() -> new Task(testTaskId, testName, testFailDescription), "Invalid description - null or length > 50");
		Assertions.assertEquals("Invalid description - null or length > 50", thrown.getMessage());
		}
	
	//Test Null case of Values
		@Test
		void tesNullTaskId() {
			IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, 
					() -> new Task(null, testName, testDescription), "Invalid task id - null or length > 10");
			Assertions.assertEquals("Invalid task id - null or length > 10", thrown.getMessage());
			}
		
		@Test
		void testNullTaskName() {
			IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, 
					() -> new Task(testTaskId, null, testDescription), "Invalid name - null or length > 20");
			Assertions.assertEquals("Invalid name - null or length > 20", thrown.getMessage());
			}
		
		@Test
		void testNullDescription() {
			IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, 
					() -> new Task(testTaskId, testName, null), "Invalid description - null or length > 50");
			Assertions.assertEquals("Invalid description - null or length > 50", thrown.getMessage());
			}
	}