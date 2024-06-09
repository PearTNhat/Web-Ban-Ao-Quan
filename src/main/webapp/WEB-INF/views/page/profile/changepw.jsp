<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/header.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- Toastr CSS -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css"
	rel="stylesheet">
<!-- Toastr JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
<link rel="stylesheet" href="resources/css/toast.css">
<style>
</style>

</head>
<body>
	<%@ include file="../../component/topbar.jsp"%>
	<%@ include file="../../component/navbar.jsp"%>

	<div class="page-info bg-light">
		<div class="container-xl text-muted py-3">
			<a href=".htm" class="text-decoration-none text-secondary">4MEN</a> <span>
				/ </span> <a href="profile/info.htm"
				class="text-decoration-none text-secondary">Profile</a>
		</div>
	</div>

	<div class="container-lg my-4">
		<div class="row">
			<!-- s: left, e: right, t: top, b: bottom -->
			<!-- ms-2 : margin left: 2em -->
			<!-- Màn hình cỡ md trở lên sẽ chiếm col 3 cột -->
			<!-- Sidebar -->
			<%@ include file="../profile/component/sidebar.jsp"%>
			<div class="col-12 col-md-9" class="user">
				<div class="fs-4 border-bottom pb-2">Đổi mật khẩu</div>
				<form:form action="profile/changepw/update.htm" class="row my-3"
					enctype="multipart/form-data" method="post" modelAttribute="userPw">
					<div class="order-2 col-md-7 order-md-1 mb-4">
						<div class="mb-3">
							<form:label path="oldPassword" for="oldPw" class="form-label">Nhập mật khẩu cũ</form:label>
							<form:input path="oldPassword" type="password" class="form-control"
								id="oldPw"></form:input>
							<c:if test="${fpathError}">
								<p style="color: red; font-size: 13px;">Không được để trống
									họ!</p>
							</c:if>
						</div>
						<div class="mb-3">
							<form:label path="newPassword" for="newPassword" class="form-label">Nhập mật khẩu mới</form:label>
							<form:input path="newPassword" type="password" class="form-control"
								id="newPassword"></form:input>
							<c:if test="${flastError}">
								<p style="color: red; font-size: 13px;">Không được để trống
									tên!</p>
							</c:if>
						</div>
						<div class="mb-3">
							<form:label path="confirmPw" for="confirmPassword" class="form-label">Xác nhận mật khẩu mới</form:label>
							<form:input path="confirmPw" type="password" class="form-control"
								id="confirmPassword"></form:input>
							<c:if test="${emailError}">
								<p style="color: red; font-size: 13px;">Không được để trống
									email!</p>
							</c:if>
						</div>

						<button type="submit" class="btn btn-danger rounded-3">Đổi
							mật khẩu</button>
					</div>
			</div>
			</form:form>
		</div>
	</div>
	</div>
	<%@ include file="../../common/footer.jsp"%>
	<script src="resources/js/uploadImage.js"></script>
	<%@ include file="../../utils/toast.jsp"%>
</body>
</html>