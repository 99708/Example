package com.xyq.entity;

import java.util.List;
import java.util.Objects;

/**
 * 菜单实体类
 * @author 997
 *
 */ public class Menu {
	private int mid;//菜单id
	private String mname;//菜单名称
	private String murl;//菜单url
	private String mdesc;//菜单描述
	private int pid;//父类id
	private List<Menu> nextMenu;//二级菜单
	
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

	public List<Menu> getNextMenu() {
		return nextMenu;
	}

	public void setNextMenu(List<Menu> nextMenu) {
		this.nextMenu = nextMenu;
	}
	
	public Menu(int mid, String mname, String murl, String mdesc, int pid, List<Menu> nextMenu) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.murl = murl;
		this.mdesc = mdesc;
		this.pid = pid;
		this.nextMenu = nextMenu;
	}

	public Menu() {
		super();
	}

	@Override
	public String toString() {
		return "Menu [mid=" + mid + ", mname=" + mname + ", murl=" + murl + ", mdesc=" + mdesc + ", pid=" + pid
				+ ", nextMenu=" + nextMenu + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Menu)) return false;
		Menu menu = (Menu) o;
		return getMid() == menu.getMid() &&
				getPid() == menu.getPid() &&
				Objects.equals(getMname(), menu.getMname()) &&
				Objects.equals(getMurl(), menu.getMurl()) &&
				Objects.equals(getMdesc(), menu.getMdesc()) &&
				Objects.equals(getNextMenu(), menu.getNextMenu());
	}

	@Override
	public int hashCode() {

		return Objects.hash(getMid(), getMname(), getMurl(), getMdesc(), getPid(), getNextMenu());
	}
}
