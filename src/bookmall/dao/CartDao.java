package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.connection.GetConnection;
import bookmall.vo.CartVo;


public class CartDao extends GetConnection {
	
	public Boolean insert(Long bookNo, Long memberNo, Long count) {
		Boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "insert into cart values ( ?, ?, ?) ";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, bookNo);
			pstmt.setLong(2, memberNo);
			pstmt.setLong(3, count);
			
	
			
			result = (1 == pstmt.executeUpdate());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return result;
		
	}
	
	
	public List<CartVo> getList() {
		List<CartVo> result = new ArrayList<CartVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			//1.연결
			conn = getConnection();
			String sql = 
					"select a.title , b.count, (b.count * a.price) as price , b.member_no" + 
					" from book a , cart b " + 
					" where a.no = b.book_no " ;
			
			//2. statement 객체생성
			pstmt = conn.prepareStatement(sql);
			
			//3. sql 문 실행
			rs = pstmt.executeQuery();			
			
			//4. 결과 가져오기
			while ( rs.next() ) {
				String bookTitle = rs.getString(1);
				Long count = rs.getLong(2);
				Long price = rs.getLong(3);
				Long memberNo = rs.getLong(4);
				
				CartVo vo = new CartVo();
				vo.setBookTitle(bookTitle);
				vo.setCount(count);
				vo.setPrice(price);
				vo.setMemberNo(memberNo);
				
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
