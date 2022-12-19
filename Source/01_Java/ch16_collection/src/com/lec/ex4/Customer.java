package com.lec.ex4;

public class Customer {
	private String name;
	private String tel;
	private String address;
	public Customer() {}
	public Customer(String name, String tel, String address) {
		this.name = name;
		this.tel = tel;
		this.address = address;
	}
	@Override
	public String toString() {
		return name + "\t" + tel + "\t" + address;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return toString().hashCode();
	}
	@Override
	public boolean equals(Object obj) { // s1.equals(s2) : s1Àº this, s2´Â obj
		// TODO Auto-generated method stub
		if(obj!=null & getClass()==obj.getClass()) {
			Customer other = (Customer)obj;
			return tel.equals(other.tel);
		}
		return false;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String adress) {
		this.address = adress;
	}
}
