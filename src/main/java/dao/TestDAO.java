package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Student;
import bean.Subject;
import bean.Test;

public class TestDAO extends DAO {
	
	public List<Test> postfilter(ResultSet rSet, School school, String classNum) throws Exception{
		List<Test> list = new ArrayList<>();
		
		while (rSet.next()) {
			Test t=new Test();
			Student stu=new Student();
			stu.setNo(rSet.getString("student.no"));
			stu.setName(rSet.getString("student.name"));
			stu.setEntYear(rSet.getInt("student.ent_year"));
			stu.setClassNum(classNum);
			stu.setIsAttend(rSet.getBoolean("student.is_attend"));
			stu.setSchool(school);

			Subject sbj=new Subject();
			sbj.setSchool(school);
			sbj.setCd(rSet.getString("subject.cd"));
			sbj.setName(rSet.getString("subject.name"));
			
			t.setStudent(stu);
			t.setClassNum(classNum);
			t.setSubject(sbj);
			t.setSchool(school);
			t.setNo(rSet.getInt("no"));
			t.setPoint(rSet.getInt("point"));
			list.add(t);
		}
		return list;
	}
	
	public List<Test> filter(int entYear, String classNum, Subject subject, int num, School school) throws Exception {
		
		List<Test> list = new ArrayList<>();
		Connection con=getConnection();
		
		String target = num == 1 ? "a.no as no, a.point as point" : "b.no as no, b.point as point";
		
		PreparedStatement st=con.prepareStatement("select student.no, student.name, student.ent_year, student.is_attend, subject.cd, subject.name, " + target
				+ " from student inner join subject on student.school_cd = subject.school_cd left outer join "
				+ " test as a left join test as b on a.student_no = b.student_no and a.subject_cd = b.subject_cd and a.no <> b.no on student.no = a.student_no and subject.cd = a.subject_cd"
				+ " where (a.no = 1 or (a.no = 2 and b.no is null)) and student.school_cd = ? and student.ent_year = ? and student.class_num = ? and subject.cd = ?;");
		
		
		st.setString(1, school.getCd());
		st.setInt(2, entYear);
		st.setString(3, classNum);
		st.setString(4, subject.getCd());
		ResultSet rs=st.executeQuery();
		
		list = postfilter(rs, school, classNum);
		
		st.close();
		con.close();
		
		return list;
	}
}
