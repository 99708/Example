package com.xyq.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.xyq.entity.Emp;
import com.xyq.service.EmpService;
import com.xyq.service.impl.EmpServiceImpl;
import com.xyq.util.TransUtil;

public class TestService {
	@Test
	public void  getEmpByArg(){
		EmpService empService = new EmpServiceImpl();
		String empid = "a";
		int  deptnoStr = 1;
		int  ondutyStr = 1;
		String  hiredateStr = "2010-12-24";
		Date hiredate = TransUtil.str2date(hiredateStr);
		List<Emp> findEmployeesListByArgs = empService.findEmpListByArgs(empid, deptnoStr, ondutyStr, hiredate);
	
		System.out.println(findEmployeesListByArgs);
	}
}
