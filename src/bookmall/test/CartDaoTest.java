package bookmall.test;


import bookmall.dao.CartDao;

public class CartDaoTest {

	public static void main(String[] args) {
		insertTest();
	}
	
	public static void insertTest() {
		CartDao dao = new CartDao(); 
		dao.insert(1L,1L,5L);
		dao.insert(2L,1L,2L);
		
	}
	
}
