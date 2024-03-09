package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import bean.detailed_billbean;

public class detailed_billdao {
public void themcthd(String id, long number, int bID,String damua  )throws Exception {
		
		
		DBConnect dc = new DBConnect();
		dc.KetNoi();
		String sql = "insert into detailed_bill(id,number,bID,damua) values (?,?,?,?) ";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, id);
		cmd.setLong(2, number);
		cmd.setInt(3, bID);
		cmd.setString(4, damua);
		cmd.executeUpdate();
			
}
	public int maxhd() throws Exception{
		DBConnect dc = new DBConnect();
		dc.KetNoi();
		
		Statement st=dc.cn.createStatement();
		ResultSet rs = st.executeQuery("select max(bID)from bill");
		int id2 = -1;
		if (rs.next()) {
		   id2 = rs.getInt(1);  
		}
		return id2;
	}
public void xacnhancthd(String pid,String damua)throws Exception {
		
		
		DBConnect dc = new DBConnect();
		dc.KetNoi();
		String sql = "update detailed_bill set damua=? where dbID=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, damua);
		cmd.setString(2, pid);
		cmd.executeUpdate();
			
}
public void xoacthd(String id) throws Exception{
	DBConnect dc = new DBConnect();
	dc.KetNoi();
	String sql = "delete from detailed_bill where dbID=? ";
	PreparedStatement cmd = dc.cn.prepareStatement(sql);
	cmd.setString(1, id);
	cmd.executeUpdate();
}
}
