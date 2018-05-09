declare
cnt number :=&请输入行数（奇数）;   
i number;
begin
i:= cnt/2;
dbms_output.put_line(lpad('*',i+1,' '));
while i>1 loop
begin
dbms_output.put(lpad('*',i,' '));
dbms_output.put_line(lpad('*',(cnt+2)-i*2,' '));
end;
i := i-1;
end loop;
while i<cnt/2 +1 loop
begin
dbms_output.put(lpad('*',i,' '));       
dbms_output.put_line(lpad('*',(cnt+2)-i*2,' '));     
end;     
i := i+1;   
end loop;   
dbms_output.put_line(lpad('*',i,' '));
end;
