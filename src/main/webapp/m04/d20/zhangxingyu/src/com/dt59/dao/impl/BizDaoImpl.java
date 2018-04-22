package com.dt59.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.dt59.dao.BaseDao;
import com.dt59.dao.BizDao;
import com.dt59.entity.Shangping;
import com.dt59.entity.User;

public class BizDaoImpl extends BaseDao implements BizDao{

	public List<Shangping> getAllShangping() {
		List<Shangping> listsp=new ArrayList<Shangping>();
		try {
			String sql="SELECT * FROM shangping";
			pst= getCon().prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				Shangping sp=new Shangping();
				sp.setSpid(rs.getInt(1));
				sp.setSpname(rs.getString(2));
				sp.setSpprice(rs.getFloat(3));
				sp.setSpdesc(rs.getString(4));
				listsp.add(sp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(con,pst,rs);
		}
		return listsp;
	}

	public boolean validateUser(User user) {
		// TODO Auto-generated method stub
		boolean flag=false;
		try {
			String sql="SELECT * FROM USER WHERE uname=? AND upwd=?";
			pst=getCon().prepareStatement(sql);
			pst.setString(1, user.getUname());
			pst.setString(2, user.getUpwd());
			rs=pst.executeQuery();
			while(rs.next()){
				flag=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(con,pst,rs);
		}
		return flag;
	}

	public Shangping getShangpingById(int id) {
		// TODO Auto-generated method stub
		Shangping sp=null;
		try {
			String sql="SELECT * FROM shangping WHERE spid=?";
			pst= getCon().prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			while(rs.next()){
				sp=new Shangping();
				sp.setSpid(rs.getInt(1));
				sp.setSpname(rs.getString(2));
				sp.setSpprice(rs.getFloat(3));
				sp.setSpdesc(rs.getString(4));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(con,pst,rs);
		}
		return sp;
	}

}
