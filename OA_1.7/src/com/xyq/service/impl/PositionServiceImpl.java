package com.xyq.service.impl;

import java.util.List;

import com.xyq.dao.PositionDao;
import com.xyq.dao.impl.PositionDaoImpl;
import com.xyq.entity.Position;
import com.xyq.service.PositionService;

public class PositionServiceImpl implements PositionService{

	PositionDao positionDao = new PositionDaoImpl();
	
	/**
	 * 查询所有的岗位信息
	 * @return
	 */
	@Override
	public List<Position> findPositionList() {
		return positionDao.getPositionList();
	}
	
	/**
	 * 添加岗位信息
	 * @param position
	 * @return
	 */
	@Override
	public int addPosition(Position position) {
		return positionDao.addPosition(position);
	}
	/**
	 * 根据岗位id删除岗位
	 * @param pid
	 * @return
	 */
	@Override
	public int deletePosition(int pid) {
		return positionDao.deletePosition(pid);
	}
	/**
	 * 修改岗位信息
	 * @param position
	 * @return
	 */
	@Override
	public int updatePosition(Position position) {
		return positionDao.updatePosition(position);
	}
	/**
	 * 根据id查看岗位信息
	 * @param pid
	 * @return
	 */
	@Override
	public Position updatePositionQuery(int pid) {
		return positionDao.updatePositionQuery(pid);
	}

}
