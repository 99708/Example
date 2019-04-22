package com.xyq.entity;

import java.util.List;

public class CusPage {
	private int pageNum;//当前请求的页码数
	private int pageSize;//当前请求的每页的记录数
	private int pageStart;//当次请求，分页起始查询行角标。
	private int count;//总的数据数量
	private int pages;//总的页码数
	private List<Customer> customerList;//当次分页请求的数据
	public CusPage(int pageNum, int pageSize, int pageStart, int count, int pages, List<Customer> customerList) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.pageStart = pageStart;
		this.count = count;
		this.pages = pages;
		this.customerList = customerList;
	}
	public CusPage() {
		super();
	}
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
	public List<Customer> getCustomerList() {
		return customerList;
	}
	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}
	@Override
	public String toString() {
		return "RentalPage [pageNum=" + pageNum + ", pageSize=" + pageSize + ", pageStart=" + pageStart + ", count="
				+ count + ", pages=" + pages + ", rentalList=" + customerList + "]";
	}
	
}
