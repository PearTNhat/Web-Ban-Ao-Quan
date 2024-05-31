<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <nav class="navbar sticky-top navbar-expand-lg navbar-light container-fluid bg-white">
        <div class="container-xl ">
            <a class="navbar-brand" href=".htm"> <img src="https://4menshop.com/logo.png?v=1" alt="Logo" width="90"
                    height="60" class="d-inline-block align-text-top">
            </a>
            <div class="d-flex align-items-center gap-4 order-lg-3">
                <!-- cart -->
                <div class="cart navbar-shopping d-md-block position-relative">
                    <i class="fas fa-shopping-cart cart-icon"></i>
                    <div class="cart-container ">
                        <small class=""> Có <strong> 2 </strong> sản phẩm trong giỏ hàng </small>
                        <ul class="cart-items">
                            <li class="cart-item">
                                <div class=" side-pic">
                                    <img src="https://4menshop.com/cache/image/70/images/thumbs/2023/04/ao-khoac-regular-technical-ak036-mau-den-17947.JPG"
                                        alt="">
                                </div>
                                <div class="cart-detail">
                                    <p>Áo thun nam cổ tròn màu đen</p>
                                    <span> <span>1</span>x 150.000</span>
                                    <div class="" style="margin-top: 15px;">
                                        <i class="bi bi-trash-fill"></i>
                                    </div>
                                </div>
                            </li>
                            <li class="cart-item">
                                <div class=" side-pic">
                                    <img src="https://4menshop.com/cache/image/70/images/thumbs/2023/04/ao-khoac-regular-technical-ak036-mau-den-17947.JPG"
                                        alt="">
                                </div>
                                <div class="cart-detail">
                                    <p>Áo thun nam cổ tròn màu đen</p>
                                    <span> <span>1</span>x 150.000</span>
                                    <div class="" style="margin-top: 15px;">
                                        <i class="bi bi-trash-fill"></i>
                                    </div>
                                </div>
                            </li>
                            <li class="cart-item">
                                <div class=" side-pic">
                                    <img src="https://4menshop.com/cache/image/70/images/thumbs/2023/04/ao-khoac-regular-technical-ak036-mau-den-17947.JPG"
                                        alt="">
                                </div>
                                <div class="cart-detail">
                                    <p>Áo thun nam cổ tròn màu đen</p>
                                    <span> <span>1</span>x 150.000</span>
                                    <div class="" style="margin-top: 15px;">
                                        <i class="bi bi-trash-fill"></i>
                                    </div>
                                </div>
                            </li>
                            <li class="cart-item">
                                <div class=" side-pic">
                                    <img src="https://4menshop.com/cache/image/70/images/thumbs/2023/04/ao-khoac-regular-technical-ak036-mau-den-17947.JPG"
                                        alt="">
                                </div>
                                <div class="cart-detail">
                                    <p>Áo thun nam cổ tròn màu đen</p>
                                    <span> <span>1</span>x 150.000</span>
                                    <div class="" style="margin-top: 15px;">
                                        <i class="bi bi-trash-fill"></i>
                                    </div>
                                </div>
                            </li>
                            <span>Tổng cộng:</span>
                            <span>300.000</span>
                            <button> Gủi đơn hàng</button>
                        </ul>
                    </div>
                </div>
                <!-- toggle navbar -->
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation"
                    style="margin-left: auto;">
                    <span class="navbar-toggler-icon"></span>
                </button>


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
							<a href="" class="d-block"> Đăng xuất </a> <i
							class="bi bi-box-arrow-left logout"></i>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<!-- Loại và tìm kiếm-->
		<%@ include file="./filterNav.jsp"%>
	</div>
