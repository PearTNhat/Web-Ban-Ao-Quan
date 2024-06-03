<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>
	$(document).ready(function() {
		const success = "${success}"
		const error = "${error}"
		toastr.options = {
			"closeButton" : true,
			"debug" : false,
			"newestOnTop" : false,
			"progressBar" : true,
			"positionClass" : "toast-top-right", // Changed position to bottom left
			"preventDuplicates" : true, // Prevent duplicate toasts
			"onclick" : null,
			"showDuration" : "300",
			"hideDuration" : "1000",
			"timeOut" : "5000", // Toast will be displayed for 5 seconds
			"extendedTimeOut" : "1000",
			"showEasing" : "swing",
			"hideEasing" : "linear",
			"showMethod" : "fadeIn",
			"hideMethod" : "fadeOut"
		};
		console.log("zo",  "${error}");
		if (error) {
			toastr.error(error, 'Lỗi');
		}
		if (success) {
			toastr.success(success, 'Thành công');
		}

	});
</script>