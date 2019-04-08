package SeverLet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.XuqiuDao;
import Message.Mes;

/**
 * Servlet implementation class MulQSeverlet1
 */
@WebServlet("/MulQSeverlet1")
public class MulQSeverlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MulQSeverlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.setCharacterEncoding("utf-8");
		int num = Integer.parseInt(req.getParameter("num"));
		System.out.println(num);
		List<Mes> needBeans = null;
		XuqiuDao needDao = new XuqiuDao();
		
		if(num == 1){
			String sType0 = req.getParameter("sType0");
			System.out.println(sType0);
			String q0 = req.getParameter("q0");
			System.out.println(q0);

			needBeans = needDao.findZH(sType0, q0, "", "", "", "", "", "");
		}else if(num == 2){
			String sType0 = req.getParameter("sType0");
			System.out.println(sType0);
			String q0 = req.getParameter("q0");
			System.out.println(q0);
			String logic1 = req.getParameter("logic1");
			System.out.println(logic1);
			String sType1 = req.getParameter("sType1");
			System.out.println(sType1);
			String q1 = req.getParameter("q1");
			System.out.println(q1);
			needBeans = needDao.findZH(sType0, q0, logic1, sType1, q1, "", "", "");
		}else{
			String sType0 = req.getParameter("sType0");
			String q0 = req.getParameter("q0");
			String logic1 = req.getParameter("logic1");
			String sType1 = req.getParameter("sType1");
			String q1 = req.getParameter("q1");
			String logic2 = req.getParameter("logic2");
			String sType2 = req.getParameter("sType2");
			String q2 = req.getParameter("q2");
			needBeans = needDao.findZH(sType0, q0, logic1, sType1, q1, logic2, sType2, q2);
		}
		req.setAttribute("needBeans", needBeans);
		if (needBeans != null) {
			req.getRequestDispatcher("/select/MulQuery.jsp?status=1").forward(req,resp);
		} else
			req.getRequestDispatcher("/select/MulQuery.jsp?status=2").forward(req,resp);
	}
		
	

}
