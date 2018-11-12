package com.xyq.service;

import java.util.List;

import com.xyq.entity.Dept;

public interface DeptService {

	List<Dept> findDept();

	int addDept(Dept dept);

	int deleteDept(int deptid);

	Dept updateQuery(int deptid);

	int updateDept(Dept dept);

}
