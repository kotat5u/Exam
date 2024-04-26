package mainmenu;

import java.time.LocalTime;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class MenuAction extends Action{
	public String execute(HttpServletRequest request, HttpServletResponse response
			) throws Exception {
//		時間判定
		String now=LocalTime.now().toString();
		now = (now.substring(0, now.indexOf(":")));
		switch (now) {
			case "6", "7", "8", "9", "10", "11":
				now="mornig";
				break;
			case "12", "13", "14", "15", "16", "17":
				now="afternoon";
				break;
			default:
				now="night";
		}
        request.setAttribute("now", now);
		
		return "mainmenu.jsp";
	}
}
