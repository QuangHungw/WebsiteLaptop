package bo;

import dao.detailed_billdao;
import dao.billdao;

public class detailed_billbo {
	detailed_billdao khdao= new detailed_billdao();
	public void getcthd(String id, long number, int bID,String damua ) throws Exception{
		    khdao.themcthd(id, number, bID, damua);
   }
	public int maxhd() throws Exception {
		return khdao.maxhd();
		
	}
	public void xacnhancthd(String pid,String damua)throws Exception {
		khdao.xacnhancthd(pid, damua);
	}
	public void xoacthd(String id) throws Exception{
		khdao.xoacthd(id);
	}
}
