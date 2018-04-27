function no2() {
	window.close();
}

function tr1_a1() {
	var va = confirm("移入收藏后，将不再购物车显示，是否继续操作?")
	if(va) {
		alert("移入收藏成功!")
	}
}

function tr1_a2() {
	var va = confirm("您确定要删除商品吗?")
	if(va) {
		alert("删除成功!")
	}
}

function tr1_input1() {
	var a1 = document.getElementById("he1").value;
	if(parseInt(a1) > 1) {
		a1 = parseInt(a1) - 1;
		document.getElementById("he1").value = a1;
		var a2 = parseFloat(document.getElementById("money1").innerHTML);
		a2 = a2 - 21.90;
		document.getElementById("money1").innerHTML = a2.toFixed(2);
		var a3 = parseFloat(document.getElementById("he3").innerHTML);
		a3 = a3 - 21.90;
		document.getElementById("he3").innerHTML = a3.toFixed(2);
	} else {
		alert("不能再减了，再减就没有啦！");
	}
}

function tr1_input3() {
	var a1 = document.getElementById("he1").value;
	a1 = parseInt(a1) + 1;
	document.getElementById("he1").value = a1;
	var a2 = parseFloat(document.getElementById("money1").innerHTML);
	a2 = a2 + 21.90;
	document.getElementById("money1").innerHTML = a2.toFixed(2);
	var a3 = parseFloat(document.getElementById("he3").innerHTML);
	a3 = a3 + 21.90;
	document.getElementById("he3").innerHTML = a3.toFixed(2);
}

function tr2_input1() {
	var a1 = document.getElementById("he2").value;
	if(parseInt(a1) > 1) {
		a1 = parseInt(a1) - 1;
		document.getElementById("he2").value = a1;
		var a2 = parseFloat(document.getElementById("money2").innerHTML);
		a2 = a2 - 24.00;
		document.getElementById("money2").innerHTML = a2.toFixed(2);
		var a3 = parseFloat(document.getElementById("he3").innerHTML);
		a3 = a3 - 24.00;
		document.getElementById("he3").innerHTML = a3.toFixed(2);
	} else {
		alert("不能再减了，再减就没有啦！");
	}
}

function tr2_input3() {
	var a1 = document.getElementById("he2").value;
	a1 = parseInt(a1) + 1;
	document.getElementById("he2").value = a1;
	var a2 = parseFloat(document.getElementById("money2").innerHTML);
	a2 = a2 + 24.00;
	document.getElementById("money2").innerHTML = a2.toFixed(2);
	var a3 = parseFloat(document.getElementById("he3").innerHTML);
	a3 = a3 + 24.00;
	document.getElementById("he3").innerHTML = a3.toFixed(2);
}