package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.TestListSubject;

public class TestListSubjectDAO extends DAO{
	
	private List<TestListSubject>postfilter(ResultSet rSet) throws Exception {
		List<TestListSubject> list = new ArrayList<>();
		while (rSet.next()) {
			TestListSubject t=new TestListSubject();
			t.setEntYear(rSet.getInt("ent_year"));
			t.setStudentNo(rSet.getString("student.no"));
			t.setStudentName(rSet.getString("name"));
			t.setClassNum(rSet.getString("student.class_num"));
			t.putPoint(rSet.getInt("test.no"), rSet.getInt("point"));
			list.add(t);
		}
		return list;
	}
	
	private String baseSql = "select * from test inner join student on test.student_no = student.no where test.school_cd = ?";
	public List<TestListSubject>filter(int entYear, String classNum, String subject, School school) throws Exception {
		List<TestListSubject> list = new ArrayList<>();
		Connection con = getConnection();
//		
		PreparedStatement st=con.prepareStatement(baseSql + " and ent_year = ? and test.class_num = ? and subject_cd = ?");
		st.setString(1, school.getCd());
		st.setInt(2, entYear);
		st.setString(3, classNum);
		st.setString(4, subject);
		ResultSet rs=st.executeQuery();
//		
		list = postfilter(rs);
		
		st.close();
		con.close();

		return list;
	}
}
