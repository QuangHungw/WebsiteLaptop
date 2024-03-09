package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import bean.lichsuMHbean;
import bean.productbean;

public class lichsuMHdao {

		
	
	   	
	public ArrayList<lichsuMHbean> getls(long cliID) throws Exception {
	    ArrayList<lichsuMHbean> ds = new ArrayList<lichsuMHbean>();

	    // B1: kết nối
	    DBConnect dc = new DBConnect();
	    dc.KetNoi();

	    // B2: lấy dữ liệu về
	    String sql = "SELECT * FROM View_1 WHERE cliID = ?";
	    PreparedStatement cmd = dc.cn.prepareStatement(sql);
	    cmd.setLong(1, cliID);
	    ResultSet rs = cmd.executeQuery();

	    // B3: duyệt qua các dữ liệu lấy về để lưu vào mảng
	    while (rs.next()) {
	        long cliID1 = rs.getLong("cliID");
	        long bID = rs.getLong("bID");
	        long dbID = rs.getLong("dbID");  // Chỉnh sửa tên cột
	        int number = rs.getInt("number");
	        int price = rs.getInt("price");
	        Date Date = rs.getDate("Date");
	        int thanhtien = rs.getInt("thanhtien");
	        String damua = rs.getString("damua");

	        ds.add(new lichsuMHbean(cliID1, bID, dbID, number, price, Date, thanhtien, damua));
	    }

	    // Đóng kết nối
	    rs.close();
	    cmd.close();
	    dc.cn.close();

	    return ds;
	}
}

