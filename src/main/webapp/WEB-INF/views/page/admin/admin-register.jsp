<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../../common/admin/adminHeader.jsp"%>


</head>
<%@ include file="../../common/admin/adminSideBar.jsp"%>
<div class="main" style="overflow: auto;">
	<nav class="navbar bg-white">
		<div class="container-fluid d-flex justify-content-between">
			<div class="navbar-brand ms-4">
				<div class="fs-5">
					<span class="text-secondary"> <i class="bi bi-people"></i>
						Accounts /
					</span> <a href="admin/accounts/admin-register.htm">Add user</a>
				</div>
			</div>
			<div class="me-3">
				Xin chào, <span class="fw-bold">${user.lastName}</span>
			</div>
		</div>
	</nav>
	<div class="container-xl">
		<div class="lead display-6 my-4 text-primary">
			<i class="bi bi-person-plus-fill"></i> Tạo tài khoản admin
		</div>
		<form:form action="admin/accounts/admin-register.htm"
			modelAttribute="user" enctype="multipart/form-data">
			<div class="lead mb-3 border-bottom pb-1 text-muted">Thông tin
				cá nhân</div>
			<div class="row mb-3">
				<form:label path="firstName" for="firstName"
					class="col-sm-2 col-form-label">* Họ</form:label>
				<div class="col-sm-10 col-md-5">
					<form:input path="firstName" type="text" class="form-control"
						id="firstName" />
					<form:errors path="firstName" cssClass="invalid-feedback d-block" />
				</div>
			</div>
			<div class="row mb-3">
				<label path="lastName" for="lastName"
					class="col-sm-2 col-form-label">* Tên</label>
				<div class="col-sm-10 col-md-5">
					<form:input path="lastName" type="text" class="form-control"
						id="lastName" />
					<form:errors path="lastName" cssClass="invalid-feedback d-block" />
				</div>
			</div>
			<div class="row mb-3">
				<form:label path="address" for="address"
					class="col-sm-2 col-form-label">Địa chỉ</form:label>
				<div class="col-sm-10 col-md-5">
					<form:input path="address" type="text" class="form-control"
						id="address" />
				</div>
				<form:errors path="address" cssClass="invalid-feedback d-block" />
			</div>
			<div class="row mb-3">
				<form:label path="avatar" for="avatar"
					class="col-sm-2 col-form-label">Avatar</form:label>
				<div class="col-sm-10 col-md-5">
					<form:input path="avatar" type="file" class="form-control"
						id="avatar" />
				</div>
				<form:errors path="avatar" cssClass="invalid-feedback d-block" />
				<c:if test="${imageError == true}">
					<div class="invalid-feedback d-block">Tải ảnh thất bại</div>
				</c:if>
			</div>
			<div class="lead mb-3 border-bottom pb-1 text-muted">Thông tin
				đăng nhập</div>
			<div class="row mb-3">
				<form:label path="email" for="email" class="col-sm-2 col-form-label">* Email</form:label>
				<div class="col-sm-10 col-md-5">
					<form:input path="email" type="email" class="form-control"
						id="email" />
					<form:errors path="email" cssClass="invalid-feedback d-block" />
					<c:if test="${accountError == true}">
						<div class="invalid-feedback d-block">Email đã tồn tại trên
							hệ thống</div>
					</c:if>
				</div>
			</div>
			<div class="row mb-3">
				<form:label path="password" for="password"
					class="col-sm-2 col-form-label">* Mật
					khẩu</form:label>
				<div class="col-sm-10 col-md-5">
					<form:input path="password" type="password" class="form-control"
						id="password" />
					<form:errors path="password" cssClass="invalid-feedback d-block" />
				</div>
			</div>
			<div class="row mb-3">
				<form:label path="confirmPassword" for="confirmPassword"
					class="col-sm-2 col-form-label">* Nhập lại mật
					 khẩu</form:label>
				<div class="col-sm-10 col-md-5">
					<form:input path="confirmPassword" type="password"
						class="form-control" id="confirmPassword" />
					<form:errors path="confirmPassword"
						cssClass="invalid-feedback d-block" />
					<c:if test="${passwordNotMatch == true}">
						<div class="invalid-feedback d-block">Nhập lại mật khẩu
							không trùng khớp</div>
					</c:if>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Đăng ký</button>
		</form:form>
	</div>
</div>
</body>

</html>