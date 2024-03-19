<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
			padding: 60px 0;
		}
		#owl-demo .item img{
		  display: block;
		  width: 100%;
		  height: auto;
		  text-align:center;
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
	</style>
</head>

<body>
<%@ include file="com/header.jsp"%>
<%@ include file="com/footer.jsp"%>
		<%-- <section class="container-xl">${connStatus}</section> --%>
		<script src="https://code.jquery.com/jquery-3.7.1.min.js"
			integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
			crossorigin="anonymous"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"
			integrity="sha512-bPs7Ae6pVvhOSiIcyUClR7/q2OAsRiovw4vAkX+zJbw3ShAeeqezq50RIIcIURq7Oa20rW2n2q+fyXBNcU9lrw=="
			crossorigin="anonymous" referrerpolicy="no-referrer"></script>
		<script>
			$(document).ready(function() {
				$('.owl-carousel').owlCarousel({
					items : 1,
					lazyLoad : true,
					loop : true,
					margin : 0,
					dots : false,
					autoplay : true, // Enable autoplay
					autoplayTimeout : 10000, // Time between slide transitions (in milliseconds)
					animateOut: 'fadeOut',
					onInitialized: startProgressBar,
				    onTranslate: resetProgressBar,
				    onTranslated: startProgressBar
				});
				
				function startProgressBar() {
			      // apply keyframe animation
			      $(".slide-progress").css({
			        width: "100%",
			        transition: "width 10000ms"
			      });
			    }

			    function resetProgressBar() {
			      $(".slide-progress").css({
			        width: 0,
			        transition: "width 0s"
			      });
			    }
			    //Init progressBar where elem is $("#owl-demo")
			    function progressBar(elem){
			      $elem = elem;
			      //build progress bar elements
			      buildProgressBar();
			      //start counting
			      start();
			    }
			});
			
		</script>
	</body>
</html>