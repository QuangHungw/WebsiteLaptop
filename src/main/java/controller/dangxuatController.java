package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/dangxuatController")
public class dangxuatController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public dangxuatController() {
        super();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session != null) {
            session.removeAttribute("dn");
             
            RequestDispatcher dispatcher = request.getRequestDispatcher("htproductController");
            dispatcher.forward(request, response);
        }
    }
}
