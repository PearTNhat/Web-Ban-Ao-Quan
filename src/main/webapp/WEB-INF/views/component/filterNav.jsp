<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div
			class="collapse navbar-collapse justify-content-end me-5 order-lg-2"
			id="navbarNav">
			<ul class="navbar-nav me-2">
				<li class="nav-item"><a class="nav-link" href="#">HÀNG BÁN
						CHẠY</a></li>
				<c:forEach var="pt" items="${pts}">
					<li class="nav-item"><span class="nav-link text-uppercase p-type">${pt.name}</span>

						<ul class="dd-type dd-type-none">
							<c:forEach var="typeDetail" items="${pt.types}">
								<li>${typeDetail.name}</li>
							</c:forEach>
						</ul></li>

				</c:forEach>
			</ul>
			<form class="d-flex my-2" role="search">
				<input class="form-control search me-2 shadow-none border"
					type="search" placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-secondary" type="submit">
					<i class="bi bi-search"></i>
				</button>
			</form>
		</div>