package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.Categorybo;


/**
 * Servlet implementation class AdminQLyBanPhim
 */
@WebServlet("/AdminQLLoaiController")
public class AdminQLLoaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminQLLoaiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Categorybo lbo = new Categorybo();
			String cateID = request.getParameter("cateID");
			String cname = request.getParameter("cname");
			String delete = request.getParameter("delete");
			String choose = request.getParameter("choose");
			if (cateID != null && cname != null) {
				if (lbo.ThemLoai(cateID, cname) == 0) {
					lbo.capnhatLoai(cateID ,cname);
				}
				else lbo.ThemLoai(cateID, cname);
			}
			
			if (delete != null) {
				lbo.xoaLSP(cateID);
			}
			
			if (choose != null) {
				request.setAttribute("ml", choose);
			}
			request.setAttribute("dsloai", lbo.getloai());
			RequestDispatcher rd = request.getRequestDispatcher("quanlyloai.jsp");
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
