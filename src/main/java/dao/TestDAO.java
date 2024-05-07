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
				+ " where ((a.no is null and b.no is null) or a.no = 1 or (a.no = 2 and b.no is null)) and student.school_cd = ? and student.ent_year = ? and student.class_num = ? and subject.cd = ?;");
		
		
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
	
	private boolean save(Test test, Connection con) throws Exception {
		PreparedStatement st1=con.prepareStatement("select * from test where student_no = ? and subject_cd = ? and no = ? and school_cd = ?");
		st1.setString(1, test.getStudent().getNo());
		st1.setString(2, test.getSubject().getCd());
		st1.setInt(3, test.getNo());
		st1.setString(4, test.getSchool().getCd());
		
		ResultSet rs1=st1.executeQuery();
		
		if (rs1.next()) {
			PreparedStatement st2=con.prepareStatement("update test set point = ? where student_no = ? and subject_cd = ? and no = ? and school_cd = ?");
			st2.setInt(1, test.getPoint());
			st2.setString(2, test.getStudent().getNo());
			st2.setString(3, test.getSubject().getCd());
			st2.setInt(4, test.getNo());
			st2.setString(5, test.getSchool().getCd());
			return st2.executeUpdate() == 1;
		} else {
			PreparedStatement st2=con.prepareStatement("insert into test values(?, ?, ?, ?, ?, ?)");
			st2.setString(1, test.getStudent().getNo());
			st2.setString(2, test.getSubject().getCd());
			st2.setString(3, test.getSchool().getCd());
			st2.setInt(4, test.getNo());
			st2.setInt(5, test.getPoint());
			st2.setString(6, test.getClassNum());
			return st2.executeUpdate() == 1;
		}
	}
	
	public boolean save(List<Test> list) throws Exception {
		Connection con=getConnection();
		boolean isError = false;
		for (Test test : list) {
			if (!save(test, con)) {
				isError = true;
				break;
			}
		}
		return isError;
	}
}
