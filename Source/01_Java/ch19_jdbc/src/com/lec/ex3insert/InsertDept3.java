package com.lec.ex3insert;
// 입력받은 부서번호가 중복된 부서번호일 경우 계속 받아
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
				System.out.println("입력할 부서 번호는? ");
				int deptno=sc.nextInt();
				String selectQuery = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=" + deptno;
				rs = stmt.executeQuery(selectQuery);
				rs.next();
				int cnt = rs.getInt("CNT");
				if(cnt!=0) {
					System.out.println("중복된 부서번호를 입력하셨습니다.");
				}else {
					System.out.println("입력할 부서명은? ");
					String dname = sc.next();
					System.out.println("입력할 부서 위치는? ");
					String loc = sc.next();
					String insertQuery = String.format("INSERT INTO DEPT VALUES ('%d', '%s', '%s')", deptno, dname, loc);
					int result = stmt.executeUpdate(insertQuery);
					System.out.println(result>0 ? "입력성공" : "입력실패"); // 성공하면 1, 실패하면 0
					break;
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("중복된 부서번호이거나 글자수 제한을 초과하여 입력하였습니다. " + e.getMessage());
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
