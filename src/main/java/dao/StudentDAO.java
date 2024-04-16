package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Student;

public class StudentDAO extends DAO {
	
	
//	学生一人を抽出する機能を作成
	public Student get(String no) throws Exception {
		
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"select * from student join school on student.school_cd = school.cd where no = ?");
		st.setString(1,no);
		ResultSet rs=st.executeQuery();
		
//		データベースに追加するためのStudentオブジェクトの作成
//		リクエストパラメータから取得した値をセッタを使用して書き込む
			Student stu=new Student();
			School sch=new School();
			stu.setNo(rs.getString("no"));
			stu.setName(rs.getString("name"));
			stu.setEntYear(rs.getInt("entYear"));
			stu.setClassNum(rs.getString("classNum"));
			stu.setIsAttend(rs.getBoolean("isAttend"));
			sch.setCd(rs.getString("cd"));
			sch.setName(rs.getString("name"));
			stu.setSchool(sch);
			
			
			st.close();
			con.close();
			
			return stu;
	}
	
//	検索機能で使用する作業をpostfilterとして作成
	private List<Student> postfilter(ResultSet rSet, School school
			) throws Exception {
		
		List<Student> list=new ArrayList<>();

//		検索結果であるResultSetオブジェクトから１行ずつ取り出し、セッタを使って書き込む
		while (rSet.next()) {
			Student stu=new Student();
			stu.setNo(rSet.getString("no"));
			stu.setName(rSet.getString("name"));
			stu.setEntYear(rSet.getInt("entYear"));
			stu.setClassNum(rSet.getString("classNum"));
			stu.setIsAttend(rSet.getBoolean("isAttend"));
			stu.setSchool(school);
			list.add(stu);
		}
		return list;
	}
	
//	検索機能:条件（school, entYear, classNum, isAttend）
	public List<Student> filter(
		School school,Integer entYear,String classNum,Boolean isAttend
			) throws Exception {
		
		Connection con = getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"select * from student where school_name = ? and ent_year = ? and class_num = ? and is_attend = ?");
		ResultSet rs=st.executeQuery();
		
//		postfilterを呼び出す
		return postfilter(rs,school);
		
	}
	
//	検索機能:条件（school, entYear, isAttend）
	public List<Student> filter(
			School school,Integer entYear,Boolean isAttend
				) throws Exception {
			
			Connection con = getConnection();
			
			PreparedStatement st=con.prepareStatement(
					"select * from student where  school_name = ? and ent_year = ? and is_attend = ?");
			ResultSet rs=st.executeQuery();
			
//			postfilterを呼び出す
			return postfilter(rs,school);
			
	}
//	検索機能:条件（school, isAttend）
	public List<Student> filter(
			School school,Boolean isAttend
				) throws Exception {
			
			Connection con = getConnection();
			
			PreparedStatement st=con.prepareStatement(
					"select * from student where  school_name = ? and is_attend = ?");
			ResultSet rs=st.executeQuery();
			
//			postfilterを呼び出す
			return postfilter(rs,school);
			
	}
	
//	保存機能の作成(未完成)
	@SuppressWarnings("null")
	public boolean save(School school) throws Exception {
		return (Boolean) null;
	}

}