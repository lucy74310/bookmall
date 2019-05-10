package bookmall.vo;

public class BookVo {
	private Long no;
	private String title;
	private String author;
	private Long price;
	
	private String categoryName;
	private Long categoryNo;
	
	
	public BookVo() {
		
	}
	
	public BookVo(String title,String author, Long price, Long categoryNo) {
		this.title = title;
		this.author = author;
		this.price =price;
		this.categoryNo = categoryNo;
	}
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Long getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(Long categoryNo) {
		this.categoryNo = categoryNo;
	}
	@Override
	public String toString() {
		return "BookVo [no=" + no + ", title=" + title + ", author=" + author + ", price=" + price + ", categoryName="
				+ categoryName + ", categoryNo=" + categoryNo + "]";
	}
	
	
	
	
	
}
