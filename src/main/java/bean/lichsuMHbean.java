package bean;

import java.util.Date;

public class lichsuMHbean {
	private long dbID;
	private long bID;
	private long cliID;
	private int  number;
	private int price;
	private Date Date;
	private int thanhtien;
	private String damua;
	public lichsuMHbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public lichsuMHbean(long dbID, long bID, long cliID, int number, int price, Date date, int thanhtien,
			String damua) {
		super();
		this.dbID = dbID;
		this.bID = bID;
		this.cliID = cliID;
		this.number = number;
		this.price = price;
		this.Date = date;
		this.thanhtien = thanhtien;
		this.damua = damua;
	}
	public long getDbID() {
		return dbID;
	}
	public void setDbID(long dbID) {
		this.dbID = dbID;
	}
	public long getbID() {
		return bID;
	}
	public void setbID(long bID) {
		this.bID = bID;
	}
	public long getCliID() {
		return cliID;
	}
	public void setCliID(long cliID) {
		this.cliID = cliID;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	public int getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(int thanhtien) {
		this.thanhtien = thanhtien;
	}
	public String getDamua() {
		return damua;
	}
	public void setDamua(String damua) {
		this.damua = damua;
	}
	
	
}
