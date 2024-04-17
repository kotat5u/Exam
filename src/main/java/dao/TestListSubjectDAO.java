package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.TestListSubject;

public class TestListSubjectDAO extends DAO{
	
	private String baseSql = "select c.ent_year as ent_yaer, c.class_num as class, c.no as no, c.name as name, a.no as an, a.point as ap, b.no as bn, b.point as bp from test a left join test as b on a.student_no = b.student_no and a.subject_cd = b.subject_cd and a.no <> b.no inner join student as c on a.student_no = c.no where (a.no = 1 or (a.no = 2 and b.no is null)) and a.school_cd = ?";
	
//	SQLの結果をListに格納する
	private List<TestListSubject>postfilter(ResultSet rSet) throws Exception {
		List<TestListSubject> list = new ArrayList<>();
		while (rSet.next()) {
			TestListSubject t=new TestListSubject();
			t.setEntYear(rSet.getInt("ent_year"));
			t.setClassNum(rSet.getString("class"));
			t.setStudentNo(rSet.getString("no"));
			t.setStudentName(rSet.getString("name"));
			if (rSet.getInt("an") == 1 || rSet.getInt("an") == 2) {
				t.putPoint(rSet.getInt("an"), rSet.getInt("ap"));
			}
			if (rSet.getInt("bn") == 2) {
				t.putPoint(rSet.getInt("bn"), rSet.getInt("bp"));
			}
			list.add(t);
		}
		return list;
	}
	
//	入学年度、クラス、科目、学校で絞り込んで成績を検索
	public List<TestListSubject>filter(int entYear, String classNum, String subject, School school) throws Exception {
		List<TestListSubject> list = new ArrayList<>();
		Connection con = getConnection();
//	
		
		PreparedStatement st=con.prepareStatement(baseSql + " and c.ent_year = ? and a.class_num = ? and a.subject_cd = ?");
		st.setString(1, school.getCd());
		st.setInt(2, entYear);
		st.setString(3, classNum);
		st.setString(4, subject);
		ResultSet rs=st.executeQuery();
//		SQLの結果をListに格納する処理
		list = postfilter(rs);
		
		st.close();
		con.close();

		return list;
	}
}
