package com.lec.ex4update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
// ���ѹݺ��̸� commit, break, close �� �� �� Ȯ��
// ������ �μ���ȣ�� �޾� �����ϴ� �μ���ȣ���� Ȯ�� ��, �μ���, �ٹ��� �Է� �޾� update
public class UpdateDept2 {
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
				int deptno = sc.nextInt();
				String selectQuery = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO="+deptno;
				rs = stmt.executeQuery(selectQuery);
				rs.next();
				int cnt = rs.getInt("CNT");
				if(cnt!=1) {
					System.out.println("�ش��ϴ� ��ȣ�� �μ��� �����ϴ�.");
				}else {
					System.out.println("�Է��� �μ�����? ");
					String dname = sc.next();
					System.out.println("�Է��� �μ� ��ġ��? ");
					String loc = sc.next();
					String updateQuery = String.format("UPDATE DEPT SET DNAME='%s', LOC='%s'" + 
							"    WHERE DEPTNO=%d", dname, loc, deptno);
					int result = stmt.executeUpdate(updateQuery);
					System.out.println(result>0 ? deptno+"�� �μ� ���� ������Ʈ �Ϸ�" : "������Ʈ�� �����߽��ϴ�.");
					break;
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
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
