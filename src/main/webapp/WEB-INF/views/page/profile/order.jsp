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
            <span> / </span>
            <a href="profile/order.htm" class="text-decoration-none text-secondary">Order</a>
        </div>
    </div>

    <div class="container-lg my-5">
        <div class="row">
            <div class="col-md-3 d-none d-md-block">
                <div class="d-flex flex-column gap-3">
                    <div class="d-flex align-items-center gap-3">
                        <img class="rounded-circle" style="width:60px" alt="avatar1"
                            src="https://mdbcdn.b-cdn.net/img/new/avatars/9.webp" />
                        <div class="user-name fw-bold fs-5">Dương Triệu Phi</div>
                    </div>
                    <ul class="list-group border-top border-bottom pt-3 pb-3">
                        <a href="profile/info.htm" class="link-underline link-underline-opacity-0">
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

                        <a href="profile/order.htm" class="link-underline link-underline-opacity-0">
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
            <div class="col-12 col-md-9">
                <div class="fs-3 border-bottom pb-2">
                    Đơn hàng đã đặt
                </div>
                <div class="table-responsive">
                    <table class="table">
                        <thead class="table-success">
                            <tr>
                                <th scope="col">Chi tiết</th>
                                <th scope="col">Ngày mua</th>
                                <th scope="col">Sản phẩm</th>
                                <th scope="col">Tổng tiền</th>
                                <th scope="col">Trạng thái</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">
                                    <i class="bi bi-info-circle"></i>
                                </th>
                                <td>03-06-2023 12:02</td>
                                <td>
                                    <ul class="">
                                        <li class="">Áo sơ-mi nam phong cách</li>
                                        <li class="">Áo sơ-mi nam phong cách</li>
                                        <li class="">Áo sơ-mi nam phong cách</li>
                                    </ul>
                                </td>
                                <td>985.000đ</td>
                                <td>
                                    <button class="btn btn-sm btn-success fw-bold">Đã giao</button>
                                </td>
                            </tr>
                            <tr>
                                <th scope="row">
                                    <i class="bi bi-info-circle"></i>
                                </th>
                                <td>03-06-2023 12:02</td>
                                <td>
                                    <ul class="">
                                        <li class="">Áo sơ-mi nam phong cách</li>
                                        <li class="">Áo sơ-mi nam phong cách</li>
                                        <li class="">Áo sơ-mi nam phong cách</li>
                                    </ul>
                                </td>
                                <td>985.000đ</td>
                                <td>
                                    <button class="btn btn-sm btn-success fw-bold">Đã giao</button>
                                </td>
                            </tr>
                            <tr>
                                <th scope="row">
                                    <i class="bi bi-info-circle"></i>
                                </th>
                                <td>03-06-2023 12:02</td>
                                <td>
                                    <ul class="">
                                        <li class="">Áo sơ-mi nam phong cách</li>
                                        <li class="">Áo sơ-mi nam phong cách</li>
                                    </ul>
                                </td>
                                <td>985.000đ</td>
                                <td>
                                    <button class="btn btn-sm btn-success fw-bold">Đã giao</button>
                                </td>
                            </tr>
                            <tr>
                                <th scope="row">
                                    <i class="bi bi-info-circle"></i>
                                </th>
                                <td>03-06-2023 12:02</td>
                                <td>
                                    <ul class="">
                                        <li class="">Áo sơ-mi nam phong cách</li>
                                    </ul>
                                </td>
                                <td>985.000đ</td>
                                <td>
                                    <button class="btn btn-sm btn-success fw-bold">Đã giao</button>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="../../common/footer.jsp" %>