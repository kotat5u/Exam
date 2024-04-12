package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Subject;

public class SubjectDAO extends DAO {
	
	public List<Subject> search(String keyword) throws Exception {
		List<Subject> list=new ArrayList<>();
		
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
			"select * from student where name like ?");
		st.setString(1, "%"+keyword+"%");
		ResultSet rs=st.executeQuery();
		
		while (rs.next()) {
			Subject s=new Subject();
			s.setNumber(rs.getInt("number"));
			s.setSname(rs.getString("sname"));
			s.setCname(rs.getString("cname"));
			list.add(s);
		}
		
		st.close();
		con.close();
		
		return list;
	}