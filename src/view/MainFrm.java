package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder; 

import util.*;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table =null;
	private Deal deal =new Deal();
	private DbUtil dbUtil=new DbUtil();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrm.class.getResource("/images/log2.png")));
		setTitle("\u5B9E\u9A8C\u5BA4\u5B89\u6392\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 942, 489);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u5B9E\u9A8C\u5BA4\u7BA1\u7406             ");
		menu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/gli.png")));
		menuBar.add(menu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u5B9E\u9A8C\u5BA4\u4FE1\u606F\u5F55\u5165   ");
		mntmNewMenuItem_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menu.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LabAddInterFrm labAddInterFrm=new LabAddInterFrm();
				labAddInterFrm.setVisible(true);
				table.add(labAddInterFrm);
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/luru.png")));
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u5B9E\u9A8C\u5BA4\u4FE1\u606F\u7BA1\u7406");
		mntmNewMenuItem_5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LabMangerInterFrm labMangerInterFrm=new LabMangerInterFrm();
				labMangerInterFrm.setVisible(true);
				table.add(labMangerInterFrm);
			}
		});
		mntmNewMenuItem_5.setIcon(new ImageIcon(MainFrm.class.getResource("/images/glii.png")));
		menu.add(mntmNewMenuItem_5);
		
		JMenu menu_1 = new JMenu("\u5B9E\u9A8C\u8BFE\u7533\u8BF7          ");
		menu_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/sqing.png")));
		menuBar.add(menu_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u5B9E\u9A8C\u8BFE\u7533\u8BF7\u5F55\u5165   ");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LabApplyInterFrm labApplyInterFrm=new LabApplyInterFrm();
				labApplyInterFrm.setVisible(true);
				table.add(labApplyInterFrm);
				
			}
		});
		mntmNewMenuItem_4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menu_1.add(mntmNewMenuItem_4);
		mntmNewMenuItem_4.setIcon(new ImageIcon(MainFrm.class.getResource("/images/sq.png")));
		
		JMenuItem menuItem = new JMenuItem("\u5B9E\u9A8C\u8BFE\u7533\u8BF7\u7BA1\u7406");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LabApplyMangerInterFrm labApplyMangerInterFrm=new LabApplyMangerInterFrm();
				labApplyMangerInterFrm.setVisible(true);
				table.add(labApplyMangerInterFrm);
			}
		});
		menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/glii.png")));
		menuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menu_1.add(menuItem);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u8BFE\u8868\u751F\u6210");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				applyresultsActionPerformed(e);
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		mntmNewMenuItem_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/sc.png")));
		menuBar.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u8BFE\u8868\u67E5\u8BE2");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApplyResultsInterFrm applyResultsInterFrm=new ApplyResultsInterFrm();
				applyResultsInterFrm.setVisible(true);
				table.add(applyResultsInterFrm);
			}
		});
		mntmNewMenuItem_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		mntmNewMenuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/cx.png")));
		menuBar.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		mntmNewMenuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null, "是否退出系统");
				if(result==0){
					dispose();
				}
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/exit.png")));
		menuBar.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		table = new JDesktopPane();
		contentPane.add(table, BorderLayout.CENTER);
		
		//设置JFrame最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	/**
	 * 课表生成事件处理
	 * @param e
	 */
	protected void applyresultsActionPerformed(ActionEvent e) {
		Connection con=null;
		try {
			con=dbUtil.getCon();
			deal.deletetable(con);//清空生成表
			//获取申请的班级总数
			int num=deal.countclassnum(con);
			//获取班级号
			String[] classcount=deal.countclass(con);
			//为每个班级增加一行记录
			deal.createEachClass(con,num,classcount);
			
			String week[]= {"9","10"};
			String xqj[]= {"Monday","Tuesday","Wednesday","Thursday","Friday"};
			String time[]= {"2-5节","6-9节"};
			
			int n=2;
			for(int i=0;i<2;i++) {   //周
				for(int j=0;j<5;j++) {  //天
					for(int k=0;k<2;k++) {  //早上下午
						n=deal.paike(con, week[i], time[k], xqj[j]);
						//if(n==0) {
						//	JOptionPane.showMessageDialog(null, "生成失败，请添加实验室");
						//	deal.deletetable(con);//清空生成表
						//	return;
						//}
					}
				}
			}
			if(n==1) {
				JOptionPane.showMessageDialog(null, "生成成功！");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
