<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/admin/adminHeader.jsp"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">

<style>
body {
	color: #566787;
	background: #f5f5f5;
	font-family: 'Varela Round', sans-serif;
	font-size: 13px;
}

.table-responsive {
	padding-top: 10px;
	min-width: 900px;
	display: flex;
	flex-direction: column;
	height: 100%;
}

.table-wrapper {
	min-width: 700px;
	background: #fff;
	padding: 20px 25px;
	border-radius: 3px;
	box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
}

.table-title {
	padding-bottom: 15px;
	background: #299be4;
	color: #fff;
	padding: 16px 30px;
	margin: -20px -25px 10px;
	border-radius: 3px 3px 0 0;
}

.table-title h2 {
	margin: 5px 0 0;
	font-size: 24px;
}

.table-title .btn {
	float: right;
	font-size: 13px;
	border: none;
	min-width: 50px;
	border-radius: 2px;
	border: none;
	outline: none !important;
	margin-left: 10px;
}

.table-title .btn i {
	float: left;
	font-size: 21px;
	margin-right: 5px;
}

.table-title .btn span {
	float: left;
	margin-top: 2px;
}

table.table tr th, table.table tr td {
	border-color: #e9e9e9;
	padding: 12px 15px;
	vertical-align: middle;
}

table.table tr th:first-child {
	width: 60px;
}

table.table tr th:last-child {
	width: 100px;
}

table.table-striped tbody tr:nth-of-type(odd) {
	background-color: #fcfcfc;
}

table.table-striped.table-hover tbody tr:hover {
	background: #f5f5f5;
}

table.table th i {
	font-size: 13px;
	margin: 0 5px;
	cursor: pointer;
}

table.table td:last-child i {
	opacity: 0.9;
	font-size: 22px;
	margin: 0 5px;
}

table.table td a {
	font-weight: bold;
	color: #566787;
	display: inline-block;
	text-decoration: none;
}

table.table td a:hover {
	color: #2196F3;
}

table.table td a.settings {
	color: #2196F3;
}

table.table td a.delete {
	color: #F44336;
}

table.table td i {
	font-size: 19px;
}

table.table .avatar {
	border-radius: 50%;
	vertical-align: middle;
	margin-right: 10px;
}

.text-success {
	color: #10c469;
}

/* pagination */
.pagination {
	gap: 10px;
}

.pagination li a {
	color: #333;
}

.page-link:hover {
	background-color: rgb(179, 31, 42);
	box-shadow: none;
}

.page-link:hover:not(.page-active) {
	color: #23527c;
	background-color: #eee;
	border-bottom: 1px solid #666;
}

.page-link:focus {
	box-shadow: none;
}

.page-active {
	background-color: rgb(179, 31, 42);
	color: #fff !important;
	box-shadow: none;
}

.page-item:first-child .page-link {
	border-top-left-radius: 0;
	border-bottom-left-radius: 0;
}

.page-item:last-child .page-link {
	border-top-right-radius: 0;
	border-bottom-right-radius: 0;
}
/*  not foubd */
.not-found {
	font-size: 30px;
	text-align: center;
	display: flex;
	justify-content: center;
	align-items: center;
	flex-basis: 100%;
}
/*  */
.search-box {
	position: relative;
	float: right;
}

.search-box input {
	height: 34px;
	border-radius: 20px;
	padding-left: 35px;
	border-color: #ddd;
	box-shadow: none;
}

.search-box input:focus {
	border-color: #3FBAE4;
}

.search-box i {
	color: #a0a5b1;
	position: absolute;
	font-size: 19px;
	top: 8px;
	left: 10px;
}

</style>

</head>
<%@ include file="../../common/admin/adminSideBar.jsp"%>
<div class="container-xl overflow-auto">
	<div class="table-responsive">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-5">
						<h2>Quản lí tài khoản admin</h2>
					</div>
					<div class="col-7">
						<div class="d-flex align-items-center justify-content-end">
							<div class="search-box d-flex align-items-center">
								<i class="material-icons">&#xE8B6;</i> <input type="text"
									id="search-input" class="form-control"
									placeholder="Search admin&hellip; ">
							</div>
							<a href="admin/accounts.htm?search=" id="search"
								class="btn btn-success">Search</a>
						</div>
					</div>

				</div>
			</div>
		</div>
		<div>${message}</div>
		<c:choose>
			<c:when test="${accounts.size() == 0}">
				<div class="not-found">Không tồn tại tài khoản nào</div>
			</c:when>

			<c:otherwise>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>Index</th>
							<th>Name</th>
							<th>Email</th>
							<th>Admin</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="a" items="${accounts }" varStatus="s">
							<tr>
								<td>${(page-1)*limit + s.index+1}</td>
								<td><a href="#"><img
										src="https://www.tutorialrepublic.com/examples/images/avatar/2.jpg"
										class="avatar" alt="Avatar"> ${a.firstName} ${a.lastName }</a>
								</td>
								<td>${a.email }</td>
								<td><c:choose>
										<c:when test="${a.isAdmin ==true }">

											<i class="bi bi-check-circle text-success"></i>
										</c:when>
										<c:otherwise>
											<i class="bi bi-x-circle text-danger"></i>
										</c:otherwise>
									</c:choose></td>

								<td><a href="admin/delete/${a.accountId}.htm?btnDelete"
									class="delete"><i class="material-icons" title="Delete">&#xE872;</i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<!-- pagination -->
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
		search.href = "admin/accounts.htm?page=1&search=" + searchInput.value;
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
	      element.href ="admin/accounts.htm?page="+${page-1}+"&search="+searchValue;
	    }
	    // next
	    else if (index === pageElement.length - 1) {
	      if(pageValue >= ${pages}){
	    	 e.preventDefault();
	        return;
	      }
	      element.href = "admin/accounts.htm?page="+${page+1}+"&search="+searchValue;
	 
	    }
	    else  {
		    const clickPage = element.textContent;
		    element.href = "admin/accounts.htm?page="+clickPage+"&search="+searchValue;
	    	
	    }
	
  	});
});
</script>
</body>

</html>