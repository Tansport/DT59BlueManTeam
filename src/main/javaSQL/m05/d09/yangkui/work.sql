--九九乘法表
declare 
  x int; 
  y varchar2(100);
begin
  for m in 1..9 loop
  y:='';
  for n in 1..m loop
  x:=m*n;
  y:= y || ' ' || m || '*' || n || '=' || x;
  end loop;
  dbms_output.put_line(substr(y,2));
     end loop;
end;

--镂空菱形
declare 
   cnt number;
   i number;
   x number;
begin
    cnt :='&请输入奇数';
    begin
    if mod(cnt, 2) = 0 then
             --dbms_output.put_line('及格!');
              --cnt :='&请输入奇数';
              dbms_output.put_line('您输入的不是奇数，请输入奇数');
       else
            --cnt :='&您输入的不是偶数，请输入偶数';
   i:= cnt/2;
   x:=cnt+2;
   dbms_output.put_line(lpad('*',i+1,' '));
   while i>1 loop
     begin
       dbms_output.put(lpad('*',i,' '));
       dbms_output.put_line(lpad('*',x-i*2,' '));
     end;
     i := i-1;
   end loop;
   
   while i<cnt/2 +1 loop
     begin
       dbms_output.put(lpad('*',i,' '));
       dbms_output.put_line(lpad('*',x-i*2,' '));
     end;
     i := i+1;
   end loop;
   dbms_output.put_line(lpad('*',i,' '));  
       end if;
       end;
end;

--反转
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




