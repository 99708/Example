package com.bjsxt.pojo;

import java.util.List;

public class StudentPage {
	private int num;// 存储当次请求的页码数，响应给浏览器，便于下一页使用
	private int pageSize;// 存储当次请求的数据量
	private List<Student> ls;// 当次请求的查询结果
	private int pages;//存储总共的分页页码数
	private int count;//存储总共的数据量
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
	public List<Student> getLs() {
		return ls;
	}
	public void setLs(List<Student> ls) {
		this.ls = ls;
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
	@Override
	public String toString() {
		return "Page [num=" + num + ", pageSize=" + pageSize + ", ls=" + ls
				+ ", pages=" + pages + ", count=" + count + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + ((ls == null) ? 0 : ls.hashCode());
		result = prime * result + num;
		result = prime * result + pageSize;
		result = prime * result + pages;
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
		StudentPage other = (StudentPage) obj;
		if (count != other.count)
			return false;
		if (ls == null) {
			if (other.ls != null)
				return false;
		} else if (!ls.equals(other.ls))
			return false;
		if (num != other.num)
			return false;
		if (pageSize != other.pageSize)
			return false;
		if (pages != other.pages)
			return false;
		return true;
	}
	public StudentPage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentPage(int num, int pageSize, List<Student> ls, int pages, int count) {
		super();
		this.num = num;
		this.pageSize = pageSize;
		this.ls = ls;
		this.pages = pages;
		this.count = count;
	}
}
