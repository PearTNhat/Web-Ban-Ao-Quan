<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="../../common/header.jsp"%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- Toastr CSS -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css"
	rel="stylesheet">
<!-- Toastr JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
<link rel="stylesheet" href="resources/css/toast.css">
</head>
<body>
	<%@ include file="../../component/topbar.jsp"%>
	<%@ include file="../../component/navbar.jsp"%>

	<div class="page-info bg-light">
		<div class="container-xl text-muted py-3">
			<a href=".htm" class="text-decoration-none text-secondary">4MEN</a> <span>
				/ </span> <a href="products/${typeDetail.typeDetailId}.htm"
				class="text-decoration-none text-secondary">${typeDetail.name}</a> <span>
				/ </span> <a
				href="products/${typeDetailId}/${productColor.productColorId}.htm"
				class="text-decoration-none text-secondary">${productColor.product.name}</a>
		</div>
	</div>

	<div class="container-xl mt-4">
		<div class="row">
			<div class="col-5">
				<div id="owl-product" class="owl-carousel owl-theme">
					<c:forEach var="image" items="${productColor.image}">
						<div class="item" data-hash="zero" style="width: 100%">
							<img src="${image.image}" alt="anh san pham">
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="col-7">
				<section class="border-bottom p-0 pb-4">
					<div class="title fs-5 fw-semibold"
						style="text-transform: uppercase">${productColor.product.name}</div>
					<div class="price mt-3">
						<u class="" style="text-underline-offset: 3px">Giá bán: </u> <span
							class="ms-3 fs-4 text-danger fw-semibold"> <fmt:formatNumber
								value="${productColor.product.price}" type="number"
								groupingUsed="true" />
						</span>
					</div>
					<div class="another-color my-3">MÀU KHÁC*</div>
					<div class="d-flex flex-wrap gap-1">
						<c:forEach var="productColorItem"
							items="${productColor.product.productDetail}">
							<a
								href="products/${typeDetail.typeDetailId}/${productColorItem.productColorId}.htm"
								style="width: 100px"><img
								src="${productColorItem.image.get(0).image}" class="img-fluid"
								alt="">
							</a>
						</c:forEach>
					</div>
					<div>Mô tả sản phẩm:</div>
					<div class="desc text-muted">${productColor.product.description}</div>
				</section>
				<section class="p-4">
					<form:form action="products/add-to-cart.htm" method="post"
						modelAttribute="cartB">
						<div class="row">
							<div class="col col-6">
								<div>
									SIZE* <span class="fst-italic fw-semibold text-danger">Hướng
										dẫn chọn size</span>
								</div>
								<form:input type="hidden" value="${productColorId}"
									path="productColorId" />
								<form:input type="hidden" value="${typeDetailId}"
									path="typeDetailId" />
								<form:select class="form-select form-select-md my-2"
									path="sizeId" aria-label="Large select example">
									<c:forEach var="size" items="${listSize}">
										<option selected value="${size.sizeId }">${size.name}</option>
									</c:forEach>
								</form:select>
								<button class="btn btn-danger w-100 mt-2">
									<i class="bi bi-cart-fill"></i> Đăng ký mua
								</button>
							</div>
							<div class="col col-6">
								<div>SỐ LƯỢNG*</div>
								<form:select class="form-select form-select-md my-2 mb-4"
									aria-label="Large select example" path="quantity">
									<option selected value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
									<option value="9">9</option>
									<option value="10">10</option>
								</form:select>
								<button name="addToCart" style="text-decoration: none"
									class="link link-danger fw-bold">+ Thêm vào giỏ hàng</button>
							</div>
						</div>
					</form:form>
				</section>
			</div>
		</div>
		<div class="row mt-1">
			<div class="col-5 thumbnails">
				<c:forEach var="image" items="${productDetail.image}">
					<a href="#zero"><img src="${image.image}" alt=""></a>
				</c:forEach>
			</div>
		</div>
	</div>

	<%@ include file="../../common/footer.jsp"%>
	<%@ include file="../../utils/toast.jsp"%>
	<script>
		$(document).ready(function() {

			$('#owl-product').owlCarousel({
				items : 1,
				lazyLoad : true,
				loop : false,
				dots : false,
				margin : 0,
				URLhashListener : true,
				autoplayHoverPause : true,
				startPosition : 'URLHash'
			});

		});
	</script>
</body>
</html>