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
--菱形
declare   
     v_l number:=&请输入行数（奇数）;--命名方式：变量_行数  
     v_c number;--控制打印*的个数  命名方式：变量_字符数  
     v_s number;--控制打印的空格数  命名方式：变量_空格数  
begin  
     if(v_l mod 2=0) then   
      dbms_output.put_line('请输入奇数！');      
     else  
       for i in 0..v_l-1  
        loop   
         --判断打印*的个数 和空格个数  
          if(i>v_l/2) then  
           v_c:=(v_l-i-1)*2+1;  --根据最大行以上的各行个数来做   比如 打印五行 则第三行为中间数 第四行和第二行的个数相同  则只需计算出()*2+1 括号中的数字即可  
           v_s:=(v_l-v_c)/2;    --根据行号和*的个数来做空格的个数   
          else   
           v_c:=i*2+1;   
           v_s:=(v_l-v_c)/2;    --根据行号和*的个数来做空格的个数   
          end if ;    
           
          --打印空格的个数  
          for j in 1..v_s  
          loop   
          dbms_output.put(' ');    
          end loop;  
          --打印*的个数  
          for j in 1..v_c  
          loop   
          dbms_output.put('*');    
          end loop;  
        dbms_output.put_line('');   
        end loop;  
      end if;  
end;  
--镂空菱形
declare 
   cnt number :=20;
   i number;
begin
   i:= cnt/2;
   
   dbms_output.put_line(lpad('*',i+1,' '));
   while i>1 loop
     begin
       dbms_output.put(lpad('*',i,' '));
       dbms_output.put_line(lpad('*',22-i*2,' '));
     end;
     i := i-1;
   end loop;
   
   while i<cnt/2 +1 loop
     begin
       dbms_output.put(lpad('*',i,' '));
       dbms_output.put_line(lpad('*',22-i*2,' '));
     end;
     i := i+1;
   end loop;
   dbms_output.put_line(lpad('*',i,' '));
end;

--反转输出
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


 
