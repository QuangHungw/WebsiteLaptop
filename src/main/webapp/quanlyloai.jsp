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
            	<div class = "form mb-3">
            		<form action = "AdminQLLoaiController" method = 'post'>
			
  <div class="form-group">
    <label for="exampleInputEmail1">Mã loại</label>
    <input name = "maloai" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Mã loại" ">
    	
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Tên loại</label>
    <input name = "tenloai" type="text" class="form-control" id="exampleInputPassword1" placeholder="Tên loại" >
  </div>
  <button type="submit" class="btn btn-primary">Thêm</button>
  <input type="submit" name = "fix" class="btn btn-primary" value = "Sửa">
</form>
            	</div>
            	 <table class = "table">
            	<thead>
            		<tr>
            			<td>Mã loại</td>
            			<td>Tên loại</td>
            		</tr>
            	</thead>
            	<tbody>
            		<%ArrayList<Categorybean> dsloai = (ArrayList<Categorybean>)request.getAttribute("dsloai");
    				if (dsloai != null) {
    					for (Categorybean item : dsloai) {
    				
    				%>
    				<tr>
    					<td><%=item.getcateID() %></td>
    					<td><%=item.getCname() %></td>
    					<td><a href = "AdminQLLoaiController?choose=<%=item.getcateID() %>" class = "btn btn-danger">Chọn</a></td>
    					<td><a class = "btn btn-danger" data-toggle="modal" data-target="#xacnhanXoa<%=item.getcateID() %>">Xóa</a>
    					
    						<div class="modal fade" id="xacnhanXoa<%=item.getcateID() %>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
								  <div class="modal-dialog" role="document">
								    <div class="modal-content">
								      <div class="modal-header">
								        <h5 class="modal-title" id="exampleModalLabel">Xác nhận xóa</h5>
								        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
								          <span aria-hidden="true">&times;</span>
								        </button>
								      </div>
								      <div class="modal-body">
								        Bạn có chắc chắn muốn xóa không
								      </div>
								      <div class="modal-footer">
								        <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
								        <a href = "AdminQLLoaiController?delete=<%=item.getcateID() %>" class="btn btn-primary">Đồng ý</a>
								      </div>
								    </div>
								  </div>
								</div>
    					
    					</td>
    				</tr>
    				
    				<% }
    					}%>
    				
            	</tbody>
            </table>
            </div>
            
           
</body>
</html>