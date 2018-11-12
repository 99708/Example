package com.xyq.service;

import java.util.Date;
import java.util.List;

import com.xyq.entity.Emp;

public interface EmpService {
	
	/**
	 * 查询员工的所有信息
	 * @return
	 */
	public List<Emp> findEmpList();
	
	/**
	 * 添加员工
	 * @param emp
	 * @return
	 */
	public int addEmp(Emp emp);
	
	/**
	 * 删除员工(将其在职状态改变为离职)
	 * @param empid
	 * @return
	 */
	public int deleteEmp(String empid);
	
	/**
	 * 修改之前进行查询，将数据展现到update界面
	 * @param empid
	 * @return
	 */
	public Emp updateEmpQuery(String empid);
	
	/**
	 * 更新员工信息
	 * @param empid
	 * @return
	 */
	public int updateEmp(Emp emp);
	
	/**
	 * 查询领导信息
	 * @return
	 */
	public List<Emp> findMgrEmpList();
	
	/**
	 * 根据id查询员工信息
	 * @param empid
	 * @return
	 */
	public Emp showEmp(String empid);
	
	/**
	 * 多条件查询
	 * @param empid
	 * @param deptno
	 * @param onduty
	 * @param hiredate
	 * @return
	 */
	public List<Emp> findEmpListByArgs(String empid, int deptno, int onduty, Date hiredate);

}
