package dao;


import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bean.xacnhanbean;

import java.sql.ResultSet;

public class billdao {


	
	public int addbill(Long cliID) throws Exception {
	    DBConnect dc = new DBConnect();
	    dc.KetNoi();
	    String sql = "INSERT INTO bill(cliID, Date, damua) VALUES (?, ?, 0)";
	    PreparedStatement cmd = dc.cn.prepareStatement(sql);

	    cmd.setLong(1, cliID);

	    // Lấy ngày giờ hiện tại
	    Date currentDate = new Date();
	    
	    // Chuyển định dạng ngày về yyyy-MM-dd
	    SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
		String st = dd.format(currentDate);

	    // Chuyển ngày thành kiểu java.sql.Date và gán vào câu lệnh SQL
		Date n2 = dd.parse(st);
		cmd.setDate(2, new java.sql.Date(n2.getTime()));
		int kq = cmd.executeUpdate();
		cmd.close(); dc.cn.close();
		return kq;

	}
	public int getMaHd() throws Exception {
		DBConnect dc = new DBConnect();
		 dc.KetNoi();
		
		String sql = "select max(bID) from bill";
		
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		int max = 0;
		while(rs.next()) {
			max = rs.getInt(1);
		}
		rs.close();
		dc.cn.close();
		return max;
	}
	
	public int xacnhanHoaDon(int bID) throws Exception {
		DBConnect dc = new DBConnect();
		 dc.KetNoi();
		
		String sql = "update bill set damua = ? where bID = ?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setLong(1, bID);
		
		int kq = cmd.executeUpdate();
		cmd.close();
		dc.cn.close();
		
		return kq;
	}
	
	public ArrayList<xacnhanbean> getHoaDonChuaXacNhan() throws Exception {
		DBConnect dc = new DBConnect();
		 dc.KetNoi();
		
		String sql = "select * from VXacNhan";
		
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		ArrayList<xacnhanbean> dsHoaDon = new ArrayList<xacnhanbean>();
		while(rs.next()) {
			long bID = rs.getLong("bID");
			int cliID = rs.getInt("cliID");
			String name = rs.getString("name");
			String namesp = rs.getString("namesp");
			int number = rs.getInt("number");
			int price = rs.getInt("price");
			int thanhtien = rs.getInt("thanhtien");
			boolean damua = rs.getBoolean("damua");
			dsHoaDon.add(new xacnhanbean(bID, cliID, name, namesp, number, price, thanhtien, damua));
		}
		return dsHoaDon;
	}
}

