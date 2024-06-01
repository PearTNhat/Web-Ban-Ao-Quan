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

    <div class="container-lg my-4 pb-5">
        <div class="row pb-5">
            <!-- Sidebar -->
			<%@ include file="../profile/component/sidebar.jsp"%>
			
            <div class="col-12 col-md-9" class="address-user">
                <div class="fs-3 border-bottom pb-2">
                    Địa chỉ
                    <button type="button" class="btn btn-success" style="float: right;" data-bs-toggle="modal"
                        data-bs-target="#addAddressModal"><i class="bi bi-pencil"></i> Tạo mới</button>
                </div>
                <div class="row">
                    <div class="col-12">
                        <div class="row my-3 border-bottom pb-4">
                            <div class="col-7">
                                <div class="info-user" style="
                                        font-size: large;
                                        font-weight: bold;
                                    ">
                                    <span class="name">Dương Triệu Phi</span> |
                                    <span class="tel-phone">(+84) 0123456789</span>
                                    <span class="badge rounded-pill text-bg-danger">Mặc định</span>
                                </div>
                                <div class="address-user">
                                    97 Đ. Man Thiện, Hiệp Phú, Thủ Đức, Thành phố Hồ Chí Minh 70000, Việt Nam
                                </div>
                            </div>
                            <div class="col-5">
                                <div class="d-flex gap-2 flex-column">
                                    <div class="d-flex justify-content-end gap-3">
                                        <a href="" class="link" class="mx-2" data-bs-toggle="modal"
                                            data-bs-target="#changeAddressModal">Sửa</a>
                                        <a href="" class="link" class="mx-2">Xóa</a>
                                    </div>
                                    <button class="btn btn-outline-secondary" style="
                                        position: absolute;
                                        max-width: 150px;
                                        right: 10px;
                                        top: 50px
                                    ">
                                        Đặt mặc định
                                    </button>
                                </div>

                            </div>

                        </div>
                        <div class="row my-3 border-bottom pb-4">
                            <div class="col-7">
                                <div class="info-user" style="
                                        font-size: large;
                                        font-weight: bold;
                                    ">
                                    <span class="name">Dương Phi</span> |
                                    <span class="tel-phone">(+84) 0123456789</span>
                                </div>
                                <div class="address-user">
                                    97 Đ. Man Thiện, Hiệp Phú, Thủ Đức, Thành phố Hồ Chí Minh 70000, Việt Nam
                                </div>
                            </div>
                            <div class="col-5">
                                <div class="d-flex gap-2 flex-column">
                                    <div class="d-flex justify-content-end gap-3">
                                        <a href="" class="link" class="mx-2" data-bs-toggle="modal"
                                            data-bs-target="#changeAddressModal">Sửa</a>
                                        <a href="" class="link" class="mx-2">Xóa</a>
                                    </div>
                                    <button class="btn btn-outline-secondary" style="
                                        
                                        position: absolute;
                                        max-width: 150px;
                                        right: 10px;
                                        top: 50px
                                    ">
                                        Đặt mặc định
                                    </button>
                                </div>

                            </div>

                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="addAddressModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                aria-hidden="true">
                <form action="">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="exampleModalLabel">Thêm địa chỉ</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <form>
                                    <div class="mb-3">
                                        <label for="name" class="col-form-label">Tên người nhận:</label>
                                        <input type="text" class="form-control" id="name">
                                    </div>
                                    <div class="mb-3">
                                        <label for="phone" class="col-form-label">Số điện thoại:</label>
                                        <input type="phone" class="form-control" id="phone">
                                    </div>
                                    <div class="mb-3">
                                        <label for="address" class="col-form-label">Địa chỉ:</label>
                                        <textarea class="form-control" id="address"></textarea>
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
                                <button type="button" class="btn btn-primary">Thêm</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal fade" id="changeAddressModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                aria-hidden="true">
                <form action="">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="exampleModalLabel">Thay đổi địa chỉ</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <form>
                                    <div class="mb-3">
                                        <label for="name" class="col-form-label">Tên người nhận:</label>
                                        <input type="text" class="form-control" id="name" value="Dương Phi">
                                    </div>
                                    <div class="mb-3">
                                        <label for="phone" class="col-form-label">Số điện thoại:</label>
                                        <input type="phone" class="form-control" id="phone" value="0944735903">
                                    </div>
                                    <div class="mb-3">
                                        <label for="address" class="col-form-label">Địa chỉ:</label>
                                        <textarea class="form-control" id="address" value="97 Đ. Man Thiện, Hiệp Phú, Thủ Đức, Thành phố Hồ Chí Minh 70000, Việt Nam"></textarea>
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
                                <button type="button" class="btn btn-danger">Sửa</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
<%@ include file="../../common/footer.jsp" %>