<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav
	class="navbar navbar-expand-lg navbar-light my-3 container-fluid sticky-top bg-white">
	<div class="container-xl">
		<a class="navbar-brand" href="#"> <img
			src="https://4menshop.com/logo.png?v=1" alt="Logo" width="90"
			height="60" class="d-inline-block align-text-top">
		</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse justify-content-end me-5"
			id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="#">HÀNG BÁN
						CHẠY</a></li>
				<li class="nav-item"><a onclick="open_ao()" class="nav-link"
					href="#">ÁO NAM</a>
					<ul class="nav-ao">
						<li>Áo sơ mi</li>
						<li>Áo thun</li>
						<li>Áo polo</li>
						<li>Áo Khoác</li>
						<li>Áo Len</li>
					</ul></li>
				<li class="nav-item"><a onclick="open_quan()" class="nav-link"
					href="#">QUẦN NAM</a>
					<ul class="nav-quan">
						<li>Quần jeans</li>
						<li>Quần tây</li>
						<li>Quần kaki</li>
						<li>Quần jogger</li>
						<li>Quần short</li>
					</ul></li>
			</ul>
		</div>
		<div class="navbar-search d-none d-md-block">
			<i onclick="open_search()" class="fa fa-search" aria-hidden="true"></i>
			<input
				style="font-size: 12px; font-family: courier, arial, helvetica;"
				type="text" class="act-search" placeholder="Tìm kiếm">
		</div>
		<div class="navbar-shopping d-none d-md-block">
			<i class="fas fa-shopping-cart"></i>
		</div>
	</div>

</nav>