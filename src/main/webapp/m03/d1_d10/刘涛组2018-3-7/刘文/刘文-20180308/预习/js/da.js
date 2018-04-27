$(document).ready(function() {
	//设置h2标签的样式
	$("#mydiv h2").css({
		"background": "#2a65ba",
		"color": "#ffffff",
		"text-align": "left"
	});
	//最后一个li，设置为无边框
	$("#mydiv li:last").css("border", "none");

	//第一个li，设置字体和颜色
	$("#mydiv li:first").css({
		"font-size": "20px",
		"color": "#e90202"
	});
	//li的偶数行
	$("#mydiv li:even").css("background-color", "aquamarine");

	//li的奇数行
	$("#mydiv li:odd").css("background-color", "bisque");
});

$(document).ready(function() {
	//用过滤选择器给h2标签设置背景颜色，以及字体颜色
	$("#mydiv :header").css({
		"background-color": "#2a65ba",
		"color": "#ffffff",
		"text-align": "left"
	});

	//最后一个li没有边框
	$("#mydiv li:last").css("border", "none");

	//设置前2个li的字体颜色（从0开始，小于2）
	$("#mydiv li:lt(2)").css("color", "#708b02");

	//设置后2个li的字体颜色（从0开始，大于3）
	$("#mydiv li:gt(3)").css("color", "#b66302");
});