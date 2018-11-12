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
 * �˳�������
 * @author 997
 *
 */
public class Quit extends JFrame implements ActionListener {

	JFrame f;		//���崰��
	JButton b1, b2;	//���尴ť���
	public Quit() {
		f = new JFrame("ը��������");	//�½�����Ϊ"ը��������"�Ĵ���
		f.setSize(450,300);			//���ô��ڴ�С
		f.setLocation(400, 200);	//���ô���λ��
		
		//���ô��ڵ�ͼ��
		f.setIconImage(GameUtil.getImage("images/ioc.jpg"));
		//���ñ���ͼƬ
		Image bg = GameUtil.getImage("images/Quit.jpg");
		ImageIcon background = new ImageIcon(bg);
		//����Ϊһ����ǩ����ǩ��С���úʹ���һ��
		JLabel label = new JLabel(background);
		label.setBounds(0,0, f.getWidth(), f.getHeight());
		//�����ݴ��ڸ�ʽ��ת��ΪJpanel,
		JPanel imagePanel = (JPanel)f.getContentPane();
		imagePanel.setOpaque(false);
		f.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		f.setLayout(null);
		
		Font ft = new Font("����", Font.PLAIN, 16);
		
		b1 = new JButton("ȷ���˳�");
		b1.setBackground(Color.YELLOW);
		b1.setFont(ft);
		b1.setBounds(60, 200, 100, 40);
		b1.setFocusPainted(false);//ȥ��������Χ����Ȧ
		b1.addActionListener(this); 
		
		b2 = new JButton("�ص���Ϸ");
		b2.setBackground(Color.YELLOW);
		b2.setFont(ft);
		b2.setBounds(280, 200, 100, 40);
		b2.setFocusPainted(false);//ȥ��������Χ����Ȧ
		b2.addActionListener(this); 
		
		f.add(b1);
		f.add(b2);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		f.setVisible(true);
		f.setResizable(false);//���ô��ڴ�С���ܸı�
	}

	/**
	 * ��дActionListener�ӿ��еķ���
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
