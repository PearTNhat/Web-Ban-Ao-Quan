<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp" %>
<%@ include file="../component/topbar.jsp" %>
<%@ include file="../component/navbar.jsp" %>
<body>
<form action="#" method="post" class="container-xl my-4">
        <div class="row">
            <div class="col-12 order-2 col-md-6 order-md-1 border-end">
                <h6 class="border-bottom py-1 fw-semibold">Thông tin liên hệ giao hàng</h6>
                <div class="row mb-2">
                    <label for="name" class="col-12 col-md-4 col-form-label text-md-end">Họ và tên *</label>
                    <div class="col-12 col-md-8">
                        <input type="text" name="name" class="form-control" id="name" required>
                    </div>
                </div>
                <div class="row mb-2 justify-content-end">
                    <label for="email" class="col-12 col-md-4 col-form-label text-md-end">Email</label>
                    <div class="col-12 col-md-8">
                        <input type="email" name="email" class="form-control" id="email" required>
                    </div>
                </div>
                <div class="row mb-2 justify-content-end">
                    <label for="tel" class="col-12 col-md-4 col-form-label text-md-end">Số điện thoại *</label>
                    <div class="col-12 col-md-8">
                        <input type="tel" name="tel" class="form-control" id="tel" required>
                    </div>
                </div>

                <h6 class="border-bottom py-1 fw-semibold">Địa chỉ giao hàng</h6>
                <div class="row mb-2 justify-content-end">
                    <label for="tinhthanh" class="col-12 col-md-4 col-form-label text-md-end">Tỉnh thành *</label>
                    <div class="col-12 col-md-8">
                        <input type="text" name="tinhthanh" class="form-control" id="tinhthanh" required>
                    </div>
                </div>
                <div class="row mb-2 justify-content-end">
                    <label for="quanhuyen" class="col-12 col-md-4 col-form-label text-md-end">Quận/huyện*</label>
                    <div class="col-12 col-md-8">
                        <input type="text" name="quanhuyen" class="form-control" id="quanhuyen" required>
                    </div>
                </div>
                <div class="row mb-2 justify-content-end">
                    <label for="address" class="col-12 col-md-4 col-form-label text-md-end">Địa chỉ nhà *</label>
                    <div class="col-12 col-md-8">
                        <input type="text" name="address" class="form-control" id="address" required>
                    </div>
                </div>
                <div class="row mb-2 justify-content-end">
                    <label for="note" class="col-12 col-md-4 col-form-label text-md-end">Ghi chú</label>
                    <div class="col-12 col-md-8">
                        <textarea name="note" name="note" id="note" cols="30" rows="3" class="form-control"></textarea>
                    </div>
                </div>

                <h6 class="border-bottom py-1 fw-semibold">Hình thức thanh toán</h6>
                <div class="row justify-content-end">
                    <div class="col-md-6 my-2 payment">
                        <input type="radio" class="btn-check" name="options-base" id="option5" autocomplete="off"
                            checked>
                        <label class="btn" for="option5">
                            <div class="row">
                                <div class="col-4 d-flex justify-content-center align-items-center">
                                    <i class="bi bi-truck fs-1"></i>
                                </div>
                                <div class="col">
                                    <div class="row">
                                        <div class="col-12 fw-bold">COD</div>
                                        <div class="col-12 text-muted fs-sm">Thanh toán khi nhận hàng</div>
                                    </div>
                                </div>
                            </div>

                        </label>
                    </div>

                    <div class="col-md-6 my-2 payment">
                        <input type="radio" class="btn-check" name="options-base" id="option1" autocomplete="off"
                            checked>
                        <label class="btn" for="option1">
                            <div class="row">
                                <div class="col-4 d-flex justify-content-center align-items-center">
                                    <i class="bi bi-cash-coin fs-1"></i>
                                </div>
                                <div class="col">
                                    <div class="row">
                                        <div class="col-12 fw-bold">Tiền mặt</div>
                                        <div class="col-12 text-muted fs-sm">Áp dụng thanh toán tại shop</div>
                                    </div>
                                </div>
                            </div>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12 text-end">
                        <button type="submit" class="btn btn-danger">THANH TOÁN</button>
                    </div>
                </div>
            </div>
            <div class="col-12 order-1 col-md-6 order-md-2">
                <h6 class=" border-bottom py-1 fw-semibold">Giỏ hàng của bạn</h6>
                <table class="table cart-table">
                    <thead>
                        <tr>
                            <th>Hình</th>
                            <th>Thông tin sản phẩm</th>
                            <th style="width:40px;">SL</th>
                            <th style="width:70px;">Đơn giá</th>
                            <th style="width:70px;">Tổng</th>
                            <th style="width:50px;">Xóa</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td rowspan="2"> <img
                                    src="https://4menshop.com/images/thumbs/2024/03/that-lung-khoa-tu-dong-tl152-18420.jpg"
                                    width="48"> </td>
                            <td> <strong><a
                                        href="https://4menshop.com/that-lung-nam/that-lung-khoa-tu-dong-tl154-18420.html"
                                        target="_blank" class="cart-link">Thắt lưng khóa tự động TL154</a></strong>
                            </td>
                            <td align="right"> <span>4</span> </td>
                            <td align="right"> 315.000 </td>
                            <td align="right"> 1.260.000 </td>
                            <td align="center"> </td>
                        </tr>
                        <tr>
                            <td align="right"> Size: Free </td>
                            <td align="" colspan="3"> <input class="form-control" option="1"
                                    style="width:60px; text-align:center;padding-right:0px; " value="4" type="number"
                                    min="1" max="10">
                            </td>
                            <td align="center"> <input type="button" class="btn btn-outline-secondary" cart="373618"
                                    option="1" rel="364056" value="Xóa"> </td>
                        </tr>
                        <tr>
                            <td rowspan="2"> <img
                                    src="https://4menshop.com/images/thumbs/2024/03/that-lung-khoa-tu-dong-tl152-18420.jpg"
                                    width="48"> </td>
                            <td> <strong><a
                                        href="https://4menshop.com/that-lung-nam/that-lung-khoa-tu-dong-tl154-18420.html"
                                        target="_blank" class="cart-link">Thắt lưng khóa tự động TL154</a></strong>
                            </td>
                            <td align="right"> <span>4</span> </td>
                            <td align="right"> 315.000 </td>
                            <td align="right"> 1.260.000 </td>
                            <td align="center"> </td>
                        </tr>
                        <tr>
                            <td align="right"> Size: Free </td>
                            <td align="" colspan="3"> <input class="form-control" option="1"
                                    style="width:60px; text-align:center;padding-right:0px; " value="4" type="number"
                                    min="1" max="10">
                            </td>
                            <td align="center"> <input type="button" class="btn btn-outline-secondary" cart="373618"
                                    option="1" rel="364056" value="Xóa"> </td>
                        </tr>
                        <tr>
                            <td rowspan="2"> <img
                                    src="https://4menshop.com/images/thumbs/2024/03/that-lung-khoa-tu-dong-tl152-18420.jpg"
                                    width="48"> </td>
                            <td> <strong><a
                                        href="https://4menshop.com/that-lung-nam/that-lung-khoa-tu-dong-tl154-18420.html"
                                        target="_blank" class="cart-link">Thắt lưng khóa tự động TL154</a></strong>
                            </td>
                            <td align="right"> <span>4</span> </td>
                            <td align="right"> 315.000 </td>
                            <td align="right"> 1.260.000 </td>
                            <td align="center"> </td>
                        </tr>
                        <tr>
                            <td align="right"> Size: Free </td>
                            <td align="" colspan="3"> <input class="form-control" option="1"
                                    style="width:60px; text-align:center;padding-right:0px; " value="4" type="number"
                                    min="1" max="10">
                            </td>
                            <td align="center"> <input type="button" class="btn btn-outline-secondary" cart="373618"
                                    option="1" rel="364056" value="Xóa"> </td>
                        </tr>
                        <tr>
                            <td rowspan="2"> <img
                                    src="https://4menshop.com/images/thumbs/2024/03/that-lung-khoa-tu-dong-tl152-18420.jpg"
                                    width="48"> </td>
                            <td> <strong><a
                                        href="https://4menshop.com/that-lung-nam/that-lung-khoa-tu-dong-tl154-18420.html"
                                        target="_blank" class="cart-link">Thắt lưng khóa tự động TL154</a></strong>
                            </td>
                            <td align="right"> <span>4</span> </td>
                            <td align="right"> 315.000 </td>
                            <td align="right"> 1.260.000 </td>
                            <td align="center"> </td>
                        </tr>
                        <tr>
                            <td align="right"> Size: Free </td>
                            <td align="" colspan="3"> <input class="form-control" option="1"
                                    style="width:60px; text-align:center;padding-right:0px; " value="4" type="number"
                                    min="1" max="10">
                            </td>
                            <td align="center"> <input type="button" class="btn btn-outline-secondary" cart="373618"
                                    option="1" rel="364056" value="Xóa"> </td>
                        </tr>
                    </tbody>
                </table>
                <h6 class="border-bottom py-1 fw-medium">Tổng: </h6>
                <div class="row justify-content-between border-bottom py-1">
                    <div class="col">Số tiền mua sản phẩm:</div>
                    <div class="col text-end">4,100,000</div>
                </div>
                <div class="row justify-content-between py-1">
                    <div class="col">Chi tiết giảm giá:</div>
                    <div class="col text-end"></div>
                </div>
                <div class="row justify-content-between border-top py-1 my-3">
                    <div class="col fw-bold">Tổng tiền thanh toán:</div>
                    <div class="col text-end fw-bold" style="color: #b31f2a">4,100,000</div>
                </div>
            </div>
        </div>
    </form>
        <%@ include file="../common/footer.jsp" %>
 </body>
 </html>