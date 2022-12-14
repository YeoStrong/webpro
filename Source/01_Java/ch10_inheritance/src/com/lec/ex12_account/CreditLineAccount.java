package com.lec.ex12_account;

public class CreditLineAccount extends CheckingAccount {
	private long creditLine;
	public CreditLineAccount(String accountNo, String ownerName, String cardNo, long creditLine) {
		super(accountNo, ownerName, cardNo);
		this.creditLine = creditLine;
	}
	public CreditLineAccount(String accountNo, String ownerName, long balance, String cardNo, long creditLine) {
		super(accountNo, ownerName, balance, cardNo);
		this.creditLine = creditLine;
	}
	@Override
	public void pay(String cardNo, int amount) {
		if(getCardNo().equals(cardNo)) { //올바른 카드 번호 입력
			if(creditLine >= amount) { // 지불가능(중복if)
				//creditLine = creditLine - amount;
				creditLine -= amount; // 잔액 차감
				System.out.printf("%s님, %d원 지불하여 구매가 완료되었습니다.한도 %d원\n", getOwnerName(), amount, creditLine);
			}else { // 한도 초과로 지불 불가
				System.out.printf("%님 한도가 초과하여 구매가 취소되었습니다.\n", getOwnerName());
			}
		}else { // 틀린 카드 번호 입력 
			System.out.println("유효한 카드 번호가 아닙니다.");
		}
	}
}
