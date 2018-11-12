package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ApplyResultsDao {
	
	/**
	 * ���༶��ѯ���ɵĿα�
	 */
	public ResultSet listclass(Connection con,String classname) throws Exception{
		String sql="select * from applyresults where classname=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, classname);
		return pstmt.executeQuery();
	}
	
	/**
	 * ��ʵ���Ҳ�ѯ
	 */
	public ResultSet listlab(Connection con,String labname,String time)throws Exception{
		String sql="select classname from applyresults where "+time+" =?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, labname);
		return pstmt.executeQuery();
	}

}
