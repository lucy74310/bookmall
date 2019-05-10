package bookmall.test;


import bookmall.dao.CategoryDao;

public class CategoryDaoTest {

	public static void main(String[] args) {
		insertTest();
	}
	
	
	public static void insertTest() {
		CategoryDao dao = new CategoryDao();
		dao.insert("문학");
		dao.insert("과학");
		dao.insert("역사/문화");
	}
}
