package bo;
import java.util.ArrayList;

import bean.Categorybean;

import dao.Categorydao;
public class Categorybo {
	Categorydao ldao= new Categorydao();
	   public ArrayList<Categorybean> getloai() throws Exception{
		   return ldao.getloai();
	   }
	   public ArrayList<Categorybean> Tim(ArrayList<Categorybean> ds, String key){
	    	ArrayList<Categorybean> tam= new ArrayList<Categorybean>();
	    	for(Categorybean sv: ds)
	    		if(sv.getcateID().toLowerCase().contains(key.toLowerCase())||sv.getCname().toLowerCase().contains(key.toLowerCase()))
	    			tam.add(sv);
	    	return tam;
	 	
		}
		public int Dem( ArrayList<Categorybean> ds, String cateID){
	    	
	    	int dem=0;
	    	for(Categorybean sv: ds)
	    		if(sv.getcateID()==cateID)
	    			dem++;
	    	return dem;
	 	
		}
		public int ThemLoai(String cateID, String cname) throws Exception {
			ArrayList<Categorybean> ds = ldao.getloai();
			for (Categorybean item : ds ) {
				if (item.getcateID().equals(cname)) return 0;
			}
			return ldao.ThemLoai(cateID, cname);
		}
		public void xoaLSP(String cateID) throws Exception{
			ldao.xoaLSP(cateID);
		}
		public Categorybean getloai(long id) throws Exception{
			return ldao.getloai(id);
		}
		public int capnhatLoai(String cateID, String cname) throws Exception {
		return ldao.capnhatLoai(cateID, cname);
}
}