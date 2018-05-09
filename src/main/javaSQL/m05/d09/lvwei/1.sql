declare 
i number := 1; 
j number := 1; 
begin 
 for i in 1 .. 9 loop 
  for j in 1 .. i loop 
   dbms_output.put(j || ' x '|| i || ' = ' || i*j || '   '); 
  end loop; 
  dbms_output.put_line('   '||chr(13)); 
 end loop; 
end; 
