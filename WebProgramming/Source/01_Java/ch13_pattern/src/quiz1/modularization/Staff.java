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
	public void setPart(String part) {
		this.part = part;
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		System.out.println("\t[ºÎ¼­]" + part);
	}
}