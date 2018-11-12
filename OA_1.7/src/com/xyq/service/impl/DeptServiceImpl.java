package com.xyq.service.impl;

import java.util.List;

import com.xyq.dao.DeptDao;
import com.xyq.dao.impl.DeptDaoImpl;
import com.xyq.entity.Dept;
import com.xyq.service.DeptService;

public class DeptServiceImpl implements DeptService {
	
	DeptDao deptDao = new DeptDaoImpl();

	@Override
	public List<Dept> findDept() {
		return deptDao.getDeptList();
	}

	@Override
	public int addDept(Dept dept) {
		return deptDao.insertDept(dept);
	}

	@Override
	public int deleteDept(int deptid) {
		return deptDao.deleteDept(deptid);
	}

	@Override
	public Dept updateQuery(int deptid) {
		return deptDao.updateQuery(deptid);
	}

	@Override
	public int updateDept(Dept dept) {
		return deptDao.updateDept(dept);
	}
	
}
