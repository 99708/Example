package com.bjsxt.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.pojo.Classes;
import com.bjsxt.pojo.MajClasses;
import com.bjsxt.pojo.Major;
import com.bjsxt.pojo.Subject;
import com.bjsxt.pojo.Teacher;
import com.bjsxt.pojo.TeacherBoss;
import com.bjsxt.pojo.TeacherPage;
import com.bjsxt.pojo.TeacherSub;
import com.bjsxt.service.TeacherService;
import com.bjsxt.service.impl.TeacherServiceImpl;
import com.bjsxt.util.Date2str;
import com.google.gson.Gson;

public class TeacherServlet extends BaseServlet {
	
	//乔
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 寻找所有的专业信息，用来接收ajax请求
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	public void findMajor(HttpServletRequest request, HttpServletResponse response) throws IOException{
		TeacherService ts = new TeacherServiceImpl();
		List<Major> majorList = ts.findMajor();
		response.getWriter().println(new Gson().toJson(majorList));
	}
	
	/**
	 * 添加老师信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String tname = request.getParameter("tname");
		int age = Integer.valueOf(request.getParameter("age"));
		String sex = request.getParameter("sex");
		String marry = request.getParameter("marry");
		String party = request.getParameter("party");
		String nation = request.getParameter("naton");
		String education = request.getParameter("education");
		Date birthdate = Date2str.str2date(request.getParameter("birthdate"));
		String idcard = request.getParameter("idcard");
		String phone = request.getParameter("phone");
		Date hiredate = Date2str.str2date(request.getParameter("hiredate"));
		int mid = Integer.valueOf(request.getParameter("mid"));
		String desc = request.getParameter("desc");
		String pwd = "bjsxt";
		int rid = 2;
		Major major = new Major();
		major.setMid(mid);
		Teacher teacher = new Teacher(pwd, rid, major, tname, sex, age, nation, party, education, marry, birthdate, idcard, phone, hiredate, desc);
		TeacherService ts = new TeacherServiceImpl();
		int num = ts.addTeacher(teacher);
		if(num>0){
			request.getRequestDispatcher("/archives/teacherDate.jsp").forward(request, response);
		}else{
			request.setAttribute("error","添加失败");
			request.getRequestDispatcher("/archives/teacherSearch.jsp").forward(request, response);
		}
	}
	
	/**
	 * 查找所有老师信息
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void findTeachers(HttpServletRequest request, HttpServletResponse response) throws IOException{
		int search = Integer.valueOf(request.getParameter("search"));
		String searchText = request.getParameter("searchText");
		int num=Integer.parseInt(request.getParameter("num"));
		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
		TeacherService ts = new TeacherServiceImpl();
		TeacherPage tp = ts.findTeachers(search,searchText,num,pageSize);
		response.getWriter().println(new Gson().toJson(tp));
	}
	
	/**
	 * 查找某一老师信息
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void findTeacher(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		int tid = Integer.valueOf(request.getParameter("tid"));
		System.out.println(tid);
		TeacherService ts = new TeacherServiceImpl();
		Teacher teacher = ts.findTeacherByTid1(tid);
		request.setAttribute("teacher", teacher);
		request.getRequestDispatcher("/archives/teacherRevice.jsp").forward(request, response);
	}
	
	/**
	 * 修改老师的信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateTeacher(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		int tid = Integer.valueOf(request.getParameter("tid"));
		int age = Integer.valueOf(request.getParameter("age"));
		String marry = request.getParameter("marry");
		String party = request.getParameter("party");
		String education = request.getParameter("education");
		String phone = request.getParameter("phone");
		int mid = Integer.valueOf(request.getParameter("mid"));
		String desc = request.getParameter("desc");
		
		Major major = new Major();
		major.setMid(mid);
		Teacher teacher = new Teacher(tid, major, age, party, education, marry, phone, desc);
		TeacherService ts = new TeacherServiceImpl();
		int num = ts.updateTeacher(teacher);
		if(num>0){
			request.getRequestDispatcher("/archives/teacherDate.jsp").forward(request, response);
		}else{
			request.setAttribute("error","修改失败");
			request.getRequestDispatcher("/archives/teacherRevice.jsp").forward(request, response);
		}
	}
	
	public void findMyInfo(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		Teacher tea =(Teacher) request.getSession().getAttribute("tea");
		Integer tid = tea.getTid();
		TeacherService ts = new TeacherServiceImpl();
		Teacher teacher = ts.findMyInfoByTid(tid);
		int mid = teacher.getMajor().getMid();
		String mname = ts.findMnameByMid(mid);
		teacher.getMajor().setMname(mname);
		
		request.setAttribute("teacher", teacher);
		request.getRequestDispatcher("/archives/teacherInfo2.jsp").forward(request, response);		
	}
	
	/**
	 * 通过ajax实现联想查询
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	public void thinkFind(HttpServletRequest request,HttpServletResponse response) throws IOException{
		int search = Integer.valueOf(request.getParameter("search"));
		String searchText = request.getParameter("searchText");
		TeacherService ts = new TeacherServiceImpl();
		List<Object> list = ts.thinkFind(search,searchText);
		response.getWriter().println(new Gson().toJson(list));
	}
	
	//耗子
	/**
	 * 遍历科目(任课科目下拉框) 请求转发到 staff/teachCurriculum.jsp页面
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	public void teacherSubList(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 调用Service获取数据
		TeacherService ts = new TeacherServiceImpl();
		List<Subject> fts = ts.findTeacherSub();

		// 将list请求转发到staff/teachCurriculum.jsp页面
		req.setAttribute("fts", fts);
		req.getRequestDispatcher("/staff/teachCurriculum.jsp").forward(req,
				resp);

	}

	/**
	 * 三条件查询教师(任课科目，教师编号，任职日期) 查询字段(教师姓名，性别，年龄，学历，授课专业，结婚状态)
	 */
	public void teacherSubBySTH(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 获取请求信息
		int num = Integer.parseInt(req.getParameter("num"));
		int pageSize = Integer.parseInt(req.getParameter("pageSize"));

		// 教师编号
		int tid = 0;
		String tidStr = req.getParameter("teacherid");
		if (tidStr != null && !"".equals(tidStr)) {
			tid = Integer.parseInt(tidStr);
		}

		// 任课科目
		String sname = req.getParameter("subject");

		// 任职日期
		String hiredate = null;
		String hiredateStr = req.getParameter("hiredate");
		if (hiredateStr != null && !"".equals(hiredateStr)) {
			hiredate = hiredateStr.replace("-", "");
		}

		System.out.println("tid : " + tid + " sname : " + sname
				+ " hiredate : " + hiredate);
		System.out.println("num : " + num + "pageSize : " + pageSize);

		// 调用Service层获取数据
		TeacherService ts = new TeacherServiceImpl();
		TeacherPage tp = ts.findTeacherBySTH(sname, tid, hiredate, num,
				pageSize);

		System.out.println(tp);

		Gson gson = new Gson();
		String json = gson.toJson(tp);

		resp.getWriter().println(json);
	}

