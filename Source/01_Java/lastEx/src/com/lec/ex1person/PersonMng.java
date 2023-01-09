package com.lec.ex1person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonMng {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection        conn = null;
		PreparedStatement pstmt = null; // 1, 2�� ���
		Statement         stmt  = null; // 3�� ���, ��������(jobs)
		ResultSet         rs    = null;
		Scanner           sc    = new Scanner(System.in);
		String fn, sql;
		ArrayList<String> jobs = new ArrayList<String>(); // �������� ����
		// ���������� jobs�� add
		try {
			sql = "SELECT JNAME FROM JOB";
			Class.forName(driver); // (1)����̹� �ε�
			conn = DriverManager.getConnection(url, "scott", "tiger");//(2)
			stmt = conn.createStatement();//(3)
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				jobs.add(rs.getString("jname"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs  !=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}// ������ ��������
		System.out.println(jobs);
		do {
			System.out.print("1:�Է� || 2:��������ȸ || 3:��ü��ȸ || �׿�:����");
			fn = sc.next();
			switch(fn) {
			case "1" : // �̸�, ������(jobs), ��,��, �� �޾� insert
				sql = "INSERT INTO PERSON " + 
						"    VALUES (PERSON_NO_SQ.NEXTVAL, ?, "
						+ "(SELECT JNO FROM JOB WHERE JNAME=?), " + 
						"            ?, ?, ?)";
				try {
					// 1�ܰ� ����̹��ε�� �ѹ��� �ϸ� ��(������ ����)
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					System.out.println("�̸���? ");
					String pname=sc.next();
					pstmt.setString(1, pname);
					System.out.println("������[���, ����, ����]? ");
					String jname=sc.next();
					pstmt.setString(2, jname);
					System.out.println("����������? ");
					int kor=sc.nextInt();
					pstmt.setInt(3, kor);
					System.out.println("����������? ");
					int eng=sc.nextInt();
					pstmt.setInt(4, eng);
					System.out.println("����������? ");
					int mat=sc.nextInt();
					pstmt.setInt(5, mat);
					rs.close();
					pstmt.close();
					pstmt = conn.prepareStatement(sql);
					int result = pstmt.executeUpdate();
					System.out.println(result>0 ? "�Է¼���" : "�Է½���"); // �����ϸ� 1, �����ϸ� 0
					// 2~6�ܰ�
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				} finally {
					// 7�ܰ� close
						try {
							if(rs!=null)rs.close();
							if(stmt!=null)stmt.close();
							if(conn!=null)conn.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							System.out.println(e.getMessage());
						}
				}
				break;
			case "2": // �������޾� ���� ���
				sql = "SELECT ROWNUM RANK, A.*" + 
						"  FROM (SELECT PNAME||'('||PNO||')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM" + 
						"            FROM PERSON P, JOB J" + 
						"            WHERE P.JNO=J.JNO AND JNAME=?" + 
						"            ORDER BY SUM DESC) A";
				try {
					// 2~6�ܰ�
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					System.out.println("�˻��ϰ��� �ϴ� ��������? ");
					pstmt.setString(1, sc.next());
					rs = pstmt.executeQuery();
					if(rs.next()) { // �ش�μ� ��� list�� ���
						System.out.println("rank\t pname(pNO)\t jname\t kor\t eng\t mat\t sum");
						do {
							int rn = rs.getInt("rank");
							String pname = rs.getString("pname");
							String jname = rs.getString("jname");
							int kor = rs.getInt("kor");
							int eng = rs.getInt("eng");
							int mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							System.out.printf("%d\t%s\t\t%s\t%d\t%d\t%d\t%d\n", rn, pname, jname, kor, eng, mat, sum);
						}while(rs.next());
					}else {
						System.out.println("�ش� ������ ���� �����ϴ�.");
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				} finally {
					// 7�ܰ� close
						try {
							if(rs!=null)rs.close();
							if(pstmt!=null)pstmt.close();
							if(conn!=null)conn.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							System.out.println(e.getMessage());
						}
				}
				break;
			case "3":
				sql = "SELECT ROWNUM RANK, A.*" + 
						"  FROM (SELECT PNAME||'('||PNO||')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM" + 
						"            FROM PERSON P, JOB J" + 
						"            WHERE P.JNO=J.JNO" + 
						"            ORDER BY SUM DESC) A";
				try {
					// 2~6�ܰ�
					conn = DriverManager.getConnection(url, "scott", "tiger");
					stmt = conn.createStatement();
					rs	 = stmt.executeQuery(sql);
					if(rs.next()) {
						System.out.println("rank\t pname(pNO)\t jname\t kor\t eng\t mat\t sum");
						do {
							int rn = rs.getInt("rank");
							String pname = rs.getString("pname");
							String jname = rs.getString("jname");
							int kor = rs.getInt("kor");
							int eng = rs.getInt("eng");
							int mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							System.out.printf("%d\t%s\t\t%s\t%d\t%d\t%d\t%d\n", rn, pname, jname, kor, eng, mat, sum);
						} while(rs.next());
					}else {
						System.out.println("��ϵ� ������ �������� �ʽ��ϴ�.");
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				} finally {
					// 7�ܰ� close
						try {
							if(rs!=null)rs.close();
							if(stmt!=null)stmt.close();
							if(conn!=null)conn.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							System.out.println(e.getMessage());
						}
				}
				break;
			}
		}while(fn.equals("1") || fn.equals("2") || fn.equals("3"));
		System.out.println("BYE");
	}
}