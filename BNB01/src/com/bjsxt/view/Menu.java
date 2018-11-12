package com.bjsxt.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.bjsxt.util.GameUtil;

/**
 * 主菜单类
 * @author 997
 *
 */
public class Menu extends JFrame implements ActionListener{
	
	JButton b1;//按钮组件
	JButton b2;
	JButton b3;
	JButton b4;
	JFrame f;  //定义窗口
	
	
	public static void main(String[] args) {
		new Menu();
	}
	
	public Menu(){
		
		f = new JFrame("炸弹怪物人");	//新建标题为"炸弹怪物人"的窗口
		f.setSize(700,480);     	//设置窗口高度
		f.setLocation(300, 100);	//设置窗口位置
		
		//设置窗口的图标
		f.setIconImage(GameUtil.getImage("images/ioc.jpg"));
		//设置背景图片
		Image bg = GameUtil.getImage("images/bg.jpg");
		ImageIcon background = new ImageIcon(bg);
		//设置为一个标签，标签大小设置和窗口一样
		JLabel label = new JLabel(background);
		label.setBounds(0,0, f.getWidth(), f.getHeight());
		//把内容窗口格式化转化为Jpanel
		JPanel imagePanel = (JPanel)f.getContentPane();
		//设置为透光的
		imagePanel.setOpaque(false);
		//添加label
		f.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		
		f.setLayout(null);                         //设置布局管理器
		Font ft = new Font("宋体", Font.PLAIN, 16); //设置按钮字体
		
		//设置按钮
		b1 = new JButton("开始游戏");    //设置按钮中的文字
		b1.setBackground(Color.YELLOW);//设置按钮颜色
		b1.setFont(ft);				   //设置按钮中文字的字体样式
		b1.setBounds(60, 150, 100, 40);//定位按钮
		b1.setFocusPainted(false);     //去除文字周围的线圈
		b1.addActionListener(this);    //设置监听
		
		b2 = new JButton("游戏规则");
		b2.setBackground(Color.YELLOW);
		b2.setFont(ft);
		b2.setBounds(60, 210, 100, 40);
		b2.addActionListener(this);
		
		b3 = new JButton("游戏得分");
		b3.setBackground(Color.YELLOW);
		b3.setFont(ft);
		b3.setBounds(60, 270, 100, 40);
		b3.addActionListener(this);
		
		b4 = new JButton("退出游戏");
		b4.setBackground(Color.YELLOW);
		b4.setFont(ft);
		b4.setBounds(60, 330, 100, 40);
		b4.addActionListener(this);
		
		f.add(b1);										 //添加按钮组件到窗口
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置点击窗口的x号时关闭程序
		f.setVisible(true);	
		f.setResizable(false);							 //设置窗口大小不能改变
	}
	
	/**
	 * 重写ActionListener接口中的方法
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		 if(e.getSource() == b1){
			 //创建开始界面
//			 new Index();
//			 f.dispose();
	     }
        if(e.getSource() == b2){
        	new Rule();			//新建游戏规则界面
	        f.dispose();		//销毁主菜单界面
        }
        if(e.getSource() == b3) {
        	new Score();		//新建计分界面
	        f.dispose();
        }
        if(e.getSource() == b4) {
        	new Quit();			//新建退出界面
        	f.dispose();
        }
	}
}
