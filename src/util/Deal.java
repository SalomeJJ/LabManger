package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.LabApply;



public class Deal {
	
	private DbUtil dbUtil=new DbUtil();
	
	
	/**
	 * ����ſ����ɱ�applyresults
	 * @return
	 */
	public int deletetable(Connection con)throws Exception{
		String sql="delete from applyresults";
		PreparedStatement pstmt=con.prepareStatement(sql);
		return pstmt.executeUpdate();
	}
	/**
	 * ���༶�Ŵ����ַ���
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
	 * ͳ�ư༶����
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
	 * �ڿα����ɽ������Ϊÿһ���ഴ��һ��
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
		//�༶ �ţ�����  ����
		String[] s_class=new String[30];
		int[] s_num=new int[30];
		
		//ʵ���Һ� ���� ����
		String[] s_lab=new String[10];
		int[] s_lab_num=new int[10];
		
		int countc=0;//ѡ�еİ༶��Ŀ
		int countl=0;//ʵ������Ŀ
		String sqlA="select class ,stu_num from apply where week=? and time=? and "+d+"="+"'��'";
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
			//�ð༶�Ҳ���ʵ�����Ͽ���
			if(test==false) {
				pk[i]="0";//��0��ʾ�ð����ʱ���û���ſ�
				return 0;
			}
		}
		
//		for(int i=0;i<countc;i++) {
//			System.out.println(pk[i]);
//			
//	    }
		
		
		//�����źõİ༶����Ӧ��ʵ���Ҳ������ݿ�applyresults��
		String MA="";
		String xqj="";
		for(int i=0;i<countc;i++) {
			if(pk[i]!="0") {//�жϸð���û�а��ŵ�ʵ����
				//�õ�׼ȷ�Ĳ���λ��
				//�ж������ϻ�������
				if(t=="2-5��") {
					MA="M";
				}else if(t=="6-9��") {
					MA="A";
				}
				
				//�ж������ڼ�
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
