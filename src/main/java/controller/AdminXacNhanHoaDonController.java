package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.billbo;


/**
 * Servlet implementation class AdminXacNhanHoaDonController
 */
@WebServlet("/AdminXacNhanHoaDonController")
public class AdminXacNhanHoaDonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminXacNhanHoaDonController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String bID = request.getParameter("bID");
			billbo hdbo = new billbo();
			if (bID != null) {
				hdbo.xacnhanHoadon(Integer.parseInt(bID));
			}
			
			request.setAttribute("dsHDChuaXN", hdbo.getDsHoaDonChuaXacNhan());
			
			RequestDispatcher rd = request.getRequestDispatcher("AdminXacNhanHd.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
