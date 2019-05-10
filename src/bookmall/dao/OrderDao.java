package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.connection.GetConnection;
import bookmall.vo.OrderBookVo;
import bookmall.vo.OrderVo;

public class OrderDao extends GetConnection {
	
	public Boolean insert(Long memberNo) {
		Boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String sql = "insert into orders " + 
					"	values ( null, " + 
					"			concat(date_format(now(), '%Y%m%d'), '-' , " + 
					"            lpad((select count(*) from orders a where left(order_serial, 8) = date_format(now(), '%Y%m%d'))+1, 4, 0) ) , " + 
					"			(select sum(a.price * b.count) as total " + 
					"			   from book a  , cart b " + 
					"			  where a.no = b.book_no " + 
					"                and b.member_no = ? ), " + 
					"			'서울특별시 서초구 강남대로53길 8 비트아카데미빌딩' ," + 
					"            default," + 
					"            ? ) "; 
				
			
			//2. statement 객체생성
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, memberNo);
			pstmt.setLong(2, memberNo);
			
			result = (1 == pstmt.executeUpdate());
			
			
			sql = "select last_insert_id()  , book_no , count " + 
					"  from cart  where member_no = ? ";
			
			pstmt.close();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, memberNo );
			rs = pstmt.executeQuery();
			
			
			int i = 0;
			Long orderNo = null;
			while(rs.next()) {
				if(i == 0 ) {
					orderNo = rs.getLong(1);
				}
				Long bookNo = rs.getLong(2);
				Long cnt = rs.getLong(3);
				insertOrderBook(bookNo, orderNo, cnt);
				i++;
			}
			
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
				if(rs != null) {
					rs.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		return result;
		
	}
	
	private Boolean insertOrderBook(Long bookNo, Long orderNo, Long cnt) {
		Boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = "insert into order_book values ( ? , ? , ? )";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, bookNo );
			pstmt.setLong(2, orderNo );
			pstmt.setLong(3, cnt );
			
			result = 1 == pstmt.executeUpdate();
			
			
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
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return result;
	}
	
	public List<OrderVo> getOrderList() {
		List<OrderVo> result = new ArrayList<OrderVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			//1.연결
			conn = getConnection();
			String sql = 
					"select " + 
					"		a.order_serial, " + 
					"  		a.price, " + 
					"   	if(" + 
					"			count(*) > 1 , " + 
					"        	concat( d.title , ' 외 ',count(*)-1,'권 (총 수량 : ' ,sum(c.count), '권)')," + 
					"        	concat( d.title , ' (' , sum(c.count), '권)')" + 
					"       )  as 'summary'," + 
					"    	a.address, " + 
					"    	a.status," + 
					"   	b.no" + 
					"  from orders a , member b , cart c, book d " + 
					" where a.member_no = b.no" + 
					"   and b.no = c.member_no" + 
					"   and c.book_no = d.no" + 
					" group by a.no ";
			
			//2. statement 객체생성
			pstmt = conn.prepareStatement(sql);
			
			//3. sql 문 실행
			rs = pstmt.executeQuery();			
			
			//4. 결과 가져오기
			while ( rs.next() ) {
				String orderSerial = rs.getString(1);
				Long price = rs.getLong(2);
				String summary = rs.getString(3);
				String address = rs.getString(4);
				String status = rs.getString(5);
				Long memberNo = rs.getLong(6);
				
				OrderVo vo = new OrderVo();
				vo.setOrderSerial(orderSerial);
				vo.setPrice(price);
				vo.setSummary(summary);
				vo.setAddress(address);
				vo.setStatus(status);
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
	
	public List<OrderBookVo> getOrderBookList() {
		List<OrderBookVo> result = new ArrayList<OrderBookVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			//1.연결
			conn = getConnection();
			String sql = 
					"select b.order_serial as '주문번호' , c.title as '제목' , a.count as '수량' , d.no as '주문자'" + 
					"  from order_book a, orders b, book c, member d" + 
					" where a.order_no = b.no" + 
					"   and a.book_no = c.no" + 
					"   and b.member_no = d.no" ;
			
			//2. statement 객체생성
			pstmt = conn.prepareStatement(sql);
			
			//3. sql 문 실행
			rs = pstmt.executeQuery();			
			
			//4. 결과 가져오기
			while ( rs.next() ) {
				String orderSerial = rs.getString(1);
				String title = rs.getString(2);
				Long count = rs.getLong(3);
				Long memberNo = rs.getLong(4);
				
				OrderBookVo vo = new OrderBookVo();
				vo.setOrderSerial(orderSerial);
				vo.setTitle(title);
				vo.setCount(count);
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
