  v_downrow:= v_row-v_uprow;
  for v_i in reverse 1..v_downrow loop
    --占坑
      for v_j in 1..v_downrow-v_i+1 loop
    dbms_output.put(' ');
      end loop;
      for v_k in 1..2*v_i-1 loop
    if(v_k=1 or v_k=2*v_i-1) then
      dbms_output.put('*');
    else 
      dbms_output.put(' ');
    end if;
      end loop;
      dbms_output.put_line('');
  end loop;
end;

declare
 v_number number; --输入的数字
 v_i number;
 v_n number;
begin
 v_number:='&请输入一个整数';
 v_i:=1;
 while(v_number/v_i>1)loop
	v_n:=floor(mod(v_number/v_i,10));
	dbms_output.put_line(v_n);
	v_i:=v_i*10;
 end loop;
end;
