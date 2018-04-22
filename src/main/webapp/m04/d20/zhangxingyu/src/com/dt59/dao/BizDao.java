package com.dt59.dao;

import java.util.List;

import com.dt59.entity.Shangping;
import com.dt59.entity.User;

public interface BizDao {
	List<Shangping> getAllShangping();
	
	boolean validateUser(User user);
	
	Shangping getShangpingById(int id);
}
