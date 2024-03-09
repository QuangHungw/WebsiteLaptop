   
<%@page import="bean.productbean"%>
<%@page import="bean.Categorybean"%>


<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<%
 response.setCharacterEncoding("utf-8");
	request.setCharacterEncoding("utf-8");
	
    ArrayList<Categorybean> dsloai=(ArrayList<Categorybean>)request.getAttribute("dsCategory");
    ArrayList<productbean> dssp=(ArrayList<productbean>)request.getAttribute("dsproduct");
 %>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"><script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    	
<script src="js/jquery-1.11.1.min.js"></script>   
   <style>
  .fakeimg {
    height: 200px;
    background: #aaa;
  }
   .btn{
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 5px 10px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  cursor: pointer;
  }
  .btn2 {background-color: #008CBA;} /* Blue */
  .btn3 {background-color: #f70000;}
  </style>
</head>
<body>
<h2 class="text-center">Quản lý Khách hàng</h2>
<div class="container"> 
 <table id="cart" class="table table-hover table-condensed"> 
  <thead> 
   <td><a href="themsanpham.jsp" class="btn btn-warning"><i class="fa fa-angle-left"></i> Thêm sản phẩm</a>
    </td> 
   <tr> 
    <th style="width:10%">ID</th> 
    <th style="width:30%">Name</th> 
    <th style="width:8%">Image</th> 
    <th style="width:22%" class="text-center">price</th> 
    <th style="width:10%">CateID </th> 
     <th style="width:20%">Lựa chọn </th> 
   </tr> 
  </thead> 
  <tbody>
   <%
                  int n=dssp.size();
                  for(int i=0;i<n;i++) {
                    productbean s=dssp.get(i);
                  %>
  <tr> 
   <td data-th="Product"> 
    <%=s.getId() %>
    </td> 
   <td data-th=""><%=s.getName() %></td> 
  
   
   <td data-th="Price"><img src="<%=s.getImage()%>"></td> 
  <td data-th="Price"><%=s.getPrice()%></td> 
  <td data-th="Price"><%=s.getCateID()%></td> 
  
 <%--   <td data-th="Subtotal" class="text-center"><%=s.getDiachi()%></td>  --%>
   <td class="actions" data-th="">
    <a href="adminSuaKH.jsp?makh=<%=s.getId() %>" class="btn btn2 ">Sửa</a>
   
    <a href="adminXoaKHController?makh=<%=s.getId() %>" class="btn btn2">Xóa</a>
    
   </td> 
  </tr> 
 
  </tbody>
  <%} %>
  <tfoot> 
   
   
  </tfoot> 
 </table>
</div>
</body>
</html>
