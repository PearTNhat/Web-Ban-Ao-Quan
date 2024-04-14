$(".imgAdd").click(function () {
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
$(document).on("click", "i.del", function () {
  $(this).parent().remove();
});
$(function () {
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
          .closest(".imgUp")
          .find(".imagePreview")
          .css("background-image", "url(" + this.result + ")");
      };
    }
  });
});
