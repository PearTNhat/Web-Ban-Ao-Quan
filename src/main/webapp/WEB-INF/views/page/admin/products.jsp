<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/admin/adminHeader.jsp"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="resources/css/admin/mangageProducts.css">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
</head>
<%@ include file="../../common/admin/adminSideBar.jsp"%>
<div class="main">
	<nav class="navbar bg-white">
	  <div class="container-fluid">
	    <div class="navbar-brand ms-4">
	      <div class="fs-5">
	      	<span class="text-secondary">
	      		<i class="bi bi-box"></i>
	      		Products /
	      	</span>
	      	<a href="admin/products.htm">Products view</a>
	      </div>
	    </div>
	  </div>
	</nav>
	<div class="container-xl overflow-auto">
	<div class="table-responsive">
		<div class="table-wrapper position-md-relative">
			<div class="table-title">
				<div class="row">
					<div class="col-5">
						<h2 class="text-left">Quản lí sản phẩm</h2>
					</div>
					<div class="col-7">
						<div class="d-flex align-items-center justify-content-end ">
							
							<form action="admin/products.htm">
								<div class="search-box d-flex align-items-center">
									<i class="material-icons">&#xE8B6;</i> <input name="search" value="${search}" type="text"
										class="form-control" id="search-input" placeholder="Tìm kiếm tên sản phẩm&hellip; ">
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
							<th>Name</th>
							<th>Quantity</th>
							<th>Price</th>
							<th>Giảm giá</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="p" items="${products }" varStatus="s">
							<tr>
								<td>${(page-1)*limit + s.index+1}</td>
								<td><a href="#"><img
										src="https://4menshop.com/cache/image/300x400/images/thumbs/2024/03/tui-canvas-den-phoi-trang-tx017-18422.jpg"
										class="avatar" alt="Avatar">${p.name}</a></td>

								<td>123</td>
								<td><fmt:formatNumber value="999" type="currency" /></td>

								<td><fmt:formatNumber value="${ p.discount}" type="percent" /></td>
								<td>
									<div class="d-flex">
										<a href="./addProduct/addProduct.html" class="edit"><i
											class="material-icons" title="Edit">&#xE254;</i></a> <a href="">
											<svg xmlns="http://www.w3.org/2000/svg" width="16"
												height="16" fill="currentColor" class="bi bi-three-dots"
												viewBox="0 0 16 16">
                    <path
													d="M3 9.5a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3m5 0a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3m5 0a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3" />
                  </svg>
										</a> <a href="#l" class="delete"><i
											class="material-icons" title="Delete">&#xE872;</i></a>

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
								<li class="page-item"><a class="page-link ${page eq 1 ? 'disabled' : ''}" href="admin/products.htm?page=${page - 1}"
									aria-label="Previous"> <span> &laquo; </span>
								</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link ${page eq 1 ? 'disabled' : ''}" href="admin/products.htm?page=${page - 1}&search=${search}"
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
								<li class="page-item"><a class="page-link ${page eq totalPage ? 'disabled' : ''}" href="admin/products.htm?page=${page + 1}"
									aria-label="Next"> &raquo; </a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link ${page eq totalPage ? 'disabled' : ''}" href="admin/products.htm?page=${page + 1}&search=${search}"
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
</body>
</html>