package com.lec.ex1person;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonMng {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection        conn = null;
		PreparedStatement pstmt = null; // 1, 2번 기능
		Statement         stmt  = null; // 3번 기능, 직업명들(jobs)
		ResultSet         rs    = null;
		Scanner           sc    = new Scanner(System.in);
		String fn, sql;
		ArrayList<String> jobs = new ArrayList<String>(); // 직업명들 저장
		// 직업명들을 jobs에 add
		try {
			sql = "SELECT JNAME FROM JOB";
			Class.forName(driver); // (1)드라이버 로드
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
		}// 직업명 가져오기
		System.out.println(jobs);
		do {
			System.out.print("1:입력 || 2:직업별조회 || 3:전체조회 || 그외:종료");
			fn = sc.next();
			switch(fn) {
			case "1" : // 이름, 직업명(jobs), 국,영, 수 받아 insert
				sql = "INSERT INTO PERSON " + 
						"    VALUES (PERSON_NO_SQ.NEXTVAL, ?, "
						+ "(SELECT JNO FROM JOB WHERE JNAME=?), " + 
						"            ?, ?, ?)";
				try {
					// 1단계 드라이버로드는 한번만 하면 됨(위에서 했음)
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					System.out.println("이름은? ");
					String pname=sc.next();
					pstmt.setString(1, pname);
					System.out.println("직업은? ");
					String jname=sc.next();
					pstmt.setString(2, jname);
					System.out.println("국어점수는? ");
					int kor=sc.nextInt();
					pstmt.setInt(3, kor);
					System.out.println("영어점수는? ");
					int eng=sc.nextInt();
					pstmt.setInt(4, eng);
					System.out.println("수학점수는? ");
					int mat=sc.nextInt();
					pstmt.setInt(5, mat);
					rs.close();
					pstmt.close();
					pstmt = conn.prepareStatement(sql);
					int result = pstmt.executeUpdate();
					System.out.println(result>0 ? "입력성공" : "입력실패"); // 성공하면 1, 실패하면 0
					// 2~6단계
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				} finally {
					// 7단계 close
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
			case "2": // 직업명받아 직업 출력
				sql = "SELECT *\r\n" + 
						"    FROM (SELECT ROWNUM || '등' \"등수\", P.PNAME ||'(' || PNO || '번)' \"이름(pNO)\", JNAME \"직업\", KOR \"국어(kor)\", ENG\"영어(eng)\", MAT\"수학(mat)\", \"총점\"\r\n" + 
						"        FROM PERSON P, JOB J, (SELECT pNAME, SUM(KOR+ENG+MAT) \"총점\" FROM PERSON GROUP BY pNAME ORDER BY \"총점\" DESC)A WHERE P.PNAME=A.PNAME \r\n" + 
						"            AND P.JNO=J.JNO\r\n" + 
						"            AND P.jNO=(SELECT jNO FROM JOB WHERE JNAME=?))";
				try {
					// 2~6단계
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					System.out.println("검색하고자 하는 직업명은? ");
					pstmt.setString(1, sc.next());
					rs = pstmt.executeQuery();
					if(rs.next()) { // 해당부서 사원 list를 출력
						System.out.println("등수\t이름(pNO)\t\t직업\t국어(kor)\t영어(eng)\t수학(mat)\t총점");
						do {
							int rn = rs.getInt("등수");
							String pname = rs.getString("이름");
							int pno = rs.getInt("pNO");
							String jname = rs.getString("직업");
							int kor = rs.getInt("국어(kor)");
							int eng = rs.getInt("영어(eng)");
							int mat = rs.getInt("수학(mat)");
							int sum = rs.getInt("총점");
							System.out.printf("%d등\t%s(%d번)\t%s\t%d\t%d\t%d\t%d", rn, pname, pno, jname, kor, eng, mat, sum);
						}while(rs.next());
					}else {
						System.out.println("해당 직업은 현재 없습니다.");
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				} finally {
					// 7단계 close
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
			case "3":
				sql = "SELECT *\r\n" + 
						"    FROM (SELECT ROWNUM || '등' \"등수\", P.PNAME ||'(' || PNO || '번)' \"이름(pNO)\", JNAME \"직업\", KOR \"국어(kor)\", ENG\"영어(eng)\", MAT\"수학(mat)\", \"총점\"\r\n" + 
						"        FROM PERSON P, JOB J, (SELECT pNAME, SUM(KOR+ENG+MAT) \"총점\" FROM PERSON GROUP BY pNAME ORDER BY \"총점\" DESC)A WHERE P.PNAME=A.PNAME \r\n" + 
						"            AND P.JNO=J.JNO)";
				try {
					// 2~6단계
					conn = DriverManager.getConnection(url, "scott", "tiger");
					stmt = conn.createStatement();
					rs	 = stmt.executeQuery(sql);
					if(rs.next()) {
						System.out.println("등수\t이름(pNO)\t\t직업\t국어(kor)\t영어(eng)\t수학(mat)\t총점");
						do {
							int rn = rs.getInt("등수");
							String pname = rs.getString("이름");
							int pno = rs.getInt("pNO");
							String jname = rs.getString("직업");
							int kor = rs.getInt("국어(kor)");
							int eng = rs.getInt("영어(eng)");
							int mat = rs.getInt("수학(mat)");
							int sum = rs.getInt("총점");
							System.out.printf("%d등\t%s(%d번)\t%s\t%d\t%d\t%d\t%d", rn, pname, pno, jname, kor, eng, mat, sum);
						} while(rs.next());
					}else {
						System.out.println("등록된 정보가 존재하지 않습니다.");
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				} finally {
					// 7단계 close
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