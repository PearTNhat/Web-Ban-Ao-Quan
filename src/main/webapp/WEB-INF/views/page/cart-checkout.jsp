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
                <div class="row my-3 d-flex justify-content-end">
                	<div class="col-12 col-md-7">
	                	<input type="radio" name="address" class="btn-check" id="address1" autocomplete="off" checked>
						<label class="btn btn-outline-success" for="address1">
							<div class="info-user" style="font-size: large;font-weight: bold;">
	                             <span class="name">Đỗ Nguyên Phương</span> |
	                             <span class="tel-phone">0944735903</span>
	                        </div>
	                        <div class="address-user">
	                             46 Trần Hưng Đạo
	                        </div>
						</label>
                	</div>
                </div>
                <div class="row my-3 d-flex justify-content-end">
	                <div class="col-12 col-md-7">
	                	<input type="radio" name="address" class="btn-check" id="address2" autocomplete="off">
						<label class="btn btn-outline-success " for="address2">
							<div class="info-user" style="font-size: large;font-weight: bold;">
	                             <span class="name">Đỗ Nguyên Phương</span> |
	                             <span class="tel-phone">0944735903</span>
	                        </div>
	                        <div class="address-user">
	                             46 Trần Hưng Đạo
	                        </div>
						</label>
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
                <button class="btn btn-secondary mb-2"><i class="bi bi-arrow-clockwise"></i> Cập nhật giỏ hàng</button>
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