	/**
	 * 遍历所有 班级 信息 请求转发到 staff/teachDirector.jsp页面
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void classesSubList(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 调用service查询数据
		TeacherService ts = new TeacherServiceImpl();
		List<Classes> ftc = ts.findTeacherClasses();

		// 请求转发到 staff/teachDirector.jsp页面
		req.setAttribute("ftc", ftc);
		req.getRequestDispatcher("/staff/teachDirector.jsp").forward(req, resp);
	}

	/**
	 * 处理前端$("#classSelect").change事件的ajax请求 通过cid查询到专业、年级信息
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getGCIDByClassName(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {

		String clazzid = req.getParameter("clazzid");
		System.out.println(clazzid);
		int cid = Integer.parseInt(clazzid);

		TeacherService ts = new TeacherServiceImpl();
		MajClasses mc = ts.findMajClassByCid(cid);

		Gson gson = new Gson();
		String json = gson.toJson(mc);

		resp.getWriter().println(json);

	}

	/**
	 * 通过tid查找老师
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getTeacherByTid(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 新建Gson对象
		Gson gson = new Gson();

		// 创建Service对象
		TeacherService ts = new TeacherServiceImpl();

		// 默认tid(教师编号)
		int tid = 0;

		// 从前端获取数据
		String teacherid = req.getParameter("teacherid");
		System.out.println(teacherid);

		// 判断数据是否为空
		if (teacherid != null && !"".equals(teacherid)) {
			Pattern pattern = Pattern.compile("[0-9]*");
			if (pattern.matcher(teacherid).matches()) {
				// 是数字,转为tid(教师编号)
				tid = Integer.parseInt(teacherid);
			} else {
				// 不是数字 ，tid = 0默认值
			}
		} else {
			// 没有得到数据，tid = 0默认值
		}

		Teacher teacher = ts.findTeacherByTid(tid);

		String json = gson.toJson(teacher);
		resp.getWriter().println(json);

	}

	/**
	 * 将老师变成班主任 修改assign表中cid字段，更换老师任课班级 修改teacher中hiredate(任职时间)、desc(职位)
	 * 老师班级专业信息会随之改变(外键关系) 通过tid找到老师
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void teacherToBoss(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 从前端页面获得数据
		// tid
		int tid = 0;
		String teacherid = req.getParameter("teacherid");

		// tid
		if (teacherid != null && !"".equals(teacherid)) {
			Pattern pattern = Pattern.compile("[0-9]*");
			if (pattern.matcher(teacherid).matches()) {
				// 是数字,转为tid(教师编号)
				tid = Integer.parseInt(teacherid);
			} else {
				// 不是数字 ，tid = 0默认值
			}
		} else {
			// 没有得到数据，tid = 0默认值
		}

		// hiredate任职日期
		String hiredate = null;
		String hiredateStr = req.getParameter("hiredate");

		if (hiredateStr != null && !"".equals(hiredateStr)) {
			hiredate = hiredateStr.replace("-", "");
		}

		System.out.println("hiredate  :  " + hiredate);

		// cid 班级ID
		int cid = 0;
		String clazzid = req.getParameter("clazzid");

		// cid
		if (clazzid != null && !"".equals(clazzid)) {
			Pattern pattern = Pattern.compile("[0-9]*");
			if (pattern.matcher(clazzid).matches()) {
				// 是数字,转为cid 班级ID
				cid = Integer.parseInt(clazzid);
			} else {
				// 不是数字 ，cid = 0默认值
			}
		} else {
			// 没有得到数据，cid = 0默认值
		}

		// 调用Service处理数据
		TeacherService ts = new TeacherServiceImpl();
		System.out.println("ServletCid : " + cid);
		int ctb = ts.changeTeacherToBossByTid(tid, hiredateStr, cid);

		System.out.println(ctb);

		// 转换成json对象
		Gson gson = new Gson();
		String json = gson.toJson(ctb);

		resp.getWriter().println(json);

	}

	/**
	 * 根据教师名称查询 教师编号、教师姓名、教师性别、任职日期、任职科目 涉及表 :
	 * teacher(教师表)、assign(教师任职任课表)、subject(课程表)
	 * 
	 * @throws IOException
	 */

