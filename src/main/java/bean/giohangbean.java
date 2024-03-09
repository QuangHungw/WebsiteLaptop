package bean;

public class giohangbean {
	private String anh;
	private String id;
    private String name;
    private Long price;
    private Long number;
    private Long thanhtien;
    public giohangbean() {
		super();
		// TODO Auto-generated constructor stub
	}
   
	public giohangbean(String anh, String id, String name, Long price, Long number, Long thanhtien) {
		super();
		this.anh = anh;
		this.id = id;
		this.name = name;
		this.price = price;
		this.number = number;
		this.thanhtien = thanhtien;
	}
	
	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public Long getThanhtien() {
		return number*price;
	}
	public void setThanhtien(Long thanhtien) {
		this.thanhtien = thanhtien;
	}
	

}
