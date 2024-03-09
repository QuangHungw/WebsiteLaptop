package bean;

import java.util.Date;

public class billbean {
	
	private int bID;
	private Long cliID;
	private Date Date;
	private String damua;
	
	public billbean()
	{
		super();
	}
	public billbean(int bID, Long cliID, Date Date, String damua)
	{
		this.bID = bID;
		this.cliID = cliID;
		this.Date = Date;
		this.damua =damua;
	}
	public int getbID() {
		return bID;
	}
	public void setbID(int bID) {
		this.bID = bID;
	}
	public Long getCliID() {
		return cliID;
	}
	public void setCliID(Long cliID) {
		this.cliID = cliID;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		this.Date = date;
	}
	public String getDamua() {
		return damua;
	}
	public void setDamua(String damua) {
		this.damua = damua;
	}
	
	
}
