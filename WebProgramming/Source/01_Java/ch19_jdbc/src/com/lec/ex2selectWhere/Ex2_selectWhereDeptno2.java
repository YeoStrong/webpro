package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 사용자에게 원하는 부서번호를 받아 부서정보를 뿌리고, 해당 부서의 사원정보도 출력
	// 1. 해당 부서 번호가 없는 경우 : 존재하지 않는 부서입니다.
	// 2. 해당 부서 번호가 있는 경우 : 부서 정보 출력
		// 2-1. 해당 부서 사원이 있는 경우 : 사원 정보 출력(사번, 이름, 급여, 상사이름)
		// 2-2. 해당 부서 사원이 없는 경우 : 해당 부서에 사원이 없습니다.
public class Ex2_selectWhereDeptno2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner scan = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		System.out.println("정보 출력을 원하는 부서의 부서 번호를 입력하세요: ");
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
				System.out.println(deptno + "번 부서정보는 다음과 같습니다.");
				System.out.println("부서명: " + dname);
				System.out.println("부서위치: " + loc);				
				rs.close();
				rs = stmt.executeQuery(sql2);
				if(rs.next()) {
					System.out.println(deptno + "번 부서의 사원 정보입니다.");
					System.out.printf("사번\t이름\t급여\t상사이름\n");
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						int sal = rs.getInt("sal");
						String manager = rs.getString("manager");
						System.out.printf("%d\t %s\t %d\t %s\n", empno, ename, sal, manager);
					} while(rs.next());
				} else {
					System.out.println(deptno + "번 부서 사원은 없습니다.");
				}
			} else {
				System.out.println("존재하지 않는 부서입니다.");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			try { // 7단계. 연결 해제
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
