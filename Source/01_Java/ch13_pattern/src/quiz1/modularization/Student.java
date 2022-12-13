package quiz1.modularization;

import quiz1.interfaces.GetStudentPay;
import quiz1.interfaces.JobStudy;

public class Student extends Person {
	private String ban;
	

	public Student(String id, String name, String ban) {
		super(id, name);
		// TODO Auto-generated constructor stub
		this.ban = ban;
		setJob(new JobStudy());
		setGet(new GetStudentPay());
	}
	public void setBan(String ban) {
		this.ban = ban;
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		System.out.println("\t[¹Ý]" + ban);
	}
}