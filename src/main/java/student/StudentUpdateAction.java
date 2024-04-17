package student;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class StudentUpdateAction extends Action{
	public String execute(HttpServletRequest request, HttpServletResponse response
			) throws Exception {
		return "StudentUpdate.jsp";
	}
}