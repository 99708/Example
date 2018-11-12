package com.bjsxt.service;

import java.util.List;

import com.bjsxt.pojo.Student;
import com.bjsxt.pojo.Subject;
import com.bjsxt.vo.PageVo;
import com.bjsxt.vo.ScoreVo;
import com.bjsxt.vo.TotalVo;

/**
 * 成绩管理
 * @author 997
 *
 */
public interface ScoreService {
	/**
	 * 根据老师的id获取所带的课程
	 * @param tid
	 * @return
	 */
	List<Subject> findSubjectByTid(int tid);
	/**
	 * 获取选择tid老师所带的subid课程的学生
	 * @param subid
	 * @param tid
	 * @return
	 */
	List<Student> findStudentBySubid(int subid, int tid);
	/**
	 * 更新学生成绩信息
	 * @param sid
	 * @param subid
	 * @param score 
	 * @return
	 */
	int updateScoreByid(int sid, int subid, int score);
	/**
	 * 分页查询学生成绩
	 * @param pageSize 
	 * @param pageStart 
	 * @return
	 */
	PageVo pageQuery(int pageNum, int pageSize, int rid, Object obj);
	/**
	 * 带条件的分页查询
	 * @return
	 */
	PageVo pageQueryByArgs(int pageNum, int pageSize, int rid, Object obj, int type, String cond);
	/**
	 * 班级成绩统计
	 * @param cid
	 * @return
	 */
	List<ScoreVo> getScoreByClasses(int cid);
	/**
	 * 年级成绩统计
	 * @param gid
	 * @param subid
	 * @return
	 */
	List<TotalVo> findScoreByGrade(int gid);
	/**
	 * 年级统计之前查询所选课程
	 * @param gid
	 * @return
	 */
	List<Subject> beforefindScoreByGrade(int gid);
}
