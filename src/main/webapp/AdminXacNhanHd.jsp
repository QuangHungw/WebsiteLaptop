<%@page import="bean.xacnhanbean"%>
<%@page import="bean.clientbean"%>
<%@page import="bean.Categorybean"%>
<%@page import="bean.productbean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bo.productbo"%>
<%@page import="bo.Categorybo"%>
<%@page import="bean.giohangbean"%>
<%@page import="bo.giohangbo"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Giỏ hàng</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <style>
  .fakeimg {
    height: 200px;
    background: #aaa;
  }
  

#slideshow {
  overflow: hidden;
  height: 200px;
  width: 728px;
  margin: 0 auto;
}

.slide-wrapper {
  width: 2912px;
  -webkit-animation: slide 14s ease infinite;
}

.slide {
  float: left;
  height: 510px;
  width: 728px;
}


@-webkit-keyframes slide {
  20% {margin-left: 0px;}
  30% {margin-left: -728px;}
  50% {margin-left: -728px;}
  60% {margin-left: -1456px;}
  80% {margin-left: -1456px;}
}
  
 .btn{
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
  }
  .btn2 {background-color: #008CBA;} /* Blue */
  .btn3 {background-color: #f70000;}  
  .btn4 {background-color: #0F0718;} 
  </style>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
   <a class="navbar-brand" href="htproductController">ILAPTOP</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="htproductController">Trang chủ</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="AdminXacNhanHoaDonController">Xác nhận hóa đơn</a>
      </li>
         
      <li class="nav-item">
        <a class="nav-link" href="AdminQLLoaiController">Quản Lý Loại Sản Phẩm</a>
      </li>  
       <li class="nav-item">
        <a class="nav-link" href="QuanLySPController">Quản Lý Sản Phẩm</a>
      </li> 
      <li> 
     
				</li>	
      <!-- <li class="nav-item" style="text-indent: 250px">
        <a class="nav-link" href="htgioController">Giỏ hàng</a>
      </li>   -->
     <!--  <li class="nav-item" >
        <a class="nav-link" href="lichsuMHController">Thanh toán</a>
      </li>  -->
      
		 <li class="nav-item"><a class="nav-link" href="#">Xin chào: Admin </a></li>
		 <li class="nav-item"><a class="nav-link" href="dangxuatController"><span></span> Đăng Xuất</a></li>
           
           
    </ul>
  </div>  	
</nav>
<div>	

<div id="slideshow">
<div class="slide-wrapper">
<div class="slide">
<img src="slider_1.jpg"width="100%"/> 
</div><div class="slide">
<img src="slider_4.png" width="100%" /> 
</div><div class="slide">
<img src="slider_5.png" width="100%"/> 	
</div>
</div>
</div>

<!-- Button Đăng nhập -->
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-sm">
      <div class="modal-content">
        <div class="modal-header">
         <h4 class="modal-title">Đăng nhập hệ thống</h4>
 <button type="button" class="close" data-dismiss="modal" style="height: 68px">&times;</button>
         
        </div>
        <div class="modal-body">
  				<form action="ktdnController" method="post">
 				<label>Tài khoản:</label><br>
  				<input type="text" id="TenDN" name="TenDN" style="width: 265px"><br>
  				<label>Mật khẩu:</label><br>
  				<input type="passWord" id="Matkhau" name="Matkhau" style="width:  265px"><br>
  				<input name="btlog" value="Đăng nhập" type="submit" style="margin-top: 10px">
				</form>
  			</div>
      </div>
    </div>
 </div>

            </nav>
            
            <div class = "container">
            	<div>
            		<ul class = "d-flex" style = "list-style: none">
            					<li class = "col">Mã hóa đơn</li>
            					<li class = "col">Họ tên khách hàng</li>
            					<li class = "col">Tên sản phẩm</li>
            					<li class = "col">Số lượng mua</li>
            					<li class = "col">Giá</li>
            					<li class = "col">Thành tiền</li>
            				</ul>
            	</div>
            	<% if (request.getAttribute("dsHDChuaXN") != null) {
            			ArrayList<xacnhanbean> ds = (ArrayList<xacnhanbean>)request.getAttribute("dsHDChuaXN");
            			int n = ds.size();
            		%>
            		<% for (int i = 0 ; i < n; i++ ) {
            			xacnhanbean item = ds.get(i);
            			%>
            			<div class = "item pb-3" style = "border-bottom: 1px solid black">
            				<ul class = "d-flex" style = "list-style: none">
            					<% if (i == 0 || (i != 0 && item.getbID() != ds.get(i-1).getbID()) ){ %>
            					<li class = "col"><%=item.getbID() %></li>
            					<%}  else if (i != 0 && item.getbID() == ds.get(i-1).getbID()) { %>
            					<li class = "col"></li>
            					<%} %>
            					<li class = "col"><%= item.getName() %></li>
            					<li class = "col"><%= item.getNamesp() %></li>
            					<li class = "col"><%= item.getNumber() %></li>
            					<li class = "col"><%= item.getPrice() %></li>
            					<li class = "col"><%= item.getThanhtien() %></li>
            					
            				</ul>
            				<% if (i == n-1 || item.getbID() != ds.get(i+1).getbID()) { %>
            				<a href = "AdminXacNhanHoaDonController?mahd=<%=item.getbID() %>" class = "ml-5 btn btn-danger">Xác nhận</a>
            				<% } %>
            			</div>
            <%} } %>
            </div>
</body>
</html>