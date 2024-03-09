package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Categorybean;
import bean.productbean;
import bo.Categorybo;
import bo.productbo;

/**
 * Servlet implementation class htgioController
 */
@WebServlet("/htgioController")
public class htgioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public htgioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Categorybo lbo = new Categorybo();
			productbo sbo= new productbo();
		 	String ml= request.getParameter("ml");
		 	String key= request.getParameter("txtfind");
		 	ArrayList<Categorybean> dsCategory=lbo.getloai();
		 	ArrayList<productbean> dsproduct= sbo.getSach();
		    if(ml!=null) dsproduct= sbo.Tim(dsproduct, ml);
		    else
		   		if(key!=null) dsproduct=sbo.Tim(dsproduct, key);
		    request.setAttribute("Category", dsCategory);
		    request.setAttribute("product", dsproduct);
		    RequestDispatcher rd= request.getRequestDispatcher("giohang.jsp");
		    rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
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
