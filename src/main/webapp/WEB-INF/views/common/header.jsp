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
<link rel="stylesheet" href="resources/css/home/home.css">
<!-- <link rel="stylesheet" href="resources/css/listProduct.css"> -->
<link rel="stylesheet" href="resources/css/footer/footer.css">

<title>Web ban hang</title>

<style>
section {
	padding: 40px 0;
}

#owl-demo .item img {
	display: block;
	width: 100%;
	height: auto;
	text-align: center;
}

.slide-progress {
	width: 0;
	max-width: 100%;
	height: 4px;
	background: rgba(0, 0, 0, .2);
}

.img-container {
	height: fit-content;
	overflow: hidden;
}

.img-container img {
	transition: transform 0.3s ease-in-out, filter 0.3s ease-in-out, opacity
		0.3s linear;
}

.img-container img:hover {
	transform: scale(1.1);
	opacity: .8;
}

.top-bar {
	background-color: #292929;
	font-size: 13px
}

.top-bar a {
	border-right: 1.5px solid #3a3a3a;
}

.top-bar a, i {
	color: #ccc !important;
	font-weight: 600;
}

#btn-back-to-top {
	position: fixed;
	bottom: 20px;
	right: 20px;
	opacity: 0;
	transition: all .2s;
}

/*  product */
table.cart-table a.cart-link {
	text-decoration: none;
	color: #b31f2a;
	transition: all .2s;
}

table.cart-table a.cart-link:hover {
	color: #444444;
}

.img-wrapper {
	margin: auto;
	width: 100px;
}

.imagePreview {
	position: relative;
	margin: auto;
	width: 100px;
	height: 100px;
	background-image:
		url("https://t4.ftcdn.net/jpg/05/65/22/41/240_F_565224180_QNRiRQkf9Fw0dKRoZGwUknmmfk51SuSS.jpg");
	border: 1px solid #ccc;
	background-size: cover;
	background-position: center;
	background-repeat: no-repeat;
	border-radius: 50%;
}

.btn-upload {
	position: absolute;
	width: 100%;
	height: 100%;
	border-radius: 50%;
}

</style>

<script>    
    //review anh
        $(document).on("change", ".uploadFile", function () {
            var uploadFile = $(this);
            var files = !!this.files ? this.files : [];

            if (!files.length || !window.FileReader) return; // no file selected, or no FileReader support
            if (/^image/.test(files[0].type)) {
                const type = files[0].type.split("/")[1];
                if (type != "jpeg" && type != "png" && type != "jpg") {
                    return alert("Only jpeg, jpg, png files are allowed");
                }
                // only image file
                var reader = new FileReader(); // instance of the FileReader
                reader.readAsDataURL(files[0]); // read the local file
                reader.onloadend = function () {
                    // set image data as background of div
                    //alert(uploadFile.closest(".upimage").find('.imagePreview').length);
                    uploadFile
                        .closest(".img-wrapper")
                        .find(".imagePreview")
                        .css("background-image", "url(" + this.result + ")");
                };
            }
        });
    //xoa preview anh
     $(".delete-img ").click(function () {
            $(".uploadFile").val(null);
            console.log($(".uploadFile"))
            $(this).closest(".img-wrapper").find(".imagePreview").css("background-image", "url('https://t4.ftcdn.net/jpg/05/65/22/41/240_F_565224180_QNRiRQkf9Fw0dKRoZGwUknmmfk51SuSS.jpg')");
        });
   
    </script>


</head>