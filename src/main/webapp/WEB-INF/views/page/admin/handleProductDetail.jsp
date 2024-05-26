<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../../common/admin/adminHeader.jsp"%>

<link rel="stylesheet" href="resources/css/admin/handleProduct.css">
<style>
form {
	width: 80%;
}
</style>
</head>
<%@ include file="../../common/admin/adminSideBar.jsp"%>

<div class="main" style="overflow: auto !important">
	<nav class="navbar sticky-top bg-white">
		<div class="container-fluid">
			<div class="navbar-brand ms-4 ">
				<div class="fs-5">
					<span> <a href="admin/products.htm" class="link-secondary">
							<i class="bi bi-box"></i> Products /
					</a>
					</span> <a href="admin/handle-product.htm">Add product</a>
				</div>
			</div>
		</div>
	</nav>
	<div class="f-container mt-4 ">
		<div class="f-container" style="flex: 1; overflow: auto">
			<form>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-12 col-sm-6 col-md-4 col-xl-3 imgUp ">
							<div class="img-wrapper">
								<div class="imagePreview"></div>
								<label class="btn btn-primary"> <i class="bi bi-upload"></i>
									<input type="file" class="uploadFile img" value="Upload Photo"
									style="width: 0px; height: 0px; overflow: hidden;" />
								</label>
							</div>
						</div>
						<!-- col-2 -->
						<i class="bi bi-plus imgAdd"></i>
					</div>
					<!-- row -->
				</div>

				<div class="mb-3 text-center">
					<span>Tên: </span> <span>Some thing</span>
				</div>
				<div class="mb-3  d-flex gap-4 justify-content-center">
					<div>
						<label for="quantity" class="form-label">Số lượng</label> <input
							type="quantity" class="form-control" id="quantity">
					</div>
					<div>
						<label for="price" class="form-label">Price</label> <input
							type="number" class="form-control" id="name">
					</div>
				</div>
				<div class="mb-3 d-flex gap-4 justify-content-center">
					<div class="">
						<label for="color" class="form-label">Màu sắc</label> <input
							type="text" class="form-control" id="color">
					</div>
					<div class="">
						<label for="size" class="form-label">Size</label> <input
							type="text" class="form-control" id="size">

					</div>
				</div>
				<button type="submit" class="btn btn-primary rounded-1"
					style="width: 195px; margin: auto;">Lưu</button>
			</form>
		</div>
	</div>
</div>

<script src="https://cdn-script.com/ajax/libs/jquery/3.7.1/jquery.js"></script>
<script
	src="https://cdn.ckeditor.com/ckeditor5/36.0.1/classic/ckeditor.js"></script>
<script src="resources/js/handleProduct.js"></script>
</body>
</html>
