package bean;

public class detailed_billbean {
	private int dbID;
	private String id;
	private int number;
	private int bID;
	private String damua;
	
	public detailed_billbean()
	{
		super();
	}
	public detailed_billbean(int dbID, String id, int number, int bID, String damua)
	{
		this.dbID = dbID;
		this.id =id;
		this.number = number;		
		this.bID = bID;
		this.damua = damua;
	}
	public int getDbID() {
		return dbID;
	}
	public void setDbID(int dbID) {
		this.dbID = dbID;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getbID() {
		return bID;
	}
	public void setbID(int bID) {
		this.bID = bID;
	}
	public String getDamua() {
		return damua;
	}
	public void setDamua(String damua) {
		this.damua = damua;
	}
	
	
}
