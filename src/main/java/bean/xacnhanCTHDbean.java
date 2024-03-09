package bean;

import java.util.Date;

public class xacnhanCTHDbean {
	private long dbID;
	private int cliID;
	private String name;
	private String namesp;
	private int number;
	private int price;
	private int thanhtien;
	private boolean damua;
	private String ngaymua;
	public xacnhanCTHDbean(long dbID, int cliID, String name, String namesp, int number, int price, int thanhtien,
			boolean damua, String ngaymua) {
		super();
		this.dbID = dbID;
		this.cliID = cliID;
		this.name = name;
		this.namesp = namesp;
		this.number = number;
		this.price = price;
		this.thanhtien = thanhtien;
		this.damua = damua;
		this.ngaymua = ngaymua;
	}
	public long getDbID() {
		return dbID;
	}
	public void setDbID(long dbID) {
		this.dbID = dbID;
	}
	public int getCliID() {
		return cliID;
	}
	public void setCliID(int cliID) {
		this.cliID = cliID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNamesp() {
		return namesp;
	}
	public void setNamesp(String namesp) {
		this.namesp = namesp;
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
	public int getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(int thanhtien) {
		this.thanhtien = thanhtien;
	}
	public boolean isDamua() {
		return damua;
	}
	public void setDamua(boolean damua) {
		this.damua = damua;
	}
	public String getNgaymua() {
		return ngaymua;
	}
	public void setNgaymua(String ngaymua) {
		this.ngaymua = ngaymua;
	}
}