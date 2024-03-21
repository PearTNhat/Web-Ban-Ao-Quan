<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"
        defer></script>

    <!-- Jquery -->

    <!-- Owl carousel -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css"
        integrity="sha512-tS3S5qG0BlhnQROyJXvNjeEM4UpMXHrQfTGmbQ1gKmelCxlSEBUaxhRBj/EFTzpbP4RVSrpEikbmdJobCvhE3g=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.theme.default.min.css"
        integrity="sha512-sMXtMNL1zRzolHYKEujM2AqCLUR9F2C4/05cdbxjjLSRvMQIciEPCQZo++nk7go3BtSuK9kfa/s+a4f4i5pLkw=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />

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
            transition: transform 0.3s ease-in-out, filter 0.3s ease-in-out, opacity 0.3s linear;
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
        
        .top-bar a, i{
            color: #ccc !important;
            font-weight: 600;
        }
        
        #btn-back-to-top {
		  position: fixed;
		  bottom: 20px;
		  right: 20px;
		  display: none;
		}
    </style>
</head>
