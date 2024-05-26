<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<link rel="stylesheet" href="resources/css/home/home.css">
<style>
#btn-back-to-top {
	position: fixed;
	bottom: 20px;
	right: 20px;
	opacity: 0;
	transition: all .2s;
}
</style>
</head>
<body>
	<%@ include file="../component/topbar.jsp"%>
	<%@ include file="../component/navbar.jsp"%>

	<%@ include file="../component/banner.jsp"%>

	<!-- Hot items -->
	<section class="hot-items">
		<div class="container-xl text-center">
			<div class="lead fw-bold">THỜI TRANG HOT NHẤT</div>
			<div class="row">
				<div class="col-6 col-md-4 col-lg-3 my-2">
					<a href="product/id.htm" class="text-decoration-none"> <i
						class="fas fa-shopping-cart"></i> <img
						src="https://4menshop.com/cache/image/300x400/images/thumbs/2019/08/ao-vest-nazafu-mau-xam-1139_small-10932.JPG"
						alt="" class="img-fluid"> <img
						src="https://4menshop.com/cache/image/300x400/images/thumbs/2019/08/ao-vest-nazafu-mau-xam-1139_2_small-10932.JPG"
						alt="" class="img-fluid"> <img
						src="https://4menshop.com/cache/image/300x400/images/thumbs/2019/08/ao-vest-nazafu-mau-xam-1139_2_small-10932.JPG"
						alt="" class="my-1" width=20%>
						<div class="promotion"></div>
					</a> <a href=""
						class="link-underline link-underline-opacity-0 link-dark d-block small">Áo
						Vest NAZAFU Màu xám da bò</a>
					<p class="price text-danger fw-semibold small">
						675.000 <span
							class="text-decoration-line-through small text-secondary">1.350.000</span>
					</p>

				</div>
				<div class="col-6 col-md-4 col-lg-3 my-2">
					<a href="" class="text-decoration-none"> <i
						class="fas fa-shopping-cart"></i> <img
						src="https://4menshop.com/cache/image/300x400/images/thumbs/2019/08/ao-vest-nazafu-mau-xam-1139_small-10932.JPG"
						alt="" class="img-fluid"> <img
						src="https://4menshop.com/cache/image/300x400/images/thumbs/2019/08/ao-vest-nazafu-mau-xam-1139_2_small-10932.JPG"
						alt="" class="img-fluid"> <img
						src="https://4menshop.com/cache/image/300x400/images/thumbs/2019/08/ao-vest-nazafu-mau-xam-1139_2_small-10932.JPG"
						alt="" class="my-1" width=20%>
					</a> <a href=""
						class="link-underline link-underline-opacity-0 link-dark d-block small">Áo
						Vest NAZAFU Màu xám da bò</a>
					<p class="price text-danger fw-semibold small">
						675.000 <span
							class="text-decoration-line-through small text-secondary">1.350.000</span>
					</p>

				</div>
				<div class="col-6 col-md-4 col-lg-3 my-2">
					<a href="" class="text-decoration-none"> <i
						class="fas fa-shopping-cart"></i> <img
						src="https://4menshop.com/cache/image/300x400/images/thumbs/2019/08/ao-vest-nazafu-mau-xam-1139_small-10932.JPG"
						alt="" class="img-fluid"> <img
						src="https://4menshop.com/cache/image/300x400/images/thumbs/2019/08/ao-vest-nazafu-mau-xam-1139_2_small-10932.JPG"
						alt="" class="img-fluid"> <img
						src="https://4menshop.com/cache/image/300x400/images/thumbs/2019/08/ao-vest-nazafu-mau-xam-1139_2_small-10932.JPG"
						alt="" class="my-1" width=20%>
					</a> <a href=""
						class="link-underline link-underline-opacity-0 link-dark d-block small">Áo
						Vest NAZAFU Màu xám da bò</a>
					<p class="price text-danger fw-semibold small">
						675.000 <span
							class="text-decoration-line-through small text-secondary">1.350.000</span>
					</p>

				</div>
				<div class="col-6 col-md-4 col-lg-3 my-2">
					<a href="" class="text-decoration-none"> <i
						class="fas fa-shopping-cart"></i> <img
						src="https://4menshop.com/cache/image/300x400/images/thumbs/2019/08/ao-vest-nazafu-mau-xam-1139_small-10932.JPG"
						alt="" class="img-fluid"> <img
						src="https://4menshop.com/cache/image/300x400/images/thumbs/2019/08/ao-vest-nazafu-mau-xam-1139_2_small-10932.JPG"
						alt="" class="img-fluid"> <img
						src="https://4menshop.com/cache/image/300x400/images/thumbs/2019/08/ao-vest-nazafu-mau-xam-1139_2_small-10932.JPG"
						alt="" class="my-1" width=20%>
					</a> <a href=""
						class="link-underline link-underline-opacity-0 link-dark d-block small">Áo
						Vest NAZAFU Màu xám da bò</a>
					<p class="price text-danger fw-semibold small">
						675.000 <span
							class="text-decoration-line-through small text-secondary">1.350.000</span>
					</p>

				</div>
			</div>
		</div>
	</section>

	<!-- Image slide -->
	<section class="slides bg-light">
		<div class="container-xl d-none d-md-block">
			<div class="row justify-content-center">
				<div class="col-3">
					<div class="img-container">
						<img src="resources/images/slides/slide-1-trang-chu-slide-1.jpg"
							alt="" class="img-fluid">
					</div>
				</div>
				<div class="col-6">
					<div class="img-container">
						<img src="resources/images/slides/slide-2-trang-chu-slide-2.jpg"
							alt="" class="img-fluid">
					</div>
				</div>
				<div class="col-3">
					<div class="img-container">
						<img src="resources/images/slides/slide-4-trang-chu-slide-3.jpg"
							alt="" class="img-fluid">
					</div>
				</div>
			</div>
		</div>
	</section>
	<button type="button"
		class="btn btn-danger btn-floating btn-lg rounded-circle"
		id="btn-back-to-top">
		<i class="bi bi-chevron-double-up"></i>
	</button>

	<section id="banchay" class="container-fluid">
		<div class="container-xl">
			<div class="lead fw-bold text-center mb-4">THỜI TRANG BÁN CHẠY</div>
			<div id="owl-demo-2" class="owl-carousel owl-theme">
				<div class="item">
					<div class="slide-item" style="width: 100%; height: 100%">
						<a href=""
							class="text-decoration-none d-flex flex-column align-items-center">
							<img
							src="https://4menshop.com/cache/image/300x400/images/thumbs/2019/08/ao-vest-nazafu-mau-xam-1139_2_small-10932.JPG"
							alt="" class="img-fluid"> <img
							src="https://4menshop.com/cache/image/300x400/images/thumbs/2019/08/ao-vest-nazafu-mau-xam-1139_2_small-10932.JPG"
							alt="" class="my-1" style="width: 20%">
						</a> <a href=""
							class="link-underline link-underline-opacity-0 link-dark d-block small text-center">Áo
							Vest NAZAFU Màu xám da bò </a>
						<p class="price text-danger fw-medium small text-center">
							675.000 <span
								class="text-decoration-line-through small text-secondary">1.350.000</span>
						</p>
					</div>
				</div>
			</div>
		</div>
	</section>

	<%@ include file="../common/footer.jsp"%>
	 <script src="resources/js/commonJS.js"></script>
</body>
</html>