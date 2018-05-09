declare
v_char1 varchar2(100);
v_char2 varchar2(100); 
v_c char(1); --中间变量
begin
v_char1 :='&请输入数字'; --替换变换 
dbms_output.put_line('输入的数据为:'||v_char1);
for i in reverse 1..length(v_char1)
loop
    v_c := substr(v_char1,i,1); 
    v_char2 := v_char2 ||v_c;
end loop;
dbms_output.put_line('反转后的数字为:'||v_char2);
end;
