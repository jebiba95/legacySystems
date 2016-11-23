package practica2;

public class Task {
	private String type;
	private String date;
	private String name;
	private String description;
	
	public Task(String type, String date, String name, String description) {
		this.type = type;
		this.date = date;
		this.name = name;
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Task [type=" + type + ", date=" + date + ", name=" + name + ", description=" + description + "]";
	}
	
}
