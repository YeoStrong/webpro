package com.lec.quiz01;

public class SalaryEmployee extends Employee {
	private int annalSalary;
	public SalaryEmployee(String name, int annalSalary) {
		super(name);
		this.annalSalary = annalSalary;
	}

	@Override
	public int computePay() {
		// TODO Auto-generated method stub
		return (int)(annalSalary / 14);
	}
	public int getAnnalSalary() {
		return annalSalary;
	}

	public void setAnnalSalary(int annalSalary) {
		this.annalSalary = annalSalary;
	}

}
