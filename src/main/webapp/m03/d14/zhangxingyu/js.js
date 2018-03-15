
$(function() {
	$("#user").blur(User);
	$("#pwd").blur(Pwd);
	$("#repwd").blur(RePwd);
	$("#email").blur(Email);
	$("#myform").submit(function() {
		var flag = true;
		if (!User()) flag = false;
		if (!Pwd()) flag = false;
		if (!RePwd) flag = false;
		if (!Email) flag = false;
		return flag;
	})
})

function User() {
	var $user = $("#user");
	var $userId = $("#userId");
	$userId.html("");
	if ($user.val() == " ") {
		$userId.html("用户名不能为空");
		return false;
	}
	if ($user.val().length < 4 || $user.val().length > 12) {
		$userId.html("用户名长度为4~12个字符");
		return false;
	}
	var reg = /^[a-z/.0-9_-]{4,12}$/;
	if (reg.test($user.val()) == false) {
		$userId.html("用户名格式不正确，请重新输入");
		return false;
	} else {
		return true;
	}
};

function Pwd() {
	var $pwd = $("#pwd");
	var $pwdId = $("#pwdId");
	$pwdId.html("");
	if ($pwd.val() == " ") {
		$pwdId.html("密码不能为空");
		return false;
	}
	if ($pwd.val().length < 6 || $pwd.val().length > 12) {
		$pwdId.html("密码必须为6~12个字符");
		return false;
	} else {
		return true;
	}
};

function RePwd() {
	var $repwd = $("#repwd");
	var $pwd = $("#pwd");
	var $repwdId = $("#repwdId");
	$repwdId.html("");
	if ($pwd.val() != $repwd.val()) {
		$repwdId.html("两次输入的密码吗不一致");
		return false;
	} else {
		return true;
	}
};

function Email() {
	var $email = $("#email");
	var $emailId = $("#emailId");
	$emailId.html("");
	if ($email.val() == " ") {
		$emailId.html("电子邮箱不能为空！");
		return false;
	}
	if ($email.val().indexOf("@") == -1) {
		$emailId.html("电子邮箱格式不正确，必须包含@");
		return false;
	}
	if ($email.val().indexOf(".") == -1) {
		$emailId.html("电子邮箱格式不正确，必须包含.");
		return false;
	}
	var eee = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/
	if (eee.test($email.val()) == false) {
		$emailId.html("电子邮箱格式不正确，请重新输入");
		return false;
	} else {
		return true;
	};
};