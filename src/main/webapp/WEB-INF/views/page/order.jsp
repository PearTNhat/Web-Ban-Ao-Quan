<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">


    <!-- Owl carousel -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css"
        integrity="sha512-tS3S5qG0BlhnQROyJXvNjeEM4UpMXHrQfTGmbQ1gKmelCxlSEBUaxhRBj/EFTzpbP4RVSrpEikbmdJobCvhE3g=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.theme.default.min.css"
        integrity="sha512-sMXtMNL1zRzolHYKEujM2AqCLUR9F2C4/05cdbxjjLSRvMQIciEPCQZo++nk7go3BtSuK9kfa/s+a4f4i5pLkw=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
        <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <title>Web ban hang</title>
    <style>
        section {
            padding: 60px 0;
        }

        .open {
            display: block !important;
            transition: 0.5s;
        }

        html {
            font-family: Arial, Helvetica, sans-serif;
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
            overflow: hidden;
        }

        .img-container img {
            transition: transform 0.3s ease-in-out, filter 0.3s ease-in-out, opacity 0.3s linear;
        }

        .img-container img:hover {
            transform: scale(1.1);
            opacity: .8;
        }

        /* .navbar-nav li:nth-child(2){
            position: relative;
        } */
        .nav-ao,
        .nav-quan {
            display: none;
            list-style: none;
            position: absolute;
            /* padding: 0 8px; */
            padding: 0;
            background-color: #fff;
            /* box-shadow: 0 0 5px rgba(0,0,0,0.3); */
        }

        .nav-ao li,
        .nav-quan li {
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
            position: fixed;
            margin-left: -260px;
            margin-top: 0px;
            width: 300px;
            ;
            padding: 5px 15px;
            border: rgb(104, 5, 5) solid 1px;
            animation: appear 0.3 ease;
        }

        .navbar-search i,
        .navbar-shopping i {
            background-color: #ededed;
            padding: 8px;
            border: 1px solid #ededed;
            color: rgb(104, 5, 5);
            margin-left: 7px;
            border-radius: 2px;
        }

        .navbar-search i:hover,
        .navbar-shopping i:hover {
            border: 1px solid rgb(104, 5, 5);
            cursor: pointer;
            transition: 0.5s;
        }

        .navbar-search .bi-x {
            font-size: larger;
            padding: 2px 2px;
        }

        .container-image-item img {
            width: 100%;
        }

        .images-item {
            display: flex;
        }

        .images-item img {
            width: calc(20% - 10px);
            margin: 5px;
        }

        .images-item img:hover {
            border: 2px solid aqua;
        }

        .title-name {
            margin: 16px;
        }

        .review-item .fa-star {
            color: #ffcc01;
        }

        .other-color-item span {
            margin: 20px 0;
        }

        .other-color-item img {
            margin-right: 5px;
        }

        .other-color-item a {
            text-decoration: none;
        }

        .other-color-item {
            border-bottom: 2px solid #ededed;
            padding-bottom: 20px;
        }

        .other-color-item img:hover {
            cursor: pointer;
        }

        .price-cost {
            text-decoration: line-through;
        }

        .choose-size button {
            align-items: center;
            background: #fff;
            border: 1px solid rgba(0, 0, 0, .09);
            border-radius: 2px;
            box-sizing: border-box;
            color: rgba(0, 0, 0, .8);
            cursor: pointer;
            display: inline-flex;
            justify-content: center;
            margin: 8px 8px 0 0;
            min-height: 2.5rem;
            min-width: 5rem;
            outline: 0;
            overflow: visible;
            padding: .5rem;
            position: relative;
            text-align: left;
            word-break: break-word;
        }

        .choose-size button:hover {
            border: 1px solid #b31f2a;
            color: #b31f2a;
        }

        #id-quantity {
            cursor: text;
            text-align: center;
            border: 1px solid #ededed;
            max-width: 80px;
        }

        .choose-quantity {
            margin-top: 20px;
        }

        #decrease,
        #increase {
            border: 1px solid #ededed;
            padding: 1px 12px;
            background-color: #fff;
        }

        .add-order .fa-shopping-cart {
            background: rgba(255, 87, 34, .1);
            background: rgba(255, 87, 34, 0.1);
            border: 1px solid #ee4d2d;
            box-shadow: 0 1px 1px 0 rgba(0, 0, 0, .03);
            color: #ee4d2d;
            outline: 0;
            overflow: visible;
            position: relative;
            padding: 14px 15px;
            max-width: 100%;
            margin: 15px;
        }

        .add-order .fa-shopping-cart:hover {
            cursor: pointer;
            transition: 0.5s;
        }

        .buy-now {
            background: #ee4d2d;
            border: 1px solid #ee4d2d;
            box-shadow: 0 1px 1px 0 rgba(0, 0, 0, .03);
            color: #fff;
            outline: 0;
            overflow: visible;
            position: relative;
            padding: 10px 55px;
            max-width: 100%;
            margin: 15px;
        }

        .order-item {
            margin-top: 20px;
        }

        @keyframes appear {
            from {
                transform: rotate(-45deg)
            }

            to {
                transform: translateX(0deg);
            }
        }

        .order {
            background-color: aqua;
            width: 80%;
            height: 500px;
            position: fixed;
            top: 150px;


            z-index: 1;

        }

        @media (min-width: 1000px) {

            .nav-ao,
            .nav-quan {
                width: 200px;
            }

            .navbar-nav li:nth-child(2):hover a,
            .navbar-nav li:nth-child(3):hover a {
                color: #b31f2a
            }

            .navbar-nav li:nth-child(2):hover ul,
            .navbar-nav li:nth-child(3):hover ul {
                display: block;

            }

            .nav-ao li:hover,
            .nav-quan li:hover {
                opacity: 0.8;
                color: #b31f2a;
                background-color: #eeeeee;
            }

            .nav-ao,
            .nav-quan {
                box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
            }
        }

        @media (max-width: 1000px) {
            .open-max-1000 {
                display: block;
            }

            .nav-ao li:hover,
            .nav-quan li:hover {
                opacity: 0.8;
                color: #b31f2a;
                background-color: #eeeeee;
            }

            .nav-ao,
            .nav-quan {
                position: relative;
            }

            .nav-ao ul {
                /* width: 200px; */
                width: 100%;
            }

            .navbar-shopping {
                position: absolute;
                right: 0;
                margin-right: 70px;
                top: 20px;
                zoom: 1.2;
            }

            .navbar-search {
                position: absolute;
                right: 0;
                top: 20px;
                margin-right: 120px;
                zoom: 1.2;
            }

            .navbar-nav li:nth-child(2):hover a,
            .navbar-nav li:nth-child(3):hover a {
                background-color: #eeeeee;
            }

        }
    </style>

