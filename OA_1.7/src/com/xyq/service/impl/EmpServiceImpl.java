package com.xyq.service.impl;

import java.util.Date;
import java.util.List;

import com.xyq.dao.EmpDao;
import com.xyq.dao.impl.EmpDaoImpl;
import com.xyq.entity.Emp;
import com.xyq.service.EmpService;

public class EmpServiceImpl implements EmpService {
	
	EmpDao empDao = new EmpDaoImpl();
	
	/**
	 * 查询员工的所有信息
	 * @return
	 */
	@Override
	public List<Emp> findEmpList() {
		return empDao.getEmpList();
	}
	/**
	 * 添加员工
	 * @param emp
	 * @return
	 */
	@Override
	public int addEmp(Emp emp) {
		return empDao.addEmp(emp);
	}
	/**
	 * 删除员工(将其在职状态改变为离职)
	 * @param empid
	 * @return
	 */
	@Override
	public int deleteEmp(String empid) {
		
		return empDao.deleteEmp(empid);
	}
	/**
	 * 修改之前进行查询，将数据展现到update界面
	 * @param empid
	 * @return
	 */
	@Override
	public Emp updateEmpQuery(String empid) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 更新员工信息
	 * @param empid
	 * @return
	 */
	@Override
	public int updateEmp(Emp emp) {
		return empDao.updateEmp(emp);
	}
	/**
	 * 查询领导信息
	 */
	@Override
	public List<Emp> findMgrEmpList() {
		return empDao.geiMgrEmpList();
	}
	@Override
	public Emp showEmp(String empid) {
		return empDao.showEmp(empid);
	}
	@Override
	public List<Emp> findEmpListByArgs(String empid, int deptno, int onduty,
			Date hiredate) {
		return empDao.getEmpListByArgs(empid , deptno, onduty, hiredate);
	}

}
