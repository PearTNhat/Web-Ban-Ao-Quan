$(document).ready(function() {
	function toggleDropdown() {
		if (window.matchMedia("(max-width: 955px)").matches) {
			$(".p-type").on("click", function() {
				var ul = $(this).next(".dd-type");
				if (ul.hasClass("dd-type-block")) {
					ul.removeClass("dd-type-block")
					ul.addClass("dd-type-none")
				} else {

					ul.removeClass("dd-type-none")
					ul.addClass("dd-type-block")
				}
			});
		} else {
			$(".p-type").off("click");
		}
	}

	// Run on initial load
	toggleDropdown();

	// Run on window resize
	$(window).resize(function() {
		toggleDropdown();
	});
});