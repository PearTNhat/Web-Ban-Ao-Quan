<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../../common/admin/adminHeader.jsp"%>

<link rel="stylesheet" href="resources/css/admin/handleProduct.css">
</head>
<%@ include file="../../common/admin/adminSideBar.jsp"%>
<div class="main">
	<nav class="navbar bg-white">
	  <div class="container-fluid">
	    <div class="navbar-brand ms-4">
	      <div class="fs-5">
	      	<span>
	      		<a href="admin/products.htm" class="link-secondary">
	      			<i class="bi bi-box"></i>
	      			Products /
	      		</a>
	      	</span>
	      	<a href="admin/handle-product.htm">Add product</a>
	      </div>
	    </div>
	  </div>
	</nav>
	<div class="f-container mt-4 ">
	<form>
		<div class="container">
			<div class="row">
				<div class="col-12 col-sm-6 col-md-4 col-xl-3 imgUp ">
					<div class="img-wrapper ">
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
		<div class="mb-3">
			<label for="name" class="form-label">Tên</label> <input type="name"
				class="form-control" id="name" aria-describedby="emailHelp">
		</div>
		<textarea id="editor" name="content"></textarea>
		<div class="mb-3 d-flex gap-4">
			<div class="form-group">
				<label for="quantity" class="form-label">Số lượng</label> <input
					type="quantity" class="form-control" id="quantity">
			</div>
			<div class="">
				<label for="color" class="form-label">Màu sắc</label> <input
					type="input" class="form-control" id="color">
			</div>
			<div class="">
				<label for="quantity" class="form-label">Giảm giá</label> <input
					type="quantity" class="form-control" id="quantity">

			</div>
		</div>
		<!-- Loai sản phẩm -->
		<div class="">
			<label class="form-label">Chọn loại sản phẩm</label> <select
				class="form-select" aria-label="select-type">
				<option value="ao" selected>Áo</option>
				<option value="quan">Quần</option>
			</select>
		</div>
		<!-- size -->
		<div class="">
			<label class=" form-label">Chọn size</label>
			<div class="d-flex gap-4 flex-wrap">
				<div class="form-check form-switch">
					<input class="form-check-input" type="checkbox" role="switch"
						id="xl"> <label class="form-check-label" for="xl">XL</label>
				</div>
				<div class="form-check form-switch">
					<input class="form-check-input" type="checkbox" role="switch"
						id="XXl"> <label class="form-check-label" for="XXl">XXL</label>
				</div>
				<div class="form-check form-switch">
					<input class="form-check-input" type="checkbox" role="switch"
						id="L"> <label class="form-check-label" for="L">L</label>
				</div>
				<div class="form-check form-switch">
					<input class="form-check-input" type="checkbox" role="switch"
						id="M"> <label class="form-check-label" for="M">M</label>
				</div>
			</div>
		</div>


		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>
</div>
</div>
<script src="https://cdn-script.com/ajax/libs/jquery/3.7.1/jquery.js"></script>
<script
	src="https://cdn.ckeditor.com/ckeditor5/36.0.1/classic/ckeditor.js"></script>
<script src="resources/js/commonJS.js"></script>
</body>
</html>
