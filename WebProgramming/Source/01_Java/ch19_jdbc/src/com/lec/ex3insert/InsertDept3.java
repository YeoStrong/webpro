package com.lec.ex3insert;
// �Է¹��� �μ���ȣ�� �ߺ��� �μ���ȣ�� ��� ��� �޾�
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDept3 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			while(true) {
				System.out.println("�Է��� �μ� ��ȣ��? ");
				int deptno=sc.nextInt();
				String selectQuery = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=" + deptno;
				rs = stmt.executeQuery(selectQuery);
				rs.next();
				int cnt = rs.getInt("CNT");
				if(cnt!=0) {
					System.out.println("�ߺ��� �μ���ȣ�� �Է��ϼ̽��ϴ�.");
				}else {
					System.out.println("�Է��� �μ�����? ");
					String dname = sc.next();
					System.out.println("�Է��� �μ� ��ġ��? ");
					String loc = sc.next();
					String insertQuery = String.format("INSERT INTO DEPT VALUES ('%d', '%s', '%s')", deptno, dname, loc);
					int result = stmt.executeUpdate(insertQuery);
					System.out.println(result>0 ? "�Է¼���" : "�Է½���"); // �����ϸ� 1, �����ϸ� 0
					break;
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("�ߺ��� �μ���ȣ�̰ų� ���ڼ� ������ �ʰ��Ͽ� �Է��Ͽ����ϴ�. " + e.getMessage());
		} finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
	}
}
