package ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://localhost/spring4fs";
	
	void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "spring4", "spring4");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	void disconnect() {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<MemberVO> listMembers() {
		connect();
		
		ArrayList<MemberVO> list = new ArrayList<>();
		String sql = "select * from member order by id";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberVO member = new MemberVO();
				member.setId(rs.getInt("id"));
				member.setEmail(rs.getString("email"));
				member.setPassword(rs.getString("password"));
				member.setName(rs.getString("name"));
				member.setRegdate(rs.getString("regdate"));
				list.add(member);
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		} finally {
			disconnect();
		}
		return list;
	}
	
	public int insert(MemberVO member) {
		String sql = "insert into member(email, password, name, regdate) values(?, ?, ?, ?)";
		int result = 0;
		
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getRegdate());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
			return result;
		} finally {
			disconnect();
		}
		
		return result;
	}
}
