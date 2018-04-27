$(function() {
	$("li").hover(function() {
			var index = $("li").index(this);
			$("li div:eq(" + index + ")").show();
			$("li:eq(" + index + ")").toggleClass("orange");
		},
		function() {
			var index = $("li").index(this);
			$("li div:eq(" + index + ")").hide();
			$("li:eq(" + index + ")").toggleClass("orange");
		}
	);
});