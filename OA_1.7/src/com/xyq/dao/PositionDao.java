package com.xyq.dao;

import java.util.List;

import com.xyq.entity.Position;

public interface PositionDao {
	/**
	 * 查询所有的岗位信息
	 * @return
	 */
	public List<Position> getPositionList();
	/**
	 * 添加岗位信息
	 * @param position
	 * @return
	 */
	public int addPosition(Position position);
	/**
	 * 根据岗位id删除岗位
	 * @param pid
	 * @return
	 */
	public int deletePosition(int pid);
	/**
	 * 修改岗位信息
	 * @param position
	 * @return
	 */
	public int updatePosition(Position position);
	/**
	 * 根据id查看岗位信息
	 * @param pid
	 * @return
	 */
	public Position updatePositionQuery(int pid);
}
