--��������ɾ����������ʱ��ɾ���ӱ����ݡ�
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
--����
delete from animal where id = 2 ;
/*���Խ��  animal��ɾ����id=2��һ�� 
protoytp��ɾ��������nid=2�������������
*/
