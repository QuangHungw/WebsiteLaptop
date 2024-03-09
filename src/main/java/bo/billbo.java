package bo;

import java.sql.Date;
import java.util.ArrayList;

import bean.xacnhanbean;
import dao.billdao;


public class billbo {

	    private billdao hddao = new billdao();

	    public int addbill(long cliID) throws Exception {
	        return hddao.addbill(cliID);
	    }
	  
	    public int getMahd() throws Exception {
			int rs = hddao.getMaHd();
			return rs;
		}
		
		public ArrayList<xacnhanbean> getDsHoaDonChuaXacNhan() throws Exception {
			return hddao.getHoaDonChuaXacNhan();
		}
		
		public int xacnhanHoadon (int bID) throws Exception {
			return hddao.xacnhanHoaDon(bID);
		}
	}
	
	
