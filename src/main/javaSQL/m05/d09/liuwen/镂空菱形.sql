declare
  v_row number(4);
  v_uprow number(4);
  v_downrow number(4);
begin
  v_row:='&请输入菱形的行数';
  while(mod(v_row,2)=0) loop
    v_row:='&请输入菱形的行数';
  end loop;
  v_uprow:=(v_row+1)/2;
  for v_i in 1..v_uprow loop
      --占坑
      for v_j in 1..v_uprow-v_i loop
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
