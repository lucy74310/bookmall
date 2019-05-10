package bookmall.vo;

public class OrderBookVo {
	private String orderSerial;
	private String title;
	private Long count;
	private Long memberNo;
	public String getOrderSerial() {
		return orderSerial;
	}
	public void setOrderSerial(String orderSerial) {
		this.orderSerial = orderSerial;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	@Override
	public String toString() {
		return "OrderBookVo [orderSerial=" + orderSerial + ", title=" + title + ", count=" + count + ", memberNo="
				+ memberNo + "]";
	}

	
	
	
}
