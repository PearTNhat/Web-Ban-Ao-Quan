<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="./cloths.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<title>Ao quan</title>
<style>
.page-title p {
	position: relative;
	background: rgb(250, 250, 250);
	padding-left: 10px;
}

.page-title p:after {
	content: '';
	position: absolute;
	top: 0;
	left: 0;
	width: 2px;
	height: 100%;
	background-color: rgb(204, 204, 204);
	z-index: 10;
}

.side-widget h5 {
	margin: 0;
	position: relative;
	font-weight: bold;
	color: #666;
	font-size: 14px;
	margin-bottom: 8px;
}

.side-widget h5::after {
	position: absolute;
	content: '';
	display: block;
	width: 100%;
	height: 1px;
	top: 50%;
	transform: translateY(-50%);
	background: #666;
	z-index: -1;
}

.side-widget h5 span {
	background: #fff;
	padding: 0 10px 0 0;
}

.text-secondary {
	color: #666;
	font-size: 13px;
}

.price-widget {
	font-size: 14px;
	padding-left: 8px;
}

.side-pic {
	padding: 3px;
	background: #eee;
	max-width: 76px;
}

.slash::after {
	content: '/';
	padding: 0 5px;
	color: #666;
}

.router {
	background: rgb(248, 248, 248);
	padding-top: 10px;
	padding-bottom: 10px;
}

.router ul {
	list-style: none;
	padding: 0;
	margin: 0;
	display: flex;
	align-items: center;
	font-size: 13px;
	font-weight: 500;
}

.router a {
	text-decoration: none;
	color: #333;
}

.pagination {
	gap: 10px;
}

.pagination li a {
	color: #333;
}

.pagination li:hover a {
	color: #23527c;
	background-color: #eee;
	border-bottom: 1px solid #666;
}

.page-link:focus {
	background-color: rgb(179, 31, 42);
	color: #fff;
	box-shadow: none;
}

.page-item:first-child .page-link {
	border-top-left-radius: 0;
	border-bottom-left-radius: 0;
}

.page-item:last-child .page-link {
	border-top-right-radius: 0;
	border-bottom-right-radius: 0;
}
</style>

</head>

<body>
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
				<h1 class="text-center text-md-start">THỜI TRANG MỚI NHẤT</h1>
				<p>
					<strong> Áo sơ mi nam </strong>luôn là trang phục lựa chọn hàng đầu
					của nhiều chàng trai, bởi sự tiện ích và tính thời trang mà nó mang
					lại cho người mặc.
				</p>
			</div>
			<div class="col-md-8">
				<div class="row">
					<div class="col-lg-4 col-6 ">
						<a href="" class="text-decoration-none"> <img
							src="https://4menshop.com/cache/image/300x400/images/thumbs/2019/08/ao-vest-nazafu-mau-xam-1139_2_small-10932.JPG"
							alt="" class="img-fluid"> <img
							src="https://4menshop.com/cache/image/300x400/images/thumbs/2019/08/ao-vest-nazafu-mau-xam-1139_2_small-10932.JPG"
							alt="" class="my-1" width=20%>
						</a> <a href=""
							class="link-underline link-underline-opacity-0 link-dark d-block small">Áo
							Vest NAZAFU Màu xám da bò </a>
						<p class="price text-danger fw-medium small">
							675.000 <span
								class="text-decoration-line-through small text-secondary">1.350.000</span>
						</p>

					</div>
					<div class="col-lg-4 col-6 ">
						<a href="" class="text-decoration-none"> <img
							src="https://4menshop.com/cache/image/300x400/images/thumbs/2019/08/ao-vest-nazafu-mau-xam-1139_2_small-10932.JPG"
							alt="" class="img-fluid"> <img
							src="https://4menshop.com/cache/image/300x400/images/thumbs/2019/08/ao-vest-nazafu-mau-xam-1139_2_small-10932.JPG"
							alt="" class="my-1" width=20%>
						</a> <a href=""
							class="link-underline link-underline-opacity-0 link-dark d-block small">Áo
							Vest NAZAFU Màu xám da bò </a>
						<p class="price text-danger fw-medium small">
							675.000 <span
								class="text-decoration-line-through small text-secondary">1.350.000</span>
						</p>

					</div>
					<div class="col-lg-4 col-6 ">
						<a href="" class="text-decoration-none"> <img
							src="https://4menshop.com/cache/image/300x400/images/thumbs/2019/08/ao-vest-nazafu-mau-xam-1139_2_small-10932.JPG"
							alt="" class="img-fluid"> <img
							src="https://4menshop.com/cache/image/300x400/images/thumbs/2019/08/ao-vest-nazafu-mau-xam-1139_2_small-10932.JPG"
							alt="" class="my-1" width=20%>
						</a> <a href=""
							class="link-underline link-underline-opacity-0 link-dark d-block small">Áo
							Vest NAZAFU Màu xám da bò </a>
						<p class="price text-danger fw-medium small">
							675.000 <span
								class="text-decoration-line-through small text-secondary">1.350.000</span>
						</p>

					</div>
					<div class="col-lg-4 col-6 ">
						<a href="" class="text-decoration-none"> <img
							src="https://4menshop.com/cache/image/300x400/images/thumbs/2019/08/ao-vest-nazafu-mau-xam-1139_2_small-10932.JPG"
							alt="" class="img-fluid"> <img
							src="https://4menshop.com/cache/image/300x400/images/thumbs/2019/08/ao-vest-nazafu-mau-xam-1139_2_small-10932.JPG"
							alt="" class="my-1" width=20%>
						</a> <a href=""
							class="link-underline link-underline-opacity-0 link-dark d-block small">Áo
							Vest NAZAFU Màu xám da bò </a>
						<p class="price text-danger fw-medium small">
							675.000 <span
								class="text-decoration-line-through small text-secondary">1.350.000</span>
						</p>

					</div>
					<nav class="d-flex justify-content-center border-top pt-2"
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

</body>

</html>