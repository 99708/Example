package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.pojo.Student;
import com.bjsxt.pojo.Subject;
import com.bjsxt.vo.ScoreVo;
import com.bjsxt.vo.StudentScoreVo;

/**
 * 成绩管理
 * @author 997
 *
 */
public interface ScoreDao {
	/**
	 * 根据老师的id获取所带的课程
	 * @param tid
	 * @return
	 */
	List<Subject> getSubjectByTid(int tid);
	/**
	 * 获取选择tid老师所带的subid课程的学生
	 * @param subid
	 * @param tid
	 * @return
	 */
	List<Student> getStudentBySubid(int subid, int tid);
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
	List<StudentScoreVo> pageQuery(int pageStart, int pageSize);
	
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
	int getScoreByGrade(int gid, int min, int max);
	/**
	 * 查询总的记录数
	 * @return
	 */
	int getpageCount();
	/**
	 * 年级统计之前查询所选课程
	 * @param gid
	 * @return
	 */
	List<Subject>beforefindScoreByGrade(int gid);
	/**
	 * 带条件的分页查询
	 * @return
	 */
	List<StudentScoreVo> pageQueryByArgs(int pageStart, int pageSize, int type, String cond);
	/**
	 * 查询单个学生的成绩总记录数
	 * @return
	 */
	int getpageCountBySid(int sid);
	/**
	 * 分页查询单个学生的成绩
	 * @param pageStart
	 * @param pageSize
	 * @return
	 */
	List<StudentScoreVo> pageQueryBySid(int pageStart, int pageSize, int sid);
	/**
	 * 动态获取学生总记录
	 * @param sid
	 * @param cond
	 * @return
	 */
	int getpageCountBySid(Integer sid,  String cond);
	/**
	 * 学生成绩动态分页
	 * @param pageStart
	 * @param pageSize
	 * @param sid
	 * @param cond
	 * @return
	 */
	List<StudentScoreVo> pageQueryBySidArgs(int pageStart, int pageSize,
			Integer sid, String cond);
	/**
	 * 动态获取总记录(角色为老师)
	 * @param type
	 * @param cond
	 * @return
	 */
	int getpageCount(int type, String cond);
}
