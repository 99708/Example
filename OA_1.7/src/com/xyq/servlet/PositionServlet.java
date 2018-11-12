package com.xyq.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyq.entity.Position;
import com.xyq.service.PositionService;
import com.xyq.service.impl.PositionServiceImpl;


public class PositionServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 查询所有的岗位信息
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void findPositionList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PositionService positionService = new PositionServiceImpl();
		List<Position> positionList = positionService.findPositionList();
		req.setAttribute("positionList", positionList);
		req.getRequestDispatcher("/position/positionList.jsp").forward(req, resp);
	}
	/**
	 * 添加岗位信息
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void addPosition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取请求数据
		int posno = 0;
		String posid = req.getParameter("posid");
		if(posid != null && !"".equals(posid)){
			posno = Integer.valueOf(posid);
		}else{
			req.setAttribute("waring", "添加的岗位id不能为空");
			req.getRequestDispatcher("/position/positionAdd.jsp").forward(req, resp);
		}
		String pname = req.getParameter("pname");
		String pdesc = req.getParameter("pdesc");
		Position position = new Position(posno, pname, pdesc);
		//调动service中的方法
		PositionService positionService = new PositionServiceImpl();
		int mun = positionService.addPosition(position);
		if(mun == -1){
			req.setAttribute("error", "添加失败");
			req.getRequestDispatcher("/position/positionAdd.jsp").forward(req, resp);
		}else{
			findPositionList(req, resp);
		}
	}
	/**
	 * 根据岗位id删除岗位
	 * @param req
	 * @param resp
	 * @return
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void deletePosition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取请求数据
		int posno = 0;
		String posid = req.getParameter("posid");
		if(posid != null && !"".equals(posid)){
			posno = Integer.valueOf(posid);
		}else{
			req.setAttribute("waring", "删除的岗位id不能为空");
			req.getRequestDispatcher("/position/positionList.jsp").forward(req, resp);
		}
		//调动service中的方法
		PositionService positionService = new PositionServiceImpl();
		int mun = positionService.deletePosition(posno);
		if(mun == -1){
			req.setAttribute("error", "删除失败");
			req.getRequestDispatcher("/position/positionList.jsp").forward(req, resp);
		}else{
			findPositionList(req, resp);
		}
	}
	/**
	 * 根据id查找岗位信息
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updatePositionQuery(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//获取请求数据
		int posno = 0;
		String posid = req.getParameter("posid");
		if(posid != null && !"".equals(posid)){
			posno = Integer.valueOf(posid);
		}else{
			req.setAttribute("waring", "查找的岗位id不能为空");
			req.getRequestDispatcher("/position/positionList.jsp").forward(req, resp);
		}
		//调动service中的方法
		PositionService positionService = new PositionServiceImpl();
		Position position = positionService.updatePositionQuery(posno);
		if(position != null){
			req.setAttribute("position", position);
			req.getRequestDispatcher("/position/positionUpdate.jsp").forward(req, resp);
		}else{
			req.setAttribute("error", "修改失败");
			req.getRequestDispatcher("/position/positionList.jsp").forward(req, resp);
		}
	}
	/**
	 * 修改岗位信息
	 * @param position
	 * @return
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void updatePosition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//获取请求数据
		int posno = 0;
		String posid = req.getParameter("posid");
		if(posid != null && !"".equals(posid)){
			posno = Integer.valueOf(posid);
		}else{
			req.setAttribute("waring", "修改的岗位id不能为空");
			req.getRequestDispatcher("/position/positionUpdate.jsp").forward(req, resp);
		}
		String pname = req.getParameter("pname");
		String pdesc = req.getParameter("pdesc");
		Position position = new Position(posno, pname, pdesc);
		//调动service中的方法
		PositionService positionService = new PositionServiceImpl();
		int mun = positionService.updatePosition(position);
		if(mun == -1){
			req.setAttribute("error", "修改失败");
			req.getRequestDispatcher("/position/positionUpdate.jsp").forward(req, resp);
		}else{
			findPositionList(req, resp);
		}
	}
	

}
