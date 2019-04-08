package SeverLet;

import java.io.IOException;import javax.activation.MailcapCommandMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Message.Mes;
import Dao.XuqiuDao;

public class FormSeverlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String town = request.getParameter("town");
		String platname = request.getParameter("platname");
		System.out.println(platname);
		String[] PingtaiLevel = request.getParameterValues("PingtaiLevel");
		String PingtaiLevelString = null;
		for(int i = 0;i < PingtaiLevel.length; i++) {
			if(PingtaiLevelString==null) {
				PingtaiLevelString=PingtaiLevel[i];
			}
			else PingtaiLevelString=PingtaiLevelString+","+PingtaiLevel[i];
		}
		System.out.println(PingtaiLevelString);
		String location = province+city+town;
		System.out.println(location);
		String[] PingtaiShape = request.getParameterValues("PingtaiShape");
		String PingtaiShapeString = null;
		for(int i = 0;i < PingtaiShape.length; i++) {
			if(PingtaiShapeString==null) {
				PingtaiShapeString=PingtaiShape[i];
			}
			else PingtaiShapeString=PingtaiShapeString+","+PingtaiShape[i];
		}
		System.out.println(PingtaiShapeString);

		String BTHconstruction = request.getParameter("BTHconstruction");
		System.out.println(BTHconstruction);
		String EconoyServing = request.getParameter("EconoyServing");
		System.out.println(EconoyServing);

		String xueke = request.getParameter("xueke");
		System.out.println(xueke);

		String YituoCompany = request.getParameter("YituoCompany");
		System.out.println(YituoCompany);

		String DanweiDaima = request.getParameter("DanweiDaima");
		System.out.println(DanweiDaima);

		String YituorenName = request.getParameter("YituorenName");
		System.out.println(YituorenName);

		String BangongPhone = request.getParameter("BangongPhone");
		System.out.println(BangongPhone);

		String YituoType = request.getParameter("YituoType");
		System.out.println(YituoType);
		String[] GongjianCompany = request.getParameterValues("GongjianCompany");
		String GongjianCompanyString = null;
		for(int i = 0 ;i < GongjianCompany.length;i++) {
			if(GongjianCompanyString==null) {
				GongjianCompanyString=GongjianCompany[i];
			}
			else GongjianCompanyString=GongjianCompanyString+","+GongjianCompany[i];
		}
		System.out.println(GongjianCompanyString);

		String TaizhangName = request.getParameter("TaizhangName");
		System.out.println(TaizhangName);

		String TaizhangSex = request.getParameter("TaizhangSex");
		System.out.println(TaizhangSex);

		String TaizhangBrith = request.getParameter("TaizhangBrith");
		System.out.println(TaizhangBrith);

		String TaizhangZhicheng = request.getParameter("TaizhangZhicheng");
		System.out.println(TaizhangZhicheng);

		String TaizhangZhuanye = request.getParameter("TaizhangZhuanye");
		System.out.println(TaizhangZhuanye);

		String TaizhangXueli = request.getParameter("TaizhangXueli");
		System.out.println(TaizhangXueli);

		String TaizhangXuewei = request.getParameter("TaizhangXuewei");
		System.out.println(TaizhangXuewei);

		String TaizhangBangong = request.getParameter("TaizhangBangong");
		System.out.println(TaizhangBangong);

		String TaizhangShouji = request.getParameter("TaizhangShouji");
		System.out.println(TaizhangShouji);

		String TaizhangEmail = request.getParameter("TaizhangEmail");
		System.out.println(TaizhangEmail);

		String PingtaiWebName = request.getParameter("PingtaiWebName");
		System.out.println(PingtaiWebName);

		String PingtaiWebaddress = request.getParameter("PingtaiWebaddress");
		System.out.println(PingtaiWebaddress);

		String PingtaiTongxunDizhi = request.getParameter("PingtaiTongxunDizhi");
		System.out.println(PingtaiTongxunDizhi);

		String mail = request.getParameter("mail");
		System.out.println(mail);

		Mes message = new Mes();
		message.setPlatname(platname);
		message.setPingtaiLevel(PingtaiLevelString);
		message.setLocation(location);
		message.setPingtaiShape(PingtaiShapeString);
		message.setBTHconstruction(BTHconstruction);
		message.setEconoyServing(EconoyServing);;
		message.setXueke(xueke);
		message.setYituoCompany(YituoCompany);;
		message.setDanweiDaima(DanweiDaima);;
		message.setBangongPhone(BangongPhone);
		message.setYituorenName(YituorenName);
		message.setYituoType(YituoType);
		message.setGongjianCompany(GongjianCompanyString);
		message.setTaizhangName(TaizhangName);
		message.setTaizhangSex(TaizhangSex);
		message.setTaizhangBrith(TaizhangBrith);
		message.setTaizhangZhicheng(TaizhangZhicheng);
		message.setTaizhangZhuanye(TaizhangZhuanye);
		message.setTaizhangXueli(TaizhangXueli);
		message.setTaizhangXuewei(TaizhangXuewei);
		message.setTaizhangBangong(TaizhangBangong);
		message.setTaizhangShouji(TaizhangShouji);
		message.setTaizhangEmail(TaizhangEmail);
		message.setPingtaiWebName(PingtaiWebName);
		message.setPingtaiWebaddress(PingtaiWebaddress);
		message.setPingtaiTongxunDizhi(PingtaiTongxunDizhi);
		message.setMail(mail);
		XuqiuDao xuqiu = new XuqiuDao();
		try {
			xuqiu.update(message);
		}catch(Exception e) {
			e.printStackTrace();
		}
		//response.sendRedirect(request.getContextPath()+"/User/Test.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
