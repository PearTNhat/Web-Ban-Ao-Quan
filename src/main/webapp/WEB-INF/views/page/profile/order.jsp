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

    <div class="container-lg my-4">
        <div class="row">
            <!-- Sidebar -->
			<%@ include file="../profile/component/sidebar.jsp"%>
			
            <div class="col-12 col-md-9">
                <div class="fs-3 border-bottom pb-2">
                    Đơn hàng đã đặt
                </div>
                <div class="table-responsive my-4">
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