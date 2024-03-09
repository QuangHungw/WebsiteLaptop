package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.productbean;
import bo.productbo;

/**
 * Servlet implementation class QuanLLyBPController
 */
@WebServlet("/QuanLySPController")
public class QuanLySPController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuanLySPController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dirUrl = null;
		
		String nameimg  = null;
		
		 DiskFileItemFactory factory = new DiskFileItemFactory();
		 DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		 ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		 response.setCharacterEncoding("utf-8");
			request.setCharacterEncoding("utf-8");
			Map<String, String> fieldMap = new HashMap<>();
		
		try {
			
			List<FileItem> fileItems = upload.parseRequest(request);//Láº¥y vá»� cÃ¡c Ä‘á»‘i tÆ°á»£ng gá»­i lÃªn
			//duyá»‡t qua cÃ¡c Ä‘á»‘i tÆ°á»£ng gá»­i lÃªn tá»« client gá»“m file vÃ  cÃ¡c control
			for (FileItem fileItem : fileItems) {
 			 if (!fileItem.isFormField()) {//Náº¿u ko pháº£i cÃ¡c control=>upfile lÃªn
				// xá»­ lÃ½ file
			 nameimg = fileItem.getName();
				if (!nameimg.equals("")) {
			           //Láº¥y Ä‘Æ°á»�ng dáº«n hiá»‡n táº¡i, chá»§ Ã½ xá»­ lÃ½ trÃªn dirUrl Ä‘á»ƒ cÃ³ Ä‘Æ°á»�ng dáº«n Ä‘Ãºng
					dirUrl = "D:\\Duanjava\\webapp\\cloth";
					File dir = new File(dirUrl);
					if (!dir.exists()) {//nếu không có tái tạo ra
						dir.mkdir();
					}
				           String fileImg = dirUrl + File.separator + nameimg;
				           File file = new File(fileImg);//táº¡o file
				            try {
				               fileItem.write(file);//lÆ°u file
				              
				 } catch (Exception e) {
				    e.printStackTrace();
				}
			}
			
				
		 }
 			if (fileItem.isFormField())//Neu la control
			{

				String fieldName = fileItem.getFieldName();
		        String fieldValue = fileItem.getString("UTF-8");
		        fieldMap.put(fieldName, fieldValue);
		        
			} 
 		
			}
			
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
			
		
		try {
			
			response.setCharacterEncoding("utf-8");
			request.setCharacterEncoding("utf-8");
			productbo spbo = new productbo();
			
			 String id = fieldMap.get("id");
	            String namesp = fieldMap.get("namesp");
	            String title = fieldMap.get("title");
	            String image = fieldMap.get("image");
	            String pricetam = request.getParameter("price"); // Lấy giá tiền từ tham số
	            String cateID = fieldMap.get("cateID");
	            String maloaichon = request.getParameter("maloaichon");
	            String maloaisua = fieldMap.get("maloaisua");
	            String maloaixoa = request.getParameter("maloaixoa");
			
	            if (id != null && namesp != null && title != null && cateID != null && image != null) {
	                try {
	                    // Chuyển đổi giá tiền thành Long
	                    Long price = (pricetam != null && !pricetam.isEmpty()) ? Long.parseLong(pricetam) : 0;
	                    spbo.ThemSp(id, namesp, image, price, title, cateID);
				} catch (Exception e) {
					// TODO: handle exception
				}
		}
			
			if (maloaixoa != null) {
				spbo.xoaSP(maloaixoa);
			}
			if (maloaichon != null) {
			    request.setAttribute("id", maloaichon);
			    ArrayList<productbean> ds = spbo.getSach();
			    for (productbean item : ds) {
			        if (item.getId().equals(maloaichon)) {
			            request.setAttribute("namesp", item.getName());
			            request.setAttribute("title", item.getTitle());
			            request.setAttribute("price", (int) item.getPrice());
			            request.setAttribute("cateID", item.getCateID());
			            request.setAttribute("image", item.getImage());
			            break;
			        }
			    }
			}
			if (maloaisua != null) {
				System.out.println(id);
			spbo.SuaSanPham(id, namesp, image,  Long.parseLong(pricetam), title, maloaixoa);
				
			}
			request.setAttribute("dssp", spbo.getSach());
			RequestDispatcher rd = request.getRequestDispatcher("quanlysp.jsp");
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



















