package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.Categorybean;

public class Categorydao {
	public ArrayList<Categorybean> getloai() throws Exception{
		ArrayList<Categorybean> ds=new ArrayList<Categorybean>();
		//b1: Kết nối
		DBConnect dc= new DBConnect();
		dc.KetNoi();
		//b2: lấy dữ liệu về
		String sql="Select * from Category";
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		ResultSet rs=cmd.executeQuery();
		//b3: Duyệt qua các dữ liệu lấy về lưu vào 1 mảng
		while (rs.next()) {
			String cateID=rs.getString("cateID");
			String cname=rs.getString("cname");
			ds.add(new Categorybean(cateID, cname));
		}
		//Đóng kết nối
		rs.close();
		dc.cn.close();
		return ds;
		
	}
	
	public int ThemLoai(String cateID, String cname) throws Exception {
	    // Bước 1: Kết nối vào CSDL
	    DBConnect dcketnoidao = new DBConnect();
	    dcketnoidao.KetNoi();

	    try {
	        // Bước 2: Chuẩn bị câu SQL để thêm loại mới
	        String sql = "INSERT INTO Category (cateID, cname) VALUES (?, ?)";
	        PreparedStatement cmd = dcketnoidao.cn.prepareStatement(sql);
	        
	        // Bước 3: Gán giá trị cho các tham số trong câu SQL
	        cmd.setString(1, cateID);
	        cmd.setString(2, cname);

	        // Bước 4: Thực hiện câu lệnh SQL
	        int result = cmd.executeUpdate();

	        // Bước 5: Đóng tài nguyên
	        cmd.close();
	        return result;
	    } finally {
	        // Đảm bảo luôn đóng kết nối, ngay cả khi có lỗi xảy ra
	        dcketnoidao.cn.close();
	    }
	}
	public int xoaLSP(String cateID) throws Exception{
		DBConnect dcketnoi = new DBConnect();
		dcketnoi.KetNoi();
		String sql1 = "delete from Category where cateID=? ";
		PreparedStatement cmd1 = dcketnoi.cn.prepareStatement(sql1);
		cmd1.setString(1, cateID);
	
		 int result = cmd1.executeUpdate();
		 
		 cmd1.close();
			
		return result;
	}
	public Categorybean getloai(long id) throws Exception{
		ArrayList<Categorybean> ds=new ArrayList<Categorybean>();
		//b1: Kết nối
		DBConnect dc= new DBConnect();
		dc.KetNoi();
		//b2: lấy dữ liệu về
		String sql="Select * from Category where cateID=?";
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		cmd.setLong(1, id);
		ResultSet rs=cmd.executeQuery();
		//b3: Duyệt qua các dữ liệu lấy về lưu vào 1 mảng
		while (rs.next()) {
			String cateID=rs.getString("cateID");
			String cname=rs.getString("cname");
			Categorybean cate=new Categorybean(cateID, cname);
			rs.close();
			dc.cn.close();
			return cate;
		}
		//Đóng kết nối
		
		return null;
		
	}
	public int capnhatLoai(String cateID,String cname) throws Exception
	{
		//b1: ket noi vao csdl
		DBConnect dc=new DBConnect();
		dc.KetNoi();
		
			String sql="update Category set cateID =? where cname =?";
			PreparedStatement cmd=dc.cn.prepareStatement(sql);
			cmd.setString(1,cateID);
			cmd.setString(2,cname);
			
			//b4: Thuc hien cau lieu
			int kq = cmd.executeUpdate();
			cmd.close();
			dc.cn.close();
			return kq;
		
	}
}
