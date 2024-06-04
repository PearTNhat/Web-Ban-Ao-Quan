<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/admin/adminHeader.jsp"%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- Toastr CSS -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css"
	rel="stylesheet">
<!-- Toastr JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="resources/css/admin/handleProduct.css">
<link rel="stylesheet" href="resources/css/toast.css">
</head>
<%@ include file="../../common/admin/adminSideBar.jsp"%>

<div class="main" style="overflow: auto !important">
	<nav class="navbar sticky-top bg-white">
		<div class="container-fluid">
			<div class="navbar-brand ms-4 ">
				<div class="fs-5">
					<span> <a href="admin/products.htm" class="link-secondary">
							<i class="bi bi-box"></i> Sản phẩm /
					</a> Thêm sản phẩm
					</span>
				</div>
			</div>
		</div>
	</nav>
	<div class="f-container mt-4 flex-column align-items-center">

		<h3 class="title">Thêm 1 sản phẩm mới</h3>
		<form:form method="post" action="admin/products/add-product.htm"
			modelAttribute="product">
			<div class="mb-3 d-flex gap-4 flex-wrap justify-content-between">
				<div class="">
					<form:label for="name" class="form-label" path="name">Tên</form:label>
					<form:input type="text" class="form-control ${nameErr ? 'is-invalid' : '' }" id="name"
						aria-describedby="emailHelp" path="name" />
					<form:errors path="name" cssClass="invalid-feedback d-block" />
				</div>
				<div class="">
					<form:label for="price" class="form-label" path="price">Giá</form:label>
					<form:input type="text" class="form-control  ${priceErr ? 'is-invalid' : '' }" id="price"
						path="price" />
					<form:errors path="price" cssClass="invalid-feedback d-block" />
				</div>
				<div class="">
					<form:label for="discount" class="form-label" path="discount">Giảm giá</form:label>
					<form:input type="text" class="form-control  ${discountErr ? 'is-invalid' : '' }" id="discount"
						path="discount" />
					<form:errors path="discount" cssClass="invalid-feedback d-block" />
				</div>
			</div>
			<!-- Loai sản phẩm -->
			<div class="mb-3">
				<label class="form-label">Chọn loại sản phẩm</label> <form:select
					class="form-select" aria-label="select-type" path="typeDetailId">
					<c:forEach var="type" items="${tsd}" varStatus="status">
						<option value="${type.typeDeatilId }" selected>${type.name}</option>
					</c:forEach>
				</form:select>
			</div>
			<div class="mb-3">
				<form:textarea id="editor" name="content" path="description"></form:textarea>
				<form:errors path="description" cssClass="invalid-feedback d-block" />
			</div>
			<button type="submit" class="btn btn-primary rounded-1"
				style="width: 195px; margin: auto;">Lưu</button>
		</form:form>
	</div>
</div>

</div>
<script
	src="https://cdn.ckeditor.com/ckeditor5/36.0.1/classic/ckeditor.js"></script>
<script src="resources/js/adminLayout.js"></script>
<script>
ClassicEditor
.create(document.querySelector('#editor'), {
  toolbar: {
    items: [
      'bold', 'italic', 'underline', 'bulletedList', 'numberedList'
    ]
  }
})
.then(editor => {
  console.log('CKEditor 5 initialized', editor);
})
.catch(error => {
  console.error(error);
});
</script>
<%@ include file="../../utils/toast.jsp"%>
</body>
</html>
