package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.clientbean;

import bean.lichsuMHbean;

import bo.lichsuMHbo;


/**
 * Servlet implementation class lichsuMHController
 */
@WebServlet("/lichsuMHController")
public class lichsuMHController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lichsuMHController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			lichsuMHbo ls = new lichsuMHbo();
			HttpSession session = request.getSession();
			if (session.getAttribute("dn") == null) {
				request.setAttribute("err", "errLs");
				RequestDispatcher rd = request.getRequestDispatcher("htproductController?err");
				rd.forward(request, response);
			}
			else {
				clientbean kh = (clientbean)session.getAttribute("dn");
				ArrayList<lichsuMHbean> lsmua = ls.getlsMH(kh.getCliID());
				request.setAttribute("ls", lsmua);
				RequestDispatcher rd = request.getRequestDispatcher("LichSuMH.jsp");
				rd.forward(request, response);
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
