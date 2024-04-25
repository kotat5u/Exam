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
		
		rs.next();
		Student stu=new Student();
		School sch=new School();
		stu.setNo(rs.getString("no"));
		stu.setName(rs.getString("name"));
		stu.setEntYear(rs.getInt("ent_year"));
		stu.setClassNum(rs.getString("class_num"));
		stu.setIsAttend(rs.getBoolean("is_attend"));
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
			stu.setEntYear(rSet.getInt("ent_Year"));
			stu.setClassNum(rSet.getString("class_Num"));
			stu.setIsAttend(rSet.getBoolean("is_Attend"));
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
				"select * from student where school_cd = ? and ent_year = ? and class_num = ? and is_attend = ?");
		st.setString(1, school.getCd());
		st.setInt(2, entYear);
		st.setString(3, classNum);
		st.setBoolean(4, isAttend);
		ResultSet rs=st.executeQuery();
		List<Student> list=postfilter(rs,school);
		st.close();
		con.close();
		return list;
		
	}
	
//	検索機能:条件（school, entYear, isAttend）
	public List<Student> filter(
			School school,Integer entYear,Boolean isAttend
				) throws Exception {
			
			Connection con = getConnection();
			System.out.println("wtfilter");
			PreparedStatement st=con.prepareStatement(
					"select * from student where  school_cd = ? and ent_year = ? and is_attend = ?");
			st.setString(1, school.getCd());
			st.setInt(2, entYear);
			st.setBoolean(3, isAttend);
			ResultSet rs=st.executeQuery();
			List<Student> list=postfilter(rs,school);
			st.close();
			con.close();
			return list;
			
	}
//	検索機能:条件（school, isAttend）
	public List<Student> filter(
			School school,Boolean isAttend
				) throws Exception {
			
			Connection con = getConnection();
			
			PreparedStatement st=con.prepareStatement(
					"select * from student where  school_cd = ? and is_attend = ?");
			st.setString(1, school.getCd());
			st.setBoolean(2, isAttend);
			ResultSet rs=st.executeQuery();
			List<Student> list=postfilter(rs,school);
			st.close();
			con.close();
			return list;
			
	}
	
	public List<Student> filter(
			School school
				) throws Exception {
			
			Connection con = getConnection();
			
			PreparedStatement st=con.prepareStatement(
					"select * from student where  school_cd = ?");
			st.setString(1, school.getCd());
			ResultSet rs=st.executeQuery();
			List<Student> list=postfilter(rs,school);
			st.close();
			con.close();
			return list;
			
	}
	
//	保存機能の作成
	public boolean save(Student student) throws Exception {
		Connection con = getConnection();
		
		PreparedStatement check=con.prepareStatement(
				"select * from student where no = ?");
		check.setString(1,student.getNo());
		ResultSet line=check.executeQuery();
		
		boolean isSaved = true;
		if (line.next()) {
			isSaved = false;
		} else {
			PreparedStatement st=con.prepareStatement(
					"insert into student values(?, ?, ?, ?,true,?)");
			
			st.setString(1,student.getNo());
			st.setString(2,student.getName());
			st.setInt(3,student.getEntYear());
			st.setString(4,student.getClassNum());
			st.setString(5,(student.getSchool()).getCd());
			st.executeUpdate();
			st.close();
		}
		check.close();
		con.close();
		return isSaved;
	}
	
	public boolean update(Student student) throws Exception {
		Connection con = getConnection();
		
			PreparedStatement st=con.prepareStatement(
					"update student name=?, class_num=?, is_attend=?,school_cd=?");
			
			st.setString(1,student.getName());
			st.setString(2,student.getClassNum());
			st.setString(3,(student.getSchool()).getCd());
			st.executeUpdate();
			st.close();
			
		con.close();
		
		return ;
	}
	
}

