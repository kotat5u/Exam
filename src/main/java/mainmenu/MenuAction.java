package mainmenu;

import java.time.LocalTime;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class MenuAction extends Action {
	public String execute (HttpServletRequest request, HttpServletResponse response
			) throws Exception {
		
		String now=LocalTime.now().toString();
		now=(now.substring(0, now.indexOf(":")));
		int time;
		switch (now) {
				case "19", "20", "21", "22", "23", "00", "01":
					time=1;
					break;
				case "02", "03", "04":
					time=2;
					break;
				case "05", "06", "07", "08", "09":
					time=3;
					break;
				default:
					time=4;
		}
		
		request.setAttribute("now", time);
//		request.setAttribute("oclock", now);
		
		return "mainmenu.jsp";
	}
}



//朝　　　４時～１０時
//昼　　１１時～１３時
//夕方　１４時～１８時
//夜　　１９時～３時