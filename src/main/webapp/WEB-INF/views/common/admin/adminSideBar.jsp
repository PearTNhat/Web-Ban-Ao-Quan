<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<body>
	<div class="wrapper vh-100">
		<aside id="sidebar" class="expand">
			<div class="d-flex">
				<button class="toggle-btn" type="button">
					<i class="lni lni-grid-alt"></i>
				</button>
				<div class="sidebar-logo">
					<a href=".htm">4Mens</a>
				</div>
			</div>
			<ul class="sidebar-nav">
				<li class="sidebar-item"><a href="dash-board.htm" class="sidebar-link">
						<i class="bi bi-speedometer2"></i> <span>Dashboard</span>
				</a></li>
				<li class="sidebar-item"><a href="#"
					class="sidebar-link collapsed has-dropdown"
					data-bs-toggle="collapse" data-bs-target="#acc"
					aria-expanded="false" aria-controls="acc"> <i
						class="bi bi-person"></i> <span>Accounts</span>
				</a>
					<ul id="acc" class="sidebar-dropdown list-unstyled collapse"
						data-bs-parent="#sidebar">
						<li class="sidebar-item"><a href="admin/accounts.htm"
							class="sidebar-link ps-5"> <i class="bi bi-person-check-fill"></i>
								Users
						</a></li>
					</ul></li>
				<li class="sidebar-item"><a href="#"
					class="sidebar-link collapsed has-dropdown"
					data-bs-toggle="collapse" data-bs-target="#product"
					aria-expanded="false" aria-controls="product"> <i
						class="bi bi-box-seam"></i> <span>Products</span>
				</a>
					<ul id="product" class="sidebar-dropdown list-unstyled collapse"
						data-bs-parent="#sidebar">
						<li class="sidebar-item"><a href="admin/products.htm"
							class="sidebar-link ps-5"> <i class="bi bi-cart4"></i>
								Product
						</a></li>
						<li class="sidebar-item"><a href="#"
							class="sidebar-link ps-5"> <i class="bi bi-bag-fill"></i>
								Register
						</a></li>
					</ul></li>
			</ul>
			<div class="sidebar-footer">
				<a href="#" class="sidebar-link"> <i class="lni lni-exit"></i> <span>Logout</span>
				</a>
			</div>
		</aside>