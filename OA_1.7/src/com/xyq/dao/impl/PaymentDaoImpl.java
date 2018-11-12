package com.xyq.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xyq.dao.PaymentDao;
import com.xyq.util.DBUtil;
import com.xyq.vo.PayMentVo;

public class PaymentDaoImpl implements PaymentDao{

	@Override
	public List<PayMentVo> getPaymentByType() {
		String sql = "select expi.type type, sum(p.amount) amount_total "
				+ "from payment p  "
				+" inner join expense exp "
				+" on p.expid = exp.expid "
				+" inner join expenseitem expi "
				+" on exp.expid = expi.expid "
				+" group by expi.type "
				+" order by expi.type ";
		List<PayMentVo> paymentVoList = new ArrayList<PayMentVo>();
		//1、获取连接
		Connection connection = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				String type = rs.getString("type");
				double amount_total = rs.getDouble("amount_total");
				PayMentVo paymentVo = new PayMentVo(type, amount_total);
				paymentVoList.add(paymentVo);
			}                                 
			return paymentVoList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//关闭资源
			DBUtil.closeAll(connection, ps, rs);
		}
		return null;
	}

}
