<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../common/header.jsp" %>

<body>
<%@ include file="../component/topbar.jsp" %>
<%@ include file="../component/navbar.jsp" %>


	<div class="page-break container-fluid border border-bottom">
    </div>

    <div class="login-form container-xl">
        <div class="row justify-content-center my-4">
            <div class="col-7 d-none d-lg-block">
                <img src="https://cdn.dribbble.com/users/988448/screenshots/5240042/icon_cadastro_v5.gif"
                    alt="" class="img-fluid">
            </div>
            <div class="col-10 col-md-5">
                <div class="display-6 fw-bold text-danger">Đăng ký
                </div>
                <div class="lead text-muted my-1 fs-6">Đăng kí để tận hưởng trải nghiệm mua sắm trọn vẹn tại 4 MENS
                </div>
                <form:form class="mt-4 needs-validation" modelAttribute="user" enctype="multipart/form-data" novalidate="novalidate">
                    <div class="row g-2 my-3">
                        <div class="col-5">
                            <div class="form-floating">
                                <form:input path="firstName" type="text" class="form-control ${submit && firstNameErr ? 'is-invalid' : '' } ${submit && !firstNameErr ? 'is-valid' : ''}" id="firstName" placeholder="firstname"/>
                                <form:label path="firstName" for="firstName">* Họ</form:label>
                            </div>
	                        <form:errors path="firstName" cssClass="invalid-feedback d-block"/>
                        </div>
                        <div class="col-7">
                            <div class="form-floating">
                                <form:input path="lastName" type="text" class="form-control ${submit && lastNameErr ? 'is-invalid' : '' } ${submit && !lastNameErr ? 'is-valid' : ''}" id="lastName" placeholder="lastname" />
                                <form:label path="lastName" for="lastName">* Tên</form:label>
                                <form:errors path="lastName" cssClass="invalid-feedback d-block"/>
                            </div>
                        </div>
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="address">Địa chỉ</span>
                        <form:input path="address" type="text" class="form-control ${submit && addressErr ? 'is-invalid' : '' }" placeholder="52 Man Thiện. Phường Tăng Nhơn Phú A"
                            aria-label="adress" aria-describedby="address" />
                        <form:errors path="address" cssClass="invalid-feedback d-block"/>
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="email">* Email</span>
                        <form:input path="email" type="text" class="form-control ${submit && emailErr ? 'is-invalid' : '' } ${submit && !emailErr ? 'is-valid' : ''} ${submit && accountError ? 'is-invalid' : '' }" placeholder="4mens@example.com" aria-label="address"
                            aria-describedby="email" />
                        <form:errors path="email" cssClass="invalid-feedback d-block"/>
						<c:if test="${accountError == true}">
							<div class="invalid-feedback d-block">Email đã tồn tại trên hệ thống</div>
						</c:if>
                    </div>
                    <div class="form-floating col-12 my-3">
                        <form:input path="password" type="password" class="form-control ${submit && passwordErr ? 'is-invalid' : '' } ${submit && !passwordErr ? 'is-valid' : ''}" id="password" placeholder="password" />
                        <label for="password">* Mật khẩu</label>
                        <form:errors path="password" cssClass="invalid-feedback d-block"/>
                    </div>
                    <div class="form-floating col-12 my-3">
                        <form:input path="confirmPassword" type="password" class="form-control ${submit && confirmPasswordErr ? 'is-invalid' : '' } ${submit && !confirmPasswordErr ? 'is-valid' : ''} ${submit && passwordNotMatch ? 'is-invalid' : '' }" id="checkpassword"
                            placeholder="password" />
                        <label for="checkpassword">* Nhập lại mật khẩu</label>
                        <form:errors path="confirmPassword" cssClass="invalid-feedback d-block"/>
                        <c:if test="${passwordNotMatch == true}">
							<div class="invalid-feedback d-block">Nhập lại mật khẩu không trùng khớp</div>
						</c:if>
                    </div>
                    <div class="mb-3">
                        <label for="formFile" class="form-label">Tải ảnh avatar:</label>
                        <form:input path="avatar" class="form-control ${submit && imageError ? 'is-invalid' : '' }" type="file" id="formFile" />
                        <form:errors path="avatar" cssClass="invalid-feedback d-block"/>
                        <c:if test="${imageError == true}">
							<div class="invalid-feedback d-block">Tải ảnh thất bại</div>
						</c:if>
                    </div>
                      
                    <button type="submit" class="btn btn-danger col-12">Đăng ký</button>
                </form:form>
                <div class="have-account my-3">
                    Bạn đã có tài khoản?
                    <a href="user/login.htm" class="link link-primary">Đăng nhập</a>
                </div>
            </div>
        </div>
    </div>
	 
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"
        integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"
        integrity="sha512-bPs7Ae6pVvhOSiIcyUClR7/q2OAsRiovw4vAkX+zJbw3ShAeeqezq50RIIcIURq7Oa20rW2n2q+fyXBNcU9lrw=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        
     <script src="resources/js/commonJS.js"></script>
   
	
    
	</body>
</html>

<%@ include file="../common/footer.jsp" %>