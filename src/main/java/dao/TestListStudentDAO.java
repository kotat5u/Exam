package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Student;
import bean.TestListStudent;

public class TestListStudentDAO extends DAO{
	
	private String baseSql="select * from test inner join subject on test.subject_cd = subject.cd";
	
	public List<TestListStudent> postfilter(ResultSet rSet) throws Exception {
		List<TestListStudent> list = new ArrayList<>();
		while (rSet.next()) {
			TestListStudent t=new TestListStudent();
			t.setSubjectName(rSet.getString("name"));
			t.setSubjectCd(rSet.getString("subject.cd"));
			t.setNum(rSet.getInt("test.no"));
			t.setPoint(rSet.getInt("point"));
			list.add(t);
		}
		return list;
	}
	
	public List<TestListStudent> filter(Student student) throws Exception {
		List<TestListStudent> list = new ArrayList<>();
		Connection con = getConnection();
//		
		PreparedStatement st=con.prepareStatement(baseSql + " where student_no = ?");
		st.setString(1, student.getNo());
		ResultSet rs=st.executeQuery();
//		SQLの結果をListに格納する処理
		list = postfilter(rs);
		
		st.close();
		con.close();

		return list;
	}
}

