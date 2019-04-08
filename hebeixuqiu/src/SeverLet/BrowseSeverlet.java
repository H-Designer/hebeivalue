package SeverLet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.XuqiuDao;
import Message.Mes;

/**
 * Servlet implementation class BrowseSeverlet
 */
@WebServlet("/BrowseSeverlet")
public class BrowseSeverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BrowseSeverlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//收到用于标记查询条件的数字
		int n = Integer.parseInt(req.getParameter("n"));
		System.out.println(n);
		if(n==1){
			//查看全部
			List<Mes> needBeans = new ArrayList<Mes>();
			XuqiuDao needDao = new XuqiuDao();
			needBeans = needDao.listNeed();
			for(int i=0;i<10;i++)
			{
				System.out.println(needBeans);

			}
			req.setAttribute("needBeans", needBeans);
			if (needBeans != null) {
				req.getRequestDispatcher("/select/BlistDetail.jsp?status=1&n=1").forward(
						req, resp);
			} else
				req.getRequestDispatcher("/select/BlistDetail.jsp?status=2&n=0").forward(
						req, resp);
		}else if(n==2||n==5||n==6){
			//京津冀共建
			List<Mes> needBeans = new ArrayList<Mes>();
			XuqiuDao needDao = new XuqiuDao();
			needBeans = needDao.findNeedJC(n);
			req.setAttribute("needBeans", needBeans);
			if (needBeans != null) {
				req.getRequestDispatcher("/select/BlistDetail.jsp?status=1&n=1").forward(
						req, resp);
			} else
				req.getRequestDispatcher("/select/BlistDetail.jsp?status=2&n=0").forward(
						req, resp);
		}else if(n==3||n==7||n==8){
			//平台级别
			List<Mes> needBeans = new ArrayList<Mes>();
			XuqiuDao needDao = new XuqiuDao();
			needBeans = needDao.findNeedJC(n);
			req.setAttribute("needBeans", needBeans);
			if (needBeans != null) {
				req.getRequestDispatcher("/select/BlistDetail.jsp?status=1&n=1").forward(
						req, resp);
			} else
				req.getRequestDispatcher("/select/BlistDetail.jsp?status=2&n=0").forward(
						req, resp);
		}else{
			//依托类型
			List<Mes> needBeans = new ArrayList<Mes>();
			XuqiuDao needDao = new XuqiuDao();
			needBeans = needDao.findNeedJC(n);
			req.setAttribute("needBeans", needBeans);
			if (needBeans != null) {
				req.getRequestDispatcher("/select/BlistDetail.jsp?status=1&n=0").forward(
						req, resp);
			} else
				req.getRequestDispatcher("/select/BlistDetail.jsp?status=2&n=0").forward(
						req, resp);
		}
	
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding( "utf-8");
		String platname=req.getParameter( "platname");
		
		if (platname == null) {
			List<Mes> needBeans = new ArrayList<Mes>();
			XuqiuDao needDao = new XuqiuDao();
			needBeans = needDao.listNeed();
			req.setAttribute("needBeans", needBeans);
			if (needBeans != null) {
				req.getRequestDispatcher("/select/list.jsp?status=1").forward(
						req, resp);
			} else
				req.getRequestDispatcher("/select/list.jsp?status=2").forward(
						req, resp);
		}
		else{
			Mes needBean = new Mes();
			XuqiuDao needDao = new XuqiuDao();
			//String platname=get("platname");
			needBean = needDao.singleNeed(platname);
			req.setAttribute("needBean", needBean);
			if (needBean != null) {
				req.getRequestDispatcher("/select/listDetail.jsp").forward(
						req, resp);
			} 
		}
		
	}

}
