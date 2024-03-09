package bo;

import java.util.ArrayList;

import bean.productbean;
import bean.productbean;
import dao.productdao;



public class productbo {
	productdao sdao = new productdao();
	public ArrayList<productbean> ds;
	public ArrayList<productbean> getSach() throws Exception{
		ds= sdao.getproduct();
		return ds;
	
	}
	public ArrayList<productbean> Product(ArrayList<productbean> ds, String cid){
		ArrayList<productbean> tam= new ArrayList<productbean>();
		for (productbean sv:ds)
			if(sv.getCateID()==cid)
				tam.add(sv);
		return tam;
	
	}
	public ArrayList<productbean> TimMa(String CateId) throws Exception{
		ArrayList<productbean> tam = new ArrayList<productbean>();
		for(productbean sv: ds)
			if(sv.getCateID().trim().toLowerCase().equals(CateId.trim().toLowerCase()))
				tam.add(sv);
		return tam;
	}
	public ArrayList<productbean> Tim(ArrayList<productbean> ds, String key){
    	ArrayList<productbean> tam= new ArrayList<productbean>();
    	for(productbean sv: ds)
    		if(sv.getName().toLowerCase().trim().contains(key.trim().toLowerCase())
    				||sv.getTitle().trim().toLowerCase().contains(key.trim().toLowerCase()))
    			tam.add(sv);
    	return tam;
    	
}
 	
	
	public int Dem( ArrayList<productbean> ds, String cid){
    	
    	int dem=0;
    	for(productbean sv: ds)
    		if(sv.getCateID()==cid)
    			dem++;
    	return dem;
 	
	}
	public int ThemSp(String id, String namesp, String image, Long price, String title, String maloai) throws Exception {
	    return sdao.ThemSp(id, namesp, image, price, title, maloai);
	}
	public int xoaSP(String id) throws Exception{
		return sdao.xoaSP(id);
	}
	public productbean loadsp(String id) throws Exception{
		return sdao.loadsp(id);
	}
	public void SuaSanPham(String id,String namesp, String image, Long price,String title ,String maloai) throws Exception
	{  sdao.SuaSanPham(id, namesp, image, price, title, maloai);}
}



