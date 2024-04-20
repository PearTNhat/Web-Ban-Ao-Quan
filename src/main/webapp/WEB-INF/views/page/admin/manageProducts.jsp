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

</head>
<%@ include file="../../common/admin/adminSideBar.jsp"%>
<div class="container-xl">
	<div class="table-responsive">
		<div class="table-wrapper position-md-relative">
			<div class="table-title">
				<div class="row">
					<div class="col-5">
						<h2 class="text-left">Quản lí sản phẩm</h2>
					</div>
					<div class="col-7">
						<div class="d-flex align-items-center justify-content-end ">
							<div class="search-box d-flex align-items-center">
								<i class="material-icons">&#xE8B6;</i> <input type="text"
									class="form-control" placeholder="Search admin&hellip; ">
							</div>
							<a href="handle-product.htm" class="btn btn-success"><i
								class="material-icons">&#xE147;</i> <span>Add</span></a>
						</div>
					</div>

				</div>
			</div>
		</div>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>#</th>
					<th>Name</th>
					<th>Size</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>Giảm giá</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td><a href="#"><img
							src="https://4menshop.com/cache/image/300x400/images/thumbs/2024/03/tui-canvas-den-phoi-trang-tx017-18422.jpg"
							class="avatar" alt="Avatar">Túi xách siêu đẹp</a></td>
					<td>XL</td>
					<td>10</td>
					<td>300.000</td>
					<td>70%</td>
					<td>
						<div class="d-flex">
							<a href="./addProduct/addProduct.html" class="edit"><i
								class="material-icons" title="Edit">&#xE254;</i></a> <a href="">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-three-dots"
									viewBox="0 0 16 16">
                    <path
										d="M3 9.5a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3m5 0a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3m5 0a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3" />
                  </svg>
							</a> <a href="#deleteEmployeeModal" class="delete"><i
								class="material-icons" title="Delete">&#xE872;</i></a>

						</div>
					</td>
				</tr>
			</tbody>
		</table>
		<!-- pagination -->
		<div class="clearfix">
			<div class="hint-text">
				Showing <b>5</b> out of <b>25</b> entries
			</div>
			<ul class="pagination">
				<li class="page-item disabled"><a href="#">Previous</a></li>
				<li class="page-item"><a href="#" class="page-link">1</a></li>
				<li class="page-item"><a href="#" class="page-link">2</a></li>
				<li class="page-item active"><a href="#" class="page-link">3</a></li>
				<li class="page-item"><a href="#" class="page-link">4</a></li>
				<li class="page-item"><a href="#" class="page-link">5</a></li>
				<li class="page-item"><a href="#" class="page-link">Next</a></li>
			</ul>
		</div>
	</div>

</div>


</div>

</body>
</html>