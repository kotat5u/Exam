package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;


public class ClassNumDAO extends DAO{

	//	引数で与えられた学校のクラス一覧を取得
	public List<String> filter(School school) throws Exception {
		List<String> list = new ArrayList<>();
		Connection con = getConnection();
//		
		PreparedStatement st=con.prepareStatement("select class_num from class_num where school_cd = ?");
		st.setString(1, school.getCd());
		ResultSet rs=st.executeQuery();
//		
		while (rs.next()) {
			String s;
			s = rs.getString("class_num");
			System.out.println(s);
			list.add(s);
		}
		
		st.close();
		con.close();

		return list;
	}
}