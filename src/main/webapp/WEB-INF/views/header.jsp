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
	<link rel="stylesheet"
		href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous" defer></script>
		
	<!-- Owl carousel -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css"
        integrity="sha512-tS3S5qG0BlhnQROyJXvNjeEM4UpMXHrQfTGmbQ1gKmelCxlSEBUaxhRBj/EFTzpbP4RVSrpEikbmdJobCvhE3g=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.theme.default.min.css"
        integrity="sha512-sMXtMNL1zRzolHYKEujM2AqCLUR9F2C4/05cdbxjjLSRvMQIciEPCQZo++nk7go3BtSuK9kfa/s+a4f4i5pLkw=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
	<title>Web ban hang</title>
	
	<style>
		section {
			padding: 60px 0;
		}
		#owl-demo .item img{
		  display: block;
		  width: 100%;
		  height: auto;
		  text-align:center;
		}
		
		.slide-progress {
		  width: 0;
		  max-width: 100%;
		  height: 4px;
		  background: rgba(0, 0, 0, .2);
		}
	</style>
</head>

<body>
	<nav class="navbar sticky-top navbar-expand-lg navbar-light container-fluid bg-white">
		<div class="container-xl">
			<a class="navbar-brand" href="#"> <img
				src="https://4menshop.com/logo.png?v=1" alt="Logo" width="90"
				height="60" class="d-inline-block align-text-top">
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse justify-content-end me-5"
				id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="#">HÀNG BÁN
							CHẠY</a></li>
					<li class="nav-item"><a class="nav-link" href="#">ÁO NAM</a></li>
					<li class="nav-item"><a class="nav-link" href="#">QUẦN NAM</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="page-info bg-light">
		<div class="container-xl text-muted py-3">
			<a href="#" class="text-decoration-none text-secondary">4MENS</a> <span>
				/ </span> <a href="#" class="text-decoration-none text-secondary">Áo
				nam</a>
		</div>
	</div>
	
	<div class="container-fuild">
		<div class="slide-progress"></div>
		<div id="owl-demo" class="owl-carousel owl-theme">
	        <div class="item" style="width:100%">
	            <img src="resources/images/banners/banner-top-trang-chu-1-slide-19.jpg" alt="banner1">
	        </div>
	        <div class="item" style="width:100%">
	            <img src="resources/images/banners/banner-top-trang-chu-2-slide-20.jpg" alt="banner2">
	        </div>
	    </div>
	</div>
	
	<!-- Hot items -->
    <section class="hot-items">
        <div class="container-xl text-center">
            <div class="lead fw-bold">THỜI TRANG HOT NHẤT</div>
            <div class="row">
                <div class="col-6 col-md-4 col-lg-3 my-2">
                    <a href="" class="text-decoration-none">
                        <img src="https://4menshop.com/cache/image/300x400/images/thumbs/2019/08/ao-vest-nazafu-mau-xam-1139_2_small-10932.JPG"
                            alt="" class="img-fluid">
                        <img src="https://4menshop.com/cache/image/300x400/images/thumbs/2019/08/ao-vest-nazafu-mau-xam-1139_2_small-10932.JPG"
                            alt="" class="my-1" width=28%>
                    </a>
                    <a href="" class="link-underline link-underline-opacity-0 link-dark d-block small">Áo Vest NAZAFU
                        Màu xám
                        da bò</a>
                    <p class="price text-danger fw-medium small">675.000
                        <span class="text-decoration-line-through small text-secondary">1.350.000</span>
                    </p>

                </div>
                <div class="col-6 col-md-4 col-lg-3 my-2">
                    <a href="" class="text-decoration-none">
                        <img src="https://4menshop.com/cache/image/300x400/images/thumbs/2019/08/ao-vest-nazafu-mau-xam-1139_2_small-10932.JPG"
                            alt="" class="img-fluid">
                        <img src="https://4menshop.com/cache/image/300x400/images/thumbs/2019/08/ao-vest-nazafu-mau-xam-1139_2_small-10932.JPG"
                            alt="" class="my-1" width=28%>
                    </a>
                    <a href="" class="link-underline link-underline-opacity-0 link-dark d-block small">Áo Vest NAZAFU
                        Màu xám
                        da bò</a>
                    <p class="price text-danger fw-medium small">675.000
                        <span class="text-decoration-line-through small text-secondary">1.350.000</span>
                    </p>

                </div>
                <div class="col-6 col-md-4 col-lg-3 my-2">
                    <a href="" class="text-decoration-none">
                        <img src="https://4menshop.com/cache/image/300x400/images/thumbs/2019/08/ao-vest-nazafu-mau-xam-1139_2_small-10932.JPG"
                            alt="" class="img-fluid">
                        <img src="https://4menshop.com/cache/image/300x400/images/thumbs/2019/08/ao-vest-nazafu-mau-xam-1139_2_small-10932.JPG"
                            alt="" class="my-1" width=28%>
                    </a>
                    <a href="" class="link-underline link-underline-opacity-0 link-dark d-block small">Áo Vest NAZAFU
                        Màu xám
                        da bò</a>
                    <p class="price text-danger fw-medium small">675.000
                        <span class="text-decoration-line-through small text-secondary">1.350.000</span>
                    </p>

                </div>
                <div class="col-6 col-md-4 col-lg-3 my-2">
                    <a href="" class="text-decoration-none">
                        <img src="https://4menshop.com/cache/image/300x400/images/thumbs/2019/08/ao-vest-nazafu-mau-xam-1139_2_small-10932.JPG"
                            alt="" class="img-fluid">
                        <img src="https://4menshop.com/cache/image/300x400/images/thumbs/2019/08/ao-vest-nazafu-mau-xam-1139_2_small-10932.JPG"
                            alt="" class="my-1" width=28%>
                    </a>
                    <a href="" class="link-underline link-underline-opacity-0 link-dark d-block small">Áo Vest NAZAFU
                        Màu xám
                        da bò</a>
                    <p class="price text-danger fw-medium small">675.000
                        <span class="text-decoration-line-through small text-secondary">1.350.000</span>
                    </p>

                </div>
            </div>
        </div>
    </section>