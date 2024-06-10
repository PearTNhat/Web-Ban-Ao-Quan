<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<nav
	class="navbar sticky-top navbar-expand-lg navbar-light container-fluid bg-white">
	<div class="container-xl ">
		<a class="navbar-brand" href=".htm"> <img
			src="https://4menshop.com/logo.png?v=1" alt="Logo" width="90"
			height="60" class="d-inline-block align-text-top">
		</a>
		<c:if test="${not empty userLogin && userLogin.isAdmin == false}">
			<c:set var="user" value="${user}" />
			<div class="cart-avar d-flex align-items-center gap-4 order-lg-3"
				style="margin-left: auto;">
				<!--    cart -->
				<div class="cart navbar-shopping d-md-block position-relative">
					<i class="fas fa-shopping-cart cart-icon"></i>
					<div class="cart-container ">
						<c:if test="${not empty user.cartDetail}">
							<small class=""> Có <strong>${user.cartDetail.size()}</strong>
								sản phẩm trong giỏ hàng
							</small>
							<ul class="cart-items">
								<c:set var="total" value="0" />
								<c:forEach var="cart" items="${user.cartDetail}" varStatus="s">
									<li class="cart-item">
										<div class=" side-pic" style="width: 24%;">
											<img src="${cart.productDetail.productColor.image[0].image}"
												alt="" style="width: 100%;">
										</div>
										<div class="cart-detail">
											<c:set var="p"
												value="${cart.productDetail.productColor.product}" />
											<c:set var="pPrice" value="${p.price/1000.0}" />
											<p>${p.name}(${  cart.productDetail.productColor.color.name}
												- ${ cart.productDetail.size.name})</p>
											<span> <span>${cart.quantity }</span>x <fmt:formatNumber
													value="${pPrice-(pPrice * p.discount)}" type="number"
													pattern="#,##0.000" />
											</span>
											<c:set var="itemTotal"
												value="${(pPrice - (pPrice * p.discount)) * cart.quantity}" />
											<c:set var="total" value="${total + itemTotal}" />
											<div class="" style="margin-top: 15px;">
												<a href="cart/detete/${cart.cartDetailId}.htm"> <i
													class="bi bi-trash-fill"></i>
												</a>
											</div>
										</div>
									</li>
								</c:forEach>
								<span>Tổng cộng:</span>
								<span><fmt:formatNumber value="${total }" type="number"
										pattern="#,##0.000" /></span>
										<button class="btn-submit">
									<a href="products/cart-checkout.htm" class="btn">Gủi đơn
										hàng</a>
								</button>
							</ul>
						</c:if>
						<c:if test="${ empty user.cartDetail}">
							<small class=""> Có <strong>0</strong> sản phẩm trong giỏ
								hàng
							</small>
						</c:if>
					</div>

				</div>

				<!-- user -->
				<div class="user">
					<c:choose>
						<c:when test="${not empty user.avatar}">
							<img src="${user.avatar}" alt=""
								class="rounded-circle d-md-block"
								style="width: 40px; height: 35px; margin-right: 5px;">
						</c:when>
						<c:otherwise>
							<img
								src="https://static.vecteezy.com/system/resources/previews/009/292/244/original/default-avatar-icon-of-social-media-user-vector.jpg"
								alt="" class="rounded-circle d-md-block"
								style="width: 40px; margin-right: 5px;">
						</c:otherwise>
					</c:choose>
					<div class="user-container">
						<ul class="user-feature">
							<li class=""><a href="profile/info.htm">Thông tin tài
									khoản</a></li>
							<li class=""><a href="profile/info.htm">Quản lí</a></li>
							<li class="border border-t-1 d-flex align-items-center gap-2">
								<a href="user/logout.htm" class="d-block"> <span>
										Đăng xuất </span> <i class="bi bi-box-arrow-left logout ml-1"></i>
							</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</c:if>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse justify-content-end order-lg-2"
			id="navbarNav">
			<ul class="navbar-nav me-2">
				<li class="nav-item"><a class="nav-link" href="#">HÀNG BÁN
						CHẠY</a></li>
				<c:forEach var="pt" items="${sessionScope.pts}">
					<li class="nav-item"><label for="click-type${pt.typeId}"
						style="display: block;"> <span
							class="nav-link text-uppercase p-type">${pt.name} </span>
					</label> <input type="checkbox" id="click-type${pt.typeId}"
						style="width: 0; height: 0; display: none" />
						<ul class="dd-type dd-type-none">
							<c:forEach var="typeDetail" items="${pt.types}">
								<li><a href="products/${typeDetail.typeDetailId}.htm"
									class="text-decoration-none"> ${typeDetail.name} </a></li>
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
			<c:if test="${not empty sessionScope.user && user.isAdmin == true}">
				<a href="admin/dashboard.htm"
					class="btn btn-outline btn-outline-secondary">Admin <i
					class="bi bi-arrow-bar-right fw-bold"></i></a>
			</c:if>
		</div>
	</div>
</nav>


