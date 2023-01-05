package com.lec.ex6prepareadStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
// 무한반복이면 commit, break, close 꼭 꼭 꼭 확인
// 수정할 부서번호를 받아 존재하는 부서번호인지 확인 후, 부서명, 근무지 입력 받아 update
public class Ex4_UpdateDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectQuery = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=?";
		String updateQuery = "UPDATE DEPT SET DNAME=?, LOC=? WHERE DEPTNO=?";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(selectQuery);
				System.out.println("입력할 부서 번호는? ");
				int deptno = sc.nextInt();
				pstmt.setInt(1, deptno);
				rs = pstmt.executeQuery();
				rs.next();
				int cnt = rs.getInt("CNT");
				if(cnt!=0) {
					System.out.println("입력할 부서명은? ");
					String dname =sc.next();
					System.out.println("입력할 부서 위치는? ");
					String loc = sc.next();
					rs.close();
					pstmt.close();
					pstmt = conn.prepareStatement(updateQuery);
					pstmt.setString(1, dname);
					pstmt.setString(2, loc);
					pstmt.setInt(3, deptno);
					int result = pstmt.executeUpdate();
					if(result>0) {
						System.out.println(deptno+"번 부서 정보 업데이트 완료");
					}
				}else {
					System.out.println("해당하는 번호의 부서가 없습니다.");
				}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
	}
}
