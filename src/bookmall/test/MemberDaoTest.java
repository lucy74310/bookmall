package bookmall.test;

import bookmall.dao.MemberDao;
import bookmall.vo.MemberVo;

public class MemberDaoTest {

	public static void main(String[] args) {
		insertTest();
		
	}
	
	public static void insertTest() {
		MemberVo vo1 = new MemberVo("둘리" , "01022792279", "dulli@gamil.com" , "1234");
		MemberVo vo2 = new MemberVo("또치" , "01057575757", "ddochi@gamil.com" , "1234"); 
		
		MemberDao dao = new MemberDao();
		dao.insert(vo1);
		dao.insert(vo2);
	}

}
