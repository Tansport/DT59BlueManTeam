--触发器：删除主表数据时，删除从表数据。
create or replace trigger tri_DP_delete
before delete on animal
referencing new as new old AS Old
for each row
DECLARE
BEGIN
delete prototype where nid=:OLD.id;
exception
when others then
raise;
END tri_DP_delete;
--测试
delete from animal where id = 2 ;
/*测试结果  animal：删除了id=2的一行 
protoytp：删除了所有nid=2的行里面的数据
*/
