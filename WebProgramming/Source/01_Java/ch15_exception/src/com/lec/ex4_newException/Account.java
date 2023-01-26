package com.lec.ex4_newException;
/* ������: accountNo(String), ownerName(String), balance(long)
 * ���(�޼ҵ�) : deposit(����), withdraw(����), infoPrint(���� ���) */
public class Account {
	private String accountNo;
	private String ownerName;
	private long balance;
	public Account() {}
	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		System.out.println(ownerName + "�� ���� ���� �����մϴ�. ���� ��ȣ�� : " + accountNo + "�ܾ�: " + balance);
	}
	public Account(String accountNo, String ownerName, long balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		System.out.println(ownerName + "�� ���� ���� �����մϴ�. ���� ��ȣ�� : " + accountNo + "�ܾ�: " + balance);
	}
	public void deposit(long money) { // ������ ����, balance�� �ִ밪��ŭ ����
		balance += money;
		System.out.println(money + "�� �����Ͽ� �ܾ�: " + balance);
	}
	public void withdraw(long money) throws Exception { // �ܾ��� ���� ��츸 ����. �ܾ� ������ �ܾ��� �����մϴ� ���
		if(balance>=money) {
			balance -= money;
			System.out.println(money + "�� �����Ͽ� �ܾ�: " + balance);
		}else {
			// ch15���� ���� ���� �߻�
			throw new Exception("�ܾ��� �����Ͽ� ���� �Ұ��մϴ�.");
		}
	}
	public void infoPrint() {
		//"110-352-7894" ȫ�浿�� �ܾ�: 1000�� ���
//		System.out.println("\"" + accountNo + "\"" + ownerName + "�� �ܾ�: " + balance + "��");
		System.out.printf("\" %s \" %s �� �ܾ�: %d��\n", accountNo, ownerName, balance);
	}
	public String infoString() {
//		return "\"" + accountNo + "\"" + ownerName + "�� �ܾ�: " + balance + "��";
		return String.format("\" %s \" %s �� �ܾ�: %d��\n", accountNo, ownerName, balance);
	}
	// setter : ownerName
	// getter : accountNo, ownerName, balance
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	
}
