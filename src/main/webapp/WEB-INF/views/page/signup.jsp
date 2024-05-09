<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp" %>

<body>
<%@ include file="../component/topbar.jsp" %>
<%@ include file="../component/navbar.jsp" %>


	<div class="page-break container-fluid border border-bottom">
    </div>

    <div class="login-form container-xl">
        <div class="row justify-content-center my-5">
            <div class="col-7 d-none d-lg-block">
                <img src="https://cdn.dribbble.com/users/988448/screenshots/5240042/icon_cadastro_v5.gif"
                    alt="" class="img-fluid">
            </div>
            <div class="col-10 col-md-5">
                <div class="display-6 fw-bold text-danger">Đăng ký
                </div>
                <div class="lead text-muted my-1 fs-6">Đăng kí để tận hưởng trải nghiệm mua sắm trọn vẹn tại 4 MENS
                </div>
                <form action="" class="mt-4">
                    <div class="row g-2 my-3">
                        <div class="col-5">
                            <div class="form-floating">
                                <input type="text" class="form-control" id="firstName" placeholder="firstname">
                                <label for="firstName">Họ</label>
                            </div>
                        </div>
                        <div class="col-7">
                            <div class="form-floating">
                                <input type="text" class="form-control" id="lastName" placeholder="lastname">
                                <label for="lastName">Tên</label>
                            </div>
                        </div>
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="basic-addon1">Địa chỉ</span>
                        <input type="text" class="form-control" placeholder="52 Man Thiện. Phường Tăng Nhơn Phú A"
                            aria-label="Username" aria-describedby="basic-addon1">
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="basic-addon1">Email</span>
                        <input type="text" class="form-control" placeholder="4mens@example.com" aria-label="Username"
                            aria-describedby="basic-addon1">
                    </div>
                    <div class="form-floating col-12 my-3">
                        <input type="password" class="form-control" id="password" placeholder="password">
                        <label for="password">Mật khẩu</label>
                    </div>
                    <div class="form-floating col-12 my-3">
                        <input type="password" class="form-control is-invalid" id="checkpassword"
                            placeholder="password">
                        <label for="checkpassword">Nhập lại mật khẩu</label>
                    </div>
                    <div class="mb-3">
                        <label for="formFile" class="form-label">Tải ảnh avatar:</label>
                        <input class="form-control" type="file" id="formFile">
                      </div>
                      
                    <button type="submit" class="btn btn-danger col-12">Đăng ký</button>
                </form>
                <div class="have-account my-3">
                    Bạn đã có tài khoản?
                    <a href="login.htm" class="link link-primary">Đăng nhập</a>
                </div>
            </div>
        </div>
    </div>
	
    <section class="container-xl">${connStatus}</section> 
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"
        integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"
        integrity="sha512-bPs7Ae6pVvhOSiIcyUClR7/q2OAsRiovw4vAkX+zJbw3ShAeeqezq50RIIcIURq7Oa20rW2n2q+fyXBNcU9lrw=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        
     <script src="resources/js/commonJS.js"></script>
   
	
    
	</body>
</html>