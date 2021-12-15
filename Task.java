package taskService;

public class Task {
	private String taskId; //limit 10
	private String name; //limit 20
	private String description; //limit 50
	
	public Task(String tid, String nm, String desc) {
		
		if(tid == null || tid.length() > 10) {
			throw new IllegalArgumentException("Invalid task id - null or length > 10");
			}

		if(nm == null || nm.length() > 20) {
			throw new IllegalArgumentException("Invalid name - null or length > 20");
			}

		if(desc == null || desc.length() > 50) {
			throw new IllegalArgumentException("Invalid description - null or length > 50");
			}

		this.taskId = tid;
		this.name = nm;
		this.description = desc;
		}
	
	//getters
	public String getTaskId() {
		return taskId;
		}
	
	public String getName() {
		return name;
		}

	public String getDescription() {
		return description;
		}
	
	//setters	
	public void setTaskId(String tid) {
		
		if (tid == null || tid.length() > 10) {
			throw new IllegalArgumentException("task ID is invalid - null or length > 10");
			}
		
		else {
			this.taskId = tid;
			}
		}

	public void setName(String nm) {
		
		if (nm == null || nm.length() > 20) {
			throw new IllegalArgumentException("task name is invalid - null or length > 20");
			}
		
		else {
			this.name = nm;
			}
		}
	
	public void setDescription(String desc) {
		
		if (desc == null || desc.length() > 50) {
			throw new IllegalArgumentException("task description is invalid - null or length > 50");
			}
		
		else {
			this.description = desc;
			}
		}
	}