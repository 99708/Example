package com.xyq.dao;

import java.util.List;

import com.xyq.entity.Dept;

public interface DeptDao {

	List<Dept> getDeptList();

	int insertDept(Dept dept);

	int deleteDept(int deptid);

	Dept updateQuery(int deptid);

	int updateDept(Dept dept);

}
