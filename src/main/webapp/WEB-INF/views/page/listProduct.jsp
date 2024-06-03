<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<link rel="stylesheet" href="resources/css/imge-cart.css">
<link rel="stylesheet" href="resources/css/listProduct.css">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
	<%@ include file="../component/topbar.jsp"%>
	<%@ include file="../component/navbar.jsp"%>
	<div class="router">
		<div class="container-lg d-flex justify-content-between">
			<ul>
				<li class="slash"><a href="#">4MEN</a></li>
				<li><a href="#">Áo Thun Nam</a></li>
			</ul>
		</div>
	</div>
	<div class="container-lg">
		<div class="row">
			<div class="col-12 page-title">
				<h3 class="text-center text-md-start">${pst.get(0).type.name}</h3>
				<p>
					<strong>${pst.get(0).type.name} </strong>${pst.get(0).type.desc}
				</p>
			</div>
			<div class="col-md-8">
				<div class="row">
					<c:forEach var="p" items="${pst}">
						<div class="col-lg-4 col-6 ">
							<a href="" class="text-decoration-none">
								<div class="main-image">
									<i class="fas fa-shopping-cart cart-product"></i> <img
										src="${p.productImage.get(0).image }"
										alt="${p.name}" class="img-fluid img-1" /> <img
										src="https://4menshop.com/cache/image/300x400/images/thumbs/2019/08/ao-vest-nazafu-mau-xam-1139_2_small-10932.JPG"
										alt="${p.productImage.get(0).image }" class="img-fluid img-2" />
								</div>
								<div class="sub-image">
									<img
										src="https://4menshop.com/cache/image/300x400/images/thumbs/2019/08/ao-vest-nazafu-mau-xam-1139_2_small-10932.JPG"
										alt="" />
								</div>
							</a>
							<p href="" class="mb-0 d-block small text-center">Áo Vest
								NAZAFU Màu xám da bò</p>
							<p class="price text-danger fw-semibold small text-center">
								675.000 <span
									class="text-decoration-line-through small text-secondary">1.350.000</span>
							</p>
						</div>
					</c:forEach>
					<nav class="d-flex justify-content-center border-top py-4"
						aria-label="Page navigation">
						<ul class="pagination">
							<li class="page-item"><a class="page-link" href="#"
								aria-label="Previous"> <span> &laquo; </span>
							</a></li>
							<li class="page-item"><a class="page-link page-active "
								href="#">1</a></li>
							<li class="page-item"><a class="page-link" href="#">2</a></li>
							<li class="page-item"><a class="page-link" href="#">3</a></li>
							<li class="page-item"><a class="page-link" href="#"
								aria-label="Next"> &raquo; </a></li>
						</ul>
					</nav>
				</div>
			</div>
			<div class="col-md-4 side-widget">
				<h5>
					<span>SẢN PHẨM HOT</span>
				</h5>
				<div class="row">
					<div class="col-12">
						<div class="row g-0 mb-2">
							<div class="col-4 side-pic">
								<a href="#" class=""> <img class="w-100"
									src="https://4menshop.com/cache/image/70/images/thumbs/2023/04/ao-khoac-regular-technical-ak036-mau-den-17947.JPG"
									alt="áo">
								</a>
							</div>
							<div class="col-8 price-widget">
								<p class="">Áo Khoác Regular Technical AK036 Màu Đen</p>
								<span class="text-danger ">249.000</span> <span
									class="text-decoration-line-through text-secondary">485.000</span>
							</div>
						</div>
						<div class="row g-0 mb-2">
							<div class="col-4 side-pic">
								<a href="#" class=""> <img class="w-100"
									src="https://4menshop.com/cache/image/70/images/thumbs/2023/04/ao-khoac-regular-technical-ak036-mau-den-17947.JPG"
									alt="áo">
								</a>
							</div>
							<div class="col-8 price-widget">
								<p class="">Áo Khoác Regular Technical AK036 Màu Đen</p>
								<span class="text-danger ">249.000</span> <span
									class="text-decoration-line-through text-secondary">485.000</span>
							</div>
						</div>
						<div class="row g-0 mb-2">
							<div class="col-4 side-pic">
								<a href="#" class=""> <img class="w-100"
									src="https://4menshop.com/cache/image/70/images/thumbs/2023/04/ao-khoac-regular-technical-ak036-mau-den-17947.JPG"
									alt="áo">
								</a>
							</div>
							<div class="col-8 price-widget">
								<p class="">Áo Khoác Regular Technical AK036 Màu Đen</p>
								<span class="text-danger ">249.000</span> <span
									class="text-decoration-line-through text-secondary">485.000</span>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../common/footer.jsp"%>