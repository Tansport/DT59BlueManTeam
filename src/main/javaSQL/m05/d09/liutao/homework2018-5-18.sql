--�žų˷���
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
--����
declare   
     v_l number:=&������������������;--������ʽ������_����  
     v_c number;--���ƴ�ӡ*�ĸ���  ������ʽ������_�ַ���  
     v_s number;--���ƴ�ӡ�Ŀո���  ������ʽ������_�ո���  
begin  
     if(v_l mod 2=0) then   
      dbms_output.put_line('������������');      
     else  
       for i in 0..v_l-1  
        loop   
         --�жϴ�ӡ*�ĸ��� �Ϳո����  
          if(i>v_l/2) then  
           v_c:=(v_l-i-1)*2+1;  --������������ϵĸ��и�������   ���� ��ӡ���� �������Ϊ�м��� �����к͵ڶ��еĸ�����ͬ  ��ֻ������()*2+1 �����е����ּ���  
           v_s:=(v_l-v_c)/2;    --�����кź�*�ĸ��������ո�ĸ���   
          else   
           v_c:=i*2+1;   
           v_s:=(v_l-v_c)/2;    --�����кź�*�ĸ��������ո�ĸ���   
          end if ;    
           
          --��ӡ�ո�ĸ���  
          for j in 1..v_s  
          loop   
          dbms_output.put(' ');    
          end loop;  
          --��ӡ*�ĸ���  
          for j in 1..v_c  
          loop   
          dbms_output.put('*');    
          end loop;  
        dbms_output.put_line('');   
        end loop;  
      end if;  
end;  
--�ο�����
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

--��ת���
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


 
