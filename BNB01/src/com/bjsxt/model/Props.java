package com.bjsxt.model;

/**
 * 道具类
 * @author 997
 *
 */
public class Props {
	
	private int x;    //横坐标
	private int y;	  //纵坐标
	private int type; //类型  1表示魔力道具，2表示加速道具，3表示加血道具
	private int size; //大小
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	public Props(int x, int y, int type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}
	
	public Props() {
	}
	
	
}
