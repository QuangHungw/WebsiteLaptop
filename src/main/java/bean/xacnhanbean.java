package bean;

public class xacnhanbean {
	private long bID;
	private int cliID;
	private String name;
	private String namesp;
	private int number;
	private int price;
	private int thanhtien;
	private boolean damua;
	public xacnhanbean(long bID, int cliID, String name, String namesp, int number, int price, int thanhtien,boolean damua) {
		super();
		this.bID = bID;
		this.cliID = cliID;
		this.name = name;
		this.namesp = namesp;
		this.number = number;
		this.price = price;
		this.thanhtien = thanhtien;
		this.damua = damua;
	}
	public long getbID() {
		return bID;
	}
	public void setbID(long bID) {
		this.bID = bID;
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
}