package SeverLet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.XuqiuDao;
import Message.Mes;

public class loginSeverlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		XuqiuDao xuqiu = new XuqiuDao();
		Mes message = xuqiu.login(username, password);
		if(message == null) {
			request.setAttribute("msg", "用户密码不正确");
			request.getRequestDispatcher("/User/Login.jsp").forward(request, response);
			return;
		}
		request.getSession().setAttribute("user", message);
		
		response.sendRedirect(request.getContextPath()+"/select/action.jsp");
		
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
