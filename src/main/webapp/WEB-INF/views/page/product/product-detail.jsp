<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../../common/header.jsp"%>
<body>
	<%@ include file="../../component/topbar.jsp"%>
	<%@ include file="../../component/navbar.jsp"%>

	<div class="page-info bg-light">
		<div class="container-xl text-muted py-3">
			<a href=".htm" class="text-decoration-none text-secondary">4MEN</a> <span>
				/ </span> <a href="products/${typeDetail.typeDetailId}.htm" class="text-decoration-none text-secondary">${typeDetail.name}</a> <span> / </span> <a href="products/${typeDetailId}/${productDetail.productDetailId}.htm"
				class="text-decoration-none text-secondary">${productDetail.product.name}</a>
		</div>
	</div>

	<div class="container-xl mt-4">
		<div class="row">
			<div class="col-5">
				<div id="owl-product" class="owl-carousel owl-theme">
					<c:forEach var="image" items="${productDetail.image}">
                		<div class="item" data-hash="zero" style="width: 100%">
						<img
							src="${image.image}"
							alt="anh san pham">
						</div>
                	</c:forEach>
				</div>
			</div>
			<div class="col-7">
				<section class="border-bottom p-0 pb-4">
					<div class="title fs-5 fw-semibold"
						style="text-transform: uppercase">${productDetail.product.name}</div>
					<div class="price mt-3">
							<u class="" style="text-underline-offset: 3px">Giá bán: </u> 
							<span class="ms-3 fs-4 text-danger fw-semibold">
							    <fmt:formatNumber value="${productDetail.product.price}" type="number" groupingUsed="true" />đ
							</span>
					</div>
					<div class="another-color my-3">MÀU KHÁC*</div>
					<div class="d-flex flex-wrap gap-1">
						<c:forEach var="productDetailItem" items="${productDetail.product.productDetail}">
							<a href="products/${typeDetail.typeDetailId}/${productDetailItem.productDetailId}.htm" style="width: 100px"><img
								src="${productDetailItem.image[0].image}"
								class="img-fluid" alt=""></a>					
                		</c:forEach>
					</div>
					<div>Mô tả sản phẩm:</div>
					<div class="desc text-muted">${productDetail.product.description}</div>
				</section>
				<section class="p-4">
					<form action="">
						<div class="row">
							<div class="col col-6">
								<div>
									SIZE* <span class="fst-italic fw-semibold text-danger">Hướng
										dẫn chọn size</span>
								</div>
								<select class="form-select form-select-md my-2"
									aria-label="Large select example">
									<c:forEach var="size" items="${listSize}">
										<option selected>${size.name}</option>									
                					</c:forEach>
								</select>
								<button class="btn btn-danger w-100 mt-2">
									<i class="bi bi-cart-fill"></i> Đăng ký mua
								</button>
							</div>
							<div class="col col-6">
								<div>SỐ LƯỢNG*</div>
								<select class="form-select form-select-md my-2 mb-4"
									aria-label="Large select example">
									<option selected>1</option>
									<option value="1">2</option>
									<option value="2">3</option>
									<option value="3">4</option>
									<option value="3">5</option>
									<option value="3">6</option>
									<option value="3">7</option>
									<option value="3">8</option>
									<option value="3">8</option>
									<option value="3">9</option>
									<option value="3">10</option>
								</select> <a href="#" style="text-decoration: none"
									class="link link-danger fw-bold">+ Thêm vào giỏ hàng</a>
							</div>
						</div>
					</form>
				</section>
			</div>
		</div>
		<div class="row mt-1">
			<div class="col-5 thumbnails">
				<c:forEach var="image" items="${productDetail.image}">
					<a href="#zero"><img
					src="${image.image}"
					alt=""></a> 
                </c:forEach>
			</div>
		</div>
	</div>

	<%@ include file="../../common/footer.jsp"%>
	<script>
		$('#owl-product').owlCarousel({
			items: 1,
			lazyLoad: true,
			loop: false,
			dots: false,
			margin: 0,
			URLhashListener: true,
			autoplayHoverPause: true,
			startPosition: 'URLHash'
		});
	</script>
	</body>
</html>