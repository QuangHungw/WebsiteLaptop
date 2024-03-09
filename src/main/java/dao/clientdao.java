package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.Categorybean;
import bean.clientbean;

public class clientdao {
	public void dangky(String name,String address, String email,String account,String pass )throws Exception {
		
		
		DBConnect dc = new DBConnect();
		dc.KetNoi();
		String sql = "INSERT INTO client(name, address,account,pass,email) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, name);
		cmd.setString(2, address);
		cmd.setString(3, account);
		cmd.setString(4, pass);
		cmd.setString(5, email);
		cmd.executeUpdate();	
}
	
	
	
	
	
	
	
	
	
public clientbean getkh(String un,String matkhau) throws Exception{
		
		//B1: kết nối
				DBConnect dc = new DBConnect();
				dc.KetNoi();
				//b2: lay du lieu ve
				String sql = "Select * from client where account=? and pass=?";
				PreparedStatement cmd = dc.cn.prepareStatement(sql);
				//Truyền tham số tài khoản mật khẩu
				cmd.setString(1, un);
				cmd.setString(2, matkhau);
				ResultSet rs = cmd.executeQuery();
				//Nếu rs.next==false return null
				// else: return kh;
					// Tạoo ra 1 khachhang:kh và return kh;
				if (rs.next()==false) return null;
				else {
					
					Long cliID=rs.getLong("cliID");
		    		String name=rs.getString("name");
		    		String address=rs.getString("address");
		    		String account=rs.getString("account");
		    		String pass=rs.getString("pass");
		    		String email=rs.getString("email");
		    		 clientbean kh=new clientbean(cliID, name, address,account, pass,email);
		    		rs.close();
			    	dc.cn.close();
		    		return kh;
					}
		    	//Dong ket noi
				
	}
public ArrayList<clientbean> getkh() throws Exception{
	ArrayList<clientbean> ds=new ArrayList<clientbean>();
	//B1: kết nối
			DBConnect dc = new DBConnect();
			dc.KetNoi();
			//b2: lay du lieu ve
			String sql = "Select * from client ";
			PreparedStatement cmd = dc.cn.prepareStatement(sql);
			//Truyền tham số tài khoản mật khẩu
			
			ResultSet rs = cmd.executeQuery();
			//Nếu rs.next==false return null
			// else: return kh;
				// Tạoo ra 1 khachhang:kh và return kh;
			while (rs.next()) 
			 {
				
				Long cliID=rs.getLong("cliID");
	    		String name=rs.getString("name");
	    		String address=rs.getString("address");
	    		String account=rs.getString("account");
	    		String pass=rs.getString("pass");
	    		String email=rs.getString("email");
	    		ds.add(new clientbean(cliID, name, address, account, pass,email));
			 }
	    		rs.close();
		    	dc.cn.close();
				
			return ds;
	    	//Dong ket noi
			
}
	public clientbean ktkh(String un) throws Exception{
	
		//B1: kết nối
				DBConnect dc = new DBConnect();
				dc.KetNoi();
				//b2: lay du lieu ve
				String sql = "Select * from client where account=? ";
				PreparedStatement cmd = dc.cn.prepareStatement(sql);
				//Truyền 01 tham số: un; pas vào cmd
				cmd.setString(1, un);
				ResultSet rs = cmd.executeQuery();
				//Nếu rs.next==false return null
				// else: return kh;
					// Tạo ra 1 khachhang:kh và  return kh;
				while (rs.next()) 
			 {
					
					Long cliID=rs.getLong("cliID");
		    		String name=rs.getString("name");
		    		String address=rs.getString("address");
		    		String account=rs.getString("account");
		    		String pass=rs.getString("pass");
		    		String email=rs.getString("email");
		    		clientbean kh=new clientbean(cliID, name, address,account, pass,email);
		    		rs.close();
			    	dc.cn.close();
		    		return kh;
				}
				return null;
		    	//Dong ket noi	
	}
	

	
}
