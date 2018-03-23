#多表查询:
select * from hos_type,sys_user,hos_district,hos_house
     -> where
     -> hos_type.htid=sys_user.uid
     -> and
     -> hos_district.did=hos_house.hmid\G;
