package bo;

import java.util.ArrayList;

import bean.giohangbean;


public class giohangbo {

	public ArrayList<giohangbean> ds=new ArrayList<giohangbean>();

	public void Them(String anh,String id, String name, Long price,Long number ){
		
		for(giohangbean g:ds)
			if(g.getId().equals(id))
			{
				g.setNumber(g.getNumber()+number);
				return ;
			}
		ds.add(new giohangbean(anh, id, name, price, number, number));
	}
	public void xoa(String id) {
		for(giohangbean g: ds)
			  if(g.getId().equals(id)) {
				  ds.remove(g);break;
			  }
	}
	public void SuaSoluong(String id, long number) {
		for (giohangbean gh : ds) {
			if (gh.getId().equals(id)) {
				gh.setNumber(number);
				break;
			}
		}
	}
	public void XoaHet() {
		ds.removeAll(ds);
	}
	public Long tongtien() {
		long s=(long)0;
		for(giohangbean g: ds)
			s+=g.getThanhtien();
		return s;
	}
public int Dem(){
    	
    	int dem=0;
    	for(giohangbean g: ds)
    		
    			dem++;
    	return dem;
 	
	}
}
