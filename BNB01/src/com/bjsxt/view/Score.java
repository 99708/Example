package com.bjsxt.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.bjsxt.util.GameUtil;

/**
 * 计分界面类
 * @author 997
 *
 */
public class Score extends JFrame implements ActionListener {

	JFrame f;	//定义窗口
	JButton b;  //定义按钮组件
	
	public Score() {
		f = new JFrame("炸弹怪物人");  //新建标题为"炸弹怪物人"的窗口
		f.setSize(1024,600);		//设置窗口大小
		f.setLocation(200, 70);		//设置窗口位置
		
		//设置窗口的图标
		f.setIconImage(GameUtil.getImage("images/ioc.jpg"));
		//设置背景图片
		Image bg = GameUtil.getImage("images/Score.jpg");
		ImageIcon background = new ImageIcon(bg);
		//设置为一个标签，标签大小设置和窗口一样
		JLabel label = new JLabel(background);
		label.setBounds(0,0, f.getWidth(), f.getHeight());
		//把内容窗口格式化转化为Jpanel
		JPanel imagePanel = (JPanel)f.getContentPane();
		//设置为透光的
		imagePanel.setOpaque(false);
		f.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		f.setLayout(null);
		
		b = new JButton("返回");
		Font ft = new Font("宋体", Font.PLAIN, 16);
		b.setBackground(Color.YELLOW);
		b.setFont(ft);
		b.setBounds(600, 500, 100, 40);
		b.setFocusPainted(false);//去除文字周围的线圈
		b.addActionListener(this); 
		
		f.add(b);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		f.setVisible(true);
	
	}
	
	/**
	 * 重写ActionListener接口中的方法
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b){
			new Menu();
			f.dispose();
	     }
	}

}