	public void getTeacherByTname(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {

		// 从前端页面获取教师姓名
		String tname = req.getParameter("serchText");

		// 处理数据
		TeacherService ts = new TeacherServiceImpl();
		List<TeacherSub> tsList = ts.findTeacherSubListByTeacherName(tname);

		// 将数据转为json格式
		Gson gson = new Gson();
		String json = gson.toJson(tsList);

		// 响应处理结果
		resp.getWriter().println(json);

	}
	
	/**
	 * 根据教师任职科目查询 教师编号、教师姓名、教师性别、任职日期、任职科目 涉及表 :
	 * teacher(教师表)、assign(教师任职任课表)、subject(课程表)
	 * 
	 * @throws IOException
	 */
	public void getTeacherBySubname(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		
		// 从前端页面获取教师任职科目
				String subname = req.getParameter("serchText");

				// 处理数据
				TeacherService ts = new TeacherServiceImpl();
				List<TeacherSub> tsList = ts.findTeacherSubListBySubname(subname);

				// 将数据转为json格式
				Gson gson = new Gson();
				String json = gson.toJson(tsList);

				// 响应处理结果
				resp.getWriter().println(json);
		
	}
	
	/**
	 * 将老师离职的方法
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void teacherLeaveOffice(HttpServletRequest req,
			HttpServletResponse resp) throws IOException{
		
		int tid = 0;
		//获取前端页面数据(老师编号)
		String tidStr = req.getParameter("tid");
		
		if (tidStr != null && !"".equals(tidStr)) {
			Pattern pattern = Pattern.compile("[0-9]*");
			if (pattern.matcher(tidStr).matches()) {
				// 是数字,转为tid 教师ID
				tid = Integer.parseInt(tidStr);
			} else {
				// 不是数字 ，tid = 0默认值
			}
		} else {
			// 没有得到数据，tid = 0默认值
		}
		
		//调用service层处理数据
		TeacherService ts = new TeacherServiceImpl();
		int num = ts.leaveOfficeTeacherService(tid);
		
		//响应处理结果
		Gson gson = new Gson();
		String json = gson.toJson(num);
		
		resp.getWriter().println(json);
		
	}
	
	/**
	 * 查询所有班主任信息
	 * 教师编号、教师姓名、教师性别、任课课程、年级、专业名称
	 * 通过班级名称、年级、专业名称
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void teacherBossList(HttpServletRequest req,
			HttpServletResponse resp) throws IOException{
		
		//获取前端数据
		//下拉框选择值
		String selidStr = req.getParameter("selid");
		int selid = Integer.parseInt(selidStr);
		
		//搜索框内容
		String serchText = req.getParameter("serchText");
		
		//调用service层查询数据
		TeacherService ts = new TeacherServiceImpl();
		
		//创建搜索对象
		int grade = 0;
		String cname = null;
		String mname = null;
		int num = selid;
		
		//判断用户搜索条件,并给条件内容赋值
		switch (num) {
		case 1:
			
			if (serchText != null && !"".equals(serchText)) {
				Pattern pattern = Pattern.compile("[0-9]*");
				if (pattern.matcher(serchText).matches()) {
					// 是数字,转为grade 年级
					grade = Integer.parseInt(serchText);
				} else {
					// 不是数字 ，grade = 0默认值
				}
			} else {
				// 没有得到数据，grade = 0默认值
			}
			
			break;

		case 2:
			cname = serchText;
			break;
		case 3:
			mname = serchText;
			break;
		default:
			break;
		}
		
		//调用service层方法查询班主任
		List<TeacherBoss> tbList = ts.findTeacherBossListByGCMN(grade, cname, mname, num);
		
		//将数据传回前端页面
		Gson gson = new Gson();
		String json = gson.toJson(tbList);
		
		resp.getWriter().println(json);
		
	}

	
}
