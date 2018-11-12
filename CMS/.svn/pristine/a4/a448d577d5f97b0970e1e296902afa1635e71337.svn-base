package com.bjsxt.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bjsxt.dao.ScoreDao;
import com.bjsxt.dao.impl.ScoreDaoImpl;
import com.bjsxt.pojo.Student;
import com.bjsxt.pojo.Subject;
import com.bjsxt.service.ScoreService;
import com.bjsxt.vo.PageVo;
import com.bjsxt.vo.ScoreVo;
import com.bjsxt.vo.StudentScoreVo;
import com.bjsxt.vo.TotalVo;

/**
 * 成绩管理
 * @author 997
 *
 */
public class ScoreServiceImpl implements ScoreService {

	ScoreDao scoreDao = new ScoreDaoImpl();
	
	@Override
	public List<Subject> findSubjectByTid(int tid) {
		return scoreDao.getSubjectByTid(tid);
	}

	@Override
	public List<Student> findStudentBySubid(int subid, int tid) {
		return scoreDao.getStudentBySubid(subid, tid);
	}

	@Override
	public int updateScoreByid(int sid, int subid, int score) {
		return scoreDao.updateScoreByid(sid, subid, score);
	}

	@Override
	public PageVo pageQuery(int pageNum, int pageSize, int rid, Object obj) {
		
		PageVo pageVo = null;
		int pageStart = (pageNum - 1)*pageSize;
		if(rid == 1){
			Student student = (Student) obj;
			int count = scoreDao.getpageCountBySid(student.getSid());
			int pageCount = (int) Math.ceil(count*1.0/pageSize);
			List<StudentScoreVo> ssList = scoreDao.pageQueryBySid(pageStart, pageSize, student.getSid());
			pageVo = new PageVo(pageNum,pageSize, pageStart, count, pageCount, ssList);
		}else{
			int count = scoreDao.getpageCount();
			int pageCount = (int) Math.ceil(scoreDao.getpageCount()*1.0/pageSize);
			List<StudentScoreVo> ssList = scoreDao.pageQuery(pageStart, pageSize);
			pageVo = new PageVo(pageNum,pageSize, pageStart, count, pageCount, ssList);
		}
		
		return pageVo;
	}

	@Override
	public PageVo pageQueryByArgs(int pageNum, int pageSize, int rid, Object obj, int type, String cond) {
		PageVo pageVo = null;
		int pageStart = (pageNum - 1)*pageSize;
		if(rid == 1){
			Student student = (Student) obj;
			int count = scoreDao.getpageCountBySid(student.getSid(), cond);
			int pageCount = (int) Math.ceil(count*1.0/pageSize);
			List<StudentScoreVo> ssList = scoreDao.pageQueryBySidArgs(pageStart, pageSize, student.getSid(), cond);
			pageVo = new PageVo(pageNum,pageSize, pageStart, count, pageCount, ssList);
		}else{
			int count = scoreDao.getpageCount(type, cond);
			int pageCount = (int) Math.ceil(count*1.0/pageSize);
			List<StudentScoreVo> ssList = scoreDao.pageQueryByArgs(pageStart, pageSize, type, cond);
			pageVo = new PageVo(pageNum, pageSize, pageStart, count, pageCount, ssList);
		}
		
		return pageVo;
	}

	@Override
	public List<ScoreVo> getScoreByClasses(int cid) {
		return scoreDao.getScoreByClasses(cid);
	}

	@Override
	public List<TotalVo> findScoreByGrade(int gid) {
		List<TotalVo> tl = new ArrayList<TotalVo>();
		
		int count1 = scoreDao.getScoreByGrade(gid, 0, 60);
		TotalVo tot1 = new TotalVo("0~60分人数", count1);
		tl.add(tot1);
		int count2 = scoreDao.getScoreByGrade(gid, 60, 80);
		TotalVo tot2 = new TotalVo("60~80分人数", count2);
		tl.add(tot2);
		int count3 = scoreDao.getScoreByGrade(gid, 80, 90);
		TotalVo tot3 = new TotalVo("80~90分人数", count3);
		tl.add(tot3);
		int count4 = scoreDao.getScoreByGrade(gid, 90, 100);
		TotalVo tot4 = new TotalVo("90~100分人数", count4);
		tl.add(tot4);
		return tl;
	}

	@Override
	public List<Subject> beforefindScoreByGrade(int gid) {
		return scoreDao.beforefindScoreByGrade(gid);
	}

}
