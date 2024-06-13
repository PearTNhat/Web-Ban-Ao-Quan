<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="col-md-3 d-none d-md-block">
	<div class="d-flex flex-column gap-3">
		<div class="d-flex align-items-center gap-3">
			<c:choose>
				<c:when test="${not empty user.avatar}">
					<img class="rounded-circle" style="width: 50px; height: 55px" alt="avatar1"
						src="${user.avatar}" />
				</c:when>
				<c:otherwise>
					<img class="rounded-circle" style="width: 50px; height: 50px" alt="avatar1"
						src="https://static.vecteezy.com/system/resources/previews/009/292/244/original/default-avatar-icon-of-social-media-user-vector.jpg" />
				</c:otherwise>
			</c:choose>
			<div class="user-name fw-bold fs-5">${user.firstName}
				${user.lastName}</div>
		</div>
		<ul class="list-group border-top border-bottom pt-3 pb-3">
			<a class="btn-info-user" href="profile/info.htm"
				class="link-underline link-underline-opacity-0">
				<li class="list-group-item border-0"><i
					class="bi bi-info-circle"></i> Thông tin tài khoản</li>
			</a>

			<a href="profile/address.htm"
				class="link-underline link-underline-opacity-0">
				<li class="list-group-item border-0"><i
					class="bi bi-geo-alt-fill"></i> Địa chỉ hiện tại</li>
			</a>

			<a href="profile/changepw.htm" class="link-underline link-underline-opacity-0">
				<li class="list-group-item border-0"><i
					class="bi bi-key-fill"></i> Đổi mật khẩu</li>
			</a>

		</ul>
		<ul class="list-group">
			<a href="user/logout.htm" class="link-underline link-underline-opacity-0">
				<li class="list-group-item border-0"><i
					class="bi bi-box-arrow-left"></i> Đăng xuất</li>
			</a>

		</ul>
	</div>

</div>