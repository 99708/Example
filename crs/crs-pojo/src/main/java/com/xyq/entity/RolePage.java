package com.xyq.entity;

import java.util.List;

public class RolePage {

	private int pageNum;// 存储当次请求的页码数，响应给浏览器，便于下一页使用
	private int pageSize;// 存储当次请求的数据量
	private List<Role> rs;// 当次请求的查询结果
	private int pages;//存储总共的分页页码数
	private int count;//存储总共的数据量

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<Role> getRs() {
		return rs;
	}

	public void setRs(List<Role> rs) {
		this.rs = rs;
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

	public RolePage() {
	}

	public RolePage(int pageNum, int pageSize, List<Role> rs, int pages, int count) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.rs = rs;
		this.pages = pages;
		this.count = count;
	}

	@Override
	public String toString() {
		return "RolePage{" +
				"pageNum=" + pageNum +
				", pageSize=" + pageSize +
				", rs=" + rs +
				", pages=" + pages +
				", count=" + count +
				'}';
	}
}
