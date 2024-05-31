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

    <div class="login-form container-lg">
        <div class="row justify-content-center my-5">
            <div class="col-7 d-none d-lg-block">
                <img src="https://previews.123rf.com/images/artinspiring/artinspiring1809/artinspiring180900781/110045594-man-choosing-clothes-in-the-clothing-store-searching-for-fashion-shirt-shop-assitant-helps-customer.jpg" alt="" class="img-fluid">
            </div>
            <div class="col-10 col-md-5">
                <div class="display-6 fw-bold">Sign in to ${loginError}
                    <img src="resources/images/4men-192x192.png" alt="Logo" width="80" height="80"
                    class="d-inline">
                </div>
                <c:if test="${loginError == true}">
					<div class="invalid-feedback d-block mb-3">Email hoặc mật khẩu không đúng</div>
				</c:if>
                <form:form class="needs-validation" modelAttribute="user" novalidate="novalidate">
                    <div class="form-floating mb-3">
                       <form:input path="email" type="email" class="form-control" id="floatingInput" placeholder="name@example.com" />
                       <form:label path="email" for="floatingInput">Email</form:label>
                       <form:errors path="email" cssClass="invalid-feedback d-block"/>
                     </div>
                     <div class="form-floating">
                       <form:input path="password" type="password" class="form-control" id="floatingPassword" placeholder="Password" />
                       <form:label path="password" for="floatingPassword">Password</form:label>
                       <form:errors path="password" cssClass="invalid-feedback d-block"/>
                     </div>
                     <div class="d-flex my-3 justify-content-between">
                         <div class="form-check">
                           <form:checkbox path="rememberMe" class="form-check-input" id="flexCheckDefault" />
                           <form:label path="rememberMe" class="form-check-label" for="flexCheckDefault">
                             Ghi nhớ tài khoản
                           </form:label>
                         </div>
                         <a href="" class="link link-secondary">Quên mật khẩu?</a>
                     </div>
                     <button type="submit" class="btn btn-danger col-12">Đăng nhập</button>
                     <div class="signup-option my-3">
                       Hoặc
                       <a href="user/signup.htm" class="link link-primary">Tạo tài khoản</a>
                     </div>
                </form:form>
            </div>
        </div>
    </div>    
<%@ include file="../common/footer.jsp" %>