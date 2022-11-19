package product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class ProductDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://localhost/spring4fs";
	ArrayList<ProductVO> basketList = new ArrayList<>();
	
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
	
	public ArrayList<ProductVO> listProducts(){
		
		ArrayList<ProductVO> list = new ArrayList<>();
		String sql = "select * from product order by id";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductVO product = new ProductVO();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setModel(rs.getString("model"));
				product.setMadein(rs.getString("madein"));
				product.setPrice(rs.getInt("price"));
				product.setReadcnt(rs.getInt("readcnt"));
				list.add(product);
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
	
	public ProductVO choiceProduct(String id) {
		ProductVO  selected = new ProductVO();
		int fixId = Integer.parseInt(id);
		String sql1 = "select * from product where id = ?";
		String sql2 = "update product set readcnt = readcnt+1 where id = ?";
		connect();
		try {
			pstmt=conn.prepareStatement(sql1);
			pstmt.setInt(1, fixId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				selected.setId(fixId);
				selected.setMadein(rs.getString("madein"));
				selected.setModel(rs.getString("model"));
				selected.setName(rs.getString("name"));
				selected.setPrice(rs.getInt("price"));
				selected.setReadcnt(rs.getInt("readcnt"));
			}
			
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, fixId);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			disconnect();
		}
		return selected;
		
		
		
	}
	
	
	public ArrayList<ProductVO> basketProducts(String id){
		int fixId = Integer.parseInt(id);
		String sql = "select * from product where id = ?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fixId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductVO basketProduct = new ProductVO();
				basketProduct.setId(rs.getInt("id"));
				basketProduct.setName(rs.getString("name"));
				basketProduct.setModel(rs.getString("model"));
				basketProduct.setMadein(rs.getString("madein"));
				basketProduct.setPrice(rs.getInt("price"));
				basketProduct.setReadcnt(rs.getInt("readcnt"));
				basketList.add(basketProduct);
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		} finally {
			disconnect();
		}
		return basketList;
		
		
	}
	

}
