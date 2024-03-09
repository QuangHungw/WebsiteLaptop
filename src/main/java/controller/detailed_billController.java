package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bean.giohangbean;
import bean.clientbean;
import bo.detailed_billbo;
import bo.giohangbo;
import bo.billbo;
import dao.billdao;

/**
 * Servlet implementation class CTHDController
 */
@WebServlet("/detailed_billController")
public class detailed_billController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public detailed_billController() {
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
			HttpSession session= request.getSession();
			giohangbo gh1=(giohangbo) session.getAttribute("gh");
			int n=gh1.ds.size();
            for(int i=0;i<=n;i++) {
              giohangbean s=gh1.ds.get(i);
				String id=s.getId();
			   long number=s.getNumber();
			   String damua="False";
			   
			   detailed_billbo cthd1=new detailed_billbo();
			  int bID=cthd1.maxhd();
				cthd1.getcthd(id, number,bID , damua);
				response.sendRedirect("lichsuMHController");
	
			}	
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
