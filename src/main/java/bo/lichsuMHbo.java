package bo;

import java.util.ArrayList;

import bean.lichsuMHbean;
import bean.productbean;
import dao.lichsuMHdao;
import dao.productdao;

public class lichsuMHbo {
	lichsuMHdao ls = new lichsuMHdao();
	public ArrayList<lichsuMHbean> getlsMH(long cliID) throws Exception{
		return ls.getls(cliID);		
	}
	
}
