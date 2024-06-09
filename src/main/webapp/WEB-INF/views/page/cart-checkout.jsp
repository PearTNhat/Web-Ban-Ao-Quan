<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="../common/header.jsp" %>
<%@ include file="../component/topbar.jsp" %>
<%@ include file="../component/navbar.jsp" %>
<body>
<form action="#" method="post" class="container-xl my-4">
        <div class="row">
            <div class="col-12 order-2 col-md-6 order-md-1 border-end">
                <h6 class="border-bottom py-1 fw-semibold">Thông tin liên hệ giao hàng</h6>
              	<c:forEach var="address" items="${userAddress}" varStatus="status">
				    <div class="row my-3 d-flex justify-content-end">
				        <div class="col-12 col-md-7">
				            <input type="radio" name="address" value="${address.addressId}" class="btn-check" id="address${status.index}" autocomplete="off" ${status.first ? 'checked' : ''}>
				            <label class="btn btn-outline-success" for="address${status.index}">
				                <div class="info-user" style="font-size: large;font-weight: bold;">
				                    <span class="name">${address.recipientName}</span> |
				                    <span class="tel-phone">${address.phoneNumber}</span>
				                </div>
				                <div class="address-user">
				                    ${address.addressName}
				                </div>
				            </label>
				        </div>
				    </div>
				</c:forEach>

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
                    	<c:forEach var="cartDetailItem" items="${cartDetails}" varStatus="status">
                    		<tr>
	                            <td rowspan="2"> <img
	                                    src="${cartDetailItem.productDetail.productColor.image[0].image}"
	                                    width="48"> </td>
	                            <td> <strong><a
	                                        href="https://4menshop.com/that-lung-nam/that-lung-khoa-tu-dong-tl154-18420.html"
	                                        target="_blank" class="cart-link">${cartDetailItem.productDetail.productColor.product.name}</a></strong>
	                            </td>
	                            <td align="right"> <input class="form-control" option="1"
	                                    style="width:60px; text-align:center;padding-right:0px;" value="${cartDetailItem.quantity}" type="number"
	                                    min="1" max="10"> </td>
	                            <td align="right">
				                    <fmt:formatNumber value="${cartDetailItem.productDetail.productColor.product.price - (cartDetailItem.productDetail.productColor.product.price * cartDetailItem.productDetail.productColor.product.discount)}" type="number" minFractionDigits="0" maxFractionDigits="0"/>đ
				                </td>
				                <td align="right">
				                    <fmt:formatNumber value="${cartDetailItem.quantity * (cartDetailItem.productDetail.productColor.product.price - (cartDetailItem.productDetail.productColor.product.price * cartDetailItem.productDetail.productColor.product.discount))}" type="number" minFractionDigits="0" maxFractionDigits="0"/>đ
				                </td>
	                            <td align="center"><a href="#"><i class="bi bi-trash3"></i></a></td>
	                        </tr>
	                        <tr>
	                            <td align="right"> Size: ${cartDetailItem.productDetail.size.name}</td>
	                        </tr>
                		</c:forEach>
                    </tbody>
                </table>
                <button name="update-cart" class="btn btn-secondary mb-2"><i class="bi bi-arrow-clockwise"></i> Cập nhật giỏ hàng</button>
                <c:set var="tongTienHang" value="0"/>
                <c:set var="tongGiamGia" value="0"/>
                <c:forEach var="cartDetailItem" items="${cartDetails}">
                    <c:set var="price" value="${cartDetailItem.productDetail.productColor.product.price}"/>
                    <c:set var="totalPrice" value="${price * cartDetailItem.quantity}"/>
                    <c:set var="discount" value="${cartDetailItem.productDetail.productColor.product.price * cartDetailItem.productDetail.productColor.product.discount * cartDetailItem.quantity}"/>
                    <c:set var="tongTienHang" value="${tongTienHang + totalPrice}"/>
                    <c:set var="tongGiamGia" value="${tongGiamGia + discount}"/>
                </c:forEach>
                <h6 class="border-bottom py-1 fw-medium">Tổng: </h6>
                <div class="row justify-content-between border-bottom py-1">
                    <div class="col">Tổng tiền hàng:</div>
                    <div class="col text-end">
                        <fmt:formatNumber value="${tongTienHang}" type="number" minFractionDigits="0" maxFractionDigits="0"/>đ
                    </div>
                </div>
                <div class="row justify-content-between py-1">
                    <div class="col">Chi tiết giảm giá:</div>
                    <div class="col text-end">
                        <fmt:formatNumber value="${tongGiamGia}" type="number" minFractionDigits="0" maxFractionDigits="0"/>đ
                    </div>
                </div>
                <div class="row justify-content-between border-top py-1 my-3">
                    <div class="col fw-bold">Tổng tiền thanh toán:</div>
                    <div class="col text-end fw-bold" style="color: #b31f2a">
                        <fmt:formatNumber value="${tongTienHang - tongGiamGia}" type="number" minFractionDigits="0" maxFractionDigits="0"/>đ
                    </div>
                </div>
            </div>
            </div>
        </div>
    </form>
<%@ include file="../common/footer.jsp" %>
</body>
</html>
            