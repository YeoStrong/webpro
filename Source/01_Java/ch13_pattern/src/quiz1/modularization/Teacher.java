package quiz1.modularization;

import quiz1.interfaces.GetSalary;
import quiz1.interfaces.JobLec;

public class Teacher extends Person {
	private String subject;
	

	public Teacher(String id, String name, String subject) {
		super(id, name);
		// TODO Auto-generated constructor stub
		this.subject = subject;
		setJob(new JobLec());
		setGet(new GetSalary());
	}
	public void setsubject(String subject) {
		this.subject = subject;
	}
}