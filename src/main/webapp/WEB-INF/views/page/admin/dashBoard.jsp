<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ include file="../../common/admin/adminHeader.jsp"%>

<%@ include file="../../common/admin/adminSideBar.jsp"%>
<div class="main">
	<nav
		class="navbar navbar-expand-sm container-fluid bg-white border border-3 border-light mb-3">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"></a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse justify-content-end"
				id="navbarNav">
				<ul class="navbar-nav text-end">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Features</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">Pricing</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="dashboard p-3">
		<div class="display-6">Dashboard</div>
		<div class="lead fw-bold text-success my-2 fs-6">Doanh thu tháng
			hiện tại</div>
		<div class="row justify-content-center gap-4 my-4">
			<div class="col-3 border p-2">
				<div class="row">
					<div
						class="col-4 d-flex justify-content-center align-items-center fs-1">
						<i class="bi bi-truck"></i>
					</div>
					<div class=" col-8 d-flex flex-column py-3">
						<div class="title">Số đơn đặt hàng</div>
						<div class="counters">307.144</div>
					</div>
				</div>
			</div>
			<div class="col-3 border p-2">
				<div class="row">
					<div
						class="col-4 d-flex justify-content-center align-items-center fs-1">
						<i class="bi bi-cash-coin"></i>
					</div>
					<div class="col-8 d-flex flex-column py-3">
						<div class="title">Tổng doanh thu</div>
						<div class="counters">307.144</div>
					</div>
				</div>
			</div>
			<div class="col-3 border p-2">
				<div class="row">
					<div
						class="col-4 d-flex justify-content-center align-items-center fs-1">
						<i class="bi bi-people-fill"></i>
					</div>
					<div class="col-8 d-flex flex-column py-3">
						<div class="title">Số khách hàng</div>
						<div class="counters">307.144</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</div>

</body>
</html>