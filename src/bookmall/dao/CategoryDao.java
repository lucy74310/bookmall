package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.connection.GetConnection;
import bookmall.vo.CategoryVo;

public class CategoryDao extends GetConnection {

	public Boolean insert(String categoryName) {
		Boolean result = false;
		
		Connection conn = null; 
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = "insert into category values(null , ?)";
			pstmt = conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setString(1, categoryName);
			
			result = 1 == pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();	
				}
				if(conn != null) {
					conn.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return result;
		
	}
	
	
	public List<CategoryVo> getList() {
		List<CategoryVo> result = new ArrayList<CategoryVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			//1.연결
			conn = getConnection();
			String sql = 
					"select name " + 
					"from category" ;
			
			//2. statement 객체생성
			pstmt = conn.prepareStatement(sql);
			
			//3. sql 문 실행
			rs = pstmt.executeQuery();			
			
			//4. 결과 가져오기
			while ( rs.next() ) {
			
				String categoryName = rs.getString(1);
				
				CategoryVo vo = new CategoryVo();
				vo.setCategoryName(categoryName);
				
				result.add(vo);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();	
				}
				if(conn != null) {
					conn.close();
				}
				if(rs != null) {
					rs.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return result;
		
	}
	
}
