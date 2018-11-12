package com.xyq.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.xyq.dao.EmpDao;
import com.xyq.entity.Dept;
import com.xyq.entity.Emp;
import com.xyq.entity.Position;
import com.xyq.util.DBUtil;
import com.xyq.util.TransUtil;

public class EmpDaoImpl implements EmpDao {

	/**
	 * 查询员工的所有信息
	 * @return
	 */
	@Override
	public List<Emp> getEmpList() {
		String sql = "SELECT E.EMPID,"
			       + "E.REALNAME,"
			       + "D.DEPTNAME,"
			       + "P.PNAME,"
			       + "E.ONDUTY,"
			       + "E.HIREDATE,"
			       + "E.PHONE"
			 + " FROM EMPLOYEE E"
			 + " INNER JOIN DEPT D"
			 + "   ON E.DEPTNO = D.DEPTNO "
			 + " INNER JOIN POSITION P"
			 + "   ON E.POSID = P.POSID" 
			 + " ORDER BY E.ONDUTY DESC";
		List<Emp> empList = new ArrayList<Emp>();
		//1、获取连接
		Connection connection = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				
				String empid = rs.getString("empid");
				String realname = rs.getString("realname");
				int onduty = rs.getInt("onduty");
				String phone = rs.getString("phone");
				Date hiredate = rs.getDate("hiredate");
				
				String pname = rs.getString("pname");
				String deptname = rs.getString("deptname");
				
				Dept dept = new Dept();
				dept.setDeptname(deptname);
				
				Position position = new Position();
				position.setPname(pname);
				
				Emp emp = new Emp(empid, realname, hiredate, onduty, phone, dept, position);
				empList.add(emp);
			
			}                                 
			return empList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//关闭资源
			DBUtil.closeAll(connection, ps, rs);
		}
		return null;
	}

	/**
	 * 添加员工
	 * @param emp
	 * @return
	 */
	@Override
	public int addEmp(Emp emp) {
		String sql = "insert into employee e ("
				+" e.empid, e.deptno, e.posid, e.mgrid,"
				+" e.realname, e.sex, e.birthdate, e.hiredate, e.onduty,"
				+" e.emptype, e.phone, e.qq, e.emercontactperson, e.idcard"
				+" ) values ("
				+" ?, ?, ?, ?,"
				+" ?, ?, ?, ?, ?,"
				+" ?, ?, ?, ?, ?"
				+" )";
		Object [] objs = {
				emp.getEmpid(), emp.getDept().getDeptno(),
				emp.getPosition().getPosid(), emp.getMgremp().getEmpid(),
				emp.getRealname(), emp.getSex(), 
				TransUtil.utildate2SQLDate(emp.getBirthdate()), 
				TransUtil.utildate2SQLDate(emp.getHiredate()),
				emp.getOnduty(), emp.getEmptype(), emp.getPhone(), emp.getQq(), emp.getEmercontactperson(),
				emp.getIdcard()
			};
		return DBUtil.executeDML(sql, objs);
	}

	/**
	 * 删除员工(将其在职状态改变为离职)
	 * @param empid
	 * @return
	 */
	@Override
	public int deleteEmp(String empid) {
		String sql = "update employee set onduty = 0 where empid = ?";
		return DBUtil.executeDML(sql, empid);
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
		String sql = "update employee e set"                                        
					+ " e.deptno = ?, e.posid = ?, e.mgrid = ?,"
					+ " e.realname = ?, e.birthdate = ?, e.hiredate = ?,"
					+ " e.leavedate = ?, e.onduty = ?, e.phone = ?, e.qq = ?," 
					+ " e.emercontactperson = ?, e.idcard = ? "
					+ " where e.empid = ?";
		
		java.sql.Date birthdate = null;
		java.sql.Date hiredate = null;
		java.sql.Date leavedate = null;
		
		if(emp.getBirthdate() != null){
			birthdate = TransUtil.utildate2SQLDate(emp.getBirthdate());
		}
		if(emp.getHiredate() != null){
			hiredate = TransUtil.utildate2SQLDate(emp.getHiredate());
		}
		if(emp.getLeavedate() != null){
			leavedate = TransUtil.utildate2SQLDate(emp.getLeavedate());
		}
		
		Object [] objs = {
				emp.getDept().getDeptno(), emp.getPosition().getPosid(), emp.getMgremp().getEmpid(),
				emp.getRealname(), birthdate, hiredate, leavedate,
				emp.getOnduty(), emp.getPhone(), emp.getQq(), 
				emp.getEmercontactperson(), emp.getIdcard(), emp.getEmpid()
			};
		
		return DBUtil.executeDML(sql, objs);
	}
	
	/**
	 * 查询领导信息
	 */
	@Override
	public List<Emp> geiMgrEmpList() {
		String sql = "select distinct e2.* from employee e1 "
				+" inner join employee e2 "
				+" on e1.mgrid = e2.empid";
		List<Emp> mgrEmpList = new ArrayList<Emp>();
		//1、获取连接
		Connection connection = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				
				String empid = rs.getString("empid");
				String realname = rs.getString("realname");
				int onduty = rs.getInt("onduty");
				String phone = rs.getString("phone");
				Date hiredate = rs.getDate("hiredate");
				
				String posidStr = rs.getString("posid");
				int posid = TransUtil.str2int(posidStr);
				String deptnoStr = rs.getString("deptno");
				int deptno = TransUtil.str2int(deptnoStr);
				
				Dept dept = new Dept();
				dept.setDeptno(deptno);
				Position position = new Position();
				position.setPosid(posid);
				
				Emp emp = new Emp(empid, realname, hiredate, onduty, phone, dept, position);
				mgrEmpList.add(emp);
			
			}                                 
			return mgrEmpList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//关闭资源
			DBUtil.closeAll(connection, ps, rs);
		}
		return null;
	}

	@Override
	public Emp showEmp(String empid) {
		String sql = "select e.empid, e.deptno, e.posid, e.mgrid,"
				+" e.realname, e.sex, e.birthdate, e.hiredate, e.onduty,"
				+" e.emptype, e.phone, e.qq, e.emercontactperson, e.idcard"
				+" from employee e where e.empid = ?";
		//1、获取连接
		Connection connection = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Emp emp = null;
		try {
			ps = connection.prepareStatement(sql);
			//设置值
			ps.setString(1, empid);
			rs = ps.executeQuery();
			while(rs.next()){
				
				String empno = rs.getString("empid");
				String realname = rs.getString("realname");
				String sex = rs.getString("sex");
				int onduty = rs.getInt("onduty");
				int emptype = rs.getInt("emptype");
				String phone = rs.getString("phone");
				String qq = rs.getString("qq");
				String emercontactperson = rs.getString("emercontactperson");
				String idcard = rs.getString("idcard");
				Date hiredate = rs.getDate("hiredate");
				Date birthdate = rs.getDate("birthdate");
				
				int posid = rs.getInt("posid");
				int deptno = rs.getInt("deptno");
				
				Dept dept = new Dept();
				dept.setDeptno(deptno);
				
				String mgrempid = rs.getString("mgrid");
				Emp mgrEmp = new Emp();
				mgrEmp.setEmpid(mgrempid);
				
				Position position = new Position();
				position.setPosid(posid);
				
				emp = new Emp(empno, realname, sex, birthdate, hiredate, onduty, emptype, phone, qq, emercontactperson, idcard, dept, position, mgrEmp);
			}                                 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//关闭资源
			DBUtil.closeAll(connection, ps, rs);
		}
		return emp;
	}

	@Override
	public List<Emp> getEmpListByArgs(String empid, int deptno, int onduty,Date hiredate) {
		String sql = "select e.empid,"
			       + " e.realname,"
			       + " d.deptname,"
			       + " p.pname,"
			       + " e.onduty,"
			       + " e.hiredate,"
			       + " e.phone"
			 + " from employee e"
			 + " inner join dept d"
			 + "   on e.deptno = d.deptno "
			 + " inner join position p"
			 + "   on e.posid = p.posid"
			 + " where d.deptno = ?"
			 + "   and e.onduty = ?";
			 
		if((empid != null && !"".equals(empid)) && hiredate != null){
			sql += " and e.hiredate = ? and e.empid like ?";
		}
		if((empid == null || "".equals(empid)) && hiredate != null){
			sql += " and e.hiredate = ?";
		}
		if((empid != null && !"".equals(empid)) && hiredate == null){
			sql += " and e.empid like ?";
		}
		List<Emp> empList = new ArrayList<Emp>();
		//1、获取连接
		Connection connection = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, deptno);
			ps.setInt(2, onduty);			
			if((empid != null && !"".equals(empid)) && hiredate != null){
				java.sql.Date hiredateSql = TransUtil.utildate2SQLDate(hiredate);
				ps.setDate(3, hiredateSql);
				ps.setString(4, "%"+empid+"%");
			}
			if((empid == null || "".equals(empid)) && hiredate != null){
				java.sql.Date hiredateSql = TransUtil.utildate2SQLDate(hiredate);
				ps.setDate(3, hiredateSql);
			}
			if((empid != null && !"".equals(empid)) && hiredate == null){
				ps.setString(3, "%"+empid+"%");
			}
			rs = ps.executeQuery();
			while(rs.next()){
				
				String empno = rs.getString("empid");
				String realname = rs.getString("realname");
				int isonduty = rs.getInt("onduty");
				String phone = rs.getString("phone");
				Date hiredateSQL = rs.getDate("hiredate");
				
				String pname = rs.getString("pname");
				String deptname = rs.getString("deptname");
				
				Dept dept = new Dept();
				dept.setDeptname(deptname);
				
				Position position = new Position();
				position.setPname(pname);
				
				Emp emp = new Emp(empno, realname, hiredateSQL, isonduty, phone, dept, position);
				empList.add(emp);
			
			}                                 
			return empList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//关闭资源
			DBUtil.closeAll(connection, ps, rs);
		}
		return null;
	}

}
