package com.lec.ex4update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
// 무한반복이면 commit, break, close 꼭 꼭 꼭 확인
// 수정할 부서번호를 받아 존재하는 부서번호인지 확인 후, 부서명, 근무지 입력 받아 update
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
				System.out.println("입력할 부서 번호는? ");
				int deptno = sc.nextInt();
				String selectQuery = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO="+deptno;
				rs = stmt.executeQuery(selectQuery);
				rs.next();
				int cnt = rs.getInt("CNT");
				if(cnt!=1) {
					System.out.println("해당하는 번호의 부서가 없습니다.");
				}else {
					System.out.println("입력할 부서명은? ");
					String dname = sc.next();
					System.out.println("입력할 부서 위치는? ");
					String loc = sc.next();
					String updateQuery = String.format("UPDATE DEPT SET DNAME='%s', LOC='%s'" + 
							"    WHERE DEPTNO=%d", dname, loc, deptno);
					int result = stmt.executeUpdate(updateQuery);
					System.out.println(result>0 ? deptno+"번 부서 정보 업데이트 완료" : "업데이트에 실패했습니다.");
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
