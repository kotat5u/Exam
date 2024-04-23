package test;

import java.util.List;

import bean.Test;
import dao.TestDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class TestRegistExecuteAction extends Action{
	
	@SuppressWarnings("unchecked")
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		List<Test> list=(List<Test>)session.getAttribute("testRegistList");
		int num=(int)session.getAttribute("choiceNum");
		
		for (Test test : list) {
			test.setNo(num);
			test.setPoint(Integer.parseInt(request.getParameter(test.getStudent().getNo())));
		}
		
		TestDAO dao=new TestDAO();
		boolean notSave = dao.save(list);
		
		return "test_regist_done.jsp";
	}
}
