package com.lec.ex2_human;
//Man kim = new Man();
// Man kim = new Man("ȫ�浿");
//Man kim = new Man("ȫ�浿", 22, 170, 65);
public class Man {
	private String name;
	private int age;
	private int height;
	private double weight;
	// �����ڰ� ������ �Լ��� ����� �����Ϸ��� ����Ʈ ������ �Լ��� ������ ����
	public Man() {
		System.out.println("�Ű����� ���� ������ �Լ�");
	}
	public Man(String name, int age, int height, double weight) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		System.out.println("������ 4�� �ʱ�ȭ�ϴ� ������ �Լ�");
	} //Man man = new Man("ȫ�浿");
	public Man(String name) {
		this.name = name;
		System.out.println("�̸� �ʱ�ȭ �ϴ� ������ �Լ�");
	} //Man man = new Man(180);
	public Man(int height) {
		this.height = height;
		System.out.println("Ű �ʱ�ȭ �ϴ� ������ �Լ�");
//		public Man(int age) { // ���� type�� ���� ������ ���� �ʱ�ȭ �ϴ� ������ �Լ��� ���� �Ұ�
//			this.age = age;
	}
	public Man(double weight) {
		this.weight = weight;
	}
	public double calculateBMI() { // ��ü ���� height�� weight�� BMI ���� return
		double result = weight / ((height*0.01) * (height*0.01));
		return result;
	}
	// getter : name, age, height, weight
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public int getHeight() {
		return height;
	}
	public double getWeight() {
		return weight;
	}
	// setter
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
}