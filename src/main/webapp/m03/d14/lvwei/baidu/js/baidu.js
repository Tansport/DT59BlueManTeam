$(function() {

	$("#user").blur(checkUser);
	$("#pwd").blur(checkPass);
	$("#repwd").blur(checkRepass);
	checksex();
	$("#email").blur(checkemail);
	$("#myform").submit(function() {
		var flag = true;
		
		if(!checkUser()) flag = false;
		
		if(!checkPass()) flag = false;
		if(!checkRepass()) flag = false;
//		if(!checksex()) flag = false;
		if(!checkemail()) flag = false;
		return flag;

	})
})

//用户名
function checkUser() {
	var $user = $("#user");
	var $userId = $("#userId");
	$userId.html("");
	if($user.val() == " ") {
		$userId.html("用户名不能为空");
		return false;
	}
	if($user.val().length < 4 || $user.val().length > 12) {
		$userId.html("用户名长度为4~12个字符");
		return false;
	}
	var reg = /^[a-z0-9_-]{4,12}$/;
	if(reg.test($user.val()) == false) {
		$userId.html("用户名格式不正确，请重新输入");
		return false;
	}
	return true;
};
//密码
function checkPass() {
	var $pwd = $("#pwd");
	var $pwdId = $("#pwdId");
	$pwdId.html("");
	if($pwd.val() == " ") {
		$pwdId.html("密码不能为空");
		return false;
	}
	if($pwd.val().length < 6 || $pwd.val().length > 12) {
		$pwdId.html("密码必须为6~12个字符");
		return false;
	}
	return true;
};
//确认密码
function checkRepass() {
	var $repwd = $("#repwd");
	var $pwd = $("#pwd");
	var $repwdId = $("#repwdId");
	$repwdId.html("");
	if($pwd.val() != $repwd.val()) {
		$repwdId.html("两次输入的密码吗不一致");
		return false;
	}
	return true;
};
//性别
function checksex() {
	var $sex = $("：radio");
	var $sexId = $("#sexId");
	$sexId.html("");
	if(!$sex.checked) {
		$sexId.html("必须选择性别");
		return false;
	}
	return true;
};
//邮箱
function checkemail() {
	var $email = $("#email");
	var $emailId = $("#emailId");
	$emailId.html("");
	if($email.val() == " ") {
		$emailId.html("Email不能为空");
		return false;
	}
	if($email.val().indexOf("@") == -1) {
		$emailId.html("Email格式不正确，必须包含@");
		return false;
	}
	if($email.val().indexOf(".") == -1) {
		$emailId.html("Email格式不正确，必须包含.");
		return false;
	}
	return true;
};