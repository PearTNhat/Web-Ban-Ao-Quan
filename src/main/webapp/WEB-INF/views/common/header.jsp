<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<base href="${pageContext.servletContext.contextPath}/">

<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css">
<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous" defer></script>

<!-- Thư viện ClassicEditor  -->
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>


<!-- Owl carousel -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css"
	integrity="sha512-tS3S5qG0BlhnQROyJXvNjeEM4UpMXHrQfTGmbQ1gKmelCxlSEBUaxhRBj/EFTzpbP4RVSrpEikbmdJobCvhE3g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.theme.default.min.css"
	integrity="sha512-sMXtMNL1zRzolHYKEujM2AqCLUR9F2C4/05cdbxjjLSRvMQIciEPCQZo++nk7go3BtSuK9kfa/s+a4f4i5pLkw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<!--  jquery-->
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="resources/css/footer/footer.css">
<link rel="stylesheet" href="resources/css/home/nav-top-bar.css">
<title>Web ban hang</title>

<style>
html {
	font-family: Arial, Helvetica, sans-serif;
}

.thumbnails {
	display: flex;
	justify-content: center;
	flex-wrap: wrap;
	gap: 5px;
}

.thumbnails a {
	flex: 1 1 calc(20% - 10px);
	max-width: calc(20% - 10px);
	margin-bottom: 10px;
}

.thumbnails img {
	width: 100%;
	height: auto;
	display: block;
}

@media ( max-width : 600px) {
	.cart-container {
		width: 100%;
		position: fixed;
		top: 80px;
		left: 0;
	}
	.cart-container::after {
		width: 100%;
	}
}

html {
	font-family: Arial, Helvetica, sans-serif;
}

.thumbnails {
	display: flex;
	justify-content: center;
	flex-wrap: wrap;
	gap: 5px;
}

.thumbnails a {
	flex: 1 1 calc(20% - 10px);
	max-width: calc(20% - 10px);
	margin-bottom: 10px;
}

.thumbnails img {
	width: 100%;
	height: auto;
	display: block;
}

@media ( max-width : 600px) {
	.cart-container {
		width: 100%;
		position: fixed;
		top: 80px;
		left: 0;
	}
	.cart-container::after {
		width: 100%;
	}
}

.navbar-toggler-icon {
	width: 1.1em;
	height: 1.1em;
}

.top-bar {
	background-color: #292929;
	font-size: 13px
}

.top-bar a {
	border-right: 1.5px solid #3a3a3a;
}

.top-bar a, i:not(.cart-icon) {
	color: #ccc !important;
	font-weight: 600;
}

i.logout {
	color: black !important;
}

section {
	padding: 60px 0;
}

.nav-ao, .nav-quan {
	display: none;
	list-style: none;
	position: absolute;
	/* padding: 0 8px; */
	padding: 0;
	background-color: #fff;
	/* box-shadow: 0 0 5px rgba(0,0,0,0.3); */
}

.nav-ao li, .nav-quan li {
	padding: 8px;
	font-size: small;
	border-bottom: 1px solid #ededed;
	border-top: 1px solid #ededed;
	cursor: pointer;
}

.navbar-search {
	position: relative;
}

.navbar-search .act-search {
	display: none;
	position: absolute;
	margin-left: -260px;
	margin-top: 0px;
	width: 300px;;
	padding: 10px 15px;
	border: rgb(104, 5, 5) solid 1px;
	animation: appear 0.3 ease;
}

.navbar-search i, .navbar-shopping i {
	background-color: #ededed;
	padding: 8px;
	border: 1px solid #ededed;
	color: rgb(104, 5, 5);
	margin-left: 7px;
	border-radius: 2px;
}

.navbar-search i:hover, .navbar-shopping i:hover {
	border: 1px solid rgb(104, 5, 5);
	cursor: pointer;
	transition: 0.5s all;
}

.navbar-search .bi-x {
	font-size: larger;
	padding: 2px 2px;
}

