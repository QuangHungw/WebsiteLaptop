package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

	import bean.productbean;

public class productdao {
	public ArrayList<productbean> getproduct() throws Exception{
			
		
		   	
			ArrayList<productbean> dsSanPham=new ArrayList<productbean>();
			//B1: kết nối
			DBConnect dc = new DBConnect();
			dc.KetNoi();
			//b2: lay du lieu ve
			String sql = "Select *from product";
			PreparedStatement cmd = dc.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			//b3: duyet qua cac du lieu lay ve de luu vao 1 mang
			while(rs.next()) {
				String id=rs.getString("id");
	    		String namesp=rs.getString("namesp");
	    		String image=rs.getString("image");
	    		Long price=rs.getLong("price");
	    		String title=rs.getString("title");
	    		String CateID=rs.getString("CateID");
	    	
	    		dsSanPham.add(new productbean(id, namesp, image, price, title,CateID));
	    	}
	    	//Dong ket noi
	    	rs.close();
	    	dc.cn.close();
	 
	    	 return dsSanPham;
		}
	public int ThemSp(String id, String namesp, String  image, Long price, String title, String maloai) throws Exception {
	    DBConnect dc = new DBConnect();
	    dc.KetNoi();
	    
	    try {
	        String sql = "INSERT INTO product(id, namesp,  image, price, title, maloai) VALUES (?, ?, ?, ?, ?, ?)";
	        PreparedStatement cmd = dc.cn.prepareStatement(sql);
	        
	        cmd.setString(1, id);
	        cmd.setString(2, namesp);
	        cmd.setString(3,  image);
	        cmd.setLong(4, price);
	        cmd.setString(5, title);
	        cmd.setString(6, maloai);

	        int result = cmd.executeUpdate();

	        cmd.close();
	        return result;
	    } finally {
	        dc.cn.close();
	    }
	}
	public int xoaSP(String id) throws Exception{
		DBConnect dc = new DBConnect();
		dc.KetNoi();
		String sql1 = "delete from detailed_bill where id=? ";
		PreparedStatement cmd1 = dc.cn.prepareStatement(sql1);
		cmd1.setString(1, id);
		int kq = cmd1.executeUpdate();
		 
		 cmd1.close();
			dc.cn.close();
		return kq;
	}
	public productbean loadsp(String id) throws Exception{
		
		//B1: káº¿t ná»‘i
				DBConnect dc = new DBConnect();
				dc.KetNoi();
				//b2: lay du lieu ve
				String sql = "Select * from product where id=?";
				PreparedStatement cmd = dc.cn.prepareStatement(sql);
				//Truyá»�n 01 tham sá»‘: un; pas vÃ o cmd
				cmd.setString(1, id);
				
				ResultSet rs = cmd.executeQuery();
				//Náº¿u rs.next==false return null
				// else: return kh;
					// Táº¡o ra 1 khachhang:kh vÃ  return kh;
				while (rs.next()) 
			 {
					String pid=rs.getString("id");
		    		String namesp=rs.getString("namesp");
		    		String image=rs.getString("image");
		    		Long price=rs.getLong("price");
		    		String title=rs.getString("title");
		    		String cateID=rs.getString("cateID");
		    		productbean kh=new productbean(pid, namesp, image,price, title, cateID);
		    		rs.close();
			    	dc.cn.close();
		    		return kh;
				}
				return null;
		    	//Dong ket noi	
	}
	public void SuaSanPham(String id,String namesp, String image, Long price,String title ,String maloai) throws Exception
	{
		//b1: ket noi vao csdl
		DBConnect dc=new DBConnect();
		dc.KetNoi();
		
			String sql="update product set namesp=?,image=?,price=?,title=?,cateID=? where id=?";
			PreparedStatement cmd=dc.cn.prepareStatement(sql);
			cmd.setString(1,namesp);
			cmd.setString(2,image);
			cmd.setLong(3,price);
			cmd.setString(4,title);
			cmd.setString(5,maloai);
			cmd.setString(6, id);
			//b4: Thuc hien cau lieu
			cmd.executeUpdate();
		
	}
}
