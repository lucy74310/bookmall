package bookmall.vo;

public class CartVo {
	private Long bookNo;
	private String bookTitle;
	private Long memberNo;
	private Long memberName;
	private Long count;
	private Long price;
	
	
	
	
	public CartVo() {
	}

	public CartVo(Long bookNo, Long memberNo, Long count) {
		this.bookNo = bookNo;
		this.memberNo = memberNo;
		this.count = count;
	}

	public Long getBookNo() {
		return bookNo;
	}
	
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	
	public Long getCount() {
		return count;
	}
	
	public void setCount(Long count) {
		this.count = count;
	}
	
	public Long getPrice() {
		return price;
	}
	
	public void setPrice(Long price) {
		this.price = price;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public Long getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}

	public Long getMemberName() {
		return memberName;
	}

	public void setMemberName(Long memberName) {
		this.memberName = memberName;
	}

	@Override
	public String toString() {
		return "CartVo [bookNo=" + bookNo + ", bookTitle=" + bookTitle + ", memberNo=" + memberNo + ", memberName="
				+ memberName + ", count=" + count + ", price=" + price + "]";
	}

	
	
	
	
		
	
		
}
