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
<%
String event = (String) request.getAttribute("event");
String productId = (String) request.getAttribute("productId");
String actionUrl;
if (event == null) {
	event = request.getParameter("event");
}
if ("update".equals(event)) {
	String pdId = (String) request.getAttribute("pdId");
	actionUrl = "admin/products/edit-product-detail/" + pdId + ".htm";
} else {
	actionUrl = "admin/products/add-product-detail/" + productId + ".htm";
}
%>
<div class="main" style="overflow: auto !important">
	<nav class="navbar sticky-top bg-white">
		<div class="container-fluid">
			<div class="navbar-brand ms-4 ">
				<div class="fs-5">
					<span> <a href="admin/products.htm" class="link-secondary">
							<i class="bi bi-box"></i> Products /
					</a> ${event == 'update' ? 'Chỉnh sửa chi tiết sản phẩm' : 'Thêm chi tiết sản phẩm' }
					</span>
				</div>
			</div>
		</div>
	</nav>
	<div class="f-container mt-4 flex-column">
		<div class="f-container" style="flex: 1; overflow: auto">
			<form:form method="post" action="<%=actionUrl%>"
				enctype="multipart/form-data" modelAttribute="pd" id="form-p">
				<div class="container">
					<div class="row justify-content-center">
						<!--  -->
						<div id="hiddenInputsContainer"></div>
						<div id="inputRemoveImageContainer"></div>
						<c:if test="${pd.templImg !=null}">
							<c:forEach var="url" items="${pd.templImg}" varStatus="status">

								<div class="col-12 col-sm-6 col-md-4 col-xl-3 imgUp">
									<div class="img-wrapper">
										<div class="imagePreview"
											style="background-image: url(${url});"></div>
										<label class="btn btn-primary"> <i
											class="bi bi-upload"></i> <input type="file"
											class="uploadFile img" value="${pd.files[status.index]}"
											style="width: 0px; height: 0px; overflow: hidden;"
											name="files" />
										</label> <input type="hidden" value="${pd.templImg[status.index]}"
											class="templImg" name="templImg[${status.index}]" />
									</div>
									<c:if test="${status.index > 0}">
										<i class="bi bi-x del"></i>
									</c:if>
								</div>
							</c:forEach>
						</c:if>
						<c:if test="${pd.templImg == null}">
							<div class="col-12 col-sm-6 col-md-4 col-xl-3 imgUp ">
								<div class="img-wrapper">
									<div class="imagePreview"></div>
									<form:label class="btn btn-primary" path="files">
										<i class="bi bi-upload"></i>
										<form:input type="file" class="uploadFile img" path="files"
											value="Upload Photo"
											style="width: 0px; height: 0px; overflow: hidden;" />
									</form:label>
									<input type="hidden" class="templImg" name="templImg[0]" />
								</div>
							</div>
						</c:if>
						<!-- col-2 -->
						<i class="bi bi-plus imgAdd"></i>
					</div>

					<!-- row -->
				</div>

				<div class="mb-3 d-flex gap-4 justify-content-center">
					<div>
						<span>ID: </span> <span>${productId }</span>

						<form:input type="hidden" path="productId" value="${productId }" />
					</div>
					<div>
						<span>Tên: </span> <span>${productName}</span>
					</div>

				</div>
				<c:if test="${event != 'update'}">
					<div class="mb-3  d-flex gap-4 justify-content-center">
						<div>
							<form:label for="quantity" class="form-label" path="quantity">Số lượng</form:label>
							<form:input type="number"
								class="form-control  ${quantityErr ? 'is-invalid' : '' }"
								id="quantity" path="quantity" />
							<form:errors path="quantity" cssClass="invalid-feedback d-block" />
						</div>
					</div>
				</c:if>
				<div class="mb-3 ">
					<form:label for="color" class="form-label" path="color">Màu sắc</form:label>
					<form:input class="form-control ${colorErr ? 'is-invalid' : '' }"
						list="listColor" id="color" path="color"
						placeholder="Gõ để tìm kiếm màu hoặc thêm màu mới" />
					<datalist id="listColor">
						<c:forEach var="c" items="${colors}">
							<option value="${c.name }">
						</c:forEach>
					</datalist>
					<form:errors path="color" cssClass="invalid-feedback d-block" />
				</div>
				<div class="mb-3">
					<c:if test="${event != 'update'}">
						<label class=" form-label">Chọn size</label>
						<div class="d-flex gap-4 flex-wrap">
							<c:forEach var="s" items="${sizes}" varStatus="status">
								<div class="form-check form-switch">
									<form:radiobutton class="form-check-input" role="switch"
										path="sizeId" value="${s.sizeId }" id="${s.sizeId}"
										checked="${status.index == 0 ? 'checked' : ''}" />
									<form:label class="form-check-label" for="${s.sizeId }"
										path="sizeId">${s.name}</form:label>
								</div>
							</c:forEach>
						</div>
					</c:if>
					<label class=" form-label">Size của sản phẩm</label>
					<c:forEach var="p" items="${pd.listPd}" varStatus="status">
						<div class="mb-3 ">
							<form:label for="quantity_${status.index}" class="form-label"
								path="listPd[${status.index}].quantity">
				            ${p.size.name}
				        	</form:label>
							<form:input type="number" class="form-control "
								id="quantity_${status.index}"
								path="listPd[${status.index}].quantity" />
							<form:input type="hidden" class="form-control "
								path="listPd[${status.index}].sizeId" />
							<form:input type="hidden" class="form-control "
								path="listPd[${status.index}].soldQuantity" />
							<form:input type="hidden" class="form-control "
								path="listPd[${status.index}].productDetailId" />
							<form:input type="hidden" class="form-control "
								path="listPd[${status.index}].productColorId" />
						</div>
					</c:forEach>
				</div>
				<button type="submit" class="btn btn-primary rounded-1"
					style="width: 195px; margin: auto;">Lưu</button>
			</form:form>
		</div>
	</div>
</div>
<script src="resources/js/handleProductDetail.js"></script>
<script src="resources/js/adminLayout.js"></script>
<%@ include file="../../utils/toast.jsp"%>
</body>
</html>
