let mybutton = document.getElementById("btn-back-to-top");

if (mybutton) {
	// When the user scrolls down 20px from the top of the document, show the button
	window.onscroll = function() {
		scrollFunction();
	};

	function scrollFunction() {
		if (
			document.body.scrollTop > 300 ||
			document.documentElement.scrollTop > 300
		) {
			mybutton.style.opacity = 1;
		} else {
			mybutton.style.opacity = 0;
		}
	}
	// When the user clicks on the button, scroll to the top of the document
	mybutton.addEventListener("click", backToTop);

	function backToTop() {
		document.body.scrollTop = 0;
		document.documentElement.scrollTop = 0;
	}
}

// Carousel
$('#owl-demo-1').owlCarousel({
	items: 1,
	lazyLoad: true,
	loop: true,
	margin: 0,
	dots: false,
	autoplay: true, // Enable autoplay
	autoplayTimeout: 10000, // Time between slide transitions (in milliseconds)
	animateOut: 'fadeOut',
	onInitialized: startProgressBar,
	onTranslate: resetProgressBar,
	onTranslated: startProgressBar
});




$('#owl-demo-2').owlCarousel({
	rtl: true,
	loop: true,
	margin: 10,
	responsiveClass: true,
	nav: true,
	responsive: {
		0: {
			items: 2, // For small screens, show 2 items
			nav: true
		},
		768: {
			items: 3, // For medium screens and above (e.g., tablets), show 3 items
			nav: true
		},
		1200: { // Assuming 1200px is the breakpoint for XL screens and above
			items: 4, // For XL screens, show 4 items
			nav: true
		}
	}
})

$('#owl-product').owlCarousel({
	items: 1,
	lazyLoad: true,
	loop: false,
	dots: false,
	margin: 0,
	URLhashListener: true,
	autoplayHoverPause: true,
	startPosition: 'URLHash'
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
function progressBar(elem) {
	$elem = elem;
	//build progress bar elements
	buildProgressBar();
	//start counting
	start();
}

