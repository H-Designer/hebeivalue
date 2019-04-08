package SeverLet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.XuqiuDao;
import Message.Mes;

public class mulSeverlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String txt_i=request.getParameter("txt_i");//2
		String txt_c=request.getParameter("txt_c");//7
		String key_logical=request.getParameter("{key}_logical");//第一个关系连接符
		String txt_1_sel=request.getParameter("txt_1_sel");//第二行的选择的条件
		String txt_1_value1=request.getParameter("txt_1_value1");//第二行的第一个输入框的内容
		String txt_1_relation=request.getParameter("txt_1_relation");//第二行的与或非条件符
		String txt_1_value2=request.getParameter("txt_1_value2");//第二行的第二个输入框的内容
		String txt_1_special1=request.getParameter("txt_1_special1");//第二行的精准模糊查询类型
		String txt_2_logical=request.getParameter("txt_2_logical");//第二个关系连接符
		String txt_2_sel=request.getParameter("txt_2_sel");//第三行的选择的条件
		String txt_2_value1=request.getParameter("txt_2_value1");//第三行的第一个输入的内容
		String txt_2_relation=request.getParameter("txt_2_relation");//第三行的与或非条件符
		String txt_2_value2=request.getParameter("txt_2_value2");//第三行的第二个输入的内容
		String txt_2_special1=request.getParameter("txt_2_special1");//第三行的第二个输入的内容
		System.out.println(txt_i);
		System.out.println("111");
		System.out.println(txt_c);
		System.out.println(key_logical);
		System.out.println(txt_1_sel);
		System.out.println(txt_1_value1);
		System.out.println(txt_1_relation);
		System.out.println(txt_1_value2);
		System.out.println(txt_1_special1);
		System.out.println(txt_2_logical);
		System.out.println(txt_2_sel);
		System.out.println(txt_2_value1);
		System.out.println(txt_2_relation);
		System.out.println(txt_2_value2);
		System.out.println(txt_2_special1);
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
