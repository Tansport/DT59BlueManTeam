declare
v_char1 varchar2(100);
v_char2 varchar2(100); 
v_c char(1); --�м����
begin
v_char1 :='&����������'; --�滻�任 
dbms_output.put_line('���������Ϊ:'||v_char1);
for i in reverse 1..length(v_char1)
loop
    v_c := substr(v_char1,i,1); 
    v_char2 := v_char2 ||v_c;
end loop;
dbms_output.put_line('��ת�������Ϊ:'||v_char2);
end;
