package quiz1.modularization;

import quiz1.interfaces.GetSalary;
import quiz1.interfaces.JobMng;

public class Staff extends Person {
	private String part;
	

	public Staff(String id, String name, String part) {
		super(id, name);
		// TODO Auto-generated constructor stub
		this.part = part;
		setJob(new JobMng());
		setGet(new GetSalary());
	}
	public void setpart(String part) {
		this.part = part;
	}
}