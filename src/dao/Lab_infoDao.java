package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



import model.Lab_info;
import util.StringUtil;

/**
 * 实验室类别Dao类
 * @author jiyuan
 *
 */
public class Lab_infoDao {
	
	/**
	 * 实验室添加
	 * @param con
	 * @param lab_info
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,Lab_info lab_info)throws Exception{
		String sql="insert into lab_info values(null,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, lab_info.getLocation());
		pstmt.setInt(2, lab_info.getSize());
		return pstmt.executeUpdate();
	
		
	}
	/**
	 * 实验室查询
	 */
	public ResultSet list(Connection con,Lab_info lab_info)throws Exception {
		StringBuffer sb=new StringBuffer("select * from lab_info");
		if(StringUtil.isNotEmpty(lab_info.getLocation())){
			sb.append(" and lab_location like '%"+lab_info.getLocation()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	/**
	 * 删除实验室
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con,String id)throws Exception{
		String sql="delete from lab_info where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	
	/**
	 * 更新实验室信息
	 * @param con
	 * @param lab_info
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con,Lab_info lab_info)throws Exception{
		String sql="update lab_info set lab_location=?,lab_size=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, lab_info.getLocation());
		pstmt.setInt(2, lab_info.getSize());
		pstmt.setInt(3, lab_info.getId());
		return pstmt.executeUpdate();
	}
	

}
