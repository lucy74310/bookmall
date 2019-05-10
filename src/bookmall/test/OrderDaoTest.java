package bookmall.test;


import bookmall.dao.OrderDao;

public class OrderDaoTest {

	public static void main(String[] args) {
		insertTest();
	}
	
	
	private static void insertTest() {
		OrderDao dao = new OrderDao(); 
		dao.insert(1L);
	}
}
