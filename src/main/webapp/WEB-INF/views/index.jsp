<%@ include file="header.jsp"%>
		<section class="container-xl">${connStatus}</section>
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