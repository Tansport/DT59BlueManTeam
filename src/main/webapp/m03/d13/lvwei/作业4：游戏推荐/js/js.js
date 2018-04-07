$(function() {
	$("#listbox dl dd:last-of-type").click(function() {
		$(this).parent("dl").remove();
	})
	$("input").click(function() {
		var $new = "<dl><dt><img src ='images/p4.jpg'/></dt> <dd >大航海家OL </dd><dd><a class='del'href='javascript:void(0);' >删除 </a></dd></dl>";
		$(".no1 ").after($new);
		$("#listbox dl dd:last-of-type").click(function() {
		$(this).parent("dl").remove();
	})
	})
})