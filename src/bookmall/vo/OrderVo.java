package bookmall.vo;

public class OrderVo {
	private Long no;
	private String orderSerial;
	private String summary;
	private Long price;
	private String address;
	private String status;
	private Long memberNo;
	
	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getOrderSerial() {
		return orderSerial;
	}

	public void setOrderSerial(String orderSerial) {
		this.orderSerial = orderSerial;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Long getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}

	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", orderSerial=" + orderSerial + ", summary=" + summary + ", price=" + price
				+ ", address=" + address + ", status=" + status + ", memberNo=" + memberNo + "]";
	}

	
	
	
	
	
	
}
