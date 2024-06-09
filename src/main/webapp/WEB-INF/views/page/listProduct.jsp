<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<link rel="stylesheet" href="resources/css/imge-cart.css">
<link rel="stylesheet" href="resources/css/listProduct.css">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<style>
/*  not foubd */
.not-found {
	font-size: 30px;
	text-align: center;
	display: flex;
	justify-content: center;
	align-items: center;
	flex-basis: 100%;
}
</style>
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
			<c:if test="${not empty pst}">
				<div class="col-12 page-title">
					<h3 class="text-center text-md-start">${pst.get(0).type.name}</h3>
					<p>
						<strong>${pst.get(0).type.name} </strong>${pst.get(0).type.desc}
					</p>
				</div>
				<div class="col-md-8">
					<div class="row">
						<c:forEach var="p" items="${pst}" varStatus="status">
							<c:if test="${not empty p.productDetail}">
								<div class="col-lg-4 col-6 ">
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
												<c:if
													test="${pds[i.index].productColorId != pds[i.index +1 ].productColorId}">
													<div class="sub-image">
														<img src="${pd.image[0].image}" alt="" />
													</div>
												</c:if>
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
						<nav class="d-flex justify-content-center border-top py-4"
							aria-label="Page navigation">
							<ul class="pagination">
								<li class="page-item"><a class="page-link" href="products/${typeId}.htm?page=${page-1}"
									aria-label="Previous"> <span> &laquo; </span>
								</a></li>
								<c:forEach begin="1" end="${pages}" varStatus="s">
									<li class="page-item"><a
										class="page-link ${s.index == page ? 'page-active' : ''}"
										href="products/${typeId}.htm?page=${s.index}">${s.index}</a></li>
								</c:forEach>
								<li class="page-item"><a class="page-link" href="products/${typeId}.htm?page=${page+1}"
									aria-label="Next"> &raquo; </a></li>
							</ul>
						</nav>
					</div>
				</div>
			</c:if>
			<c:if test="${empty pst}">
				<div class="col-md-8">
					<div class="not-found">Không tồn tại sản phẩm thuộc loại này</div>
				</div>
			</c:if>
			<div class="col-md-4 side-widget">
				<h5>
					<span>SẢN PHẨM HOT</span>
				</h5>
				<div class="row">
					<div class="col-12">
						<c:forEach var="p" items="${hotProduct}" varStatus="status">
							<c:if test="${not empty p.productDetail}">
								<div class="row g-0 mb-2">
									<c:set var="pds" value="${p.productDetail}" />
									<div class="col-4 side-pic">
										<a href="#" class=""> <img class="w-100"
											src="${pds[0].image[0].image}" alt="${p.name}" />
										</a>
									</div>
									<div class="col-8 price-widget"
										style="display: flex; flex-direction: column; justify-content: space-around;">
										<p class="mb-0 d-block large " style="font-size: 14px;">${p.name}</p>
										<c:set var="pPrice" value="${p.price/1000.0}" />
										<p class="price text-danger fw-semibold "
											style="margin: 0; font-size: 13px;">

											<fmt:formatNumber value="${pPrice-(pPrice * p.discount)}"
												type="number" pattern="#,##0.000" />
											<span
												class="text-decoration-line-through small text-secondary price-second"
												style="font-size: 11px;"> <fmt:formatNumber
													value="${pPrice}" type="number" pattern="#,##0.000" />
											</span> <span class="discount">-<fmt:formatNumber
													value="${p.discount}" type="percent" /></span>
										</p>
									</div>
								</div>
							</c:if>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../common/footer.jsp"%>
</body>
</html>