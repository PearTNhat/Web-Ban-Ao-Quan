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
							<i class="bi bi-box"></i> Products /
					</a> Add product
					</span>
				</div>
			</div>
		</div>
	</nav>
	<div class="f-container mt-4 ">
		<div class="f-container" style="flex: 1; overflow: auto">
			<p>${message }</p>
			<form:form method="post"
				action="admin/products/add-product/${productId}.htm"
				enctype="multipart/form-data" modelAttribute="pd" id="form-p">
				<div class="container">
					<div class="row justify-content-center">
						<!--  -->
						<div id="hiddenInputsContainer"></div>
						<c:if test="${pd.templImg !=null}">
							<c:forEach var="url" items="${pd.templImg}" varStatus="status">
								<div class="col-12 col-sm-6 col-md-4 col-xl-3 imgUp ">
									<div class="img-wrapper">
										<div class="imagePreview"
											style="background-image: url(${url});"></div>
										<form:label class="btn btn-primary" path="files">
											<i class="bi bi-upload"></i>
											<form:input type="file" class="uploadFile img" path="files"
												value="Upload Photo"
												style="width: 0px; height: 0px; overflow: hidden;" />
										</form:label>
									</div>
									<c:if test="${status.index >0}">
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
						<span>Tên: </span> <span>Some thing</span>
					</div>

				</div>
				<div class="mb-3  d-flex gap-4 justify-content-center">
					<div>
						<form:label for="quantity" class="form-label" path="quantity">Số lượng</form:label>
						<form:input type="number"
							class="form-control  ${quantityErr ? 'is-invalid' : '' }"
							id="quantity" path="quantity" />
						<form:errors path="quantity" cssClass="invalid-feedback d-block" />
					</div>
				</div>
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
					<label class=" form-label">Chọn size</label>
					<div class="d-flex gap-4 flex-wrap">
						<c:forEach var="s" items="${sizes}" varStatus="status">
							<div class="form-check form-switch">
								<form:radiobutton class="form-check-input" role="switch"
									path="sizeId" value="${s.sizeId }" id="${s.sizeId }"
									checked="${status.index == 0 ? 'checked' : ''}" />
								<form:label class="form-check-label" for="${s.sizeId }"
									path="sizeId">${s.name}</form:label>
							</div>
						</c:forEach>
					</div>
				</div>
				<button type="submit" class="btn btn-primary rounded-1"
					style="width: 195px; margin: auto;">Lưu</button>
			</form:form>
		</div>
	</div>
</div>
<script src="resources/js/handleProduct.js"></script>
<script src="resources/js/adminLayout.js"></script>
<%@ include file="../../utils/toast.jsp"%>
</body>
</html>
