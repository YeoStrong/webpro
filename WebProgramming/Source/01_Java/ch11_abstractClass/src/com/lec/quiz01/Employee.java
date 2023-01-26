package com.lec.quiz01;
// name, int computePay(),int computeIncentive()
public abstract class Employee {
	private String name;
	public Employee() {}
	public Employee(String name) {
		this.name = name;
	}
	public abstract int computePay();
	public final int computeIncentive() {
		// TODO Auto-generated method stub
		int temp = computePay();
		if(temp >= 3000000) {
			return (int) (temp * 0.05);			
		}
		return 0;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
