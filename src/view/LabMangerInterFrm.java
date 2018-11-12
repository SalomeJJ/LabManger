package view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import dao.Lab_infoDao;
import model.Lab_info;
import util.DbUtil;
import util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LabMangerInterFrm extends JInternalFrame {
	private JTable labtable;
	private DbUtil dbUtil=new DbUtil();
	private Lab_infoDao lab_infoDao=new Lab_infoDao();
	private JTextField s_labTxt;
	private JTextField idTxt;
	private JTextField lablocationTxt;
	private JTextField labsizeTxt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LabMangerInterFrm frame = new LabMangerInterFrm();
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
	public LabMangerInterFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u5B9E\u9A8C\u5BA4\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 511, 536);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("\u5B9E\u9A8C\u5BA4\u5730\u5740\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		
		s_labTxt = new JTextField();
		s_labTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labSearchActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton.setIcon(new ImageIcon(LabMangerInterFrm.class.getResource("/images/cx.png")));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(74)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(s_labTxt, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
							.addGap(44)
							.addComponent(btnNewButton))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE))
					.addGap(98))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(58)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(s_labTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(30)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(46, Short.MAX_VALUE))
		);
		
		JLabel label = new JLabel("\u7F16\u53F7\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 17));
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5B9E\u9A8C\u5BA4\u5730\u5740\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 17));
		
		lablocationTxt = new JTextField();
		lablocationTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5B9E\u9A8C\u5BA4\u4EBA\u6570\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 17));
		
		labsizeTxt = new JTextField();
		labsizeTxt.setColumns(10);
		
		JButton button = new JButton("\u4FEE\u6539");
		button.setFont(new Font("宋体", Font.PLAIN, 18));
		button.setIcon(new ImageIcon(LabMangerInterFrm.class.getResource("/images/xiug.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labUpdateActionEvent(e);
			}
		});
		
		JButton button_1 = new JButton("\u5220\u9664");
		button_1.setFont(new Font("宋体", Font.PLAIN, 18));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labdeleteActionEvent(e);
			}
		});
		button_1.setIcon(new ImageIcon(LabMangerInterFrm.class.getResource("/images/schu .png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(labsizeTxt, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lablocationTxt, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(125)
							.addComponent(button)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_1)))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(21)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label)
								.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1)))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lablocationTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(2)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_2))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(labsizeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(12)
							.addComponent(button))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(11)
							.addComponent(button_1)))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		labtable = new JTable();
		labtable.setFont(new Font("宋体", Font.PLAIN, 18));
		labtable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				labTableMousePressed(e);
			}
		});
		labtable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u5B9E\u9A8C\u5BA4\u5730\u5740", "\u5B9E\u9A8C\u5BA4\u5BB9\u7EB3\u4EBA\u6570"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		labtable.getColumnModel().getColumn(0).setPreferredWidth(63);
		labtable.getColumnModel().getColumn(1).setPreferredWidth(96);
		labtable.getColumnModel().getColumn(2).setPreferredWidth(121);
		scrollPane.setViewportView(labtable);
		getContentPane().setLayout(groupLayout);
		
		
		this.fillTable(new Lab_info());

	}
	/**
	 * 删除事件处理
	 * @param e
	 */
	private void labdeleteActionEvent(ActionEvent e) {
		String id=idTxt.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
		if(n==0) {
			Connection con=null;
			try {
				con=dbUtil.getCon();
				int deleteNum=lab_infoDao.delete(con, id);
				if(deleteNum==1){
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetValue();
					this.fillTable(new Lab_info());
				}else{
					JOptionPane.showMessageDialog(null, "删除失败");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "删除失败");
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

	/**
	 * 实验室修改事件处理
	 * @param evt
	 */
	private void labUpdateActionEvent(ActionEvent evt) {
		String id=idTxt.getText();
		String lablocatio=lablocationTxt.getText();
		String labsize=labsizeTxt.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		if(StringUtil.isEmpty(lablocatio)){
			JOptionPane.showMessageDialog(null, "实验室地址不能为空");
			return;
		}
		Lab_info lab_info=new Lab_info(Integer.parseInt(id),lablocatio,Integer.parseInt(labsize));
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int modifyNum=lab_infoDao.update(con, lab_info);
			if(modifyNum==1){
				JOptionPane.showMessageDialog(null, "修改成功");
				this.resetValue();
				this.fillTable(new Lab_info());
			}else{
				JOptionPane.showMessageDialog(null, "修改失败");
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "修改失败");
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * 表格行点击事件处理
	 * @param e
	 */
	private void labTableMousePressed(MouseEvent evt) {
		int row=labtable.getSelectedRow();
		idTxt.setText((String)labtable.getValueAt(row, 0));
		lablocationTxt.setText((String)labtable.getValueAt(row, 1));
		labsizeTxt.setText((String)labtable.getValueAt(row, 2));
	}
 
	/**
	 * 图书类别搜索事件处理
	 * @param evt
	 */
	private void labSearchActionPerformed(ActionEvent evt) {
		String s_lab=this.s_labTxt.getText();
		Lab_info lab_info=new Lab_info();
		lab_info.setLocation(s_lab);
		this.fillTable(lab_info);
	}

	/**
	 * 初始化表格
	 * @param lab_info
	 */
	private void fillTable(Lab_info lab_info) {
		DefaultTableModel dtm=(DefaultTableModel) labtable.getModel();
		dtm.setRowCount(0);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=lab_infoDao.list(con,lab_info);
			while(rs.next()){
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("lab_location"));
				v.add(rs.getString("lab_size"));
				dtm.addRow(v);
			}
			 
		}catch (Exception e) {
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
	 * 重置表单
	 */
	private void resetValue(){
		this.idTxt.setText("");
		this.lablocationTxt.setText("");
		this.labsizeTxt.setText("");
	}
}
