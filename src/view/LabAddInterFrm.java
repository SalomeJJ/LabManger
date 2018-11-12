package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.Lab_infoDao;
import model.Lab_info;
import util.DbUtil;
import util.StringUtil;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class LabAddInterFrm extends JInternalFrame {
	private JTextField labLocationTxt;
	private JTextField labSizeTxt;
	
	private DbUtil dbUtil=new DbUtil();
	private Lab_infoDao lab_infoDao=new Lab_infoDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LabAddInterFrm frame = new LabAddInterFrm();
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
	public LabAddInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u5B9E\u9A8C\u5BA4\u4FE1\u606F\u6DFB\u52A0");
		setBounds(100, 100, 450, 300);
		
		JLabel lblNewLabel = new JLabel("\u5B9E\u9A8C\u5BA4\u5730\u5740\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(LabAddInterFrm.class.getResource("/images/loc.png")));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label = new JLabel("\u5B9E\u9A8C\u5BA4\u4EBA\u6570\uFF1A");
		label.setIcon(new ImageIcon(LabAddInterFrm.class.getResource("/images/size.png")));
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		
		labLocationTxt = new JTextField();
		labLocationTxt.setColumns(10);
		
		labSizeTxt = new JTextField();
		labSizeTxt.setColumns(10);
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labAddActionPerformed(e);
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 18));
		button.setIcon(new ImageIcon(LabAddInterFrm.class.getResource("/images/tj.png")));
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 18));
		button_1.setIcon(new ImageIcon(LabAddInterFrm.class.getResource("/images/reset.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(58)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(label)
								.addComponent(lblNewLabel))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(labLocationTxt)
								.addComponent(labSizeTxt, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(47)
							.addComponent(button)
							.addGap(61)
							.addComponent(button_1)))
					.addContainerGap(151, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(labLocationTxt, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(labSizeTxt, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(42)
							.addComponent(button))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(41)
							.addComponent(button_1)))
					.addContainerGap(79, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
	
	
	/**
	 * 实验室类别添加事件处理
	 * @param e
	 */
	private void labAddActionPerformed(ActionEvent evt) {
		String  lablocation=this.labLocationTxt.getText();
		String slabsize=this.labSizeTxt.getText();
		if(StringUtil.isEmpty(lablocation)){
			JOptionPane.showMessageDialog(null, "实验室地址不能为空！");
			return;
		}
		if(StringUtil.isEmpty(slabsize)){
			JOptionPane.showMessageDialog(null, "实验室容纳人数不能为空！");
			return;
		}
		int labsize=Integer.valueOf(this.labSizeTxt.getText());
		Lab_info lab_info=new Lab_info(lablocation,labsize);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int n=lab_infoDao.add(con, lab_info);
			if(n==1){
				JOptionPane.showMessageDialog(null, "实验室添加成功！");
				resetValue();
			}else{
				JOptionPane.showMessageDialog(null, "实验室添加失败！");
			}
		}catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "图书类别添加失败！");
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
	 * 重置事件处理
	 * @param evt
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		this.resetValue();
		
	}


	/**
	 * 重置表单
	 */
	private void resetValue(){
		this.labLocationTxt.setText("");
		this.labSizeTxt.setText("");
	}

}
