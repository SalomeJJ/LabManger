package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;

/**
 * 用户Dao类
 * @author jiyuan
 *
 */
public class UserDao {
	/**
	 * 登陆验证
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User login(Connection con,User user) throws Exception{
		User resultUser=null;
		String sql="select * from lab_user where username=? and password=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getPassword());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){	
			resultUser=new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setUsername(rs.getString("username"));
			resultUser.setPassword(rs.getString("password"));
		}
		return resultUser;
		
	}

	

}
