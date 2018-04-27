$(function() {
	$("li").hover(function() {
			$(this).children("div").show();
			$(this).toggleClass("orange");
		},
		function() {
			$(this).children("div").hide();
			$(this).toggleClass("orange");
		});
});