package com.bjsxt.pojo;

import java.util.List;

import com.bjsxt.pojo.Menu;

public class Menu {
	private int mid;//存储菜单ID
	private String mname;//存储菜单名
	private String murl;//菜单URL
	private String mdesc;//菜单描述
	private int pid;//菜单父ID
	
	private List<Menu> lm;//存储二级菜单信息

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMurl() {
		return murl;
	}

	public void setMurl(String murl) {
		this.murl = murl;
	}

	public String getMdesc() {
		return mdesc;
	}

	public void setMdesc(String mdesc) {
		this.mdesc = mdesc;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public List<Menu> getLm() {
		return lm;
	}

	public void setLm(List<Menu> lm) {
		this.lm = lm;
	}

	@Override
	public String toString() {
		return "Menu [mid=" + mid + ", mname=" + mname + ", murl=" + murl
				+ ", mdesc=" + mdesc + ", pid=" + pid + ", lm=" + lm + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lm == null) ? 0 : lm.hashCode());
		result = prime * result + ((mdesc == null) ? 0 : mdesc.hashCode());
		result = prime * result + mid;
		result = prime * result + ((mname == null) ? 0 : mname.hashCode());
		result = prime * result + ((murl == null) ? 0 : murl.hashCode());
		result = prime * result + pid;
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
		Menu other = (Menu) obj;
		if (lm == null) {
			if (other.lm != null)
				return false;
		} else if (!lm.equals(other.lm))
			return false;
		if (mdesc == null) {
			if (other.mdesc != null)
				return false;
		} else if (!mdesc.equals(other.mdesc))
			return false;
		if (mid != other.mid)
			return false;
		if (mname == null) {
			if (other.mname != null)
				return false;
		} else if (!mname.equals(other.mname))
			return false;
		if (murl == null) {
			if (other.murl != null)
				return false;
		} else if (!murl.equals(other.murl))
			return false;
		if (pid != other.pid)
			return false;
		return true;
	}

	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Menu(int mid, String mname, String murl, String mdesc, int pid,
			List<Menu> lm) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.murl = murl;
		this.mdesc = mdesc;
		this.pid = pid;
		this.lm = lm;
	}
	
}
