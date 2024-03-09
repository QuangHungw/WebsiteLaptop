
<%@page import="bean.lichsuMHbean"%>
<%@page import="bean.clientbean"%>
<%@page import="bean.Categorybean"%>
<%@page import="bean.productbean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bo.productbo"%>
<%@page import="bo.Categorybo"%> 
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
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
<%
response.setCharacterEncoding("utf-8");
	request.setCharacterEncoding("utf-8");
%>
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
        <a class="nav-link" href="giohang.jsp">Thanh toán</a>
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
 <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Đăng nhập hệ thống</h4>
        </div>
        <div class="modal-body">
  				<form action="ktdnController" method="post">
 				<label>Tài khoản</label><br>
  				<input type="text" id="TenDN" name="TenDN" style="width: 265px"><br>
  				<label>Mật khẩu</label><br>
  				<input type="passWord" id="Matkhau" name="Matkhau" style="width:  265px"><br>
  				<input name="btlog" value="Đăng nhập" type="submit" style="margin-top: 10px">
				</form>
  			</div>
      </div>
    </div>
 </div>
   <h2 style="text-align:center">LỊCH SỬ MUA HÀNG</h2><table align="center">
<%
 response.setCharacterEncoding("utf-8");
	request.setCharacterEncoding("utf-8");
	ArrayList<lichsuMHbean> ds = (ArrayList<lichsuMHbean>) request.getAttribute("ls");
   
 %>

             <table width="1000" align="center">
    
    <tr> 
       <td valign="top" width="200">
       		<table class="table table-bordered">
       		 <thead>
    <tr>
   	  <th scope="col">Mã hóa đơn</th>
       <th scope="col">Mã khách hàng</th> 
      <th scope="col" >Tên sản phẩm</th>
      <th scope="col">Số lượng mua</th>
      <th scope="col">Giá</th>
         <th scope="col">Ngày mua</th>
      <th scope="col">Thành tiền</th>
      <th scope="col">Đã mua</th>
         
    </tr>
  </thead>
       		<%
    if (ds != null) {
        int n = ds.size();
        for (int i = 0; i < n; i++) {
            lichsuMHbean ls = ds.get(i);
%>
            <tr>
                <td><%= ls.getbID() %></td>
                <td><%= ls.getDbID() %></td>
                <td><%= ls.getCliID() %></td>
                <td><%= ls.getNumber() %></td>
                <td><%= ls.getPrice() %></td>
                <td><%= ls.getDate() %></td>
                <td><%= ls.getThanhtien() %></td>
                <td><%= ls.getDamua() %></td>
            </tr>
<%
        }
    } else {
        // Handle the case when ds is null or empty, for example, show an error message.
        out.println("No data available.");
    }
%>
       		</table>
        </td>
        </tr>
        </table>

</body>
</html>








