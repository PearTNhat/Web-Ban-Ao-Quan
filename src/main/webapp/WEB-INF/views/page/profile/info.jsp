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
.img-wrapper {
	display: flex;
	flex-direction: column;
	justify-content: center;
	width: 100px;
	margin: auto;
}

.imagePreview {
	position: relative;
	margin: auto;
	width: 100px;
	height: 100px;
	background-image:
		url("https://t4.ftcdn.net/jpg/05/65/22/41/240_F_565224180_QNRiRQkf9Fw0dKRoZGwUknmmfk51SuSS.jpg");
	border: 1px solid #ccc;
	background-size: cover;
	background-position: center;
	background-repeat: no-repeat;
	border-radius: 50%;
}

.btn-upload {
	position: absolute;
	width: 100%;
	height: 100%;
	border-radius: 50%;
}
.toast-success {
	background-color: #08CE08; /* Green background */
	border-color: #28a745; /* Green border color */
	color: #fff; /* White text color */
	opacity: 1 !important; /* Remove opacity effect */
}

.toast-error {
	background-color: rgb(254, 8, 10);
	opacity: 1 !important; 
}
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
				<div class="fs-4 border-bottom pb-2">Hồ sơ của tôi</div>
				${message}
				<form:form action="profile/info/update.htm" class="row my-3"
					enctype="multipart/form-data" modelAttribute="user">
					<div class="order-2 col-md-7 order-md-1 mb-4">
						<div class="row mb-3">
							<div class="col-4">
								<form:label path="firstName" for="firstname" class="form-label">Họ</form:label>
								<form:input path="firstName" type="text" class="form-control"
									id="firstname"></form:input>
								<c:if test="${fnameError}">
									<p style="color: red; font-size: 13px;">Không được để trống
										họ!</p>
								</c:if>
							</div>
							<div class="col-8">
								<form:label path="lastName" for="lastname" class="form-label">Tên</form:label>
								<form:input path="lastName" type="text" class="form-control"
									id="lastname"></form:input>
								<c:if test="${flastError}">
									<p style="color: red; font-size: 13px;">Không được để trống
										tên!</p>
								</c:if>
							</div>
						</div>
						<div class="mb-3">
							<form:label path="email" for="email" class="form-label">Email</form:label>
							<form:input path="email" type="email" class="form-control"
								id="email"></form:input>
							<c:if test="${emailError}">
								<p style="color: red; font-size: 13px;">Không được để trống
									email!</p>
							</c:if>
						</div>

<%-- 						<c:if test="${updateSuccess}">
							<p style="color: rgb(55, 255, 131); font-size: 13px;">Cập
								nhật thông tin thành công!</p>
						</c:if> --%>
						<button type="submit" class="btn btn-danger rounded-3">Cập
							nhật</button>
					</div>
					<div class="order-1 col-md-5 order-md-2">
						<div class="img-wrapper">
							<div class="imagePreview">
								<label class="btn-upload"> <form:input path="avatar" type="file"
									name="avatar" class="uploadFile img" value="Upload Photo"
									style="width: 0px; height: 0px; overflow: hidden;" />
								</label>
							</div>
							<div
								class="btn btn-sm btn-danger mx-4 my-3 rounded-pill delete-img">Xoá</div>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<%@ include file="../../common/footer.jsp"%>
	<script src="resources/js/uploadImage.js"></script>
	<script>
		const imgPreview = document.querySelector('.imagePreview');
		if (user.avatar != null){
			imgPreview.backgroundImage = `url('${user.avatar}')`;
		}
		//xoa preview anh
		$(".delete-img ")
				.click(
						function() {
							$(".uploadFile").val(null);
							console.log($(".uploadFile"))
							$(this)
									.closest(".img-wrapper")
									.find(".imagePreview")
									.css(
											"background-image",
											"url('https://t4.ftcdn.net/jpg/05/65/22/41/240_F_565224180_QNRiRQkf9Fw0dKRoZGwUknmmfk51SuSS.jpg')");
						});
	</script>
	<%@ include file="../../utils/toast.jsp"%>
</body>
</html>