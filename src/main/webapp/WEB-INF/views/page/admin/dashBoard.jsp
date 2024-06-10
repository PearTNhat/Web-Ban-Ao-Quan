<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../../common/admin/adminHeader.jsp"%>
</head>
<%@ include file="../../common/admin/adminSideBar.jsp"%>
<div class="main">
	<nav class="navbar bg-white">
	  <div class="container-fluid d-flex justify-content-between">
	    <div class="navbar-brand ms-4">
	      <div class="fs-5">
	      	<a href="admin/dashboard.htm">
		      	<i class="bi bi-speedometer2"></i> Dashboard	      	
	      	</a>
	      </div>
	    </div>
	    <div class="me-3">
	    	Xin chào, <span class="fw-bold">${user.lastName}</span>
	    </div>
	  </div>
	</nav>
	<div class="dashboard p-3">
		<div class="lead fw-bold text-success my-2 ms-3 fs-6 border-bottom pb-2">Doanh thu tháng
			hiện tại</div>
		<div class="row justify-content-center gap-4 my-5">
			<div class="col-sm-12 col-md-3 border rounded p-2">
				<div class="row">
					<div
						class="col-4 d-flex justify-content-center align-items-center fs-1">
						<i class="bi bi-truck"></i>
					</div>
					<div class=" col-8 d-flex flex-column py-3">
						<div class="title">Số đơn đặt hàng</div>
						<div class="counters">${totalBought}</div>
					</div>
				</div>
			</div>
			<div class="col-sm-12 col-md-3 border rounded p-2">
				<div class="row">
					<div
						class="col-4 d-flex justify-content-center align-items-center fs-1">
						<i class="bi bi-cash-coin"></i>
					</div>
					<div class="col-8 d-flex flex-column py-3">
						<div class="title">Tổng doanh thu</div>
						<div class="counters">${totalMoney}</div>
					</div>
				</div>
			</div>
			<div class="col-sm-12 col-md-3 border rounded p-2">
				<div class="row">
					<div
						class="col-4 d-flex justify-content-center align-items-center fs-1">
						<i class="bi bi-people-fill"></i>
					</div>
					<div class="col-8 d-flex flex-column py-3">
						<div class="title">Số khách hàng</div>
						<div class="counters">${quantity_user}</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</div>

</body>
</html>