package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// ����ڿ��� ���ϴ� �μ���ȣ�� �޾� �μ������� �Ѹ���, �ش� �μ��� ��������� ���
	// 1. �ش� �μ� ��ȣ�� ���� ��� : �������� �ʴ� �μ��Դϴ�.
	// 2. �ش� �μ� ��ȣ�� �ִ� ��� : �μ� ���� ���
		// 2-1. �ش� �μ� ����� �ִ� ��� : ��� ���� ���(���, �̸�, �޿�, ����̸�)
		// 2-2. �ش� �μ� ����� ���� ��� : �ش� �μ��� ����� �����ϴ�.
public class Ex2_selectWhereDeptno2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner scan = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		System.out.println("���� ����� ���ϴ� �μ��� �μ� ��ȣ�� �Է��ϼ���: ");
		int deptno = scan.nextInt();
		String sql = "SELECT * FROM DEPT WHERE DEPTNO=" + deptno;
		String sql2 = "SELECT W.EMPNO, W.ENAME, W.SAL, M.ENAME MANAGER\r\n" + 
				"    FROM EMP W, EMP M" + 
				"    WHERE W.MGR=M.EMPNO AND W.DEPTNO=" + deptno;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				System.out.println(deptno + "�� �μ������� ������ �����ϴ�.");
				System.out.println("�μ���: " + dname);
				System.out.println("�μ���ġ: " + loc);				
				rs.close();
				rs = stmt.executeQuery(sql2);
				if(rs.next()) {
					System.out.println(deptno + "�� �μ��� ��� �����Դϴ�.");
					System.out.printf("���\t�̸�\t�޿�\t����̸�\n");
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						int sal = rs.getInt("sal");
						String manager = rs.getString("manager");
						System.out.printf("%d\t %s\t %d\t %s\n", empno, ename, sal, manager);
					} while(rs.next());
				} else {
					System.out.println(deptno + "�� �μ� ����� �����ϴ�.");
				}
			} else {
				System.out.println("�������� �ʴ� �μ��Դϴ�.");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			try { // 7�ܰ�. ���� ����
				if(rs!=null) rs.close();
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
	}
}
