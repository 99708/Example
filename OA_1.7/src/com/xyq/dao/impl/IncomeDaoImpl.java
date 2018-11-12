package com.xyq.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.xyq.dao.IncomeDao;
import com.xyq.entity.Dept;
import com.xyq.entity.Emp;
import com.xyq.entity.Position;
import com.xyq.util.DBUtil;
import com.xyq.vo.IncomeVo;

public class IncomeDaoImpl implements IncomeDao {

	@Override
	public List<IncomeVo> getIncomeByType() {
		String sql = "select ictype, sum(amount) amount_total from income group by ictype ";
		List<IncomeVo> incomeVoList = new ArrayList<IncomeVo>();
		//1、获取连接
		Connection connection = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				String ictype = rs.getString("ictype");
				int amount_total = rs.getInt("amount_total");
				IncomeVo incomeVo = new IncomeVo(amount_total, ictype);
				incomeVoList.add(incomeVo);
			}                                 
			return incomeVoList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//关闭资源
			DBUtil.closeAll(connection, ps, rs);
		}
		return null;
	}

}
