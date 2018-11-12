package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;



import dao.LabApplyDao;
import model.LabApply;
import util.DbUtil;
import util.StringUtil;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;

public class LabApplyInterFrm extends JInternalFrame {
	private JTextField classTxt;
	private JTextField stu_numTxt;
	private JTextField teacherTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	
	private JComboBox Jcb1;
	private JComboBox Jcb2;
	private JComboBox Jcb3;
	private JComboBox Jcb4;
	private JComboBox Jcb5;
	
	private JRadioButton MJrb;
	private JRadioButton AJrb;
	private JRadioButton week9Jrb;
	private JRadioButton week10Jrb;
	
	private DbUtil dbUtil=new DbUtil();
	private LabApplyDao labApplyDao=new LabApplyDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LabApplyInterFrm frame = new LabApplyInterFrm();
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
	public LabApplyInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u5B9E\u9A8C\u8BFE\u7533\u8BF7");
		setBounds(100, 100, 693, 360);
		
		JLabel label = new JLabel("\u73ED\u7EA7\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		
		classTxt = new JTextField();
		classTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u4EBA\u6570\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		stu_numTxt = new JTextField();
		stu_numTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u8001\u5E08\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		teacherTxt = new JTextField();
		teacherTxt.setColumns(10);
		
		JLabel label_3 = new JLabel("\u5468\u6B21\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 18));
		
		week9Jrb = new JRadioButton("9");
		buttonGroup.add(week9Jrb);
		week9Jrb.setSelected(true);
		week9Jrb.setFont(new Font("宋体", Font.PLAIN, 18));
		
		week10Jrb = new JRadioButton("10");
		buttonGroup.add(week10Jrb);
		week10Jrb.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label_4 = new JLabel("\u65F6\u95F4\uFF1A");
		label_4.setFont(new Font("宋体", Font.PLAIN, 18));
		
		MJrb = new JRadioButton("\u4E0A\u53482-5\u8282");
		buttonGroup_1.add(MJrb);
		MJrb.setSelected(true);
		MJrb.setFont(new Font("宋体", Font.PLAIN, 18));
		
	    AJrb = new JRadioButton("\u4E0B\u53486-9\u8282");
		buttonGroup_1.add(AJrb);
		AJrb.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label_5 = new JLabel("\u5468\u4E00");
		label_5.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label_6 = new JLabel("\u5468\u4E8C");
		label_6.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label_7 = new JLabel("\u5468\u4E09");
		label_7.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label_8 = new JLabel("\u5468\u56DB");
		label_8.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label_9 = new JLabel("\u5468\u4E94");
		label_9.setFont(new Font("宋体", Font.PLAIN, 18));
		
		Jcb1 = new JComboBox();
		Jcb1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		Jcb2 = new JComboBox();
		Jcb2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		Jcb3 = new JComboBox();
		Jcb3.setFont(new Font("宋体", Font.PLAIN, 18));
		
		Jcb4 = new JComboBox();
		Jcb4.setFont(new Font("宋体", Font.PLAIN, 18));
		
		Jcb5 = new JComboBox();
		Jcb5.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JButton button = new JButton("\u63D0\u4EA4");
		button.setIcon(new ImageIcon(LabApplyInterFrm.class.getResource("/images/tj.png")));
		button.setFont(new Font("宋体", Font.PLAIN, 18));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					labApplyActionPerformed(e);
			}
		});
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.setIcon(new ImageIcon(LabApplyInterFrm.class.getResource("/images/reset.png")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetActionPerformed(e);
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(week9Jrb)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(week10Jrb))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(label)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(classTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup()
													.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
														.addComponent(label_2)
														.addComponent(label_1))
													.addPreferredGap(ComponentPlacement.RELATED)
													.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
														.addComponent(teacherTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(stu_numTxt, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
											.addPreferredGap(ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(Jcb1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(label_5))
											.addGap(25))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_4)
											.addGap(231)))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(5)
											.addComponent(button))
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(label_6)
												.addComponent(Jcb2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGap(27)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(Jcb3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(label_7))))
									.addGap(25)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(label_8)
												.addComponent(Jcb4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGap(18)
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(Jcb5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(label_9)))
										.addComponent(button_1)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(86)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(AJrb)
								.addComponent(MJrb))))
					.addGap(128))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(classTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5)
						.addComponent(label_6)
						.addComponent(label_7)
						.addComponent(label_8)
						.addComponent(label_9))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(stu_numTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Jcb1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Jcb2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Jcb3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Jcb4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Jcb5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(teacherTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(week9Jrb)
						.addComponent(week10Jrb))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(MJrb)
						.addComponent(button)
						.addComponent(button_1)
						.addComponent(label_4))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(AJrb)
					.addContainerGap(58, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		fillbox();

	}
	
	/**
	 * 重置事件处理
	 * @param e
	 */
	private void resetActionPerformed(ActionEvent e) {
		resetValue();
	}

	/**
	 * 实验室课申请提交事件处理
	 * @param e
	 */
	private void labApplyActionPerformed(ActionEvent evt) {
			 String classname=classTxt.getText();
			 String stu_num=stu_numTxt.getText();
			 String teacher =teacherTxt.getText();
			 if(StringUtil.isEmpty(classname)){
					JOptionPane.showMessageDialog(null, "班级不能为空！");
					return;
				}
			 if(StringUtil.isEmpty(stu_num)){
					JOptionPane.showMessageDialog(null, "人数不能为空！");
					return;
				}
			 if(StringUtil.isEmpty(teacher)){
					JOptionPane.showMessageDialog(null, "老师不能为空！");
					return;
				}
			 String week="";
			 if(week9Jrb.isSelected()) {
				 week="9";
			 }else if(week10Jrb.isSelected()) {
				 week="10";
			 }
			 
			 String time="";
			 if(MJrb.isSelected()) {
				 time="2-5节";
			 }else if(AJrb.isSelected()) {
				 time="6-9节";
			 }
			 
			 String z1=(String)Jcb1.getSelectedItem();
			 String z2=(String)Jcb2.getSelectedItem();	
			 String z3=(String)Jcb3.getSelectedItem();	
			 String z4=(String)Jcb4.getSelectedItem();	
			 String z5=(String)Jcb5.getSelectedItem();	
			 
			 LabApply labApply=new LabApply(classname, Integer.parseInt(stu_num), teacher, week, time, z1,z2,z3,z4,z5);
			 
			 Connection con =null;
			 try {
				 con=dbUtil.getCon();
				 int addNum=labApplyDao.add(con,labApply);
				 if(addNum==1){
						JOptionPane.showMessageDialog(null, "申请提交成功！");
						resetValue();
					}else {
						JOptionPane.showMessageDialog(null, "申请提交失败！");
					}
			 }catch(Exception e) {
				 e.printStackTrace();
				 JOptionPane.showMessageDialog(null, "申请提交失败！");
			 }finally {
					try {
						dbUtil.closeCon(con);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			 }
	}
	
	/**
	 * 重置表单
	 */
	private void resetValue() {
		this.classTxt.setText("");
		this.stu_numTxt.setText("");
		this.teacherTxt.setText("");
		this.week9Jrb.setSelected(true);
		this.MJrb.setSelected(true);
		this.Jcb1.setSelectedIndex(0);
		this.Jcb2.setSelectedIndex(0);
		this.Jcb3.setSelectedIndex(0);
		this.Jcb4.setSelectedIndex(0);
		this.Jcb5.setSelectedIndex(0);
	}

	/**
	 * 初始化下拉框
	 */
	private void fillbox() {
		this.Jcb1.addItem(null);
		this.Jcb1.addItem("√");
		this.Jcb1.addItem("×");
		this.Jcb2.addItem(null);
		this.Jcb2.addItem("√");
		this.Jcb2.addItem("×");
		this.Jcb3.addItem(null);
		this.Jcb3.addItem("√");
		this.Jcb3.addItem("×");
		this.Jcb4.addItem(null);
		this.Jcb4.addItem("√");
		this.Jcb4.addItem("×");
		this.Jcb5.addItem(null);
		this.Jcb5.addItem("√");
		this.Jcb5.addItem("× ");
		
	}
	
	
}
