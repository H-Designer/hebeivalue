package SeverLet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Message.Mes;
import Dao.XuqiuDao;
public class RegistSeverLet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		//System.out.println(username);
		String password = request.getParameter("password");
		//System.out.println(password);
		String platname = request.getParameter("platname");
		//System.out.println(platname);
		String pizhunwenhao = request.getParameter("pizhunwenhao");
		//System.out.println(pizhunwenhao);
		String platnum = request.getParameter("platnum");
		//System.out.println(platnum);
		String jishulingyu = request.getParameter("jishulingyu");
		//System.out.println(jishulingyu);
		String pizhuntime = request.getParameter("pizhuntime");
		//System.out.println(pizhuntime);
		Mes message = new Mes();
		XuqiuDao xuqiu = new XuqiuDao();
		message = xuqiu.login(username, password);
		if(message != null){
			request.setAttribute("failure","用户已存在！");
			request.getRequestDispatcher("/User/Register.jsp").forward(request, response);
		}
		message = new Mes();
		try {
			message.setJishulingyu(jishulingyu);
			message.setPassword1(password);
			message.setPizhuntime(pizhuntime);
			message.setPizhunwenhao(pizhunwenhao);
			message.setPlatname(platname);
			message.setPlatnum(platnum);
			message.setUsername(username);
			xuqiu.add(message);
		request.setAttribute("login","注册成功！请登陆：");
		request.getRequestDispatcher("/User/Login.jsp").forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
