create or replace trigger tr_dp_delete
before delete
on stu
referencing new as new old as lod
for each row
declare
begin
delete stw where nid=:lod.id;
exception
when others then
raise;
end tr_dp_delete;