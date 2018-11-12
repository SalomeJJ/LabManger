package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.V1toV2StatementInterceptorAdapter;

import dao.ApplyResultsDao;
import util.DbUtil;
import util.StringUtil;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ApplyResultsInterFrm extends JInternalFrame {
	private JTable applyresulttable;
	private JTextField s_name;
	private DbUtil dbUtil=new DbUtil();
	private ApplyResultsDao  applyResultsDao=new ApplyResultsDao();
	private JComboBox Jcb;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplyResultsInterFrm frame = new ApplyResultsInterFrm();
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
	public ApplyResultsInterFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u8BFE\u8868\u67E5\u5BFB");
		setBounds(100, 100, 1113, 503);
		
		JScrollPane scrollPane = new JScrollPane();
		
		s_name = new JTextField();
		s_name.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.setIcon(new ImageIcon(ApplyResultsInterFrm.class.getResource("/images/cx.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchApplyResultsActionPerformed(e);
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 18));
		
		Jcb = new JComboBox();
		Jcb.setFont(new Font("宋体", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(66)
							.addComponent(Jcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(75)
							.addComponent(s_name, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(button))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(41)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 1001, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(55, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(69, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(s_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(31))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(Jcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(button))
							.addGap(27)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
					.addGap(111))
		);
		
		applyresulttable = new JTable();
		applyresulttable.setFont(new Font("宋体", Font.PLAIN, 20));
		applyresulttable.setRowHeight(60);
		applyresulttable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7B2C\u4E5D\u5468", "\u661F\u671F\u4E00", "\u661F\u671F\u4E8C", "\u661F\u671F\u4E09", "\u661F\u671F\u56DB", "\u661F\u671F\u4E94", "\u7B2C\u5341\u5468", "\u661F\u671F\u4E00", "\u661F\u671F\u4E8C", "\u661F\u671F\u4E09", "\u661F\u671F\u56DB", "\u661F\u671F\u4E94"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(applyresulttable);
		getContentPane().setLayout(groupLayout);
		fillbox();

	}
	
	/**
	 * 初始化下拉框
	 */
	private void fillbox() {
		this.Jcb.addItem("按班级查询");
		this.Jcb.addItem("按实验室查询");
	}
	
	/**
	 * 排课结果查询事件处理
	 * @param evt
	 */

	private void searchApplyResultsActionPerformed(ActionEvent evt) {
		String search="";
		int i=0;
		search =s_name.getText();
		if(StringUtil.isEmpty(search)){
			JOptionPane.showMessageDialog(null, "搜索框不能为空");
			return;
		}
		if(this.Jcb.getSelectedIndex()==0) {
			i=0;
		}else {
			i=1;
		}
		
		
		filltable(i,search);
		
	}

	private void filltable(int i,String searchname) {
		DefaultTableModel dtm=(DefaultTableModel) applyresulttable.getModel();
		dtm.setRowCount(0);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			if(i==0) {
				ResultSet rs=applyResultsDao.listclass(con, searchname);
				while(rs.next()) {
					Vector v1=new Vector();
					v1.add("2-5节");
					v1.add(rs.getString("9z1M"));
					v1.add(rs.getString("9z2M"));
					v1.add(rs.getString("9z3M"));
					v1.add(rs.getString("9z4M"));
					v1.add(rs.getString("9z5M"));
					v1.add(null);
					v1.add(rs.getString("10z1M"));
					v1.add(rs.getString("10z2M"));
					v1.add(rs.getString("10z3M"));
					v1.add(rs.getString("10z4M"));
					v1.add(rs.getString("10z5M"));
					dtm.addRow(v1);
					
					
					Vector v2=new Vector();
					v2.add("6-9节");
					v2.add(rs.getString("9z1A"));
					v2.add(rs.getString("9z2A"));
					v2.add(rs.getString("9z3A"));
					v2.add(rs.getString("9z4A"));
					v2.add(rs.getString("9z5A"));
					v2.add(null);
					v2.add(rs.getString("10z1A"));
					v2.add(rs.getString("10z2A"));
					v2.add(rs.getString("10z3A"));
					v2.add(rs.getString("10z4A"));
					v2.add(rs.getString("10z5A"));
					dtm.addRow(v2);
				}
			}else if(i==1) {
				String[] time= {"9z1M","9z2M","9z3M","9z4M","9z5M","10z1M","10z2M","10z3M","10z4M","10z5M","9z1A","9z2A","9z3A","9z4A","9z5A","10z1A","10z2A","10z3A","10z4A","10z5A"};
				Vector v3=new Vector();
				v3.add("2-5节");
				for(int j=0;j<5;j++) {
					ResultSet rs=applyResultsDao.listlab(con, searchname, time[j]);
					StringBuffer sBuffer=new StringBuffer("");
					while(rs.next()) {
						sBuffer.append(rs.getString("classname"));	
						sBuffer.append("\r\n");
					}
					v3.add(sBuffer.toString());
				}
				v3.add("");
				for(int j=5;j<10;j++) {
					ResultSet rs=applyResultsDao.listlab(con, searchname, time[j]);
					StringBuffer sBuffer=new StringBuffer("");
					while(rs.next()) {
						sBuffer.append(rs.getString("classname"));	
						sBuffer.append("\r\n");
					}
					v3.add(sBuffer.toString());
				}
				dtm.addRow(v3);
				
				Vector v4=new Vector();
				v4.add("6-9节");
				for(int j=10;j<15;j++) {
					ResultSet rs=applyResultsDao.listlab(con, searchname, time[j]);
					StringBuffer sBuffer=new StringBuffer("");
					while(rs.next()) {
						sBuffer.append(rs.getString("classname"));
						sBuffer.append("\r\n");
					}
					v4.add(sBuffer.toString());
				}
				v4.add("");
				for(int j=15;j<20;j++) {
					ResultSet rs=applyResultsDao.listlab(con, searchname, time[j]);
					StringBuffer sBuffer=new StringBuffer("");
					while(rs.next()) {
						sBuffer.append(rs.getString("classname"));	
						sBuffer.append("\r\n");
					}
					v4.add(sBuffer.toString());
				}
				dtm.addRow(v4);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
