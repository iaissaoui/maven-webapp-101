package model;

public class Task {

	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Task(String name) {
		super();
		this.name = name;
	}

	public Task() {
		super();
	}

	@Override
	public String toString() {
		return "Task [name=" + name + "]";
	}

}
