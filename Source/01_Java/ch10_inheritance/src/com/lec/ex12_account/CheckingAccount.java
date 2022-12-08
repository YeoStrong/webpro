package com.lec.ex12_account;

public class CheckingAccount extends Account {
	private String cardNo;
	public CheckingAccount(String accountNo, String ownerName, String cardNo) {
		super(accountNo, ownerName);
		this.cardNo = cardNo;
	}
	public CheckingAccount(String accountNo, String ownerName, long balance, String cardNo) {
		super(accountNo, ownerName, balance);
		this.cardNo = cardNo;
	}
	public void pay(String cardNo, int amount) {
		if(this.cardNo.equals(cardNo)) { //�ùٸ� ī�� ��ȣ �Է�
			if(getBalance() >= amount) { // ���Ұ���(�ߺ�if)
				//balance = balance - amount;
				setBalance(getBalance() - amount); // �ܾ� ����
				System.out.printf("%s��, %d�� �����Ͽ� ���Ű� �Ϸ�Ǿ����ϴ�. ����(%s)�� �ܾ� %d��\n", getOwnerName(), amount, getAccountNo(),getBalance());
			}else { // �ܾ� �������� ���� �Ұ�
				System.out.printf("%s�� �ܾ��� �����Ͽ� ���Ű� ��ҵǾ����ϴ�.\n", getOwnerName());
			}
		}else { // Ʋ�� ī�� ��ȣ �Է� 
			System.out.println("��ȿ�� ī�� ��ȣ�� �ƴմϴ�.");
		}
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
}