.navbar-search form {
	right: -100%;
	top: 52px;
}

.search-sub {
	padding: 8px;
	transform: translateY(5px);
	border: none;
	color: #502a2a;
}

.cart-container {
	display: none;
}

.cart:hover .cart-container {
	display: block;
}

.cart-container::after {
	content: "";
	position: absolute;
	width: 59px;
	height: 30px;
	top: -23px;
	right: 0;
	display: block;
	background-color: transparent;
}

.cart-container {
	position: absolute;
	width: 400px;
	background: #fff;
	border: 1px solid #ccc;
	color: #000;
	border-radius: 5px;
	top: 53px;
	right: -12px;
	font-size: 15px;
	z-index: 100;
}

.cart-container small {
	display: block;
	font-size: 13px;
	color: #444;
	padding: 10px;
	border-bottom: 1px solid rgb(232, 232, 232);
}

.cart-container small span {
	color: #b31f2a;
}

.cart-items {
	font-size: 14px;
	padding: 0 0 10px 0;
	max-height: 350px;
	overflow-y: auto;
}

.cart-item {
	list-style: none;
	display: flex;
	padding-left: 0;
	padding: 10px;
	border-bottom: 1px solid rgb(232, 232, 232);
	margin-bottom: 10px;
}

.cart-item:hover {
	background-color: #e5e4e4;
}

.cart-items .cart-detail {
	padding-left: 10px;
}

.cart-detail p {
	line-height: 14px;
	margin-bottom: 10px;
}

.cart-detail i {
	font-size: 16px;
}

.cart-detail i:hover {
	color: red;
}

.cart-container button {
	display: block;
	margin-top: 10px;
	font-size: 11px;
	font-weight: 500;
	outline: none;
	border: none;
	color: #fff;
	background: #333333;
	border-radius: 4px;
	padding: 8px;
}

.cart-container button:hover {
	background: #b31f2a;
}

.user {
	position: relative;
	cursor: pointer;
}

.user:hover .user-feature {
	display: block;
}

.user-feature {
	position: absolute;
	display: none;
	border: 1px solid #ccc;
	width: 200px;
	background: #fff;
	color: #000;
	border-radius: 5px;
	top: 108%;
	right: 0;
	font-size: 15px;
	padding: 0;
	transition: all .4s;
}

.user-feature::before {
	content: "";
	position: absolute;
	width: 50px;
	height: 10px;
	background-color: transparent;
	top: -10px;
	right: 0;
}

.user-feature li {
	cursor: pointer;
	padding: 10px;
}

.user-feature li a {
	text-decoration: none;
	color: #000;
}

.user-feature li:hover {
	background-color: #ededed;
}

@media ( min-width : 995px) {
	.nav-ao, .nav-quan {
		width: 200px;
	}
	.navbar-nav li:nth-child(2):hover a, .navbar-nav li:nth-child(3):hover a
		{
		color: #b31f2a
	}
	.navbar-nav li:nth-child(2):hover ul, .navbar-nav li:nth-child(3):hover ul
		{
		display: block;
	}
	.nav-ao li:hover, .nav-quan li:hover {
		opacity: 0.8;
		color: #b31f2a;
		background-color: #eeeeee;
	}
	.nav-ao, .nav-quan {
		box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
	}
	.navbar-shopping {
		position: relative;
	}
}

@media ( max-width : 995px) {
	.open-max-1000 {
		display: block;
	}
	.display-none {
		display: none !important;
	}
	.nav-ao li:hover, .nav-quan li:hover {
		opacity: 0.8;
		color: #b31f2a;
		background-color: #eeeeee;
	}
	.nav-ao, .nav-quan {
		position: relative;
	}
	.nav-ao ul {
		width: 100%;
	}
	.navbar-nav li:nth-child(2):hover a, .navbar-nav li:nth-child(3):hover a
		{
		background-color: #eeeeee;
	}
}
</style>
