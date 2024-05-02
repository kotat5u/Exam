package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Subject;

public class SubjectDAO extends DAO {
	
//	科目を1つ抽出
	public Subject get(String cd, School school) throws Exception {
		
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement("select name from subject where school_cd = ? and cd = ?");
		st.setString(1, school.getCd());
		st.setString(2, cd);
		ResultSet rs=st.executeQuery();
		
		Subject s = new Subject();
		if (rs.next()) {
			s.setSchool(school);
			s.setCd(cd);
			s.setName(rs.getString("name"));
		}
		st.close();
		con.close();
			
		return s;
	}
	
	
//	引数で与えられた学校にある科目一覧を取得
	public List<Subject> filter(School school) throws Exception {
		List<Subject> list = new ArrayList<>();
		Connection con = getConnection();
//		
		PreparedStatement st=con.prepareStatement("select * from subject where school_cd = ?");
		st.setString(1, school.getCd());
		ResultSet rs=st.executeQuery();
//		
		while (rs.next()) {
			Subject s=new Subject();
			s.setCd(rs.getString("cd"));
			s.setName(rs.getString("name"));
			s.setSchool(school);
			list.add(s);
		}
		
		st.close();
		con.close();

		return list;
	}

	
	

public boolean save(Subject subject) throws Exception {
	Connection con=getConnection();
	
	if (get(subject.getCd(), subject.getSchool()).getCd() == null) { 
	
		PreparedStatement st=con.prepareStatement(
				"insert into subject values(?, ?, ?)");
		st.setString(1,subject.getSchool().getCd());
		st.setString(2,subject.getCd());
		st.setString(3,subject.getName());
	
		st.executeUpdate();

		st.close();
		con.close();
	}else {
		PreparedStatement st=con.prepareStatement(
				"update subject set name = ? where cd = ? and shool_cd = ?");
		st.setString(1,subject.getName());
		st.setString(2,subject.getCd());
		st.setString(3,subject.getSchool().getCd());
	
		st.executeUpdate();

		st.close();
		con.close();
	}
	
	return true;
}




public boolean delete(String cd) throws Exception {
	Connection con=getConnection();

	PreparedStatement st=con.prepareStatement(
		"delete from subject where cd = ?");
	st.setString(1, cd);
	
	
	st.executeUpdate();


	st.close();
	con.close();
	
	return true;

 
}









}