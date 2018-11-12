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
 * 退出界面类
 * @author 997
 *
 */
public class Quit extends JFrame implements ActionListener {

	JFrame f;		//定义窗口
	JButton b1, b2;	//定义按钮组件
	public Quit() {
		f = new JFrame("炸弹怪物人");	//新建标题为"炸弹怪物人"的窗口
		f.setSize(450,300);			//设置窗口大小
		f.setLocation(400, 200);	//设置窗口位置
		
		//设置窗口的图标
		f.setIconImage(GameUtil.getImage("images/ioc.jpg"));
		//设置背景图片
		Image bg = GameUtil.getImage("images/Quit.jpg");
		ImageIcon background = new ImageIcon(bg);
		//设置为一个标签，标签大小设置和窗口一样
		JLabel label = new JLabel(background);
		label.setBounds(0,0, f.getWidth(), f.getHeight());
		//把内容窗口格式化转化为Jpanel,
		JPanel imagePanel = (JPanel)f.getContentPane();
		imagePanel.setOpaque(false);
		f.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		f.setLayout(null);
		
		Font ft = new Font("宋体", Font.PLAIN, 16);
		
		b1 = new JButton("确认退出");
		b1.setBackground(Color.YELLOW);
		b1.setFont(ft);
		b1.setBounds(60, 200, 100, 40);
		b1.setFocusPainted(false);//去除文字周围的线圈
		b1.addActionListener(this); 
		
		b2 = new JButton("回到游戏");
		b2.setBackground(Color.YELLOW);
		b2.setFont(ft);
		b2.setBounds(280, 200, 100, 40);
		b2.setFocusPainted(false);//去除文字周围的线圈
		b2.addActionListener(this); 
		
		f.add(b1);
		f.add(b2);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		f.setVisible(true);
		f.setResizable(false);//设置窗口大小不能改变
	}

	/**
	 * 重写ActionListener接口中的方法
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1){
			System.exit(0);
	     }
		if(e.getSource() == b2){
			new Menu();
			f.dispose();
	     }
	}
}
