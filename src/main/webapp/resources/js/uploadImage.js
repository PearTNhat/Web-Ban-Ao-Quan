//review anh
$(document).on(
	"change",
	".uploadFile",
	function() {
		var uploadFile = $(this);
		var files = !!this.files ? this.files : [];

		if (!files.length || !window.FileReader)
			return; // no file selected, or no FileReader support
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
				uploadFile.closest(".img-wrapper")
					.find(".imagePreview").css("background-image",
						"url(" + this.result + ")");
			};
		}
	});
//xoa preview anh
$(".delete-img ")
	.click(
		function() {
			$(".uploadFile").val(null);
			console.log($(".uploadFile"))
			$(this)
				.closest(".img-wrapper")
				.find(".imagePreview")
				.css(
					"background-image",
					"url('https://t4.ftcdn.net/jpg/05/65/22/41/240_F_565224180_QNRiRQkf9Fw0dKRoZGwUknmmfk51SuSS.jpg')");
		});