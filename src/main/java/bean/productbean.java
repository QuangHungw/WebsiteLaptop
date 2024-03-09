package bean;

public class productbean {
	private String id;
	private String namesp;
	private String image;
	private long price;
	private String title;
	private String cateID;
	

	public productbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public productbean( String id, String name, String image, long price, String title, String cateID) {
		this.id = id;
		this.namesp = name;
		this.image = image;
		this.price = price;
		this.title = title;
		this.cateID = cateID;
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return namesp;
	}
	public void setName(String name) {
		this.namesp = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCateID() {
		return cateID;
	}
	public void setCateID(String cateID) {
		this.cateID = cateID;
	}

}
