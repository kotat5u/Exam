package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.School;
import bean.Teacher;

public class TeacherDAO extends DAO{

	//	login機能
	public Teacher login(String id, String password) throws Exception {
		
		School s = new School();
		Teacher t = new Teacher();
		
		Connection con = getConnection();
//		schoolテーブルとteacherテーブルを結合したテーブルからid,passwordが合うデータを抽出
		PreparedStatement st=con.prepareStatement("select * from teacher inner join school on teacher.school_cd = school.cd where id = ? and password = ?");
		st.setString(1, id);
		st.setString(2, password);
		ResultSet rs=st.executeQuery();
//		結果をTeacherに入れて返す
		if (rs.next()) {
			t.setId(id);
			t.setPassword(password);
			t.setName(rs.getString("Name"));
			s.setCd(rs.getString("cd"));
			s.setName(rs.getString("name"));
			t.setSchool(s);
			
			st.close();
			con.close();

			return t;
		}
		
		st.close();
		con.close();

		return t;
	}
}