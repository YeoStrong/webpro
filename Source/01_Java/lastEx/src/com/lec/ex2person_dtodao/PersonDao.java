package com.lec.ex2person_dtodao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonDao {
	// ���� - ������ - �޼ҵ�
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public final static int SUCCESS =1;
	public final static int FAIL =0;
	private static PersonDao INSTANCE;
	public static PersonDao getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new PersonDao();
		}
		return INSTANCE;
	}
	private PersonDao() {
		try {
			Class.forName(driver); // 1�ܰ�� �����ڿ��� �ѹ�
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	// 1�� ���: dto(�̸�, ������, ����, ����, ����) �޾� DB�� insert�ϰ� SUCCESS/FAIL�� return
	public int insertPerson(PersonDto dto) {
		int result = FAIL;
		// DB insert�ϰ� ����� result�� �Ҵ�
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO PERSON VALUES(TO_CHAR(PERSON_NO_SQ.NEXTVAL), ?, (SELECT JNO FROM JOB WHERE JNAME=?), ?, ?, ? )";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2
			pstmt = conn.prepareStatement(sql); // 3
			pstmt.setString(1, dto.getPname());
			pstmt.setString(2, dto.getJname());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());
			result = pstmt.executeUpdate();
			if(result==SUCCESS) {
				System.out.println("�Է� ����");
			}
		} catch (SQLException e) {
			// TODO: handle exception
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
		return result;
	}
	// 2�� ���: ������ �޾� DB�� select�� ����� ArrayList<PersonDto>�� return
	public ArrayList<PersonDto> selectJname(String jname) {
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
		// DB ����� dtos�� add
		Connection 		   conn = null;
		PreparedStatement pstmt = null;
		ResultSet 			 rs = null;
		String sql = "SELECT ROWNUM RANK, A.*" + 
				"  FROM (SELECT PNAME||'('||PNO||')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM" + 
				"            FROM PERSON P, JOB J" + 
				"            WHERE P.JNO=J.JNO AND JNAME=?" + 
				"            ORDER BY SUM DESC) A";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int rank = rs.getInt("rank");
				String pname = rs.getString("pname");
				jname = rs.getString("jname");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int sum = rs.getInt("sum");
				dtos.add(new PersonDto(rank, pname, jname, kor, eng, mat, sum));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
	// 3�� ���: DB�� ��ü select�� ����� ArrayList<PersonDto>�� return
	public ArrayList<PersonDto> selectAll() {
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RANK, A.*" + 
				"  FROM (SELECT PNAME||'('||PNO||')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM" + 
				"            FROM PERSON P, JOB J" + 
				"            WHERE P.JNO=J.JNO" + 
				"            ORDER BY SUM DESC) A";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				PersonDto dto = new PersonDto(); // �ڡڡڡڡ� dto ��ü������ while�� �ȿ�
				dto.setRank(rs.getInt("rank"));
				dto.setPname(rs.getString("pname"));
				dto.setJname(rs.getString("jname"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setSum(rs.getInt("sum"));
				dtos.add(dto);
			}
		}  catch (SQLException e) {
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
		return dtos;
	}
	// jnames���� ArrayList<String>�� return
	public ArrayList<String> jnamelist() {
		ArrayList<String> jnames = new ArrayList<String>();
		Connection 		   conn = null;
		PreparedStatement pstmt = null;
		ResultSet		  	 rs = null;
		String sql = "SELECT JNAME FROM JOB";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				jnames.add(rs.getString("jname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		} // try-catch
		return jnames;
	}
 }