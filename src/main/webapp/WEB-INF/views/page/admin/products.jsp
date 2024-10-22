<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/admin/adminHeader.jsp"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<!-- Toast -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css"
	rel="stylesheet">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
<link rel="stylesheet" href="resources/css/toast.css">
<!--  -->
<link rel="stylesheet" href="resources/css/admin/mangageProducts.css">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

</head>
<%@ include file="../../common/admin/adminSideBar.jsp"%>
<div class="main" style="overflow: auto;">
	<nav class="navbar bg-white">
		<div class="container-fluid d-flex justify-content-between">
			<div class="navbar-brand ms-4">
				<div class="fs-5">
					<span class="text-secondary"> <i class="bi bi-box"></i>
						Products /
					</span> <a href="admin/products.htm">Products view</a>
				</div>
			</div>
			<div class="me-3">
				Xin chào, <span class="fw-bold">${user.lastName}</span>
			</div>
		</div>
	</nav>
	<div class="container-xl overflow-auto">
		<div class="table-responsive">
			<div class="table-wrapper position-md-relative">
				<div class="table-title">
					<div class="row">
						<c:choose>
							<c:when test="${deleteSuccess}">
								<div class="alert alert-success alert-dismissible fade show"
									role="alert">
									Xóa sản phẩm thành công!
									<button type="button" class="btn-close" data-bs-dismiss="alert"
										aria-label="Close"></button>

								</div>
							</c:when>
							<c:when test="${deleteError}">
								<div class="alert alert-danger alert-dismissible fade show"
									role="alert">
									Xóa sản phẩm thất bại, vui lòng kiểm tra lại sản phẩm!
									<button type="button" class="btn-close" data-bs-dismiss="alert"
										aria-label="Close"></button>

								</div>
							</c:when>
							<c:when test="${cannotDelete}">
								<div class="alert alert-warning alert-dismissible fade show"
									role="alert">
									Không thể xóa sản phẩm đã có chi tiết!
									<button type="button" class="btn-close" data-bs-dismiss="alert"
										aria-label="Close"></button>

								</div>
							</c:when>
						</c:choose>
						<div class="col-5">
							<h2 class="text-left">Quản lí sản phẩm</h2>
						</div>
						<div class="col-7">
							<div class="d-flex align-items-center justify-content-end ">

								<form action="admin/products.htm" style="display: flex;">
									<div class="search-box d-flex align-items-center">
										<i class="material-icons">&#xE8B6;</i> <input name="search"
											value="${search}" type="text" class="form-control"
											id="search-input"
											placeholder="Tìm kiếm tên sản phẩm&hellip; ">
									</div>
									<button type="submit" class="btn btn-success" id="search">Search</button>
								</form>
							</div>
						</div>

					</div>
				</div>
			</div>
			<c:choose>
				<c:when test="${products.size() == 0}">
					<div class="not-found">Không tồn tại tài khoản nào</div>
				</c:when>

				<c:otherwise>
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<th>#</th>
								<th>Tên sản phẩm</th>
								<th>Giá</th>
								<th>Giảm giá</th>
								<th>Số lượng đã bán</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="p" items="${products }" varStatus="s">
								<tr>
									<td>${(page-1)*limit + s.index+1}</td>
									<td><a href="admin/products/${p.productId}.htm"> <c:set
												var="firstImage" value="true" /> <c:forEach var="pd"
												items="${p.productDetail}">
												<c:forEach var="img" items="${pd.image}">
													<c:if test="${firstImage}">
														<img src="${img.image}" class="avatar" alt="Avatar" />
														<c:set var="firstImage" value="false" />
													</c:if>
												</c:forEach>
											</c:forEach> ${p.name}
									</a></td>

									<td><fmt:formatNumber value="${p.price}" type="number"
											groupingUsed="true" maxFractionDigits="0"
											minFractionDigits="0" />đ</td>
									<td><fmt:formatNumber value="${p.discount}" type="percent" /></td>
									<td>${p.soldQuantity}</td>
									<td>
										<div class="d-flex">
											<a href="admin/products/edit-product/${p.productId }.htm"
												class="edit"><i class="material-icons" title="Edit">&#xE254;</i></a>
											<a
												href="admin/products/add-product-detail/${p.productId }.htm">
												<svg xmlns="http://www.w3.org/2000/svg" width="16"
													height="16" fill="currentColor" class="bi bi-plus-circle"
													viewBox="0 0 16 16">
											  <path
														d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16" />
											  <path
														d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4" />
											</svg>

											</a> <a href="admin/products/delete/${p.productId}.htm"
												class="delete"><i class="material-icons" title="Delete">&#xE872;</i></a>

										</div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<nav class="d-flex justify-content-center border-top py-4"
						aria-label="Page navigation">
						<ul class="pagination">
							<c:choose>
								<c:when test="${empty search}">
									<li class="page-item"><a
										class="page-link ${page eq 1 ? 'disabled' : ''}"
										href="admin/products.htm?page=${page - 1}"
										aria-label="Previous"> <span> &laquo; </span>
									</a></li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a
										class="page-link ${page eq 1 ? 'disabled' : ''}"
										href="admin/products.htm?page=${page - 1}&search=${search}"
										aria-label="Previous"> <span> &laquo; </span>
									</a></li>
								</c:otherwise>
							</c:choose>
							<c:forEach begin="1" end="${totalPage}" varStatus="s">
								<c:choose>
									<c:when test="${empty search}">
										<li class="page-item"><a
											class="page-link ${s.index == page ? 'page-active' : ''}"
											href="admin/products.htm?page=${s.index}">${s.index}</a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a
											class="page-link ${s.index == page ? 'page-active' : ''}"
											href="admin/products.htm?page=${s.index}&search=${search}">${s.index}</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:choose>
								<c:when test="${empty search}">
									<li class="page-item"><a
										class="page-link ${page eq totalPage ? 'disabled' : ''}"
										href="admin/products.htm?page=${page + 1}" aria-label="Next">
											&raquo; </a></li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a
										class="page-link ${page eq totalPage ? 'disabled' : ''}"
										href="admin/products.htm?page=${page + 1}&search=${search}"
										aria-label="Next"> &raquo; </a></li>
								</c:otherwise>
							</c:choose>
						</ul>
					</nav>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>
</div>
<script src="resources/js/adminLayout.js"></script>
<%@ include file="../../utils/toast.jsp"%></body>
</html>