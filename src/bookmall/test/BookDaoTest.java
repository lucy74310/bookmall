package bookmall.test;


import bookmall.dao.BookDao;
import bookmall.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		insertTest();
	}
	
	public static void insertTest() {
		BookVo vo1 = new BookVo("태백산맥1", "조정래" , 13800L ,1L);
		BookVo vo2 = new BookVo("코스모스", "칼 세이건", 18500L , 2L);
		BookVo vo3 = new BookVo("총균쇠" , "재레드 다이아몬드", 25200L, 3L);
		
		BookDao dao = new BookDao();
		dao.insert(vo1);
		dao.insert(vo2);
		dao.insert(vo3);
		
	}
	
}
