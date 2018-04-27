$(function() {
	$("li.on").hover(
		function() {
			$("ul.topDown").show("slow");
		},
		function() {
			$("ul.topDown").hide("fast");
		}
	);

	$("nav.nav ul dt").toggle(
		function() {
			$(this).siblings().slideDown("slow");
		},
		function() {
			$(this).siblings().slideUp("slow");
		}
	)
});