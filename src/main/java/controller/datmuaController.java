package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.clientbean;
import bean.giohangbean;

import bo.billbo;

import bo.detailed_billbo;
import bo.giohangbo;


/**
 * Servlet implementation class datmuaController
 */
@WebServlet("/datmuaController")
public class datmuaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public datmuaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		clientbean kh= (clientbean) session.getAttribute("dn");
		try {
		if(kh==null)
			response.sendRedirect("dangkyController");
			else {
				billbo hdbo = new billbo();
				detailed_billbo ctbo = new detailed_billbo();
				// tao ra 1 hoa don
				hdbo.addbill(kh.getCliID());
				int maxhd = hdbo.getMahd();
			
				// Them vao bang chitietHD
				giohangbo gh = (giohangbo) session.getAttribute("gh");
				for(giohangbean h:gh.ds)
					ctbo.getcthd(h.getId(),h.getNumber(),maxhd,h.getId());
				session.removeAttribute("gh");
				response.sendRedirect("htproductController");
			}
	} catch (Exception e) {
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
