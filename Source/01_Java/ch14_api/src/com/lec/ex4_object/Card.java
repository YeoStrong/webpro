package com.lec.ex4_object;
// new card('♥', 6) ♠ ♣ ◆
public class Card {
	private char kind; // ♥ ♠ ♣ ◆
	private int num; // 1 ~ 13
	public Card() {}
	public Card(char kind, int num) {
		this.kind = kind;
		this.num = num;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "카드: " + kind + " " + num; // 카드 : ♥ 7
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		// c1.equals(comCard) => card가 this. comCard가 obj
		// obj가 null이 아니고 obj가 Card타입 객체인지 확인 후, kind와 num 비교 결과 return
		// if(obj!=null && getClass()==obj.getClass()) {}
		if(obj!=null && obj instanceof Card) {
			// kind와 num 비교 결과 return
			Card other = (Card)obj;
			boolean kindChk = kind == other.kind; // kind,equals(om kkkAAAther.kind)
			boolean numChk = num == other.num;
			
			return kindChk && numChk;
		}else {
			return false;
		}
	}
}
