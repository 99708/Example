package com.bjsxt.model;

/**
 * ������
 * @author 997
 *
 */
public class Props {
	
	private int x;    //������
	private int y;	  //������
	private int type; //����  1��ʾħ�����ߣ�2��ʾ���ٵ��ߣ�3��ʾ��Ѫ����
	private int size; //��С
	
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
