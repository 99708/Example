package com.xyq.entity;

import java.util.List;

/**
 * 用户分页实体类
 * 
 *
 */
public class UserPage {
	private int pageNum;//当前请求页码
	private int pageSize;////当前请求的每页的记录数
	private int pageStart;//当次请求，分页起始查询行角标。
	private int count;//总的数据数量
	private int pages;//总的页码数
	private List<User> lu;
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
	public int getPageStart() {
		return pageStart;
	}
	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public List<User> getLu() {
		return lu;
	}
	public void setLu(List<User> lu) {
		this.lu = lu;
	}
	@Override
	public String toString() {
		return "UserPage [pageNum=" + pageNum + ", pageSize=" + pageSize + ", pageStart=" + pageStart + ", count="
				+ count + ", pages=" + pages + ", lu=" + lu + "]";
	}
	public UserPage(int pageNum, int pageSize, int pageStart, int count, int pages, List<User> lu) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.pageStart = pageStart;
		this.count = count;
		this.pages = pages;
		this.lu = lu;
	}
	public UserPage() {
		super();
	}
	
}
