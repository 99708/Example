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
 * ���˵���
 * @author 997
 *
 */
public class Menu extends JFrame implements ActionListener{
	
	JButton b1;//��ť���
	JButton b2;
	JButton b3;
	JButton b4;
	JFrame f;  //���崰��
	
	
	public static void main(String[] args) {
		new Menu();
	}
	
	public Menu(){
		
		f = new JFrame("ը��������");	//�½�����Ϊ"ը��������"�Ĵ���
		f.setSize(700,480);     	//���ô��ڸ߶�
		f.setLocation(300, 100);	//���ô���λ��
		
		//���ô��ڵ�ͼ��
		f.setIconImage(GameUtil.getImage("images/ioc.jpg"));
		//���ñ���ͼƬ
		Image bg = GameUtil.getImage("images/bg.jpg");
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
		
		f.setLayout(null);                         //���ò��ֹ�����
		Font ft = new Font("����", Font.PLAIN, 16); //���ð�ť����
		
		//���ð�ť
		b1 = new JButton("��ʼ��Ϸ");    //���ð�ť�е�����
		b1.setBackground(Color.YELLOW);//���ð�ť��ɫ
		b1.setFont(ft);				   //���ð�ť�����ֵ�������ʽ
		b1.setBounds(60, 150, 100, 40);//��λ��ť
		b1.setFocusPainted(false);     //ȥ��������Χ����Ȧ
		b1.addActionListener(this);    //���ü���
		
		b2 = new JButton("��Ϸ����");
		b2.setBackground(Color.YELLOW);
		b2.setFont(ft);
		b2.setBounds(60, 210, 100, 40);
		b2.addActionListener(this);
		
		b3 = new JButton("��Ϸ�÷�");
		b3.setBackground(Color.YELLOW);
		b3.setFont(ft);
		b3.setBounds(60, 270, 100, 40);
		b3.addActionListener(this);
		
		b4 = new JButton("�˳���Ϸ");
		b4.setBackground(Color.YELLOW);
		b4.setFont(ft);
		b4.setBounds(60, 330, 100, 40);
		b4.addActionListener(this);
		
		f.add(b1);										 //��Ӱ�ť���������
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���õ�����ڵ�x��ʱ�رճ���
		f.setVisible(true);	
		f.setResizable(false);							 //���ô��ڴ�С���ܸı�
	}
	
	/**
	 * ��дActionListener�ӿ��еķ���
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		 if(e.getSource() == b1){
			 //������ʼ����
//			 new Index();
//			 f.dispose();
	     }
        if(e.getSource() == b2){
        	new Rule();			//�½���Ϸ�������
	        f.dispose();		//�������˵�����
        }
        if(e.getSource() == b3) {
        	new Score();		//�½��Ʒֽ���
	        f.dispose();
        }
        if(e.getSource() == b4) {
        	new Quit();			//�½��˳�����
        	f.dispose();
        }
	}
}
