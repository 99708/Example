package com.xyq.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xyq.dao.PositionDao;
import com.xyq.entity.Dept;
import com.xyq.entity.Position;
import com.xyq.util.DBUtil;

public class PositionDaoImpl implements PositionDao {
	/**
	 * 查询所有的岗位信息
	 * @return
	 */
	@Override
	public List<Position> getPositionList() {
		String sql = "select * from position order by posid asc";
		List<Position> positionList = new ArrayList<Position>();
		//1、获取连接
		Connection connection = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				int posid = rs.getInt("posid");
				String pname = rs.getString("pname");
				String pdesc = rs.getString("pdesc");
				Position position = new Position(posid, pname, pdesc);
				positionList.add(position);
			}
			return positionList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//关闭资源
			DBUtil.closeAll(connection, ps, rs);
		}
		return null;
	}
	
	/**
	 * 添加岗位信息
	 * @param position
	 * @return
	 */
	@Override
	public int addPosition(Position position) {
		String sql = "insert into position(posid, pname, pdesc) values(?, ?, ?)";
		return DBUtil.executeDML(sql, position.getPosid(), position.getPname(), position.getPdesc());
	}
	
	/**
	 * 根据岗位id删除岗位
	 * @param pid
	 * @return
	 */
	@Override
	public int deletePosition(int pid) {
		String sql = "delete from position where posid = ?";
		return DBUtil.executeDML(sql, pid);
	}
	
	/**
	 * 修改岗位信息
	 * @param position
	 * @return
	 */
	@Override
	public int updatePosition(Position position) {
		String sql = "update position set pname = ?, pdesc = ? where posid = ?";
		return DBUtil.executeDML(sql, position.getPname(), position.getPdesc(), position.getPosid());
	}
	
	/**
	 * 根据id查看岗位信息
	 * @param pid
	 * @return
	 */
	@Override
	public Position updatePositionQuery(int pid) {
		String sql = "select * from position where posid = ? order by posid asc";
		//1、获取连接
		Connection connection = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Position position = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, pid);
			rs = ps.executeQuery();
			while(rs.next()){
				int posid = rs.getInt("posid");
				String pname = rs.getString("pname");
				String pdesc = rs.getString("pdesc");
				position = new Position(posid, pname, pdesc);
			}
			return position;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//关闭资源
			DBUtil.closeAll(connection, ps, rs);
		}
		return null;
	}

}
