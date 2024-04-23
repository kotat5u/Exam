package test;

import java.util.List;

import bean.Subject;
import bean.Teacher;
import dao.ClassNumDAO;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class TestListAction extends Action{
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		Teacher t=new Teacher();
		t = (Teacher) session.getAttribute("teacher");
		
//		ユーザー(先生)の所属する学校をもとにクラス一覧と科目一覧を取得
		ClassNumDAO classdao=new ClassNumDAO();
		List<String> classlist=classdao.filter(t.getSchool());
		
		SubjectDAO subjectdao=new SubjectDAO();
		List<Subject> subjectlist=subjectdao.filter(t.getSchool());
		
//		クラス一覧と科目一覧を保存
		session.setAttribute("classlist", classlist);
		session.setAttribute("subjectlist", subjectlist);
		
		return "test_list.jsp";
	}

}