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
					System.out.println("직업은[배우, 가수, 엠씨]? ");
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
				sql = "SELECT ROWNUM RANK, A.*" + 
						"  FROM (SELECT PNAME||'('||PNO||')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM" + 
						"            FROM PERSON P, JOB J" + 
						"            WHERE P.JNO=J.JNO AND JNAME=?" + 
						"            ORDER BY SUM DESC) A";
				try {
					// 2~6단계
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					System.out.println("검색하고자 하는 직업명은? ");
					pstmt.setString(1, sc.next());
					rs = pstmt.executeQuery();
					if(rs.next()) { // 해당부서 사원 list를 출력
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
						System.out.println("해당 직업은 현재 없습니다.");
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				} finally {
					// 7단계 close
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
					// 2~6단계
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