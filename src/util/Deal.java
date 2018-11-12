package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.LabApply;



public class Deal {
	
	private DbUtil dbUtil=new DbUtil();
	
	
	/**
	 * 清空排课生成表applyresults
	 * @return
	 */
	public int deletetable(Connection con)throws Exception{
		String sql="delete from applyresults";
		PreparedStatement pstmt=con.prepareStatement(sql);
		return pstmt.executeUpdate();
	}
	/**
	 * 将班级号存入字符串
	 * @return
	 */
	public String[] countclass(Connection con)throws Exception {
		String[] classcount= new String[30];
		String sql="select class from apply";
		PreparedStatement pstmt=con.prepareStatement(sql);
		ResultSet rs= pstmt.executeQuery();
		int count=0;
		while(rs.next()) {
			boolean b=false;
			for(int i=0;i<count;i++) {
				if(classcount[i].equalsIgnoreCase(rs.getString("class"))) {
					b=true;
					//break;
				}
			}
			if(b==false) {
				classcount[count]=rs.getString("class");
				count++;
			}
		}
		return classcount;
	}
	/**
	 * 统计班级个数
	 * @return
	 */
	public int countclassnum(Connection con)throws Exception {
		String[] classcount= new String[30];
		String sql="select class from apply";
		PreparedStatement pstmt=con.prepareStatement(sql);
		ResultSet rs= pstmt.executeQuery();
		int count=0;
		while(rs.next()) {
			boolean b=false;
			for(int i=0;i<count;i++) {
				if(classcount[i].equalsIgnoreCase(rs.getString("class"))) {
					b=true;
					//break;
				}
			}
			if(b==false) {
				classcount[count]=rs.getString("class");
				count++;
			}
		}
		return count;
	}
	
	/**
	 * 在课表生成结果表中为每一个班创建一行
	 * @param args
	 */
	public void createEachClass(Connection con,int num,String[] names)throws Exception {
		for(int i=0;i<num;i++) {
			String sql="insert into applyresults(classname) values('"+names[i]+"')";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.executeUpdate();
		}
	}
	
	
	public int paike(Connection con,String w,String t,String d) throws Exception{
		//班级 号，人数  数组
		String[] s_class=new String[30];
		int[] s_num=new int[30];
		
		//实验室号 人数 数组
		String[] s_lab=new String[10];
		int[] s_lab_num=new int[10];
		
		int countc=0;//选中的班级数目
		int countl=0;//实验室数目
		String sqlA="select class ,stu_num from apply where week=? and time=? and "+d+"="+"'√'";
		PreparedStatement pstmt=con.prepareStatement(sqlA);
		pstmt.setString(1, w);
		pstmt.setString(2, t);
		//pstmt.setString(3, d);
		ResultSet rs=pstmt.executeQuery();
		
		while(rs.next()) {
			s_class[countc]=rs.getString("class");
			s_num[countc]=rs.getInt("stu_num");
			countc++;
		}
		
//		for(int i=0;i<countc;i++) {
//		System.out.println(s_class[i]);
//			System.out.println(s_num[i]);		
//		}
		
		String sqlB="select * from lab_info";
		PreparedStatement pstmt2=con.prepareStatement(sqlB);
		ResultSet rs2=pstmt2.executeQuery();
		while(rs2.next()) {
			s_lab[countl]=rs2.getString("lab_location");
			s_lab_num[countl]=rs2.getInt("lab_size");
			countl++;
		}
//		for(int i=0;i<countl;i++) {
//			System.out.println(s_lab[i]);
//			System.out.println(s_lab_num[i]);
//			
//	    }
		
		String[] pk=new String[countc];
		for(int i=0;i<countc;i++) {
			boolean test=false;
			for(int j=0;j<countl;j++) {
				if(s_num[i]<=s_lab_num[j]) {
					pk[i]=s_lab[j];
					s_lab_num[j]=s_lab_num[j]-s_num[i];
					test=true;
					break;
				}
			}
			//该班级找不到实验室上课了
			if(test==false) {
				pk[i]="0";//置0表示该班这个时间段没安排课
				return 0;
			}
		}
		
//		for(int i=0;i<countc;i++) {
//			System.out.println(pk[i]);
//			
//	    }
		
		
		//将安排好的班级即对应的实验室插入数据库applyresults中
		String MA="";
		String xqj="";
		for(int i=0;i<countc;i++) {
			if(pk[i]!="0") {//判断该班有没有安排到实验室
				//得到准确的插入位置
				//判断是早上还是下午
				if(t=="2-5节") {
					MA="M";
				}else if(t=="6-9节") {
					MA="A";
				}
				
				//判断是星期几
				if(d=="Monday") {
					xqj="z1";
				}else if(d=="Tuesday") {
					xqj="z2";
				}else if(d=="Wednesday") {
					xqj="z3";
				}else if(d=="Thursday") {
					xqj="z4";
				}else if(d=="Friday") {
					xqj="z5";
				}
				
				
				
				String sqlC="update applyresults set "+w+xqj+MA+ " =? where classname = ?;";
				PreparedStatement pstmt3=con.prepareStatement(sqlC);
				pstmt3.setString(1, pk[i]);
				pstmt3.setString(2, s_class[i]);
				pstmt3.executeUpdate();	
				
				
				
				//System.out.println(s_class[i]);
				//System.out.println(pk[i]);
			}
			
		}
		return 1;
		
		
		
		
		
		
	}	
}
