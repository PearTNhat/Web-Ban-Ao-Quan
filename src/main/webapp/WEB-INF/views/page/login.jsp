<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp" %>

<body>
<%@ include file="../component/topbar.jsp" %>
<%@ include file="../component/navbar.jsp" %>

	<div class="page-break container-fluid border border-bottom">
    </div>

    <div class="login-form container-lg">
        <div class="row justify-content-center my-5">
            <div class="col-7 d-none d-lg-block">
                <img src="https://previews.123rf.com/images/artinspiring/artinspiring1809/artinspiring180900781/110045594-man-choosing-clothes-in-the-clothing-store-searching-for-fashion-shirt-shop-assitant-helps-customer.jpg" alt="" class="img-fluid">
            </div>
            <div class="col-10 col-md-5">
                <div class="display-6 fw-bold">Sign in to
                    <img src="resources/images/4men-192x192.png" alt="Logo" width="80" height="80"
                    class="d-inline">
                </div>
                <form action="">
                    <div class="form-floating mb-3">
                        <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
                        <label for="floatingInput">Email</label>
                      </div>
                      <div class="form-floating">
                        <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
                        <label for="floatingPassword">Password</label>
                      </div>
                      <div class="d-flex my-3 justify-content-between">
                          <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                            <label class="form-check-label" for="flexCheckDefault">
                              Remember me
                            </label>
                          </div>
                          <a href="" class="link link-secondary">Quên mật khẩu</a>
                      </div>
                      <button type="submit" class="btn btn-danger col-12">Đăng nhập</button>
                      <div class="signup-option my-3">
                        Hoặc
                        <a href="user/signup.htm" class="link link-primary">Tạo tài khoản</a>
                      </div>
                </form>
            </div>
        </div>
    </div>    
<%@ include file="../common/footer.jsp" %>