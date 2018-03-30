DELIMITER ;;
CREATE PROCEDURE ups_test_01()
BEGIN
	SELECT  * FROM question_info;
END
;;
DELIMITER ;

CALL ups_test_01();

DELIMITER ;;
CREATE PROCEDURE ups_test_02(IN srt VARCHAR(300))
BEGIN
	SELECT * FROM question_info WHERE question LIKE srt;
END
;;
DELIMITER ;

CALL ups_test_02('%变量名%');

DROP PROCEDURE ups_test_02;