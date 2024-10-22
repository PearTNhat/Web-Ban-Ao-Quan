<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/header.jsp"%>
<style>
/* pagination */
.pagination {
	gap: 10px;
}

.pagination li a {
	color: #333;
}

.page-link:hover {
	background-color: rgb(179, 31, 42);
	box-shadow: none;
}

.page-link:hover:not(.page-active) {
	color: #23527c;
	background-color: #eee;
	border-bottom: 1px solid #666;
}

.page-link:focus {
	box-shadow: none;
}

.page-active {
	background-color: rgb(179, 31, 42);
	color: #fff !important;
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
<body>
	<%@ include file="../../component/topbar.jsp"%>
	<%@ include file="../../component/navbar.jsp"%>

	<div class="page-info bg-light">
		<div class="container-xl text-muted py-3">
			<a href=".htm" class="text-decoration-none text-secondary">4MEN</a> <span>
				/ </span> <a href="profile/info.htm"
				class="text-decoration-none text-secondary">Profile</a> <span>
				/ </span> <a href="profile/order.htm"
				class="text-decoration-none text-secondary">Order</a>
		</div>
	</div>

	<div class="container-lg my-4">
		<div class="row">
			<!-- Sidebar -->
			<%@ include file="../profile/component/sidebar.jsp"%>

			<div class="col-12 col-md-9">
				<div class="fs-3 border-bottom pb-2">Đơn hàng đã đặt</div>
				<div class="table-responsive my-4">
					<table class="table">
						<thead class="table-success">

							<tr>
								<th scope="col">#</th>
								<th scope="col">Ngày mua</th>
								<th scope="col">Sản phẩm</th>
								<th scope="col">Tổng tiền</th>
								<th scope="col">Trạng thái</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="p" items="${pst}" varStatus="status">
								<tr>
									<th scope="row"><i class="bi bi-info-circle"></i></th>
									<td>03-06-2023 12:02</td>
									<td>
										<ul class="">
											<li class="">Áo sơ-mi nam phong cách</li>
											<li class="">Áo sơ-mi nam phong cách</li>
											<li class="">Áo sơ-mi nam phong cách</li>
										</ul>
									</td>
									<td>985.000đ</td>
									<td>
										<button class="btn btn-sm btn-success fw-bold">Đã
											giao</button>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<nav class="d-flex justify-content-center border-top py-4"
						aria-label="Page navigation">
						<ul class="pagination">
							<li class="page-item"><a
								class="page-link ${page eq 1 ? 'disabled' : ''}"
								href="products/${typeId}.htm?page=${page-1}"
								aria-label="Previous"> <span> &laquo; </span>
							</a></li>
							<c:forEach begin="1" end="${pages}" varStatus="s">
								<li class="page-item"><a
									class="page-link ${s.index == page ? 'page-active' : ''}"
									href="products/${typeId}.htm?page=${s.index}">${s.index}</a></li>
							</c:forEach>
							<li class="page-item"><a
								class="page-link ${page eq pages ? 'disabled' : ''}"
								href="products/${typeId}.htm?page=${page+1}" aria-label="Next">
									&raquo; </a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../../common/footer.jsp"%>