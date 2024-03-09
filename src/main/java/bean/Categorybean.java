package bean;

public class Categorybean {
	private String cateID;
	private String cname;
	public Categorybean() 
	{
		super();
	}
	public Categorybean(String cateID, String cname)
	{
		this.cateID= cateID;
		this.cname = cname;
	}
	public String getcateID() {
		return cateID;
	}
	public void setcateID(String cateID) {
		this.cateID = cateID;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	

}
