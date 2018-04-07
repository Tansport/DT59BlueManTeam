CREATE TABLE question_info(
	questionId INT PRIMARY KEY AUTO_INCREMENT COMMENT'试题编号',
	 question VARCHAR(300) NOT NULL COMMENT'题干',
	 optionA VARCHAR(300) NOT NULL COMMENT'选项A',
	 optionB VARCHAR(300) NOT NULL COMMENT'选项B',
	 optionC VARCHAR(300) NOT NULL COMMENT'选项C',
	 optionD VARCHAR(300) NOT NULL COMMENT'选项D',
	 SUBJECT INT NOT NULL COMMENT'1代表Java,2代表C#,3代表JSP',
	 answer VARCHAR(10) NOT NULL COMMENT'正确答案'

)
INSERT INTO question_info VALUES(1,',在Java中，以下合法的变量名是（）。','选项A:_Sum',
	'选项B:var%','选项C:9var','选项D:My name','1','答案:A');
INSERT INTO question_info VALUES(2,',以下关于Java类和对象描述正确的是（）。',
'选项A:一个类只能有一个对象','选项B:对象是类的具体实例',
'选项C:对象是对现实世界中客观事物的抽象','选项D:使用class关键字定义一个对象','3','答案:B');
INSERT INTO question_info VALUES(3,',在WinFrom中，消息框的返回值为（）类型。',
'选项A:MessageBox','选项B:DialogResult',
'选项C:Yes','选项D:No','2','答案:B');
INSERT INTO question_info VALUES(4,',在C#中，以下非法的变量名是（）。',
'选项A:$avg','选项B:count_1','选项C:num%','选项D:3name','2','答案:C');

SELECT * FROM question_info