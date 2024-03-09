package controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.clientbean;
import bo.clientbo;
import dao.clientdao;

/**
 * Servlet implementation class ktdkController
 */
@WebServlet("/ktdkController")
public class ktdkController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ktdkController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setCharacterEncoding("utf-8");
	        request.setCharacterEncoding("utf-8");

	        try {
	            String name = request.getParameter("name");
	            String address = request.getParameter("address");
	            String email = request.getParameter("email");
	            String account = request.getParameter("account");
	            String pass = request.getParameter("pass");
	            String repassword = request.getParameter("repass");
	            if (name != null && account != null && pass != null) {
					if (repassword.equals(pass)) {
	            clientbo kh = new clientbo();
	            kh.dangky(name, address, email, account, pass);
					}
	            // Chuyển hướng đến trang thành công hoặc thực hiện xử lý tiếp theo
	            response.sendRedirect("htproductController");
	            }
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
