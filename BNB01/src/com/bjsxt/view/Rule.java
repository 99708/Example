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
 * ��Ϸ���������
 * @author 997
 *
 */
public class Rule extends JFrame implements ActionListener{
	
	JFrame f;    //���崰��
	JButton b;   //���尴ť���
	public Rule() {
		f = new JFrame("ը��������");	//�½�����Ϊ"ը��������"�Ĵ���
		f.setSize(1024,600);		//���ô��ڴ�С
		f.setLocation(200, 70);		//���ô���λ��
		
		//���ô��ڵ�ͼ��
		f.setIconImage(GameUtil.getImage("images/ioc.jpg"));
		//���ñ���ͼƬ
		Image bg = GameUtil.getImage("images/Rule.jpg");
		ImageIcon background = new ImageIcon(bg);
		//����Ϊһ����ǩ����ǩ��С���úʹ���һ��
		JLabel label = new JLabel(background);
		label.setBounds(0,0, f.getWidth(), f.getHeight());
		//�����ݴ��ڸ�ʽ��ת��ΪJpanel
		JPanel imagePanel = (JPanel)f.getContentPane();
		//����Ϊ͸���
		imagePanel.setOpaque(false);
		//���label
		f.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		
		f.setLayout(null);							//���ò��ֹ�����
		b = new JButton("����");						//���ð�ť����
		Font ft = new Font("����", Font.PLAIN, 16);	//����������
		b.setBackground(Color.YELLOW);				//���ð�ť�ı�����ɫ
		b.setFont(ft);								//���ð�ť�������ʽ
		b.setBounds(600, 500, 100, 40);				//���ð�ť��λ��
		b.setFocusPainted(false);					//ȥ��������Χ����Ȧ
		b.addActionListener(this); 					//��Ӽ���
		
		f.add(b);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //���õ�����ڵ�x��ʱ�رճ���
		f.setVisible(true);
		f.setResizable(false);							  //���ô��ڴ�С���ܸı�
		
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
