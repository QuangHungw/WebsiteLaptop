package bo;

import java.util.ArrayList;

import bean.clientbean;
import dao.clientdao;

public class clientbo {
	clientdao khdao= new clientdao();
	clientbean kh=new clientbean();
	 public void dangky(String name, String address,  String account, String pass,String email) throws Exception{
	        khdao.dangky(name, address, account, pass ,email);
	    }

	   
	   public clientbean ktdn(String cliID, String pass) throws Exception
	   {
		   

	    	return khdao.getkh(cliID, pass);
	   }
	   public clientbean ktkh(String cliID) throws Exception
	   {
		   

	    	return khdao.ktkh(cliID);
	   }
	   public ArrayList<clientbean> getkh() throws Exception{
		   return khdao.getkh();
	   }
}
