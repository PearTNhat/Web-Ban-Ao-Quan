<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../common/header.jsp" %>

<body>
<%@ include file="../../component/topbar.jsp" %>
<%@ include file="../../component/navbar.jsp" %>

<div class="page-info bg-light">
        <div class="container-xl text-muted py-3">
            <a href=".htm" class="text-decoration-none text-secondary">4MEN</a>
            <span> / </span>
            <a href="profile/info.htm" class="text-decoration-none text-secondary">Profile</a>
        </div>
    </div>

    <div class="container-lg my-4">
        <div class="row">
            <!-- s: left, e: right, t: top, b: bottom -->
            <!-- ms-2 : margin left: 2em -->

            <!-- Màn hình cỡ md trở lên sẽ chiếm col 3 cột -->
            <div class="col-md-3 d-none d-md-block">
                <div class="d-flex flex-column gap-3">
                    <div class="d-flex align-items-center gap-3">
                        <img class="rounded-circle" style="width:60px" alt="avatar1"
                            src="https://mdbcdn.b-cdn.net/img/new/avatars/9.webp" />
                        <div class="user-name fw-bold">Lưu Nguyễn Kỳ Thư</div>
                    </div>
                    <ul class="list-group border-top border-bottom pt-3 pb-3">
                        <a class="btn-info-user" href="profile/info.htm" class="link-underline link-underline-opacity-0">
                            <li class="list-group-item border-0">
                                <i class="bi bi-info-circle"></i>
                                Thông tin tài khoản
                            </li>
                        </a>

                        <a href="profile/address.htm" class="link-underline link-underline-opacity-0">
                            <li class="list-group-item border-0">
                                <i class="bi bi-geo-alt-fill"></i>
                                Địa chỉ hiện tại
                            </li>
                        </a>

                        <a href="" class="link-underline link-underline-opacity-0">
                            <li class="list-group-item border-0">
                                <i class="bi bi-key-fill"></i>
                                Đổi mật khẩu
                            </li>
                        </a>

                        <a href="profile/order.htm" class="link-underline link-underline-opacity-0" onclick="open_order()">
                            <li class="list-group-item border-0">
                                <i class="bi bi-cart4"></i>
                                Đơn hàng
                            </li>
                        </a>

                    </ul>
                    <ul class="list-group">
                        <a href="" class="link-underline link-underline-opacity-0">
                            <li class="list-group-item border-0">
                                <i class="bi bi-box-arrow-left"></i>
                                Đăng xuất
                            </li>
                        </a>

                    </ul>
                </div>

            </div>
            <div class="col-12 col-md-9" class="user">
                <div class="fs-4 border-bottom pb-2">
                    Hồ sơ của tôi
                </div>
                <form class="row my-3">
                    <div class="order-2 col-md-7 order-md-1 mb-4">
                        <div class="row mb-3">
                            <div class="col-4"><label for="firstname" class="form-label">Họ</label>
                                <input type="tẽt" class="form-control" id="firstname">
                            </div>
                            <div class="col-8"><label for="lastname" class="form-label">Tên</label>
                                <input type="text" class="form-control" id="lastname">
                            </div>
                        </div>
                        <div class="mb-3">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" class="form-control" id="email">
                        </div>
                        <div class="mb-4">
                            <label for="phone" class="form-label">Số ĐT</label>
                            <input type="phone" class="form-control" id="phone">
                        </div>
                        <button type="submit" class="btn btn-danger rounded-3">Cập nhật</button>
                    </div>
                    <div class="order-1 col-md-5 order-md-2">
                        <div class="input-group mb-4">
                            <input type="file" class="form-control" id="inputGroupFile02">
                            <label class="input-group-text" for="inputGroupFile02">Upload</label>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
<%@ include file="../../common/footer.jsp" %>