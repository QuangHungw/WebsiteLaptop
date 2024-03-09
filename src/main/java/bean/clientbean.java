package bean;

public class clientbean {
	private Long cliID;
	private String name;
	private String address;
	private String account;
	private String pass;
	private String email;
	public clientbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public clientbean(long cliID, String name, String address,String account, String pass,String email) {
		super();
		this.cliID = cliID;
		this.name = name;
		this.address = address;
		this.account = account;
		this.pass = pass;
		this.email= email;
	}
	public Long getCliID() {
		return cliID;
	}
	public void setCliID(Long cliID) {
		this.cliID = cliID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
