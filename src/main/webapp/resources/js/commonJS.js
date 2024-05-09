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


// image product
$(".imgAdd").click(function() {
	$(this)
		.closest(".row")
		.find(".imgAdd")
		.before(
			`
      <div class="col-12 col-sm-6 col-md-4 col-xl-3 imgUp">
        <div class="imagePreview"></div>
        <label class="btn btn-primary">
          <i class="bi bi-upload"></i>
          <input type="file" class="uploadFile img" value="Upload Photo"
            style="width: 0px;height: 0px;overflow: hidden;" />
        </label>
        <i class="bi bi-x del"></i>
        </div>
      `
		);
});
$(document).on("click", "i.del", function() {
	$(this).parent().remove();
});
$(function() {
	$(document).on("change", ".uploadFile", function() {
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
			reader.onloadend = function() {
				// set image data as background of div
				//alert(uploadFile.closest(".upimage").find('.imagePreview').length);
				uploadFile
					.closest(".imgUp")
					.find(".imagePreview")
					.css("background-image", "url(" + this.result + ")");
			};
		}
	});
});
// CK editor
ClassicEditor
	.create(document.querySelector('#editor'), {
		toolbar: {
			items: [
				'bold', 'italic', 'underline',
				'link', 'bulletedList', 'numberedList'
			]
		}
	})
	.then(editor => {
		console.log('CKEditor 5 initialized', editor);
	})
	.catch(error => {
		console.error(error);
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
let mybutton = document.getElementById("btn-back-to-top");

// When the user scrolls down 20px from the top of the document, show the button
window.onscroll = function() {
	scrollFunction();
};

function scrollFunction() {
	if (
		document.body.scrollTop > 20 ||
		document.documentElement.scrollTop > 20
	) {
		mybutton.style.display = "block";
	} else {
		mybutton.style.display = "none";
	}
}
// When the user clicks on the button, scroll to the top of the document
mybutton.addEventListener("click", backToTop);

function backToTop() {
	document.body.scrollTop = 0;
	document.documentElement.scrollTop = 0;
}
