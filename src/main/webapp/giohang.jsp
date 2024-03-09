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
        <a class="nav-link" href="htproductController">Sản phẩm</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Giới thiệu</a>
      </li>    
      <li class="nav-item">
        <a class="nav-link" href="lichsuMHController">Lịch sử</a>
      </li>  
      <li> 
      <form method="POST" class="search_form">
						<div class="input-	group">
							<input type="text" class="search-query form-control input-group" Placeholder="My laptop.">
							<span class="input-group-btn">
								<!-- <button class="btn btn-primary rounded-circle btnpro" type="button" id="btn-search"  >
									<span class="fa fa-search"></span>
								</button> -->
							</span>						
						</div>
					</form>
				</li>	
      <li class="nav-item" style="text-indent: 250px">
        <a class="nav-link" href="htgioController">Giỏ hàng</a>
      </li>  
      <li class="nav-item" >
        <a class="nav-link" href="lichsuMHController">Thanh toán</a>
      </li> 
      <% clientbean kh=(clientbean)session.getAttribute("dn");
		if(kh!=null){
		   
		%>
		 <li class="nav-item"><a class="nav-link" href="#">Xin chào: <%=kh.getName()%> </a></li>
		 <li class="nav-item"><a class="nav-link" href="dangxuatController"><span></span> Đăng Xuất</a></li>
           <%}else{ %>
         <li class="nav-item"><a class="nav-link" href="dangkyController"><span ></span> Đăng ký</a></li>
		 <li class="nav-item"><a class="nav-link" href="#" data-toggle="modal" data-target="#myModal">
           <span class="glyphicon glyphicon-log-in"></span> Đăng nhập</a></li>
              <%  if(session.getAttribute("kt")!=null && session.getAttribute("kt").toString().equals("0")){%>
             		 <script>alert('Dang nhap sai');</script>
              <%} %>
           <%} %>
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

<section style=" text-align:  center;">
<h5 style=" color: #03A9F4">SHOPPING CART</h5>
</section>
<hr>				
						<h4 class="title"><span class="text">Giỏ Hàng Của Bạn </span></h4>
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Ảnh</th>
									<th>Mặt hàng</th>
									<th> Tên Sản Phẩm </th>
									<th> Số Lượng </th>
									<th> Giá Tiền </th>
									<th> Tổng </th>
								</tr>
							</thead>
							<tbody>
								<% giohangbo gh1;
             
if(session.getAttribute("gh")!=null){
	gh1=(giohangbo) session.getAttribute("gh");%>

	 <b>Giỏ hàng có: <%=gh1.Dem()%> </b>
	<% for(giohangbean g1: gh1.ds) {%>
	<tr>
				
				<th style="width: 10px"><img src="<%=g1.getAnh() %>"height="150"></th>
				<th><b><%=g1.getId() %></b></th>
				<th><b><%=g1.getName() %></b></th>
				
				
				<th>
					<form action="capnhatController" method="post">
					<input type="hidden" name="id" value="<%=g1.getId()%>">	
						 <input type="number" min="1"  name="soluong" value="<%=g1.getNumber()%>" style="width:50px;">
						
						<input type="submit" name ="butcapnhat"value="Cập nhật">
						<input type="submit" name="butxoa" value="Trả lại">
					</form>
					</th>
					<th><b><%=g1.getPrice() %> VNĐ</b><br></th>
					<th><b> <%=g1.getThanhtien() %> VNĐ</b><br></th>
			
		</tr>
		</tbody>
			
	<% }%>	
	<td style="background-color: white; width: 250px"><h4><b>Tổng tiền: <%=gh1.tongtien() %> VNĐ</b></h4></td>

	<% } %>
		</table>	
						<p class="buttons center">				
							<input class="btn btn2" type="submit" name ="butcapnhat" value="Cập nhật"  >
							<a href="htproductController"><button class="btn btn4"> Tiếp Tục </button></a>
							<a href="datmuaController"><button class="btn" type="submit" id="checkout">Thanh Toán</button></a>
						</p>					

</div>	

</body>
</html>