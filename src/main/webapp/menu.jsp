<%@page import="bean.clientbean"%>
<%@page import="bean.Categorybean"%>
<%@page import="bean.productbean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bo.productbo"%>
<%@page import="bo.Categorybo"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Trang chủ</title>
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
      <form method="POST" class="search_form" action="htproductController">
						<div class="input-	group">
							<input type="text" name = "txtfind" class="search-query form-control input-group" Placeholder="My laptop.">
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
</div><div class="slide">
<img src="slider_6.png" width="100%" />
</div><div class="slide">
<img src="slider_7.png" width="100%"/>
</div>
</div>
</div>

<section style=" text-align:  center;">
<h5>Website chúng tôi chuyên cung cấp các sản phẩm chất lượng có uy tín và mới nhất trên thị trường hiện nay
<br>Hãy ghé thăm trang web của chúng tôi và đừng bỏ lỡ các sản phẩm mới nhé!</h5>
</section>
<hr>
</div>
<div class="container" style="margin-top:5px; margin-left: 10px">
  <div class="row">
    <div class="col-sm-3">
  
      <ul class="nav nav-pills flex-column" style="background-color: #DFDFDF ;">
        <li class="nav-item">
          <a class="nav-link active" href="htproductController">ILAPTOP</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Hãng sản phẩm</a>
          <ul>
				
				
			<c:forEach var="loai" items="${dsCategory}" >
    <tr> 	<li>
        <td>
           <a href="htproductController?ml=${loai.getcateID()}">
           ${loai.getCname()}
           </a>
          

           
        </td>  </li>
   	 </tr>
	</c:forEach>
		
										
			</ul>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Loại sản phẩm</a>
          <ul>
				<li><a href="#">Chơi game</a></li>									
				<li><a href="#">Học tập-văn phòng</a></li>
				<li><a href="#">Đồ họa-kỹ thuật</a></li>	
				<li><a href="#">Cao cấp sang trọng</a></li>																	
			</ul>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Bán chạy nhất</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Sản phẩm mới</a>
        </li>
      </ul>
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
 
  <%
 response.setCharacterEncoding("utf-8");
	request.setCharacterEncoding("utf-8");
	ArrayList<Categorybean> dsloai =(ArrayList<Categorybean>)request.getAttribute("dsloai");
    ArrayList<productbean> ds=(ArrayList<productbean>)request.getAttribute("dsproduct");
 %>
 
    <div id="myCarousel-2" class="myCarousel carousel slide">
								
										<div class="active item">
																						
		<table class="table table-hover">
                  <%
                  int n = ds.size();                                    
                  for(int i=0;i<n;i++) {
                    productbean s=ds.get(i);
                  %>
					<tr>
                       <td>
                            <img src=<%=s.getImage() %>><br>
                             <a href="giohangController?id=<%=s.getId()%>&name=<%=s.getName()%>&image=<%=s.getImage()%>&gia=<%=s.getPrice()%>">
                             <img src="mua.jpg">
                             </a> 
                             <br>
                             <%=s.getName() %> <br>
                             <%=s.getTitle()%> <br>
                             <%=s.getPrice()%> VNĐ <br>
     
						<%i++;
                         if(i<n){
                        	 s=ds.get(i);
                         
                       %><td>
                            <img src=<%=s.getImage() %>><br>
                             <a href="giohangController?id=<%=s.getId()%>&name=<%=s.getName()%>&image=<%=s.getImage()%>&gia=<%=s.getPrice()%>">
                             <img src="mua.jpg">
                             </a> 
								<br>
                             <%=s.getName() %> <br>
                             <%=s.getTitle()%> <br>
                             <%=s.getPrice()%> VNĐ<br>
                       </td>
                       <%} %>
                       <%i++;
                         if(i<n){
                        	 s=ds.get(i);
                         
                       %><td>
                            <img src=<%=s.getImage() %>><br>
                             <a href="giohangController?id=<%=s.getId()%>&name=<%=s.getName()%>&image=<%=s.getImage()%>&gia=<%=s.getPrice()%>">
                             <img src="mua.jpg">
                             </a> 
								<br>
                             <%=s.getName() %> <br>
                             <%=s.getTitle()%> <br>
                             <%=s.getPrice()%> VNĐ<br>
                       </td>
                       <%} %>
                    </tr>
                  <%} %>
              </table>									
				 																						
 </div> 
 <%if(request.getAttribute("ktt")!=null)
	out.print("Không tìm thất");
%>

 </div>
 </div>
 </div>
									

</body>
</html>