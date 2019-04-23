package com.xyq.entity;

import java.util.List;

/**
 * 日志管理实体类(分页)
 * @author HaoziDada
 */
public class SlfPage {
	
	private Integer num;// 存储当次请求的页码数，响应给浏览器，便于下一页使用
	private Integer pageSize;// 存储当次请求的数据量
	private List<SlfLog> slf;// 当次请求的查询结果
	private Integer pages;//存储总共的分页页码数
	private Integer count;//存储总共的数据量
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public List<SlfLog> getSlf() {
		return slf;
	}
	public void setSlf(List<SlfLog> slf) {
		this.slf = slf;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "SlfPage [num=" + num + ", pageSize=" + pageSize + ", slf=" + slf + ", pages=" + pages + ", count="
				+ count + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((num == null) ? 0 : num.hashCode());
		result = prime * result + ((pageSize == null) ? 0 : pageSize.hashCode());
		result = prime * result + ((pages == null) ? 0 : pages.hashCode());
		result = prime * result + ((slf == null) ? 0 : slf.hashCode());
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
		SlfPage other = (SlfPage) obj;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (num == null) {
			if (other.num != null)
				return false;
		} else if (!num.equals(other.num))
			return false;
		if (pageSize == null) {
			if (other.pageSize != null)
				return false;
		} else if (!pageSize.equals(other.pageSize))
			return false;
		if (pages == null) {
			if (other.pages != null)
				return false;
		} else if (!pages.equals(other.pages))
			return false;
		if (slf == null) {
			if (other.slf != null)
				return false;
		} else if (!slf.equals(other.slf))
			return false;
		return true;
	}
	public SlfPage(Integer num, Integer pageSize, List<SlfLog> slf, Integer pages, Integer count) {
		super();
		this.num = num;
		this.pageSize = pageSize;
		this.slf = slf;
		this.pages = pages;
		this.count = count;
	}
	public SlfPage() {
		super();
	}
}
