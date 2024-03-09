package bean;

public class adminbean {
	public String user;
	public String pass;
	public String isAdmin;
	public adminbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public adminbean(String user, String pass, String isAdmin) {
		super();
		this.user = user;
		this.pass = pass;
		this.isAdmin = isAdmin;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	
}
