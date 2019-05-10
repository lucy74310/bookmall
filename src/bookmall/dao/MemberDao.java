package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.connection.GetConnection;
import bookmall.vo.MemberVo;


public class MemberDao extends GetConnection {
	
	
	public Boolean insert(MemberVo vo) {
		Boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "insert into member values (null, ?, ?, ?, password(?)) ";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPhone());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getPassword());
			
			
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
	
	
	public List<MemberVo> getList() {
		List<MemberVo> result = new ArrayList<MemberVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			//1.연결
			conn = getConnection();
			String sql = 
					"select name, phone, email , password " + 
					"  from member ";
			
			//2. statement 객체생성
			pstmt = conn.prepareStatement(sql);
			
			//3. sql 문 실행
			rs = pstmt.executeQuery();			
			
			//4. 결과 가져오기
			while ( rs.next() ) {
				String name = rs.getString(1);
				String phone = rs.getString(2);
				String email = rs.getString(3);
				String password = rs.getString(4);
				
				MemberVo vo = new MemberVo();
				
				vo.setName(name);
				vo.setPhone(phone);
				vo.setEmail(email);
				vo.setPassword(password);
				
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
