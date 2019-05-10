package bookmall.main;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.dao.CartDao;
import bookmall.dao.CategoryDao;
import bookmall.dao.MemberDao;
import bookmall.dao.OrderDao;
import bookmall.vo.BookVo;
import bookmall.vo.CartVo;
import bookmall.vo.CategoryVo;
import bookmall.vo.MemberVo;
import bookmall.vo.OrderBookVo;
import bookmall.vo.OrderVo;

public class BookMall {

	public static void main(String[] args) {
		
		displayMemberList();
		displayCategoryList();
		displayBookList();
		displayCartList();
		displayOrderList();
		displayOrderBookList();
		
	}
	
	private static void displayMemberList() {
		MemberDao dao = new MemberDao();
		List<MemberVo> list =  dao.getList();
		
		System.out.println("[고객 리스트 ]");
		System.out.println();
		
		for( MemberVo vo : list ) {
			System.out.print(
					"고객명 : " + vo.getName() + "\r\n" +
					"전화번호 : " + vo.getPhone() + "\r\n" + 
					"이메일 : " + vo.getEmail() + "\r\n" +
					"비밀번호 : " + vo.getPassword() + "\r\n" 
					);
			System.out.println("-----------------------------------------------------");
		}
		System.out.println();
		System.out.println();
	}
	
	private static void displayCategoryList() {
		CategoryDao dao = new CategoryDao();
		List<CategoryVo> list =  dao.getList();
		
		
		System.out.println("[카테고리 리스트 ]");
		System.out.println();
		
		for( CategoryVo vo : list ) {
			System.out.print(vo.getCategoryName() + "\r\n");
		}
		System.out.println();
		System.out.println();
	}
	
	private static void displayBookList() {
		List<BookVo> list = new BookDao().getList();
		
		System.out.println("[도서 리스트 ]");
		System.out.println();
		
		for( BookVo vo : list ) {
			System.out.print(
					"도서명 	: " + vo.getTitle() + "\t\n" +
					"  저자	: " + vo.getAuthor() + "\t\n" + 
					"  가격	: " + vo.getPrice() + "\t\n" +
					"  분류	: " + vo.getCategoryName() + "\t\n"  
					);
			System.out.println("--------------------------------------------");
		}
		System.out.println();
		System.out.println();
	}
	
	private static void displayCartList() {
		List<CartVo> list = new CartDao().getList();
		
		
		System.out.println("[카트 리스트 ]");
		System.out.println();
		
		for( CartVo vo : list ) {
			System.out.print(
					"도서명	: " + vo.getBookTitle() + "\r\n" +
					"수량	: " + vo.getCount() + "\r\n" + 
					"고객번호	: " + vo.getMemberNo() + "\r\n"
					);
			System.out.println("--------------------------------------------");
		}
		
		System.out.println();
		System.out.println();
	}
	
	private static void displayOrderList() {
		List<OrderVo> list =  new OrderDao().getOrderList();
		
		System.out.println("[주문 리스트 ]");
		System.out.println();
		
		for( OrderVo vo : list ) {
			System.out.print(
					"주문번호	: " + vo.getOrderSerial() + "\r\n" + 
					"결제금액 	: " + vo.getPrice() + "\r\n" + 
					"주문도서 	: " + vo.getSummary() + "\r\n" + 
					"배송지	: " + vo.getAddress() + "\r\n" + 
					"주문상태	: " + vo.getStatus() + "\r\n" + 
					"고객번호	: " + vo.getMemberNo() + "\r\n" 	
					);
			System.out.println("--------------------------------------------");
		}
		
		System.out.println();
		System.out.println();
	}
	
	private static void displayOrderBookList() {
		List<OrderBookVo> list = new OrderDao().getOrderBookList();
		
		System.out.println("[ 주문 도서 리스트 ]");
		System.out.println();
		
		for( OrderBookVo vo : list ) {
			System.out.print(
					"주문번호: " + vo.getOrderSerial() + "\r\n" +
					"도서명	: " + vo.getTitle() + "\r\n" +
					"수량	: "	+ vo.getCount() + "\r\n" +
					"고객번호	: " + vo.getMemberNo() + "\r\n" 
					);
			System.out.println("-----------------------------");
		}
	}
	
}
