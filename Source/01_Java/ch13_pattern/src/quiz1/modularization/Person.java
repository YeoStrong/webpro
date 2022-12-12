package quiz1.modularization;

import quiz1.interfaces.GetImpl;
import quiz1.interfaces.JobImpl;

public abstract class Person {
	private String id;
	private String name;
	private JobImpl job;
	private GetImpl get;
	

	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public void job() {
		job.job();
	}
	public void get() {
		get.get();
	}
	public void print() {
		System.out.println(id + name);
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setJob(JobImpl job) {
		this.job = job;
	}
	public void setGet(GetImpl get) {
		this.get = get;
	}
}
