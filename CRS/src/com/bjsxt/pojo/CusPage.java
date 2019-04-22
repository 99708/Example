package com.bjsxt.pojo;

import java.util.List;

public class CusPage {
	private int pageNum;//当前请求页码
	private int pageSize;////当前请求的每页的记录数
	private int pageStart;//当次请求，分页起始查询行角标。
	private int count;//总的数据数量
	private int pages;//总的页码数
	private List<Customer> lc;
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
	public List<Customer> getLc() {
		return lc;
	}
	public void setLc(List<Customer> lc) {
		this.lc = lc;
	}
	@Override
	public String toString() {
		return "CusPage [pageNum=" + pageNum + ", pageSize=" + pageSize + ", pageStart=" + pageStart + ", count="
				+ count + ", pages=" + pages + ", lc=" + lc + "]";
	}
	public CusPage(int pageNum, int pageSize, int pageStart, int count, int pages, List<Customer> lc) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.pageStart = pageStart;
		this.count = count;
		this.pages = pages;
		this.lc = lc;
	}
	public CusPage() {
		super();
	}
	
}
