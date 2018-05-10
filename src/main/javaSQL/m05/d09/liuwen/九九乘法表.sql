--使用for循环实现九九乘法表
declare
  i int:=0;
  j int:=0;
begin
  for i in 1..9 loop
      for j in 1..i loop
      Dbms_Output.put(i||'*'||j||'='||i*j);
      dbms_output.put(' ');
      end loop;
      dbms_output.new_line;
  end loop;
end;

--使用while循环实现九九乘法表
declare
  i int:=1;
  j int:=1;
begin
    while i<=9 loop
    j:=1;
          while j<=i loop
                Dbms_Output.put(i||'*'||j||'='||i*j);
                dbms_output.put(' ');
                j:=j+1;
          end loop;
          dbms_output.new_line;
    i:=i+1;
   end loop;
end;
 
 --使用loop循环用实现九九乘法表
declare
   i int:=1;
   j int:=1;
begin
   loop
     loop
       Dbms_Output.put(i||'*'||j||'='||i*j);
       dbms_output.put(' ');
       j:=j+1;
     exit when j>i;
     end loop;
   dbms_output.put_line('');
   i:=i+1;
   j:=1;
   exit when i>9;
   end loop;
 end;
