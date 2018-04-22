package com.dt59.service.impl;

import java.util.List;

import com.dt59.dao.BizDao;
import com.dt59.entity.Shangping;
import com.dt59.entity.User;
import com.dt59.service.BizService;

public class BizServiceImpl implements BizService{
	private BizDao bizDao;
	
	public BizDao getBizDao() {
		return bizDao;
	}

	public void setBizDao(BizDao bizDao) {
		this.bizDao = bizDao;
	}

	public List<Shangping> getAllShangping() {
		// TODO Auto-generated method stub
		return bizDao.getAllShangping();
	}

	public boolean validateUser(User user) {
		// TODO Auto-generated method stub
		return bizDao.validateUser(user);
	}

	public Shangping getShangpingById(int id) {
		// TODO Auto-generated method stub
		return bizDao.getShangpingById(id);
	}

}
