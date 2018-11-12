package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.LabApply;
import util.StringUtil;

public class LabApplyDao {
	/**
	 * ≈≈øŒ…Í«ÎDao
	 * @param con
	 * @param labApply
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,LabApply labApply)throws Exception{
		String sql="insert into apply values(null,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		
		pstmt.setString(1, labApply.getClassd());
		pstmt.setInt(2, labApply.getStu_num());
		pstmt.setString(3, labApply.getTeacher());
		pstmt.setString(4, labApply.getWeek());
		pstmt.setString(5, labApply.getTime());
		pstmt.setString(6, labApply.getMonday());
		pstmt.setString(7, labApply.getTuesday());
		pstmt.setString(8, labApply.getWednesday());
		pstmt.setString(9, labApply.getThursday());
		pstmt.setString(10, labApply.getFriday());
		
		
		return pstmt.executeUpdate();	
	}
	
	/**
	 * ≈≈øŒ≤È—Ø
	 */
	public ResultSet list(Connection con,LabApply labApply)throws Exception {
		StringBuffer sb=new StringBuffer("select * from Apply");
		if(StringUtil.isNotEmpty(labApply.getClassd())){
			sb.append(" and class like '%"+labApply.getClassd()+"%'");
		}
		if(StringUtil.isNotEmpty(labApply.getTeacher())){
			sb.append(" and teacher like '%"+labApply.getTeacher()+"%'");
		}
		
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	/**
	 * ≈≈øŒ…Í«Î…æ≥˝
	 */
	public int delete(Connection con,String id)throws Exception{
		String sql="delete from Apply where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	/**
	 * ≈≈øŒ…Í«Î–ﬁ∏ƒ
	 */
	public int update(Connection con,LabApply lab_Apply)throws Exception{
		String sql="update Apply set class=?,stu_num=? ,teacher=?,week=?,time=?,Monday=?,Tuesday=?,Wednesday=?,Thursday=?,Friday=?where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,lab_Apply.getClassd());
		pstmt.setInt(2, lab_Apply.getStu_num());
		pstmt.setString(3,lab_Apply.getTeacher());
		pstmt.setString(4,lab_Apply.getWeek());
		pstmt.setString(5,lab_Apply.getTime());
		pstmt.setString(6,lab_Apply.getMonday());
		pstmt.setString(7,lab_Apply.getTuesday());
		pstmt.setString(8,lab_Apply.getWednesday());
		pstmt.setString(9,lab_Apply.getThursday());
		pstmt.setString(10,lab_Apply.getFriday());
		pstmt.setInt(11,lab_Apply.getId());
		
		return pstmt.executeUpdate();
	}
}
