package com.lec.ex0Conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		try {
			Class.forName(driver); // 1. ����̹� �ε�
			System.out.println("����̹� �ε� ����");
			conn = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("Oracle ���� ����");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("����̹� �ε� ����" + e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}finally {
			try {
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
	}
}
