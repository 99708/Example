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
 * �Ʒֽ�����
 * @author 997
 *
 */
public class Score extends JFrame implements ActionListener {

	JFrame f;	//���崰��
	JButton b;  //���尴ť���
	
	public Score() {
		f = new JFrame("ը��������");  //�½�����Ϊ"ը��������"�Ĵ���
		f.setSize(1024,600);		//���ô��ڴ�С
		f.setLocation(200, 70);		//���ô���λ��
		
		//���ô��ڵ�ͼ��
		f.setIconImage(GameUtil.getImage("images/ioc.jpg"));
		//���ñ���ͼƬ
		Image bg = GameUtil.getImage("images/Score.jpg");
		ImageIcon background = new ImageIcon(bg);
		//����Ϊһ����ǩ����ǩ��С���úʹ���һ��
		JLabel label = new JLabel(background);
		label.setBounds(0,0, f.getWidth(), f.getHeight());
		//�����ݴ��ڸ�ʽ��ת��ΪJpanel
		JPanel imagePanel = (JPanel)f.getContentPane();
		//����Ϊ͸���
		imagePanel.setOpaque(false);
		f.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		f.setLayout(null);
		
		b = new JButton("����");
		Font ft = new Font("����", Font.PLAIN, 16);
		b.setBackground(Color.YELLOW);
		b.setFont(ft);
		b.setBounds(600, 500, 100, 40);
		b.setFocusPainted(false);//ȥ��������Χ����Ȧ
		b.addActionListener(this); 
		
		f.add(b);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		f.setVisible(true);
	
	}
	
	/**
	 * ��дActionListener�ӿ��еķ���
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b){
			new Menu();
			f.dispose();
	     }
	}

}