</head>

<body>
    <nav class="navbar sticky-top navbar-expand-lg navbar-light container-fluid bg-white">
        <div class="container-xl">
            <a class="navbar-brand" href="#"> <img src="https://4menshop.com/logo.png?v=1" alt="Logo" width="90"
                    height="60" class="d-inline-block align-text-top">
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse justify-content-end me-5" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item"><a class="nav-link" href="#">HÀNG BÁN CHẠY</a></li>
                    <li class="nav-item"><a onclick="open_ao()" class="nav-link" href="#">ÁO NAM</a>
                        <ul class="nav-ao">
                            <li>Áo sơ mi</li>
                            <li>Áo thun</li>
                            <li>Áo polo</li>
                            <li>Áo Khoác</li>
                            <li>Áo Len</li>
                        </ul>
                    </li>
                    <li class="nav-item"><a onclick="open_quan()" class="nav-link" href="#">QUẦN NAM</a>
                        <ul class="nav-quan">
                            <li>Quần jeans</li>
                            <li>Quần tây</li>
                            <li>Quần kaki</li>
                            <li>Quần jogger</li>
                            <li>Quần short</li>
                        </ul>
                    </li>
                </ul>
            </div>
            <div class="navbar-search d-none d-md-block">
                <i onclick="open_search()" class="fa fa-search" aria-hidden="true"></i>
                <input style="
                font-size:12px;
                font-family:courier,arial,helvetica;
                " type="text" class="act-search" placeholder="Tìm kiếm">
            </div>
            <div class="navbar-shopping d-none d-md-block">
                <i class="fas fa-shopping-cart"></i>
            </div>
        </div>


    </nav>
    <div class="order-container container-lg">
        <div class="row">
            <div class="col-md-4 col-sm-6">
                <img src="https://4menshop.com/images/thumbs/2019/08/ao-vest-nazafu-mau-xam-1139-10932-slide-products-5d42d398e4349.JPG"
                    alt="" class="img-fluid">
                <div class="images-item">
                    <img src="https://4menshop.com/images/thumbs/2019/08/ao-vest-nazafu-mau-xam-1139-10932-slide-products-5d42d398e4349.JPG"
                        alt="" class="img-fluid">
                    <img src="https://4menshop.com/images/thumbs/2019/08/ao-vest-nazafu-mau-xam-1139-10932-slide-products-5d42d3a158746.JPG"
                        alt="">
                    <img src="https://4menshop.com/images/thumbs/2019/08/ao-vest-nazafu-mau-xam-1139-10932-slide-products-5d42d3a1aaf63.JPG"
                        alt="">
                    <img src="https://4menshop.com/images/thumbs/2019/08/ao-vest-nazafu-mau-xam-1139-10932-slide-products-5d42d3a203017.JPG"
                        alt="">
                    <img src="https://4menshop.com/images/thumbs/2019/08/ao-vest-nazafu-mau-xam-1139-10932-slide-products-5d42d3a23db73.JPG"
                        alt="">
                </div>
            </div>
            <div class="col-md-8 col-sm-6">
                <h2 class="title-name">ÁO VEST NAZAFU MÀU XANH BÍCH AV1139</h2>
                <div class="price-item ms-3">
                    <p style="font-size: x-large;">
                        <span class="price-now" style="color: #b31f2a;">₫300000</span>

                        <span class="price-cost" style="font-size: large;">₫500000</span>
                    </p>
                </div>
                <div class="review-item ms-3">
                    <span class="rate">4.9</span>
                    <span class="act fa fa-star" aria-hidden="true"></span> <span class="act fa fa-star"
                        aria-hidden="true"></span> <span class="act fa fa-star" aria-hidden="true"></span> <span
                        class="act fa fa-star" aria-hidden="true"></span> <span class="act fa fa-star"
                        aria-hidden="true"></span> <em> (116 đánh giá / 264
                        lượt mua)</em>
                </div>
                <div class="other-color-item ms-3">
                    <span style="display: block;">MÀU KHÁC</span>
                    <a href="">
                        <img src="https://4menshop.com/cache/image/70/images/thumbs/2019/08/ao-vest-nazafu-mau-xanh-den-1138-10930.JPG"
                            alt="">
                    </a>
                    <a href="">
                        <img src="https://4menshop.com/cache/image/70/images/thumbs/2019/08/ao-vest-nazafu-mau-da-bo-1139-10931.JPG"
                            alt="">
                    </a>
                    <a href="">
                        <img src="https://4menshop.com/cache/image/70/images/thumbs/2019/08/ao-vest-nazafu-mau-caro-den-1139-10933.JPG"
                            alt="">

                    </a>
                </div>
                <div class="choose-size ms-3" style="margin-top: 10px;">
                    <span style="margin-right: 20px;">SIZE</span>
                    <button id="S">S</button>
                    <button id="M">M</button>
                    <button id="L">L</button>
                    <button id="XL">XL</button>

                </div>
                <div class="choose-quantity ms-3">
                    <span style="margin-right: 20px;">SỐ LƯỢNG</span>
                    <button id="decrease" onclick="btn_decrease()">&#8722;</button>
                    <input type="text" id="id-quantity" style="display: inline-block;" value="1">
                    <button id="increase" onclick="btn_increase()">&#43;</button>
                </div>
                <div class="order-item">
                    <div class="add-order" style="display: inline-block;">

                        <i class="fas fa-shopping-cart"> Thêm vào giỏ hàng</i>
                    </div>
                    <button class="buy-now">Mua ngay</button>
                </div>
                <div class="description-item">
                    <a href="">Xem chi tiết sản phẩm</a>
                </div>
            </div>
        </div>
    </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"
        defer></script>
    <script>
        // var btn_item = document.querySelectorAll('.nav-item');
        // onclick.btn_ao = function(){
        //     btn_ao.style.display = 'block';
        // }
        var ok = 1;
        function open_ao() {
            var js_ao = document.querySelector('.nav-ao');
            if (js_ao.classList.contains("open-max-1000")) {
                js_ao.classList.remove("open-max-1000");
            } else {
                js_ao.classList.add("open-max-1000")
            }
        }
        function open_quan() {
            var js_quan = document.querySelector('.nav-quan');
            if (js_quan.classList.contains("open-max-1000")) {
                js_quan.classList.remove("open-max-1000");
            } else {
                js_quan.classList.add("open-max-1000")
            }
        }
        function open_search() {
            var js_search = document.querySelector('.act-search');
            if (js_search.classList.contains("open")) {
                js_search.classList.remove("open");
            } else {
                setTimeout(() => {
                    js_search.classList.add("open");
                }, 10);
            }

        }
        window.addEventListener('click', function (event) {
            if (event.target.className === 'act-search open') return;
            var js_search = document.querySelector('.act-search');

            if (js_search.classList.contains("open")) {
                js_search.classList.remove("open");
            }
        });

        document.addEventListener('click', function(event) {
            if (js_search.classList.contains("open")){
                js_search.classList.remove("open");
            }
        });
        $(document).ready(function () {

            $("#owl-demo").owlCarousel({

                autoPlay: 3000, //Set AutoPlay to 3 seconds

                items: 4,
                itemsDesktop: [1199, 3],
                itemsDesktopSmall: [979, 3]

            });

        });
        function btn_decrease() {
            if (document.getElementById('id-quantity').value > 1)
                document.getElementById('id-quantity').value--;
        }
        function btn_increase() {
            // var js_quantity = document.getElementById('id-quantity').value;
            // alert(js_quantity);
            document.getElementById('id-quantity').value++;
        }
     
        
        document.getElementById('id-quantity').addEventListener('input',function (e){
        this.value  =e.target.value.replace(/[^0-9]/g, '');
        });
    </script>

</body>

</html>