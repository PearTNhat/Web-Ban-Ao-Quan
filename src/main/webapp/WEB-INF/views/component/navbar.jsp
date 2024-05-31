<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav
	class="navbar sticky-top navbar-expand-lg navbar-light container-fluid bg-white">
	<div class="container-xl ">
		<a class="navbar-brand" href=".htm"> <img
			src="https://4menshop.com/logo.png?v=1" alt="Logo" width="90"
			height="60" class="d-inline-block align-text-top">
		</a>
		<c:if test="${not empty sessionScope.user}">
			<div class="cart-avar d-flex align-items-center gap-4 order-lg-3"
				style="margin-left: auto;">
				<!--                 cart -->
				<div class="cart navbar-shopping d-md-block position-relative">
					<i class="fas fa-shopping-cart cart-icon"></i>

					<div class="cart-container ">
						<small class=""> Có <strong> 2 </strong> sản phẩm trong
							giỏ hàng
						</small>
						<ul class="cart-items">
							<li class="cart-item">
								<div class=" side-pic">
									<img
										src="https://4menshop.com/cache/image/70/images/thumbs/2023/04/ao-khoac-regular-technical-ak036-mau-den-17947.JPG"
										alt="">
								</div>
								<div class="cart-detail">
									<p>Áo thun nam cổ tròn màu đen</p>
									<span> <span>1</span>x 150.000
									</span>
									<div class="" style="margin-top: 15px;">
										<i class="bi bi-trash-fill"></i>
									</div>
								</div>
							</li>
							<li class="cart-item">
								<div class=" side-pic">
									<img
										src="https://4menshop.com/cache/image/70/images/thumbs/2023/04/ao-khoac-regular-technical-ak036-mau-den-17947.JPG"
										alt="">
								</div>
								<div class="cart-detail">
									<p>Áo thun nam cổ tròn màu đen</p>
									<span> <span>1</span>x 150.000
									</span>
									<div class="" style="margin-top: 15px;">
										<i class="bi bi-trash-fill"></i>
									</div>
								</div>
							</li>
							<li class="cart-item">
								<div class=" side-pic">
									<img
										src="https://4menshop.com/cache/image/70/images/thumbs/2023/04/ao-khoac-regular-technical-ak036-mau-den-17947.JPG"
										alt="">
								</div>
								<div class="cart-detail">
									<p>Áo thun nam cổ tròn màu đen</p>
									<span> <span>1</span>x 150.000
									</span>
									<div class="" style="margin-top: 15px;">
										<i class="bi bi-trash-fill"></i>
									</div>
								</div>
							</li>
							<li class="cart-item">
								<div class=" side-pic">
									<img
										src="https://4menshop.com/cache/image/70/images/thumbs/2023/04/ao-khoac-regular-technical-ak036-mau-den-17947.JPG"
										alt="">
								</div>
								<div class="cart-detail">
									<p>Áo thun nam cổ tròn màu đen</p>
									<span> <span>1</span>x 150.000
									</span>
									<div class="" style="margin-top: 15px;">
										<i class="bi bi-trash-fill"></i>
									</div>
								</div>
							</li>
							<span>Tổng cộng:</span>
							<span>300.000</span>
							<button>Gủi đơn hàng</button>
						</ul>
					</div>
				</div>
				<!-- user -->
				<div class="user">
					<img
						src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTVlCnyLYgXFNF7pdPhUodXuPIzZPLEHBb_1A&s"
						alt="" class="rounded-circle d-md-block"
						style="width: 40px; margin-right: 5px;">
					<div class="user-container">
						<ul class="user-feature">
							<li class=""><a href="profile/info.htm">Thông tin tài
									khoản</a></li>
							<li class=""><a href="profile/info.htm">Quản lí</a></li>
							<li class="border border-t-1 d-flex align-items-center gap-2">
								<a href="user/logout.htm" class="d-block"> Đăng xuất </a> <i
								class="bi bi-box-arrow-left logout"></i>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</c:if>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation"
			>
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse justify-content-end order-lg-2"
			id="navbarNav">
			<ul class="navbar-nav me-2">
				<li class="nav-item"><a class="nav-link" href="#">HÀNG BÁN
						CHẠY</a></li>
				<c:forEach var="pt" items="${sessionScope.pts}">
					<li class="nav-item"><span
						class="nav-link text-uppercase p-type">${pt.name}</span>

						<ul class="dd-type dd-type-none">
							<c:forEach var="typeDetail" items="${pt.types}">
								<li>${typeDetail.name}</li>
							</c:forEach>
						</ul></li>

				</c:forEach>
			</ul>
			<form class="d-flex my-2 me-5" role="search">
				<input class="form-control search me-2 shadow-none border"
					type="search" placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-secondary" type="submit">
					<i class="bi bi-search"></i>
				</button>
			</form>
			<c:if test="${empty sessionScope.user}">
				<a class="mx-2" href="user/login.htm">Đăng nhập</a>
				<a class="btn btn-danger" href="user/signup.htm">Đăng ký</a>
			</c:if>
		</div>
	</div>
</nav>


