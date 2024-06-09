<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<link rel="stylesheet" href="resources/css/home/home.css">
<link rel="stylesheet" href="resources/css/imge-cart.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
</head>

<body>
	<%@ include file="../component/topbar.jsp"%>
	<%@ include file="../component/navbar.jsp"%>

	<%@ include file="../component/banner.jsp"%>

	<!-- Hot items -->
	<section class="hot-items">
		<div class="container-xl text-center">
			<div class="lead fw-bold">THỜI TRANG BÁN CHẠY NHẤT</div>
			<div class="row">
				<c:forEach var="p" items="${hotProduct}" varStatus="status">
					<c:if test="${not empty p.productDetail}">
						<c:set var="pds" value="${p.productDetail}" />
						<div class="col-lg-3 col-md-4 col-6 ">
							<a href="products/${typeId}/${pds[0].productColorId}.htm"
								class="text-decoration-none">
								<div class="main-image">
									<i class="fas fa-shopping-cart cart-product"></i> <img
										src="${pds[0].image[0].image}" alt="${p.name}"
										class="img-fluid img-1" /> <img
										src="${pds[0].image[1] == null ? pds[0].image[0].image:pds[0].image[1].image}"
										alt="${p.name}" class="img-fluid img-2" />
								</div>
								<div class="d-flex justify-content-center">
									<c:forEach var="pd" items="${pds}" varStatus="i">
										<div class="sub-image">
											<img src="${pd.image[0].image}" alt="" />
										</div>
									</c:forEach>
								</div>
							</a>
							<p class="mb-0 d-block large text-center"
								style="font-size: 20px;">${p.name}</p>
							<c:set var="pPrice" value="${p.price/1000.0}" />
							<p class="price text-danger fw-semibold small text-center">

								<fmt:formatNumber value="${pPrice-(pPrice * p.discount)}"
									type="number" pattern="#,##0.000" />
								<span
									class="text-decoration-line-through small text-secondary price-second">
									<fmt:formatNumber value="${pPrice}" type="number"
										pattern="#,##0.000" />
								</span> <span class="discount">-<fmt:formatNumber
										value="${p.discount}" type="percent" /></span>
							</p>
						</div>
					</c:if>
				</c:forEach>
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
			<div class="lead fw-bold text-center mb-4">HÀNG MỚI VỀ</div>
			<div class="row">
				<c:forEach var="p" items="${newProduct}" varStatus="status">
					<c:if test="${not empty p.productDetail}">
						<div class="col-lg-3 col-md-4 col-6 ">
							<c:set var="pds" value="${p.productDetail}" />
							<a href="products/${typeId}/${pds[0].productColorId}.htm"
								class="text-decoration-none">
								<div class="main-image">
									<i class="fas fa-shopping-cart cart-product"></i> <img
										src="${pds[0].image[0].image}" alt="${p.name}"
										class="img-fluid img-1" /> <img
										src="${pds[0].image[1] == null ? pds[0].image[0].image:pds[0].image[1].image}"
										alt="${p.name}" class="img-fluid img-2" />
								</div>
								<div class="d-flex justify-content-center">
									<c:forEach var="pd" items="${pds}" varStatus="i">
										<%-- <c:if
											test="${pds[i.index].productColorId != pds[i.index +1 ].productColorId}"> --%>
										<div class="sub-image">
											<img src="${pd.image[0].image}" alt="" />
										</div>
										<%-- 	</c:if> --%>
									</c:forEach>
								</div>
							</a>
							<p class="mb-0 d-block large text-center"
								style="font-size: 20px;">${p.name}</p>
							<c:set var="pPrice" value="${p.price/1000.0}" />
							<p class="price text-danger fw-semibold small text-center">

								<fmt:formatNumber value="${pPrice-(pPrice * p.discount)}"
									type="number" pattern="#,##0.000" />
								<span
									class="text-decoration-line-through small text-secondary price-second">
									<fmt:formatNumber value="${pPrice}" type="number"
										pattern="#,##0.000" />
								</span> <span class="discount">-<fmt:formatNumber
										value="${p.discount}" type="percent" /></span>
							</p>
						</div>
					</c:if>
				</c:forEach>
			</div>
		</div>
		</div>
	</section>

	<%@ include file="../common/footer.jsp"%>
	<script>
		let mybutton = document.getElementById("btn-back-to-top");

		if (mybutton) {
			// When the user scrolls down 20px from the top of the document, show the button
			window.onscroll = function() {
				scrollFunction();
			};

			function scrollFunction() {
				if (document.body.scrollTop > 300
						|| document.documentElement.scrollTop > 300) {
					mybutton.style.opacity = 1;
				} else {
					mybutton.style.opacity = 0;
				}
			}
			// When the user clicks on the button, scroll to the top of the document
			mybutton.addEventListener("click", backToTop);

			function backToTop() {
				document.body.scrollTop = 0;
				document.documentElement.scrollTop = 0;
			}
		}

		// Carousel
		$('#owl-demo-1').owlCarousel({
			items : 1,
			lazyLoad : true,
			loop : true,
			margin : 0,
			dots : false,
			autoplay : true, // Enable autoplay
			autoplayTimeout : 10000, // Time between slide transitions (in milliseconds)
			animateOut : 'fadeOut',
			onInitialized : startProgressBar,
			onTranslate : resetProgressBar,
			onTranslated : startProgressBar
		});

		function startProgressBar() {
			// apply keyframe animation
			$(".slide-progress").css({
				width : "100%",
				transition : "width 10000ms"
			});
		}

		function resetProgressBar() {
			$(".slide-progress").css({
				width : 0,
				transition : "width 0s"
			});
		}
		//Init progressBar where elem is $("#owl-demo")
		function progressBar(elem) {
			$elem = elem;
			//build progress bar elements
			buildProgressBar();
			//start counting
			start();
		}
	</script>
</body>
</html>