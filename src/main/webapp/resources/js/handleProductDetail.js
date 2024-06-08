$(document).ready(function() {

    // Add more file input fields dynamically
    $(".imgAdd").click(function() {
		let count = $('.imgUp').length;
        const newImgUp = `
            <div class="col-12 col-sm-6 col-md-4 col-xl-3 imgUp">
                <div class="imagePreview"></div>
                <label class="btn btn-primary">
                    <i class="bi bi-upload"></i>
                    <input type="file" class="uploadFile img" name="files" value="Upload Photo"
                        style="width: 0px; height: 0px; overflow: hidden;" />
                </label>
                <input type="hidden" class="templImg" name="templImg[${count}]" />
                <i class="bi bi-x del"></i>
            </div>
        `;
        
        $(this).before(newImgUp);
    });
	$(document).on("click", "i.del", function() {
		let imgUp = $(this).closest(".imgUp");

		/* // Find the .uploadFile within the .imgUp ancestor
		let uploadFile = imgUp.find(".uploadFile");

		// Find the .imagePreview within the .imgUp ancestor
		let imagePreview = imgUp.find(".imagePreview");
		let currentBgImage = imagePreview.css('background-image')
			.replace(/^url\(["']?/, '').replace(/["']?\)$/, '');

		// Check if the current background image starts with the specific URL and does not exist in removeImage
		if (currentBgImage.startsWith("https://res.cloudinary.com/") && !removeImage.includes(currentBgImage)) {
			removeImage.push(currentBgImage);
		} */
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
					// Get the closest .imgUp and then find the .imagePreview within it
					let imagePreview = uploadFile.closest(".imgUp").find(".imagePreview");
					let templImg = uploadFile.closest(".imgUp").find(".templImg");
					templImg.val(this.result);
					/* previewImgs.push(this.result);
					let currentBgImage = imagePreview.css('background-image')
						.replace(/^url\(["']?/, '').replace(/["']?\)$/, '');

					// Check if the current background image starts with the specific URL and does not exist in removeImage
					if (currentBgImage.startsWith("https://res.cloudinary.com/") && !removeImage.includes(currentBgImage)) {
						removeImage.push(currentBgImage);
					}
					console.log(removeImage) */
					
					imagePreview.css("background-image", "url(" + this.result + ")");
				};
			}
		});
	});
})