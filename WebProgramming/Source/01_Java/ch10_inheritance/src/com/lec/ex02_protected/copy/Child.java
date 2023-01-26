package com.lec.ex02_protected.copy;
// SuperIJ: private i, j / public setI(), getI(), setJ(), getJ()    //100퍼센트 마음에 들면 상속받지 말고 그걸 쓰면 됨.
public class Child extends SuperIJ{
	private int total;
	public Child() {
		super();
		System.out.println("매개변수 없는 Child 생성자 함수");
	}
	public Child(int i, int j) { // 오후 수정 예정
		super (i, j);
		System.out.println("매개변수 있는 Child 생성자 함수 - i, j 초기화"); // super 이용하여 수정해보기
//		this.i = i;	//super class의 private라 직접 access 불가, protected라면 직접 사용 가능
//		//setI(i); 
//		this.j = j;
//		//setJ(j); 
	}
	public void sum() {
		total = i + j;
		//total = getI() + getJ();	
		System.out.println("i = " + getI() + ", j=" + getJ() + ", total = " + total);
	}
}
