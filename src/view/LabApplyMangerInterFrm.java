package view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.management.NotificationEmitter;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.LabApply;
import model.Lab_info;
import util.DbUtil;
import util.StringUtil;
import dao.LabApplyDao;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LabApplyMangerInterFrm extends JInternalFrame {
	private DbUtil dbUtil=new DbUtil();
	private LabApplyDao labApplyDao=new LabApplyDao();
	private JTable labApplyTable;
	private JTextField cxTxt;
	private JComboBox Jcb;
	private JTextField idTxt;
	private JTextField classTxt;
	private JTextField stu_numTxt;
	private JTextField teacherTxt;
	private JTextField weekTxt;
	private JTextField timeTxt;
	private JTextField z1Txt;
	private JTextField z2Txt;
	private JTextField z3Txt;
	private JTextField z4Txt;
	private JTextField z5Txt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LabApplyMangerInterFrm frame = new LabApplyMangerInterFrm();
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
	public LabApplyMangerInterFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u6392\u8BFE\u7BA1\u7406");
		setBounds(100, 100, 848, 861);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u6392\u8BFE\u7533\u8BF7\u4FE1\u606F\u67E5\u8BE2");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		
		Jcb = new JComboBox();
		Jcb.setFont(new Font("宋体", Font.PLAIN, 18));
		
		cxTxt = new JTextField();
		cxTxt.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.setIcon(new ImageIcon(LabApplyMangerInterFrm.class.getResource("/images/cx.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				applySearchActionPerformed(e);
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(label)
							.addGap(18)
							.addComponent(Jcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addComponent(cxTxt, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(button)))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(Jcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cxTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGap(27)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		
		JLabel label_1 = new JLabel("\u7F16\u53F7\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		idTxt = new JTextField();
		idTxt.setFont(new Font("宋体", Font.PLAIN, 18));
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u73ED\u7EA7\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		classTxt = new JTextField();
		classTxt.setFont(new Font("宋体", Font.PLAIN, 18));
		classTxt.setColumns(10);
		
		JLabel label_3 = new JLabel("\u4EBA\u6570\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 18));
		
		stu_numTxt = new JTextField();
		stu_numTxt.setFont(new Font("宋体", Font.PLAIN, 18));
		stu_numTxt.setColumns(10);
		
		JLabel label_4 = new JLabel("\u6559\u5E08\uFF1A");
		label_4.setFont(new Font("宋体", Font.PLAIN, 18));
		
		teacherTxt = new JTextField();
		teacherTxt.setFont(new Font("宋体", Font.PLAIN, 18));
		teacherTxt.setColumns(10);
		
		JLabel label_5 = new JLabel("\u5468\u6570\uFF1A");
		label_5.setFont(new Font("宋体", Font.PLAIN, 18));
		
		weekTxt = new JTextField();
		weekTxt.setFont(new Font("宋体", Font.PLAIN, 18));
		weekTxt.setColumns(10);
		
		JLabel label_6 = new JLabel("\u65F6\u95F4\uFF1A");
		label_6.setFont(new Font("宋体", Font.PLAIN, 18));
		
		timeTxt = new JTextField();
		timeTxt.setFont(new Font("宋体", Font.PLAIN, 18));
		timeTxt.setColumns(10);
		
		JLabel label_7 = new JLabel("\u5468\u4E00");
		label_7.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label_8 = new JLabel("\u5468\u4E8C");
		label_8.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label_9 = new JLabel("\u5468\u4E09");
		label_9.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label_10 = new JLabel("\u5468\u56DB");
		label_10.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label_11 = new JLabel("\u5468\u4E94");
		label_11.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labApplyUpdateActionEvent(e);
			}
		});
		button_1.setIcon(new ImageIcon(LabApplyMangerInterFrm.class.getResource("/images/xiug.png")));
		button_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JButton button_2 = new JButton("\u5220\u9664");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labApplydeleteActionEvent(e);
			}
		});
		button_2.setIcon(new ImageIcon(LabApplyMangerInterFrm.class.getResource("/images/schu .png")));
		button_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		z1Txt = new JTextField();
		z1Txt.setFont(new Font("宋体", Font.PLAIN, 18));
		z1Txt.setColumns(10);
		
		z2Txt = new JTextField();
		z2Txt.setFont(new Font("宋体", Font.PLAIN, 18));
		z2Txt.setColumns(10);
		
		z3Txt = new JTextField();
		z3Txt.setFont(new Font("宋体", Font.PLAIN, 18));
		z3Txt.setColumns(10);
		
		z4Txt = new JTextField();
		z4Txt.setFont(new Font("宋体", Font.PLAIN, 18));
		z4Txt.setColumns(10);
		
		z5Txt = new JTextField();
		z5Txt.setFont(new Font("宋体", Font.PLAIN, 18));
		z5Txt.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(classTxt))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(stu_numTxt))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_6)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(timeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_5)
								.addComponent(label_4))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(teacherTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(weekTxt)))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))
					.addGap(84)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_7)
								.addComponent(label_8))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(z1Txt, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
								.addComponent(z2Txt, 0, 0, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_10)
									.addGap(18)
									.addComponent(z4Txt, 0, 0, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_9)
									.addGap(18)
									.addComponent(z3Txt, 0, 0, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_11)
									.addGap(18)
									.addComponent(z5Txt, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)))))
					.addGap(87)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(button_2)
						.addComponent(button_1))
					.addGap(204))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(13, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(label_1)
										.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(10)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(label_2)
										.addComponent(classTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(13))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(label_7)
										.addComponent(z1Txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)))
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel.createSequentialGroup()
											.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
												.addComponent(label_3)
												.addComponent(stu_numTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(label_8)
												.addComponent(z2Txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGap(13)
											.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
												.addComponent(label_4)
												.addComponent(teacherTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
											.addComponent(label_9)
											.addComponent(z3Txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(button_1)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
											.addComponent(weekTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(label_5)
											.addComponent(label_10))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(z4Txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(6)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(label_6)
										.addComponent(timeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_11)))
								.addComponent(button_2)))
						.addComponent(z5Txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		labApplyTable = new JTable();
		labApplyTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				labApplyTableMousePressed(e);
			}
		});
		labApplyTable.setRowHeight(50);//指定每一行的行高50
		labApplyTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u73ED\u7EA7", "\u4EBA\u6570", "\u6559\u5E08", "\u5468\u6570", "\u65F6\u95F4", "\u5468\u4E00", "\u5468\u4E8C", "\u5468\u4E09", "\u5468\u56DB", "\u5468\u4E94"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		labApplyTable.getColumnModel().getColumn(1).setPreferredWidth(83);
		labApplyTable.setFont(new Font("宋体", Font.PLAIN, 18));
		scrollPane.setViewportView(labApplyTable);
		getContentPane().setLayout(groupLayout);
		this.fillTable(new LabApply());
		this.fillbox();

	}
	
	private void labApplydeleteActionEvent(ActionEvent evt) {
		String id=idTxt.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
		if(n==0) {
			Connection con=null;
			try {
				con=dbUtil.getCon();
				int deleteNum=labApplyDao.delete(con, id);
				if(deleteNum==1){
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetValue();
					this.fillTable(new LabApply());
				}else{
					JOptionPane.showMessageDialog(null, "删除失败");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "删除失败");
			}finally {
				try {
					dbUtil.closeCon(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 实验课申请信息修改
	 * @param e
	 */
	private void labApplyUpdateActionEvent(ActionEvent e) {
		String id=idTxt.getText();
		String classname=classTxt.getText();
		String stu_num=stu_numTxt.getText();
		String teacher=teacherTxt.getText();
		String week=weekTxt.getText();
		String time=timeTxt.getText();
		String w1=z1Txt.getText();
		String w2=z2Txt.getText();
		String w3=z3Txt.getText();
		String w4=z4Txt.getText();
		String w5=z5Txt.getText();
		
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		if(StringUtil.isEmpty(classname)){
			JOptionPane.showMessageDialog(null, "班级不能为空");
			return;
		}
		if(StringUtil.isEmpty(stu_num)){
			JOptionPane.showMessageDialog(null, "人数不能为空");
			return;
		}
		if(StringUtil.isEmpty(teacher)){
			JOptionPane.showMessageDialog(null, "教师不能为空");
			return;
		}
		if(StringUtil.isEmpty(week)){
			JOptionPane.showMessageDialog(null, "周数不能为空");
			return;
		}
		if(StringUtil.isEmpty(time)){
			JOptionPane.showMessageDialog(null, "时间不能为空");
			return;
		}
		
		LabApply labApply=new LabApply(Integer.parseInt(id),classname,Integer.parseInt(stu_num),teacher,week,time,w1,w2,w3,w4,w5);
		Connection con =null;
		try {
			con=dbUtil.getCon();
			int modifyNum=labApplyDao.update(con, labApply);
			if(modifyNum==1){
				JOptionPane.showMessageDialog(null, "修改成功");
				this.resetValue();
				fillTable(new LabApply());
			}else{
				JOptionPane.showMessageDialog(null, "修改失败");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "修改失败");
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 重置
	 */

	private void resetValue() {
		idTxt.setText("");
		classTxt.setText("");
		stu_numTxt.setText("");
		teacherTxt.setText("");
		weekTxt.setText("");
		timeTxt.setText("");
		z1Txt.setText(null);
		z2Txt.setText(null);
		z3Txt.setText(null);
		z4Txt.setText(null);
		z5Txt.setText(null);
	}

	/**
	 * 表格点击事件处理
	 * @param e
	 */
	private void labApplyTableMousePressed(MouseEvent evt) {
		int row=labApplyTable.getSelectedRow();
		idTxt.setText((String)(labApplyTable.getValueAt(row, 0)));
		classTxt.setText((String)labApplyTable.getValueAt(row, 1));
		stu_numTxt.setText((String)labApplyTable.getValueAt(row, 2));
		teacherTxt.setText((String)labApplyTable.getValueAt(row, 3));
		weekTxt.setText((String)labApplyTable.getValueAt(row, 4));
		timeTxt.setText((String)labApplyTable.getValueAt(row, 5));
		z1Txt.setText((String)labApplyTable.getValueAt(row, 6));
		z2Txt.setText((String)labApplyTable.getValueAt(row, 7));
		z3Txt.setText((String)labApplyTable.getValueAt(row, 8));
		z4Txt.setText((String)labApplyTable.getValueAt(row, 9));
		z5Txt.setText((String)labApplyTable.getValueAt(row, 10));
		
	}

	/**
	 * 排课申请查询事件处理
	 * @param evt
	 */
	private void applySearchActionPerformed(ActionEvent evt) {
		if(this.Jcb.getSelectedIndex()==0) {
			String s_classname=this.cxTxt.getText();
			LabApply labApply=new LabApply();
			labApply.setClassd(s_classname);
			this.fillTable(labApply);
		}else if (this.Jcb.getSelectedIndex()==1) {
			String s_teacher=this.cxTxt.getText();
			LabApply labApply=new LabApply();
			labApply.setTeacher(s_teacher);
			this.fillTable(labApply);
		}
	}

	/**
	 * 初始化表格
	 * @param labApply
	 */
	private void fillTable(LabApply labApply) {
		DefaultTableModel dtm=(DefaultTableModel) labApplyTable.getModel();
		dtm.setRowCount(0);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=labApplyDao.list(con, labApply);
			while(rs.next()){
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("class"));
				v.add(rs.getString("stu_num"));
				v.add(rs.getString("teacher"));
				v.add(rs.getString("week"));
				v.add(rs.getString("time"));
				v.add(rs.getString("Monday"));
				v.add(rs.getString("Tuesday"));
				v.add(rs.getString("Wednesday"));
				v.add(rs.getString("Thursday"));
				v.add(rs.getString("Friday"));
				
				dtm.addRow(v);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	 * 初始化下拉框
	 */
	private void fillbox() {
		this.Jcb.addItem("按班级查询");
		this.Jcb.addItem("按教师查询");
		
		
	}
}
