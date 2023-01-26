package com.lec.ex3supermarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDao {
	// dao�� �̱������� ���� / private ������, driver�ε�
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public final static int SUCCESS =1;
	public final static int FAIL =0;
	private static CustomerDao INSTANCE = new CustomerDao();
	public static CustomerDao getInstance() {
		return INSTANCE;
	}
	private CustomerDao() {
		try {
			Class.forName(driver); // 1�ܰ�� �����ڿ��� �ѹ�
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	// 1. ȸ������ :  public int insertCustomer(String ctel, String cname)
	public int insertCustomer(String ctel, String cname) {
		int result = FAIL;
		// DB insert�ϰ� ����� result�� �Ҵ�
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO CUSTOMER (CID, CTEL, CNAME)" + 
				"    VALUES(TO_CHAR(CUSTOMER_ID_SQ.NEXTVAL), ?, ?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
			pstmt.setString(2, cname);
			result = pstmt.executeUpdate();
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
		return result;
	}
	public int insertCustomer(CustomerDto dto) {
		int result = FAIL;
		// DB insert�ϰ� ����� result�� �Ҵ�
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO CUSTOMER (CID, CTEL, CNAME)" + 
				"    VALUES(TO_CHAR(CUSTOMER_ID_SQ.NEXTVAL), ?, ?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCtel());
			pstmt.setString(2, dto.getCname());
			result = pstmt.executeUpdate();
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
		return result;
	}
	// 2. �� ��4�ڸ�(Ǯ��ȣ) �˻�:
	public ArrayList<CustomerDto> ctelGetCustomers(String searchTel){
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection 		   conn = null;
		PreparedStatement pstmt = null;
		ResultSet 			 rs = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, (SELECT MAX_NEED+1-CAMOUNT FROM CUSTOMER WHERE LEVELNO!=3 AND CID=C.CID) NEEDAMOUNT" + 
				"        FROM CUSTOMER C, CLEVEL L" + 
				"        WHERE C.LEVELNO = L.LEVELNO" + 
				"        AND CTEL LIKE '%'||?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchTel);
			rs = pstmt.executeQuery();
			while(rs.next()) {
//				 int cid 		  = rs.getInt("cid");
//				 String ctel 	  = rs.getString("ctel");
//				 String cname 	  = rs.getString("cname");
//				 int cpoint 	  = rs.getInt("cpoint");
//				 int camount      = rs.getInt("camount");
//				 String levelname = rs.getString("levelname");
//				 int needamount   = rs.getInt("needamount");
//				 dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelname, needamount));
				CustomerDto dto = new CustomerDto();
				dto.setCid(rs.getInt("cid"));
				dto.setCtel(rs.getString("ctel"));
				dto.setCname(rs.getString("cname"));
				dto.setCpoint(rs.getInt("cpoint"));
				dto.setCamount(rs.getInt("camount"));
				dto.setLevelname(rs.getString("levelname"));
				dto.setNeedamount(rs.getInt("needamount"));
				dtos.add(dto);
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
	
	// 3. ��ǰ ���� : 
	public int buy(int cid, int price) {
		int result = FAIL;
		// DB insert�ϰ� ����� result�� �Ҵ�
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER" + 
				"        SET CPOINT = CPOINT+0.05*?," + 
				"            CAMOUNT= CAMOUNT+?," + 
				"            LEVELNO = (SELECT L.LEVELNO" + 
				"                        FROM CUSTOMER, CLEVEL L" + 
				"                        WHERE CAMOUNT+? BETWEEN MIN_NEED AND MAX_NEED " + 
				"                            AND CID=?)" + 
				"        WHERE CID = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, price);
			pstmt.setInt(2, price);
			pstmt.setInt(3, price);
			pstmt.setInt(4, cid);
			pstmt.setInt(5, cid);
			result = pstmt.executeUpdate();
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
		return result;
	}
	// 3�� ��ǰ ���� �� ������ ���� ��� : 
	public CustomerDto getCustomer(int cid) {
		CustomerDto dto = null;
		Connection 		   conn = null;
		PreparedStatement pstmt = null;
		ResultSet 			 rs = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, (SELECT MAX_NEED+1-CAMOUNT FROM CUSTOMER WHERE LEVELNO!=3 AND CID=C.CID) NEEDAMOUNT" + 
				"        FROM CUSTOMER C, CLEVEL L" + 
				"        WHERE C.LEVELNO = L.LEVELNO" + 
				"        AND CID=?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
			rs = pstmt.executeQuery();
			if(rs.next()) { // �˻� ����� ���� ���(cid�� ���� ���), dto�� CustomerDto�� ��ü �����Ͽ� �Ҵ�
				 //int cid = rs.getInt("cid");
				 String ctel = rs.getString("ctel");
				 String cname = rs.getString("cname");
				 int cpoint = rs.getInt("cpoint");
				 int camount = rs.getInt("camount");
				 String levelname = rs.getString("levelname");
				 int needamount = rs.getInt("needamount");
				 dto = new CustomerDto(cid, ctel, cname, cpoint, camount, levelname, needamount);
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
		return dto;
	}
	// 4�� �� levelName�� ���� ���: 
	public ArrayList<String> getLevelNames() {
		ArrayList<String> levelNames = new ArrayList<String>();
		Connection 		   conn = null;
		PreparedStatement pstmt = null;
		ResultSet 			 rs = null;
		String sql = "SELECT LEVELNAME FROM CLEVEL";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				levelNames.add(rs.getString("levelName"));
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
		return levelNames;
	}
	
	// 4. ��޺� �� ��� : 
	public ArrayList<CustomerDto> levelNameGetCustomer(String levelName) {
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection 		   conn = null;
		PreparedStatement pstmt = null;
		ResultSet 			 rs = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, (SELECT MAX_NEED+1-CAMOUNT FROM CUSTOMER WHERE LEVELNO!=3 AND CID=C.CID) NEEDAMOUNT" + 
				"        FROM CUSTOMER C, CLEVEL L" + 
				"        WHERE C.LEVELNO = L.LEVELNO" + 
				"            AND LEVELNAME = UPPER(?)" + 
				"        ORDER BY CAMOUNT DESC";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, levelName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				 int cid 		  = rs.getInt("cid");
				 String ctel 	  = rs.getString("ctel");
				 String cname 	  = rs.getString("cname");
				 int cpoint 	  = rs.getInt("cpoint");
				 int camount      = rs.getInt("camount");
				 String levelname = rs.getString("levelname");
				 int needamount   = rs.getInt("needamount");
				 dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelname, needamount));
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
	// 5. ��ü ��� : 
	public ArrayList<CustomerDto> getCustomers() {
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection 		   conn = null;
		PreparedStatement pstmt = null;
		ResultSet 			 rs = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, (SELECT MAX_NEED+1-CAMOUNT FROM CUSTOMER WHERE LEVELNO!=3 AND CID=C.CID) NEEDAMOUNT" + 
				"        FROM CUSTOMER C, CLEVEL L" + 
				"        WHERE C.LEVELNO = L.LEVELNO";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				 int cid 		  = rs.getInt("cid");
				 String ctel 	  = rs.getString("ctel");
				 String cname 	  = rs.getString("cname");
				 int cpoint 	  = rs.getInt("cpoint");
				 int camount      = rs.getInt("camount");
				 String levelname = rs.getString("levelname");
				 int needamount   = rs.getInt("needamount");
				 dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelname, needamount));
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
	// 6. ȸ�� Ż�� : 
	public int deleteCustomer(String ctel) {
		int result = FAIL;
		// DB insert�ϰ� ����� result�� �Ҵ�
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM CUSTOMER" + 
				"    WHERE CTEL=?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
			result = pstmt.executeUpdate();
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
		return result;
	}
}
