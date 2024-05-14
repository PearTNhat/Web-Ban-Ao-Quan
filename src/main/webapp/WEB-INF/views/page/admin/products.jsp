<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/admin/adminHeader.jsp"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="resources/css/admin/mangageProducts.css">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
</head>
<%@ include file="../../common/admin/adminSideBar.jsp"%>
<div class="container-xl overflow-auto">
	<div class="table-responsive">
		<div class="table-wrapper position-md-relative">
			<div class="table-title">
				<div class="row">
					<div class="col-5">
						<h2 class="text-left">Quản lí sản phẩm</h2>
					</div>
					<div class="col-7">
						<div class="d-flex align-items-center justify-content-end ">
							<div class="search-box d-flex align-items-center">
								<i class="material-icons">&#xE8B6;</i> <input type="text"
									class="form-control" id="search-input" placeholder="Tìm kiếm tên sản phẩm&hellip; ">
							</div>
							<a href="#" class="btn btn-success" id="search"><i
								class="material-icons">&#xE147;</i> <span>Search</span></a>
						</div>
					</div>

				</div>
			</div>
		</div>
		<c:choose>
			<c:when test="${products.size() == 0}">
				<div class="not-found">Không tồn tại tài khoản nào</div>
			</c:when>

			<c:otherwise>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>Name</th>
							<th>Quantity</th>
							<th>Price</th>
							<th>Giảm giá</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="p" items="${products }" varStatus="s">
							<tr>
								<td>${(page-1)*limit + s.index+1}</td>
								<td><a href="#"><img
										src="https://4menshop.com/cache/image/300x400/images/thumbs/2024/03/tui-canvas-den-phoi-trang-tx017-18422.jpg"
										class="avatar" alt="Avatar">${p.name}</a></td>

								<td>${p.quantity }</td>
								<td><fmt:formatNumber value="${p.price }" type="currency" /></td>

								<td><fmt:formatNumber value="${ p.discount}" type="percent" /></td>
								<td>
									<div class="d-flex">
										<a href="./addProduct/addProduct.html" class="edit"><i
											class="material-icons" title="Edit">&#xE254;</i></a> <a href="">
											<svg xmlns="http://www.w3.org/2000/svg" width="16"
												height="16" fill="currentColor" class="bi bi-three-dots"
												viewBox="0 0 16 16">
                    <path
													d="M3 9.5a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3m5 0a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3m5 0a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3" />
                  </svg>
										</a> <a href="#l" class="delete"><i
											class="material-icons" title="Delete">&#xE872;</i></a>

									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
					<nav class="d-flex justify-content-center border-top py-4"
					aria-label="Page navigation">
					<ul class="pagination">
						<li class="page-item"><a class="page-link" href="#"
							aria-label="Previous"> <span> &laquo; </span>
						</a></li>
						<c:forEach begin="1" end="${pages}" varStatus="s">
							<li class="page-item"><a
								class="page-link ${s.index == page ? 'page-active' : ''}"
								href="#">${s.index}</a></li>
						</c:forEach>
						<li class="page-item"><a class="page-link" href="#"
							aria-label="Next"> &raquo; </a></li>
					</ul>
				</nav>
			</c:otherwise>
		</c:choose>
	</div>
</div>
</div>
<script>
const search = document.querySelector('#search');
const searchInput = document.querySelector('#search-input');
const pageElement = document.querySelectorAll('a.page-link');

search.addEventListener('click', handleSubmit);
function handleSubmit(e) {
	search.href = "admin/products.htm?page=1&search=" + searchInput.value;
}
var url = new URL(window.location.href);
// Get the search parameter value
var searchValue = url.searchParams.get("search") || "";
searchInput.value = searchValue
/* pagination */
pageElement.forEach((element, index) => {
	element.addEventListener("click", (e) => {
    const url = new URL(window.location.href);
    const searchValue = url.searchParams.get("search") || "";
    const pageValue = url.searchParams.get("page") || 1;
    //prev
    if (index === 0) {
      if (pageValue <= 1) {
	   	e.preventDefault();
        return;
      }
      element.href ="admin/products.htm?page="+${page-1}+"&search="+searchValue;
    }
    // next
    else if (index === pageElement.length - 1) {
      if(pageValue >= ${pages}){
    	 e.preventDefault();
        return;
      }
      element.href = "admin/products.htm?page="+${page+1}+"&search="+searchValue;
 
    }
    else  {
	    const clickPage = element.textContent;
	    element.href = "admin/products.htm?page="+clickPage+"&search="+searchValue;
    	
    }

	});
});
</script>
</body>
</html>