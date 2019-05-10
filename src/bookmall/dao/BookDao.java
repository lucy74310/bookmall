package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.connection.GetConnection;
import bookmall.vo.BookVo;

public class BookDao extends GetConnection {
	
	public Boolean insert(BookVo vo) {
		Boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "insert into book values (null, ?, ?, ?, ?) ";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getAuthor());
			pstmt.setLong(3, vo.getPrice());
			pstmt.setLong(4, vo.getCategoryNo());
			
			result = (1 == pstmt.executeUpdate());
			
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
	
	
	public List<BookVo> getList() {
		List<BookVo> result = new ArrayList<BookVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			//1.연결
			conn = getConnection();
			String sql = 
					"select a.title, a.author, a.price, b.name " + 
					"from book a , category b " + 
					"where a.category_no = b.no " ;
			
			//2. statement 객체생성
			pstmt = conn.prepareStatement(sql);
			
			//3. sql 문 실행
			rs = pstmt.executeQuery();			
			
			//4. 결과 가져오기
			while ( rs.next() ) {
				String title = rs.getString(1);
				String author = rs.getString(2);
				Long price = rs.getLong(3);
				String categoryName = rs.getString(4);
				
				BookVo vo = new BookVo();
				vo.setTitle(title);
				vo.setPrice(price);
				vo.setAuthor(author);
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
