package com.bjsxt.pojo;

import java.util.List;

public class TeacherPage {

	private int num;// 存储当次请求的页码数，响应给浏览器，便于下一页使用
	private int pageSize;// 存储当次请求的数据量
	private List<Teacher> ts;// 当次请求的查询结果
	private int pages;//存储总共的分页页码数
	private int count;//存储总共的数据量
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + num;
		result = prime * result + pageSize;
		result = prime * result + pages;
		result = prime * result + ((ts == null) ? 0 : ts.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TeacherPage other = (TeacherPage) obj;
		if (count != other.count)
			return false;
		if (num != other.num)
			return false;
		if (pageSize != other.pageSize)
			return false;
		if (pages != other.pages)
			return false;
		if (ts == null) {
			if (other.ts != null)
				return false;
		} else if (!ts.equals(other.ts))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TeacherPage [num=" + num + ", pageSize=" + pageSize + ", ts="
				+ ts + ", pages=" + pages + ", count=" + count + "]";
	}
	public TeacherPage(int num, int pageSize, List<Teacher> ts, int pages,
			int count) {
		super();
		this.num = num;
		this.pageSize = pageSize;
		this.ts = ts;
		this.pages = pages;
		this.count = count;
	}
	public TeacherPage() {
		super();
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<Teacher> getTs() {
		return ts;
	}
	public void setTs(List<Teacher> ts) {
		this.ts = ts;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
