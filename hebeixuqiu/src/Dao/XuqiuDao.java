package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import Message.Mes;
import Util.DBUtil;



public class XuqiuDao {
	
	//注册信息
	public void add(Mes message) {
		PreparedStatement preparedStatement = null;
		Connection connection = DBUtil.getConnection();
		
		String sql = "insert into user(username,password,platname,platnum,pizhuntime,pizhunwenhao,jishulingyu) values(?,?,?,?,?,?,?)";
		System.out.println(message.getUsername());
		System.out.println(message.getJishulingyu());
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,message.getUsername());
			preparedStatement.setString(2,message.getPassword1());
			preparedStatement.setString(3,message.getPlatname());
			preparedStatement.setString(4,message.getPlatnum());
			preparedStatement.setString(5,message.getPizhuntime());
			preparedStatement.setString(6,message.getPizhunwenhao());
			preparedStatement.setString(7,message.getJishulingyu());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		
	}
	//用户登陆
			public Mes login(String username , String password) {
				Connection connection = DBUtil.getConnection();
				//准备sql语句
				String sql = "select * from user  where username = ? and password = ?";
				//创建语句传输对象
				PreparedStatement preparedStatement = null;
				ResultSet resultSet = null;
				Mes message = null;
				try {
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setString(1, username);
					preparedStatement.setString(2, password);
					resultSet = preparedStatement.executeQuery();
					while(resultSet.next()) {
						message = new Mes();
						message.setUsername(resultSet.getString("username"));
						message.setPassword1(resultSet.getString("password"));
						message.setPlatname(resultSet.getString("platname"));
						message.setPlatnum(resultSet.getString("platnum"));
						message.setJishulingyu(resultSet.getString("jishulingyu"));
						message.setPizhuntime(resultSet.getString("pizhuntime"));
						message.setPizhunwenhao(resultSet.getString("pizhunwenhao"));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					DBUtil.close(resultSet);
					DBUtil.close(preparedStatement);
					DBUtil.close(connection);
				}
				return  message;
			}
	//填表信息
			
			public void update(Mes message) {
				PreparedStatement preparedStatement = null;
				Connection connection = DBUtil.getConnection();
				String sql = "insert into xuqiuvalue( PingtaiLevel,location,PingtaiShape,BTHconstruction,EconoyServing,xueke,YituoCompany,DanweiDaima,"
						+ "YituorenName,BangongPhone,YituoType,GongjianCompany,TaizhangName,TaizhangSex,TaizhangBrith,TaizhangZhicheng,"
						+ "TaizhangZhuanye,TaizhangXueli,TaizhangXuewei,TaizhangBangong,TaizhangShouji,TaizhangEmail,PingtaiWebName,PingtaiWebaddress,"
						+ "PingtaiTongxunDizhi,mail,platname)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				try {
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setString(1, message.getPingtaiLevel());
					preparedStatement.setString(2, message.getLocation());
					preparedStatement.setString(3, message.getPingtaiShape());
					preparedStatement.setString(4, message.getBTHconstruction());
					preparedStatement.setString(5, message.getEconoyServing());
					preparedStatement.setString(6, message.getXueke());
					preparedStatement.setString(7, message.getYituoCompany());
					preparedStatement.setString(8, message.getDanweiDaima());
					preparedStatement.setString(9, message.getYituorenName());
					preparedStatement.setString(10, message.getBangongPhone());
					preparedStatement.setString(11, message.getYituoType());
					preparedStatement.setString(12, message.getGongjianCompany());
					preparedStatement.setString(13, message.getTaizhangName());
					preparedStatement.setString(14, message.getTaizhangSex());
					preparedStatement.setString(15, message.getTaizhangBrith());
					preparedStatement.setString(16, message.getTaizhangZhicheng());
					preparedStatement.setString(17, message.getTaizhangZhuanye());
					preparedStatement.setString(18, message.getTaizhangXueli());
					preparedStatement.setString(19, message.getTaizhangXuewei());
					preparedStatement.setString(20, message.getTaizhangBangong());
					preparedStatement.setString(21, message.getTaizhangShouji());
					preparedStatement.setString(22, message.getTaizhangEmail());
					preparedStatement.setString(23, message.getPingtaiWebName());
					preparedStatement.setString(24, message.getPingtaiWebaddress());
					preparedStatement.setString(25, message.getPingtaiTongxunDizhi());
					preparedStatement.setString(26, message.getMail());
					preparedStatement.setString(27, message.getPlatname());
					preparedStatement.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					DBUtil.close(preparedStatement);
					DBUtil.close(connection);
				}
			}
			public List<Mes> listNeed(){
				List<Mes> needBeans = new ArrayList<Mes>();
				String sql = "select * from xuqiuvalue";
				Connection conn =DBUtil.getConnection();
				Statement state =null;
				ResultSet rs = null;
				Mes needBean =null;
				try{
					state=conn.createStatement();
					rs=state.executeQuery(sql);
					while(rs.next()){
						needBean = new Mes();
						needBean.setPlatname(rs.getString("platname"));
						needBean.setPingtaiLevel(rs.getString("PingtaiLevel"));
						needBean.setLocation(rs.getString("location"));
						needBean.setPingtaiShape(rs.getString("PingtaiShape"));
						needBean.setBTHconstruction(rs.getString("BTHconstruction"));
						needBean.setEconoyServing(rs.getString("EconoyServing"));;
						needBean.setXueke(rs.getString("xueke"));
						needBean.setYituoCompany(rs.getString("YituoCompany"));;
						needBean.setDanweiDaima(rs.getString("DanweiDaima"));;
						needBean.setBangongPhone(rs.getString("BangongPhone"));
						needBean.setYituorenName(rs.getString("YituorenName"));
						needBean.setYituoType(rs.getString("YituoType"));
						needBean.setGongjianCompany(rs.getString("GongjianCompany"));
						needBean.setTaizhangName(rs.getString("TaizhangName"));
						needBean.setTaizhangSex(rs.getString("TaizhangSex"));
						needBean.setTaizhangBrith(rs.getString("TaizhangBrith"));
						needBean.setTaizhangZhicheng(rs.getString("TaizhangZhicheng"));
						needBean.setTaizhangZhuanye(rs.getString("TaizhangZhuanye"));
						needBean.setTaizhangXueli(rs.getString("TaizhangXueli"));
						needBean.setTaizhangXuewei(rs.getString("TaizhangXuewei"));
						needBean.setTaizhangBangong(rs.getString("TaizhangBangong"));
						needBean.setTaizhangShouji(rs.getString("TaizhangShouji"));
						needBean.setTaizhangEmail(rs.getString("TaizhangEmail"));
						needBean.setPingtaiWebName(rs.getString("PingtaiWebName"));
						needBean.setPingtaiWebaddress(rs.getString("PingtaiWebaddress"));
						needBean.setPingtaiTongxunDizhi(rs.getString("PingtaiTongxunDizhi"));
						needBean.setMail(rs.getString("mail"));
						needBeans.add(needBean);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				finally{
					DBUtil.close(rs, state, conn);
				}
				return needBeans;
			}
			public Mes singleNeed(String platname){
				String sql = "select * from xuqiuvalue where platname= '"+platname+"'";
				Connection conn =DBUtil.getConnection();
				Statement state =null;
				ResultSet rs = null;
				Mes needBean =new Mes();
				try{
					state=conn.createStatement();
					rs=state.executeQuery(sql);
					while(rs.next()){
						needBean.setPlatname(rs.getString("platname"));
						needBean.setPingtaiLevel(rs.getString("PingtaiLevelString"));
						needBean.setLocation(rs.getString("location"));
						needBean.setPingtaiShape(rs.getString("PingtaiShapeString"));
						needBean.setBTHconstruction(rs.getString("BTHconstruction"));
						needBean.setEconoyServing(rs.getString("EconoyServing"));;
						needBean.setXueke(rs.getString("xueke"));
						needBean.setYituoCompany(rs.getString("YituoCompany"));;
						needBean.setDanweiDaima(rs.getString("DanweiDaima"));;
						needBean.setBangongPhone(rs.getString("BangongPhone"));
						needBean.setYituorenName(rs.getString("YituorenName"));
						needBean.setYituoType(rs.getString("YituoType"));
						needBean.setGongjianCompany(rs.getString("GongjianCompanyString"));
						needBean.setTaizhangName(rs.getString("TaizhangName"));
						needBean.setTaizhangSex(rs.getString("TaizhangSex"));
						needBean.setTaizhangBrith(rs.getString("TaizhangBrith"));
						needBean.setTaizhangZhicheng(rs.getString("TaizhangZhicheng"));
						needBean.setTaizhangZhuanye(rs.getString("TaizhangZhuanye"));
						needBean.setTaizhangXueli(rs.getString("TaizhangXueli"));
						needBean.setTaizhangXuewei(rs.getString("TaizhangXuewei"));
						needBean.setTaizhangBangong(rs.getString("TaizhangBangong"));
						needBean.setTaizhangShouji(rs.getString("TaizhangShouji"));
						needBean.setTaizhangEmail(rs.getString("TaizhangEmail"));
						needBean.setPingtaiWebName(rs.getString("PingtaiWebName"));
						needBean.setPingtaiWebaddress(rs.getString("PingtaiWebaddress"));
						needBean.setPingtaiTongxunDizhi(rs.getString("PingtaiTongxunDizhi"));
						needBean.setMail(rs.getString("mail"));
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				finally{
					DBUtil.close(rs, state, conn);
				}
				return needBean;
			}
			//综合查询
			public List<Mes> findZH(String search1,String find1,String logic1,String search2,String find2,String logic2,String search3,String find3){
				List<Mes> needBeans = new ArrayList<Mes>();
				String sql = "select * from xuqiuvalue where "+search1+" like '%"+find1+"%' ";
				Connection conn =DBUtil.getConnection();
				Statement state =null;
				ResultSet rs = null;
				Mes needBean =null;
				System.out.println(logic1);
				System.out.println(logic2);
				if(!logic1.equals("")){
					if(logic1.equals("not"))
						sql += "and " + search2 + " not like '"+find2+"' ";
					else
						sql += logic1+" "+search2+" like '%"+find2+"%'";
				}
				if(!logic2.equals("")){
					if(logic2.equals("not"))
						sql += " and " + search3 + " not like '%"+find3+"%' ";
					else
						sql += logic2+" "+search3+" like '%"+find3+"%'";
				}
				try{
					state=conn.createStatement();
					rs=state.executeQuery(sql);
					while(rs.next()){
						needBean = new Mes();
						needBean.setPlatname(rs.getString("platname"));
						needBean.setPingtaiLevel(rs.getString("PingtaiLevel"));
						needBean.setLocation(rs.getString("location"));
						needBean.setPingtaiShape(rs.getString("PingtaiShape"));
						needBean.setBTHconstruction(rs.getString("BTHconstruction"));
						needBean.setEconoyServing(rs.getString("EconoyServing"));;
						needBean.setXueke(rs.getString("xueke"));
						needBean.setYituoCompany(rs.getString("YituoCompany"));;
						needBean.setDanweiDaima(rs.getString("DanweiDaima"));;
						needBean.setBangongPhone(rs.getString("BangongPhone"));
						needBean.setYituorenName(rs.getString("YituorenName"));
						needBean.setYituoType(rs.getString("YituoType"));
						needBean.setGongjianCompany(rs.getString("GongjianCompany"));
						needBean.setTaizhangName(rs.getString("TaizhangName"));
						needBean.setTaizhangSex(rs.getString("TaizhangSex"));
						needBean.setTaizhangBrith(rs.getString("TaizhangBrith"));
						needBean.setTaizhangZhicheng(rs.getString("TaizhangZhicheng"));
						needBean.setTaizhangZhuanye(rs.getString("TaizhangZhuanye"));
						needBean.setTaizhangXueli(rs.getString("TaizhangXueli"));
						needBean.setTaizhangXuewei(rs.getString("TaizhangXuewei"));
						needBean.setTaizhangBangong(rs.getString("TaizhangBangong"));
						needBean.setTaizhangShouji(rs.getString("TaizhangShouji"));
						needBean.setTaizhangEmail(rs.getString("TaizhangEmail"));
						needBean.setPingtaiWebName(rs.getString("PingtaiWebName"));
						needBean.setPingtaiWebaddress(rs.getString("PingtaiWebaddress"));
						needBean.setPingtaiTongxunDizhi(rs.getString("PingtaiTongxunDizhi"));
						needBean.setMail(rs.getString("mail"));
						needBeans.add(needBean);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				finally{
					DBUtil.close(rs, state, conn);
				}
				
				return needBeans;
			}
			
			public List<Mes> findNeedJC(int n){
				List<Mes> needBeans = new ArrayList<Mes>();
				if(n==2){//京津冀共建
					String sql = "select * from xuqiuvalue";
					Connection conn =DBUtil.getConnection();
					Statement state =null;
					ResultSet rs = null;
					Mes needBean =null;
					try{
						state=conn.createStatement();
						rs=state.executeQuery(sql);
						while(rs.next()){
							needBean = new Mes();
							needBean.setPlatname(rs.getString("platname"));
							needBean.setPingtaiLevel(rs.getString("PingtaiLevel"));
							needBean.setLocation(rs.getString("location"));
							needBean.setPingtaiShape(rs.getString("PingtaiShape"));
							needBean.setBTHconstruction(rs.getString("BTHconstruction"));
							needBean.setEconoyServing(rs.getString("EconoyServing"));;
							needBean.setXueke(rs.getString("xueke"));
							needBean.setYituoCompany(rs.getString("YituoCompany"));;
							needBean.setDanweiDaima(rs.getString("DanweiDaima"));;
							needBean.setBangongPhone(rs.getString("BangongPhone"));
							needBean.setYituorenName(rs.getString("YituorenName"));
							needBean.setYituoType(rs.getString("YituoType"));
							needBean.setGongjianCompany(rs.getString("GongjianCompany"));
							needBean.setTaizhangName(rs.getString("TaizhangName"));
							needBean.setTaizhangSex(rs.getString("TaizhangSex"));
							needBean.setTaizhangBrith(rs.getString("TaizhangBrith"));
							needBean.setTaizhangZhicheng(rs.getString("TaizhangZhicheng"));
							needBean.setTaizhangZhuanye(rs.getString("TaizhangZhuanye"));
							needBean.setTaizhangXueli(rs.getString("TaizhangXueli"));
							needBean.setTaizhangXuewei(rs.getString("TaizhangXuewei"));
							needBean.setTaizhangBangong(rs.getString("TaizhangBangong"));
							needBean.setTaizhangShouji(rs.getString("TaizhangShouji"));
							needBean.setTaizhangEmail(rs.getString("TaizhangEmail"));
							needBean.setPingtaiWebName(rs.getString("PingtaiWebName"));
							needBean.setPingtaiWebaddress(rs.getString("PingtaiWebaddress"));
							needBean.setPingtaiTongxunDizhi(rs.getString("PingtaiTongxunDizhi"));
							needBean.setMail(rs.getString("mail"));
							needBeans.add(needBean);
						}
					}catch(Exception e){
						e.printStackTrace();
					}
					finally{
						DBUtil.close(rs, state, conn);
					}
					return needBeans;
				}else if(n==3){//平台级别
					String sql = "select * from xuqiuvalue";
					Connection conn =DBUtil.getConnection();
					Statement state =null;
					ResultSet rs = null;
					Mes needBean =null;
					try{
						state=conn.createStatement();
						rs=state.executeQuery(sql);
						while(rs.next()){
							needBean = new Mes();
							needBean.setPlatname(rs.getString("platname"));
							needBean.setPingtaiLevel(rs.getString("PingtaiLevel"));
							needBean.setLocation(rs.getString("location"));
							needBean.setPingtaiShape(rs.getString("PingtaiShape"));
							needBean.setBTHconstruction(rs.getString("BTHconstruction"));
							needBean.setEconoyServing(rs.getString("EconoyServing"));;
							needBean.setXueke(rs.getString("xueke"));
							needBean.setYituoCompany(rs.getString("YituoCompany"));;
							needBean.setDanweiDaima(rs.getString("DanweiDaima"));;
							needBean.setBangongPhone(rs.getString("BangongPhone"));
							needBean.setYituorenName(rs.getString("YituorenName"));
							needBean.setYituoType(rs.getString("YituoType"));
							needBean.setGongjianCompany(rs.getString("GongjianCompany"));
							needBean.setTaizhangName(rs.getString("TaizhangName"));
							needBean.setTaizhangSex(rs.getString("TaizhangSex"));
							needBean.setTaizhangBrith(rs.getString("TaizhangBrith"));
							needBean.setTaizhangZhicheng(rs.getString("TaizhangZhicheng"));
							needBean.setTaizhangZhuanye(rs.getString("TaizhangZhuanye"));
							needBean.setTaizhangXueli(rs.getString("TaizhangXueli"));
							needBean.setTaizhangXuewei(rs.getString("TaizhangXuewei"));
							needBean.setTaizhangBangong(rs.getString("TaizhangBangong"));
							needBean.setTaizhangShouji(rs.getString("TaizhangShouji"));
							needBean.setTaizhangEmail(rs.getString("TaizhangEmail"));
							needBean.setPingtaiWebName(rs.getString("PingtaiWebName"));
							needBean.setPingtaiWebaddress(rs.getString("PingtaiWebaddress"));
							needBean.setPingtaiTongxunDizhi(rs.getString("PingtaiTongxunDizhi"));
							needBean.setMail(rs.getString("mail"));
							needBeans.add(needBean);
						}
					}catch(Exception e){
						e.printStackTrace();
					}
					finally{
						DBUtil.close(rs, state, conn);
					}
					return needBeans;
				}else if(n==4){//依托类型
					String sql = "select * from xuqiuvalue";
					Connection conn =DBUtil.getConnection();
					Statement state =null;
					ResultSet rs = null;
					Mes needBean =null;
					try{
						state=conn.createStatement();
						rs=state.executeQuery(sql);
						while(rs.next()){
							needBean = new Mes();
							needBean.setPlatname(rs.getString("platname"));
							needBean.setPingtaiLevel(rs.getString("PingtaiLevel"));
							needBean.setLocation(rs.getString("location"));
							needBean.setPingtaiShape(rs.getString("PingtaiShape"));
							needBean.setBTHconstruction(rs.getString("BTHconstruction"));
							needBean.setEconoyServing(rs.getString("EconoyServing"));;
							needBean.setXueke(rs.getString("xueke"));
							needBean.setYituoCompany(rs.getString("YituoCompany"));;
							needBean.setDanweiDaima(rs.getString("DanweiDaima"));;
							needBean.setBangongPhone(rs.getString("BangongPhone"));
							needBean.setYituorenName(rs.getString("YituorenName"));
							needBean.setYituoType(rs.getString("YituoType"));
							needBean.setGongjianCompany(rs.getString("GongjianCompany"));
							needBean.setTaizhangName(rs.getString("TaizhangName"));
							needBean.setTaizhangSex(rs.getString("TaizhangSex"));
							needBean.setTaizhangBrith(rs.getString("TaizhangBrith"));
							needBean.setTaizhangZhicheng(rs.getString("TaizhangZhicheng"));
							needBean.setTaizhangZhuanye(rs.getString("TaizhangZhuanye"));
							needBean.setTaizhangXueli(rs.getString("TaizhangXueli"));
							needBean.setTaizhangXuewei(rs.getString("TaizhangXuewei"));
							needBean.setTaizhangBangong(rs.getString("TaizhangBangong"));
							needBean.setTaizhangShouji(rs.getString("TaizhangShouji"));
							needBean.setTaizhangEmail(rs.getString("TaizhangEmail"));
							needBean.setPingtaiWebName(rs.getString("PingtaiWebName"));
							needBean.setPingtaiWebaddress(rs.getString("PingtaiWebaddress"));
							needBean.setPingtaiTongxunDizhi(rs.getString("PingtaiTongxunDizhi"));
							needBean.setMail(rs.getString("mail"));
							needBeans.add(needBean);
						}
					}catch(Exception e){
						e.printStackTrace();
					}
					finally{
						DBUtil.close(rs, state, conn);
					}
					return needBeans;
				}else if(n==5){//京津冀共建是
					String sql = "select * from xuqiuvalue where BTHconstruction='是'";
					Connection conn =DBUtil.getConnection();
					Statement state =null;
					ResultSet rs = null;
					Mes needBean =null;
					try{
						state=conn.createStatement();
						rs=state.executeQuery(sql);
						while(rs.next()){
							needBean = new Mes();
							needBean.setPlatname(rs.getString("platname"));
							needBean.setPingtaiLevel(rs.getString("PingtaiLevel"));
							needBean.setLocation(rs.getString("location"));
							needBean.setPingtaiShape(rs.getString("PingtaiShape"));
							needBean.setBTHconstruction(rs.getString("BTHconstruction"));
							needBean.setEconoyServing(rs.getString("EconoyServing"));;
							needBean.setXueke(rs.getString("xueke"));
							needBean.setYituoCompany(rs.getString("YituoCompany"));;
							needBean.setDanweiDaima(rs.getString("DanweiDaima"));;
							needBean.setBangongPhone(rs.getString("BangongPhone"));
							needBean.setYituorenName(rs.getString("YituorenName"));
							needBean.setYituoType(rs.getString("YituoType"));
							needBean.setGongjianCompany(rs.getString("GongjianCompany"));
							needBean.setTaizhangName(rs.getString("TaizhangName"));
							needBean.setTaizhangSex(rs.getString("TaizhangSex"));
							needBean.setTaizhangBrith(rs.getString("TaizhangBrith"));
							needBean.setTaizhangZhicheng(rs.getString("TaizhangZhicheng"));
							needBean.setTaizhangZhuanye(rs.getString("TaizhangZhuanye"));
							needBean.setTaizhangXueli(rs.getString("TaizhangXueli"));
							needBean.setTaizhangXuewei(rs.getString("TaizhangXuewei"));
							needBean.setTaizhangBangong(rs.getString("TaizhangBangong"));
							needBean.setTaizhangShouji(rs.getString("TaizhangShouji"));
							needBean.setTaizhangEmail(rs.getString("TaizhangEmail"));
							needBean.setPingtaiWebName(rs.getString("PingtaiWebName"));
							needBean.setPingtaiWebaddress(rs.getString("PingtaiWebaddress"));
							needBean.setPingtaiTongxunDizhi(rs.getString("PingtaiTongxunDizhi"));
							needBean.setMail(rs.getString("mail"));
							needBeans.add(needBean);
						}
					}catch(Exception e){
						e.printStackTrace();
					}
					finally{
						DBUtil.close(rs, state, conn);
					}
					return needBeans;
				}else if(n==6){//京津冀共建否
					String sql = "select * from xuqiuvalue where BTHconstruction='否'";
					Connection conn =DBUtil.getConnection();
					Statement state =null;
					ResultSet rs = null;
					Mes needBean =null;
					try{
						state=conn.createStatement();
						rs=state.executeQuery(sql);
						while(rs.next()){
							needBean = new Mes();
							needBean.setPlatname(rs.getString("platname"));
							needBean.setPingtaiLevel(rs.getString("PingtaiLevel"));
							needBean.setLocation(rs.getString("location"));
							needBean.setPingtaiShape(rs.getString("PingtaiShape"));
							needBean.setBTHconstruction(rs.getString("BTHconstruction"));
							needBean.setEconoyServing(rs.getString("EconoyServing"));;
							needBean.setXueke(rs.getString("xueke"));
							needBean.setYituoCompany(rs.getString("YituoCompany"));;
							needBean.setDanweiDaima(rs.getString("DanweiDaima"));;
							needBean.setBangongPhone(rs.getString("BangongPhone"));
							needBean.setYituorenName(rs.getString("YituorenName"));
							needBean.setYituoType(rs.getString("YituoType"));
							needBean.setGongjianCompany(rs.getString("GongjianCompany"));
							needBean.setTaizhangName(rs.getString("TaizhangName"));
							needBean.setTaizhangSex(rs.getString("TaizhangSex"));
							needBean.setTaizhangBrith(rs.getString("TaizhangBrith"));
							needBean.setTaizhangZhicheng(rs.getString("TaizhangZhicheng"));
							needBean.setTaizhangZhuanye(rs.getString("TaizhangZhuanye"));
							needBean.setTaizhangXueli(rs.getString("TaizhangXueli"));
							needBean.setTaizhangXuewei(rs.getString("TaizhangXuewei"));
							needBean.setTaizhangBangong(rs.getString("TaizhangBangong"));
							needBean.setTaizhangShouji(rs.getString("TaizhangShouji"));
							needBean.setTaizhangEmail(rs.getString("TaizhangEmail"));
							needBean.setPingtaiWebName(rs.getString("PingtaiWebName"));
							needBean.setPingtaiWebaddress(rs.getString("PingtaiWebaddress"));
							needBean.setPingtaiTongxunDizhi(rs.getString("PingtaiTongxunDizhi"));
							needBean.setMail(rs.getString("mail"));
							needBeans.add(needBean);
						}
					}catch(Exception e){
						e.printStackTrace();
					}
					finally{
						DBUtil.close(rs, state, conn);
					}
					return needBeans;
				}else if(n==7){//国家级
					String sql = "select * from xuqiuvalue where PingtaiLevel='国家级'";
					Connection conn =DBUtil.getConnection();
					Statement state =null;
					ResultSet rs = null;
					Mes needBean =null;
					try{
						state=conn.createStatement();
						rs=state.executeQuery(sql);
						while(rs.next()){
							needBean = new Mes();
							needBean.setPlatname(rs.getString("platname"));
							needBean.setPingtaiLevel(rs.getString("PingtaiLevel"));
							needBean.setLocation(rs.getString("location"));
							needBean.setPingtaiShape(rs.getString("PingtaiShape"));
							needBean.setBTHconstruction(rs.getString("BTHconstruction"));
							needBean.setEconoyServing(rs.getString("EconoyServing"));;
							needBean.setXueke(rs.getString("xueke"));
							needBean.setYituoCompany(rs.getString("YituoCompany"));;
							needBean.setDanweiDaima(rs.getString("DanweiDaima"));;
							needBean.setBangongPhone(rs.getString("BangongPhone"));
							needBean.setYituorenName(rs.getString("YituorenName"));
							needBean.setYituoType(rs.getString("YituoType"));
							needBean.setGongjianCompany(rs.getString("GongjianCompany"));
							needBean.setTaizhangName(rs.getString("TaizhangName"));
							needBean.setTaizhangSex(rs.getString("TaizhangSex"));
							needBean.setTaizhangBrith(rs.getString("TaizhangBrith"));
							needBean.setTaizhangZhicheng(rs.getString("TaizhangZhicheng"));
							needBean.setTaizhangZhuanye(rs.getString("TaizhangZhuanye"));
							needBean.setTaizhangXueli(rs.getString("TaizhangXueli"));
							needBean.setTaizhangXuewei(rs.getString("TaizhangXuewei"));
							needBean.setTaizhangBangong(rs.getString("TaizhangBangong"));
							needBean.setTaizhangShouji(rs.getString("TaizhangShouji"));
							needBean.setTaizhangEmail(rs.getString("TaizhangEmail"));
							needBean.setPingtaiWebName(rs.getString("PingtaiWebName"));
							needBean.setPingtaiWebaddress(rs.getString("PingtaiWebaddress"));
							needBean.setPingtaiTongxunDizhi(rs.getString("PingtaiTongxunDizhi"));
							needBean.setMail(rs.getString("mail"));
							needBeans.add(needBean);
						}
					}catch(Exception e){
						e.printStackTrace();
					}
					finally{
						DBUtil.close(rs, state, conn);
					}
					return needBeans;
				}else if(n==8){//省级
					String sql = "select * from xuqiuvalue where PingtaiLevel='省级'";
					Connection conn =DBUtil.getConnection();
					Statement state =null;
					ResultSet rs = null;
					Mes needBean =null;
					try{
						state=conn.createStatement();
						rs=state.executeQuery(sql);
						while(rs.next()){
							needBean = new Mes();
							needBean.setPlatname(rs.getString("platname"));
							needBean.setPingtaiLevel(rs.getString("PingtaiLevel"));
							needBean.setLocation(rs.getString("location"));
							needBean.setPingtaiShape(rs.getString("PingtaiShape"));
							needBean.setBTHconstruction(rs.getString("BTHconstruction"));
							needBean.setEconoyServing(rs.getString("EconoyServing"));;
							needBean.setXueke(rs.getString("xueke"));
							needBean.setYituoCompany(rs.getString("YituoCompany"));;
							needBean.setDanweiDaima(rs.getString("DanweiDaima"));;
							needBean.setBangongPhone(rs.getString("BangongPhone"));
							needBean.setYituorenName(rs.getString("YituorenName"));
							needBean.setYituoType(rs.getString("YituoType"));
							needBean.setGongjianCompany(rs.getString("GongjianCompany"));
							needBean.setTaizhangName(rs.getString("TaizhangName"));
							needBean.setTaizhangSex(rs.getString("TaizhangSex"));
							needBean.setTaizhangBrith(rs.getString("TaizhangBrith"));
							needBean.setTaizhangZhicheng(rs.getString("TaizhangZhicheng"));
							needBean.setTaizhangZhuanye(rs.getString("TaizhangZhuanye"));
							needBean.setTaizhangXueli(rs.getString("TaizhangXueli"));
							needBean.setTaizhangXuewei(rs.getString("TaizhangXuewei"));
							needBean.setTaizhangBangong(rs.getString("TaizhangBangong"));
							needBean.setTaizhangShouji(rs.getString("TaizhangShouji"));
							needBean.setTaizhangEmail(rs.getString("TaizhangEmail"));
							needBean.setPingtaiWebName(rs.getString("PingtaiWebName"));
							needBean.setPingtaiWebaddress(rs.getString("PingtaiWebaddress"));
							needBean.setPingtaiTongxunDizhi(rs.getString("PingtaiTongxunDizhi"));
							needBean.setMail(rs.getString("mail"));
							needBeans.add(needBean);
						}
					}catch(Exception e){
						e.printStackTrace();
					}
					finally{
						DBUtil.close(rs, state, conn);
					}
					return needBeans;
				}else if(n==9){//依托企业
					String sql = "select * from xuqiuvalue where YituoType='企业'";
					Connection conn =DBUtil.getConnection();
					Statement state =null;
					ResultSet rs = null;
					Mes needBean =null;
					try{
						state=conn.createStatement();
						rs=state.executeQuery(sql);
						while(rs.next()){
							needBean = new Mes();
							needBean.setPlatname(rs.getString("platname"));
							needBean.setPingtaiLevel(rs.getString("PingtaiLevel"));
							needBean.setLocation(rs.getString("location"));
							needBean.setPingtaiShape(rs.getString("PingtaiShape"));
							needBean.setBTHconstruction(rs.getString("BTHconstruction"));
							needBean.setEconoyServing(rs.getString("EconoyServing"));;
							needBean.setXueke(rs.getString("xueke"));
							needBean.setYituoCompany(rs.getString("YituoCompany"));;
							needBean.setDanweiDaima(rs.getString("DanweiDaima"));;
							needBean.setBangongPhone(rs.getString("BangongPhone"));
							needBean.setYituorenName(rs.getString("YituorenName"));
							needBean.setYituoType(rs.getString("YituoType"));
							needBean.setGongjianCompany(rs.getString("GongjianCompany"));
							needBean.setTaizhangName(rs.getString("TaizhangName"));
							needBean.setTaizhangSex(rs.getString("TaizhangSex"));
							needBean.setTaizhangBrith(rs.getString("TaizhangBrith"));
							needBean.setTaizhangZhicheng(rs.getString("TaizhangZhicheng"));
							needBean.setTaizhangZhuanye(rs.getString("TaizhangZhuanye"));
							needBean.setTaizhangXueli(rs.getString("TaizhangXueli"));
							needBean.setTaizhangXuewei(rs.getString("TaizhangXuewei"));
							needBean.setTaizhangBangong(rs.getString("TaizhangBangong"));
							needBean.setTaizhangShouji(rs.getString("TaizhangShouji"));
							needBean.setTaizhangEmail(rs.getString("TaizhangEmail"));
							needBean.setPingtaiWebName(rs.getString("PingtaiWebName"));
							needBean.setPingtaiWebaddress(rs.getString("PingtaiWebaddress"));
							needBean.setPingtaiTongxunDizhi(rs.getString("PingtaiTongxunDizhi"));
							needBean.setMail(rs.getString("mail"));
							needBeans.add(needBean);
						}
					}catch(Exception e){
						e.printStackTrace();
					}
					finally{
						DBUtil.close(rs, state, conn);
					}
					return needBeans;
				
			}else if(n==10){//依托科研
				String sql = "select * from xuqiuvalue where YituoType='科研机构'";
				Connection conn =DBUtil.getConnection();
				Statement state =null;
				ResultSet rs = null;
				Mes needBean =null;
				try{
					state=conn.createStatement();
					rs=state.executeQuery(sql);
					while(rs.next()){
						needBean = new Mes();
						needBean.setPlatname(rs.getString("platname"));
						needBean.setPingtaiLevel(rs.getString("PingtaiLevel"));
						needBean.setLocation(rs.getString("location"));
						needBean.setPingtaiShape(rs.getString("PingtaiShape"));
						needBean.setBTHconstruction(rs.getString("BTHconstruction"));
						needBean.setEconoyServing(rs.getString("EconoyServing"));;
						needBean.setXueke(rs.getString("xueke"));
						needBean.setYituoCompany(rs.getString("YituoCompany"));;
						needBean.setDanweiDaima(rs.getString("DanweiDaima"));;
						needBean.setBangongPhone(rs.getString("BangongPhone"));
						needBean.setYituorenName(rs.getString("YituorenName"));
						needBean.setYituoType(rs.getString("YituoType"));
						needBean.setGongjianCompany(rs.getString("GongjianCompany"));
						needBean.setTaizhangName(rs.getString("TaizhangName"));
						needBean.setTaizhangSex(rs.getString("TaizhangSex"));
						needBean.setTaizhangBrith(rs.getString("TaizhangBrith"));
						needBean.setTaizhangZhicheng(rs.getString("TaizhangZhicheng"));
						needBean.setTaizhangZhuanye(rs.getString("TaizhangZhuanye"));
						needBean.setTaizhangXueli(rs.getString("TaizhangXueli"));
						needBean.setTaizhangXuewei(rs.getString("TaizhangXuewei"));
						needBean.setTaizhangBangong(rs.getString("TaizhangBangong"));
						needBean.setTaizhangShouji(rs.getString("TaizhangShouji"));
						needBean.setTaizhangEmail(rs.getString("TaizhangEmail"));
						needBean.setPingtaiWebName(rs.getString("PingtaiWebName"));
						needBean.setPingtaiWebaddress(rs.getString("PingtaiWebaddress"));
						needBean.setPingtaiTongxunDizhi(rs.getString("PingtaiTongxunDizhi"));
						needBean.setMail(rs.getString("mail"));
						needBeans.add(needBean);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				finally{
					DBUtil.close(rs, state, conn);
				}
				return needBeans;
			
			}else if(n==11){//依托高校
				String sql = "select * from xuqiuvalue where YituoType='高等院校'";
				Connection conn =DBUtil.getConnection();
				Statement state =null;
				ResultSet rs = null;
				Mes needBean =null;
				try{
					state=conn.createStatement();
					rs=state.executeQuery(sql);
					while(rs.next()){
						needBean = new Mes();
						needBean.setPlatname(rs.getString("platname"));
						needBean.setPingtaiLevel(rs.getString("PingtaiLevel"));
						needBean.setLocation(rs.getString("location"));
						needBean.setPingtaiShape(rs.getString("PingtaiShape"));
						needBean.setBTHconstruction(rs.getString("BTHconstruction"));
						needBean.setEconoyServing(rs.getString("EconoyServing"));;
						needBean.setXueke(rs.getString("xueke"));
						needBean.setYituoCompany(rs.getString("YituoCompany"));;
						needBean.setDanweiDaima(rs.getString("DanweiDaima"));;
						needBean.setBangongPhone(rs.getString("BangongPhone"));
						needBean.setYituorenName(rs.getString("YituorenName"));
						needBean.setYituoType(rs.getString("YituoType"));
						needBean.setGongjianCompany(rs.getString("GongjianCompany"));
						needBean.setTaizhangName(rs.getString("TaizhangName"));
						needBean.setTaizhangSex(rs.getString("TaizhangSex"));
						needBean.setTaizhangBrith(rs.getString("TaizhangBrith"));
						needBean.setTaizhangZhicheng(rs.getString("TaizhangZhicheng"));
						needBean.setTaizhangZhuanye(rs.getString("TaizhangZhuanye"));
						needBean.setTaizhangXueli(rs.getString("TaizhangXueli"));
						needBean.setTaizhangXuewei(rs.getString("TaizhangXuewei"));
						needBean.setTaizhangBangong(rs.getString("TaizhangBangong"));
						needBean.setTaizhangShouji(rs.getString("TaizhangShouji"));
						needBean.setTaizhangEmail(rs.getString("TaizhangEmail"));
						needBean.setPingtaiWebName(rs.getString("PingtaiWebName"));
						needBean.setPingtaiWebaddress(rs.getString("PingtaiWebaddress"));
						needBean.setPingtaiTongxunDizhi(rs.getString("PingtaiTongxunDizhi"));
						needBean.setMail(rs.getString("mail"));
						needBeans.add(needBean);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				finally{
					DBUtil.close(rs, state, conn);
				}
				return needBeans;
			}else if(n==12){//依托检测
				String sql = "select * from xuqiuvalue where YituoType='检测机构'";
				Connection conn =DBUtil.getConnection();
				Statement state =null;
				ResultSet rs = null;
				Mes needBean =null;
				try{
					state=conn.createStatement();
					rs=state.executeQuery(sql);
					while(rs.next()){
						needBean = new Mes();
						needBean.setPlatname(rs.getString("platname"));
						needBean.setPingtaiLevel(rs.getString("PingtaiLevel"));
						needBean.setLocation(rs.getString("location"));
						needBean.setPingtaiShape(rs.getString("PingtaiShape"));
						needBean.setBTHconstruction(rs.getString("BTHconstruction"));
						needBean.setEconoyServing(rs.getString("EconoyServing"));;
						needBean.setXueke(rs.getString("xueke"));
						needBean.setYituoCompany(rs.getString("YituoCompany"));;
						needBean.setDanweiDaima(rs.getString("DanweiDaima"));;
						needBean.setBangongPhone(rs.getString("BangongPhone"));
						needBean.setYituorenName(rs.getString("YituorenName"));
						needBean.setYituoType(rs.getString("YituoType"));
						needBean.setGongjianCompany(rs.getString("GongjianCompany"));
						needBean.setTaizhangName(rs.getString("TaizhangName"));
						needBean.setTaizhangSex(rs.getString("TaizhangSex"));
						needBean.setTaizhangBrith(rs.getString("TaizhangBrith"));
						needBean.setTaizhangZhicheng(rs.getString("TaizhangZhicheng"));
						needBean.setTaizhangZhuanye(rs.getString("TaizhangZhuanye"));
						needBean.setTaizhangXueli(rs.getString("TaizhangXueli"));
						needBean.setTaizhangXuewei(rs.getString("TaizhangXuewei"));
						needBean.setTaizhangBangong(rs.getString("TaizhangBangong"));
						needBean.setTaizhangShouji(rs.getString("TaizhangShouji"));
						needBean.setTaizhangEmail(rs.getString("TaizhangEmail"));
						needBean.setPingtaiWebName(rs.getString("PingtaiWebName"));
						needBean.setPingtaiWebaddress(rs.getString("PingtaiWebaddress"));
						needBean.setPingtaiTongxunDizhi(rs.getString("PingtaiTongxunDizhi"));
						needBean.setMail(rs.getString("mail"));
						needBeans.add(needBean);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				finally{
					DBUtil.close(rs, state, conn);
				}
				return needBeans;
			}else if(n==13){//依托医疗
				String sql = "select * from xuqiuvalue where YituoType='医疗机构'";
				Connection conn =DBUtil.getConnection();
				Statement state =null;
				ResultSet rs = null;
				Mes needBean =null;
				try{
					state=conn.createStatement();
					rs=state.executeQuery(sql);
					while(rs.next()){
						needBean = new Mes();
						needBean.setPlatname(rs.getString("platname"));
						needBean.setPingtaiLevel(rs.getString("PingtaiLevel"));
						needBean.setLocation(rs.getString("location"));
						needBean.setPingtaiShape(rs.getString("PingtaiShape"));
						needBean.setBTHconstruction(rs.getString("BTHconstruction"));
						needBean.setEconoyServing(rs.getString("EconoyServing"));;
						needBean.setXueke(rs.getString("xueke"));
						needBean.setYituoCompany(rs.getString("YituoCompany"));;
						needBean.setDanweiDaima(rs.getString("DanweiDaima"));;
						needBean.setBangongPhone(rs.getString("BangongPhone"));
						needBean.setYituorenName(rs.getString("YituorenName"));
						needBean.setYituoType(rs.getString("YituoType"));
						needBean.setGongjianCompany(rs.getString("GongjianCompany"));
						needBean.setTaizhangName(rs.getString("TaizhangName"));
						needBean.setTaizhangSex(rs.getString("TaizhangSex"));
						needBean.setTaizhangBrith(rs.getString("TaizhangBrith"));
						needBean.setTaizhangZhicheng(rs.getString("TaizhangZhicheng"));
						needBean.setTaizhangZhuanye(rs.getString("TaizhangZhuanye"));
						needBean.setTaizhangXueli(rs.getString("TaizhangXueli"));
						needBean.setTaizhangXuewei(rs.getString("TaizhangXuewei"));
						needBean.setTaizhangBangong(rs.getString("TaizhangBangong"));
						needBean.setTaizhangShouji(rs.getString("TaizhangShouji"));
						needBean.setTaizhangEmail(rs.getString("TaizhangEmail"));
						needBean.setPingtaiWebName(rs.getString("PingtaiWebName"));
						needBean.setPingtaiWebaddress(rs.getString("PingtaiWebaddress"));
						needBean.setPingtaiTongxunDizhi(rs.getString("PingtaiTongxunDizhi"));
						needBean.setMail(rs.getString("mail"));
						needBeans.add(needBean);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				finally{
					DBUtil.close(rs, state, conn);
				}
				return needBeans;
			}else if(n==14){//依托政府
				String sql = "select * from xuqiuvalue where YituoType='政府机构'";
				Connection conn =DBUtil.getConnection();
				Statement state =null;
				ResultSet rs = null;
				Mes needBean =null;
				try{
					state=conn.createStatement();
					rs=state.executeQuery(sql);
					while(rs.next()){
						needBean = new Mes();
						needBean.setPlatname(rs.getString("platname"));
						needBean.setPingtaiLevel(rs.getString("PingtaiLevel"));
						needBean.setLocation(rs.getString("location"));
						needBean.setPingtaiShape(rs.getString("PingtaiShape"));
						needBean.setBTHconstruction(rs.getString("BTHconstruction"));
						needBean.setEconoyServing(rs.getString("EconoyServing"));;
						needBean.setXueke(rs.getString("xueke"));
						needBean.setYituoCompany(rs.getString("YituoCompany"));;
						needBean.setDanweiDaima(rs.getString("DanweiDaima"));;
						needBean.setBangongPhone(rs.getString("BangongPhone"));
						needBean.setYituorenName(rs.getString("YituorenName"));
						needBean.setYituoType(rs.getString("YituoType"));
						needBean.setGongjianCompany(rs.getString("GongjianCompany"));
						needBean.setTaizhangName(rs.getString("TaizhangName"));
						needBean.setTaizhangSex(rs.getString("TaizhangSex"));
						needBean.setTaizhangBrith(rs.getString("TaizhangBrith"));
						needBean.setTaizhangZhicheng(rs.getString("TaizhangZhicheng"));
						needBean.setTaizhangZhuanye(rs.getString("TaizhangZhuanye"));
						needBean.setTaizhangXueli(rs.getString("TaizhangXueli"));
						needBean.setTaizhangXuewei(rs.getString("TaizhangXuewei"));
						needBean.setTaizhangBangong(rs.getString("TaizhangBangong"));
						needBean.setTaizhangShouji(rs.getString("TaizhangShouji"));
						needBean.setTaizhangEmail(rs.getString("TaizhangEmail"));
						needBean.setPingtaiWebName(rs.getString("PingtaiWebName"));
						needBean.setPingtaiWebaddress(rs.getString("PingtaiWebaddress"));
						needBean.setPingtaiTongxunDizhi(rs.getString("PingtaiTongxunDizhi"));
						needBean.setMail(rs.getString("mail"));
						needBeans.add(needBean);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				finally{
					DBUtil.close(rs, state, conn);
				}
				return needBeans;
			}else if(n==15){//依托社团
				String sql = "select * from xuqiuvalue where YituoType='社团'";
				Connection conn =DBUtil.getConnection();
				Statement state =null;
				ResultSet rs = null;
				Mes needBean =null;
				try{
					state=conn.createStatement();
					rs=state.executeQuery(sql);
					while(rs.next()){
						needBean = new Mes();
						needBean.setPlatname(rs.getString("platname"));
						needBean.setPingtaiLevel(rs.getString("PingtaiLevel"));
						needBean.setLocation(rs.getString("location"));
						needBean.setPingtaiShape(rs.getString("PingtaiShape"));
						needBean.setBTHconstruction(rs.getString("BTHconstruction"));
						needBean.setEconoyServing(rs.getString("EconoyServing"));;
						needBean.setXueke(rs.getString("xueke"));
						needBean.setYituoCompany(rs.getString("YituoCompany"));;
						needBean.setDanweiDaima(rs.getString("DanweiDaima"));;
						needBean.setBangongPhone(rs.getString("BangongPhone"));
						needBean.setYituorenName(rs.getString("YituorenName"));
						needBean.setYituoType(rs.getString("YituoType"));
						needBean.setGongjianCompany(rs.getString("GongjianCompany"));
						needBean.setTaizhangName(rs.getString("TaizhangName"));
						needBean.setTaizhangSex(rs.getString("TaizhangSex"));
						needBean.setTaizhangBrith(rs.getString("TaizhangBrith"));
						needBean.setTaizhangZhicheng(rs.getString("TaizhangZhicheng"));
						needBean.setTaizhangZhuanye(rs.getString("TaizhangZhuanye"));
						needBean.setTaizhangXueli(rs.getString("TaizhangXueli"));
						needBean.setTaizhangXuewei(rs.getString("TaizhangXuewei"));
						needBean.setTaizhangBangong(rs.getString("TaizhangBangong"));
						needBean.setTaizhangShouji(rs.getString("TaizhangShouji"));
						needBean.setTaizhangEmail(rs.getString("TaizhangEmail"));
						needBean.setPingtaiWebName(rs.getString("PingtaiWebName"));
						needBean.setPingtaiWebaddress(rs.getString("PingtaiWebaddress"));
						needBean.setPingtaiTongxunDizhi(rs.getString("PingtaiTongxunDizhi"));
						needBean.setMail(rs.getString("mail"));
						needBeans.add(needBean);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				finally{
					DBUtil.close(rs, state, conn);
				}
				return needBeans;
			}else if(n==16){//依托其他
				String sql = "select * from xuqiuvalue where YituoType='其他'";
				Connection conn =DBUtil.getConnection();
				Statement state =null;
				ResultSet rs = null;
				Mes needBean =null;
				try{
					state=conn.createStatement();
					rs=state.executeQuery(sql);
					while(rs.next()){
						needBean = new Mes();
						needBean.setPlatname(rs.getString("platname"));
						needBean.setPingtaiLevel(rs.getString("PingtaiLevel"));
						needBean.setLocation(rs.getString("location"));
						needBean.setPingtaiShape(rs.getString("PingtaiShape"));
						needBean.setBTHconstruction(rs.getString("BTHconstruction"));
						needBean.setEconoyServing(rs.getString("EconoyServing"));;
						needBean.setXueke(rs.getString("xueke"));
						needBean.setYituoCompany(rs.getString("YituoCompany"));;
						needBean.setDanweiDaima(rs.getString("DanweiDaima"));;
						needBean.setBangongPhone(rs.getString("BangongPhone"));
						needBean.setYituorenName(rs.getString("YituorenName"));
						needBean.setYituoType(rs.getString("YituoType"));
						needBean.setGongjianCompany(rs.getString("GongjianCompany"));
						needBean.setTaizhangName(rs.getString("TaizhangName"));
						needBean.setTaizhangSex(rs.getString("TaizhangSex"));
						needBean.setTaizhangBrith(rs.getString("TaizhangBrith"));
						needBean.setTaizhangZhicheng(rs.getString("TaizhangZhicheng"));
						needBean.setTaizhangZhuanye(rs.getString("TaizhangZhuanye"));
						needBean.setTaizhangXueli(rs.getString("TaizhangXueli"));
						needBean.setTaizhangXuewei(rs.getString("TaizhangXuewei"));
						needBean.setTaizhangBangong(rs.getString("TaizhangBangong"));
						needBean.setTaizhangShouji(rs.getString("TaizhangShouji"));
						needBean.setTaizhangEmail(rs.getString("TaizhangEmail"));
						needBean.setPingtaiWebName(rs.getString("PingtaiWebName"));
						needBean.setPingtaiWebaddress(rs.getString("PingtaiWebaddress"));
						needBean.setPingtaiTongxunDizhi(rs.getString("PingtaiTongxunDizhi"));
						needBean.setMail(rs.getString("mail"));
						needBeans.add(needBean);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				finally{
					DBUtil.close(rs, state, conn);
				}
				return needBeans;
			}else if(n==17){//所属学科
				String sql = "select * from xuqiuvalue ";
				Connection conn =DBUtil.getConnection();
				Statement state =null;
				ResultSet rs = null;
				Mes needBean =null;
				try{
					state=conn.createStatement();
					rs=state.executeQuery(sql);
					while(rs.next()){
						needBean = new Mes();
						needBean.setPlatname(rs.getString("platname"));
						needBean.setPingtaiLevel(rs.getString("PingtaiLevel"));
						needBean.setLocation(rs.getString("location"));
						needBean.setPingtaiShape(rs.getString("PingtaiShape"));
						needBean.setBTHconstruction(rs.getString("BTHconstruction"));
						needBean.setEconoyServing(rs.getString("EconoyServing"));;
						needBean.setXueke(rs.getString("xueke"));
						needBean.setYituoCompany(rs.getString("YituoCompany"));;
						needBean.setDanweiDaima(rs.getString("DanweiDaima"));;
						needBean.setBangongPhone(rs.getString("BangongPhone"));
						needBean.setYituorenName(rs.getString("YituorenName"));
						needBean.setYituoType(rs.getString("YituoType"));
						needBean.setGongjianCompany(rs.getString("GongjianCompany"));
						needBean.setTaizhangName(rs.getString("TaizhangName"));
						needBean.setTaizhangSex(rs.getString("TaizhangSex"));
						needBean.setTaizhangBrith(rs.getString("TaizhangBrith"));
						needBean.setTaizhangZhicheng(rs.getString("TaizhangZhicheng"));
						needBean.setTaizhangZhuanye(rs.getString("TaizhangZhuanye"));
						needBean.setTaizhangXueli(rs.getString("TaizhangXueli"));
						needBean.setTaizhangXuewei(rs.getString("TaizhangXuewei"));
						needBean.setTaizhangBangong(rs.getString("TaizhangBangong"));
						needBean.setTaizhangShouji(rs.getString("TaizhangShouji"));
						needBean.setTaizhangEmail(rs.getString("TaizhangEmail"));
						needBean.setPingtaiWebName(rs.getString("PingtaiWebName"));
						needBean.setPingtaiWebaddress(rs.getString("PingtaiWebaddress"));
						needBean.setPingtaiTongxunDizhi(rs.getString("PingtaiTongxunDizhi"));
						needBean.setMail(rs.getString("mail"));
						needBeans.add(needBean);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				finally{
					DBUtil.close(rs, state, conn);
				}
				return needBeans;
			}else if(n==18){//学科外语
				String sql = "select * from xuqiuvalue where xueke='外语'";
				Connection conn =DBUtil.getConnection();
				Statement state =null;
				ResultSet rs = null;
				Mes needBean =null;
				try{
					state=conn.createStatement();
					rs=state.executeQuery(sql);
					while(rs.next()){
						needBean = new Mes();
						needBean.setPlatname(rs.getString("platname"));
						needBean.setPingtaiLevel(rs.getString("PingtaiLevel"));
						needBean.setLocation(rs.getString("location"));
						needBean.setPingtaiShape(rs.getString("PingtaiShape"));
						needBean.setBTHconstruction(rs.getString("BTHconstruction"));
						needBean.setEconoyServing(rs.getString("EconoyServing"));;
						needBean.setXueke(rs.getString("xueke"));
						needBean.setYituoCompany(rs.getString("YituoCompany"));;
						needBean.setDanweiDaima(rs.getString("DanweiDaima"));;
						needBean.setBangongPhone(rs.getString("BangongPhone"));
						needBean.setYituorenName(rs.getString("YituorenName"));
						needBean.setYituoType(rs.getString("YituoType"));
						needBean.setGongjianCompany(rs.getString("GongjianCompany"));
						needBean.setTaizhangName(rs.getString("TaizhangName"));
						needBean.setTaizhangSex(rs.getString("TaizhangSex"));
						needBean.setTaizhangBrith(rs.getString("TaizhangBrith"));
						needBean.setTaizhangZhicheng(rs.getString("TaizhangZhicheng"));
						needBean.setTaizhangZhuanye(rs.getString("TaizhangZhuanye"));
						needBean.setTaizhangXueli(rs.getString("TaizhangXueli"));
						needBean.setTaizhangXuewei(rs.getString("TaizhangXuewei"));
						needBean.setTaizhangBangong(rs.getString("TaizhangBangong"));
						needBean.setTaizhangShouji(rs.getString("TaizhangShouji"));
						needBean.setTaizhangEmail(rs.getString("TaizhangEmail"));
						needBean.setPingtaiWebName(rs.getString("PingtaiWebName"));
						needBean.setPingtaiWebaddress(rs.getString("PingtaiWebaddress"));
						needBean.setPingtaiTongxunDizhi(rs.getString("PingtaiTongxunDizhi"));
						needBean.setMail(rs.getString("mail"));
						needBeans.add(needBean);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				finally{
					DBUtil.close(rs, state, conn);
				}
				return needBeans;
			}else if(n==19){//学科数学
				String sql = "select * from xuqiuvalue where xueke='数学'";
				Connection conn =DBUtil.getConnection();
				Statement state =null;
				ResultSet rs = null;
				Mes needBean =null;
				try{
					state=conn.createStatement();
					rs=state.executeQuery(sql);
					while(rs.next()){
						needBean = new Mes();
						needBean.setPlatname(rs.getString("platname"));
						needBean.setPingtaiLevel(rs.getString("PingtaiLevel"));
						needBean.setLocation(rs.getString("location"));
						needBean.setPingtaiShape(rs.getString("PingtaiShape"));
						needBean.setBTHconstruction(rs.getString("BTHconstruction"));
						needBean.setEconoyServing(rs.getString("EconoyServing"));;
						needBean.setXueke(rs.getString("xueke"));
						needBean.setYituoCompany(rs.getString("YituoCompany"));;
						needBean.setDanweiDaima(rs.getString("DanweiDaima"));;
						needBean.setBangongPhone(rs.getString("BangongPhone"));
						needBean.setYituorenName(rs.getString("YituorenName"));
						needBean.setYituoType(rs.getString("YituoType"));
						needBean.setGongjianCompany(rs.getString("GongjianCompany"));
						needBean.setTaizhangName(rs.getString("TaizhangName"));
						needBean.setTaizhangSex(rs.getString("TaizhangSex"));
						needBean.setTaizhangBrith(rs.getString("TaizhangBrith"));
						needBean.setTaizhangZhicheng(rs.getString("TaizhangZhicheng"));
						needBean.setTaizhangZhuanye(rs.getString("TaizhangZhuanye"));
						needBean.setTaizhangXueli(rs.getString("TaizhangXueli"));
						needBean.setTaizhangXuewei(rs.getString("TaizhangXuewei"));
						needBean.setTaizhangBangong(rs.getString("TaizhangBangong"));
						needBean.setTaizhangShouji(rs.getString("TaizhangShouji"));
						needBean.setTaizhangEmail(rs.getString("TaizhangEmail"));
						needBean.setPingtaiWebName(rs.getString("PingtaiWebName"));
						needBean.setPingtaiWebaddress(rs.getString("PingtaiWebaddress"));
						needBean.setPingtaiTongxunDizhi(rs.getString("PingtaiTongxunDizhi"));
						needBean.setMail(rs.getString("mail"));
						needBeans.add(needBean);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				finally{
					DBUtil.close(rs, state, conn);
				}
				return needBeans;
			}else if(n==20){//学科物理
				String sql = "select * from xuqiuvalue where xueke='物理'";
				Connection conn =DBUtil.getConnection();
				Statement state =null;
				ResultSet rs = null;
				Mes needBean =null;
				try{
					state=conn.createStatement();
					rs=state.executeQuery(sql);
					while(rs.next()){
						needBean = new Mes();
						needBean.setPlatname(rs.getString("platname"));
						needBean.setPingtaiLevel(rs.getString("PingtaiLevel"));
						needBean.setLocation(rs.getString("location"));
						needBean.setPingtaiShape(rs.getString("PingtaiShape"));
						needBean.setBTHconstruction(rs.getString("BTHconstruction"));
						needBean.setEconoyServing(rs.getString("EconoyServing"));;
						needBean.setXueke(rs.getString("xueke"));
						needBean.setYituoCompany(rs.getString("YituoCompany"));;
						needBean.setDanweiDaima(rs.getString("DanweiDaima"));;
						needBean.setBangongPhone(rs.getString("BangongPhone"));
						needBean.setYituorenName(rs.getString("YituorenName"));
						needBean.setYituoType(rs.getString("YituoType"));
						needBean.setGongjianCompany(rs.getString("GongjianCompany"));
						needBean.setTaizhangName(rs.getString("TaizhangName"));
						needBean.setTaizhangSex(rs.getString("TaizhangSex"));
						needBean.setTaizhangBrith(rs.getString("TaizhangBrith"));
						needBean.setTaizhangZhicheng(rs.getString("TaizhangZhicheng"));
						needBean.setTaizhangZhuanye(rs.getString("TaizhangZhuanye"));
						needBean.setTaizhangXueli(rs.getString("TaizhangXueli"));
						needBean.setTaizhangXuewei(rs.getString("TaizhangXuewei"));
						needBean.setTaizhangBangong(rs.getString("TaizhangBangong"));
						needBean.setTaizhangShouji(rs.getString("TaizhangShouji"));
						needBean.setTaizhangEmail(rs.getString("TaizhangEmail"));
						needBean.setPingtaiWebName(rs.getString("PingtaiWebName"));
						needBean.setPingtaiWebaddress(rs.getString("PingtaiWebaddress"));
						needBean.setPingtaiTongxunDizhi(rs.getString("PingtaiTongxunDizhi"));
						needBean.setMail(rs.getString("mail"));
						needBeans.add(needBean);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				finally{
					DBUtil.close(rs, state, conn);
				}
				return needBeans;
			}else if(n==21){//依托生物
				String sql = "select * from xuqiuvalue where xueke='生物'";
				Connection conn =DBUtil.getConnection();
				Statement state =null;
				ResultSet rs = null;
				Mes needBean =null;
				try{
					state=conn.createStatement();
					rs=state.executeQuery(sql);
					while(rs.next()){
						needBean = new Mes();
						needBean.setPlatname(rs.getString("platname"));
						needBean.setPingtaiLevel(rs.getString("PingtaiLevel"));
						needBean.setLocation(rs.getString("location"));
						needBean.setPingtaiShape(rs.getString("PingtaiShape"));
						needBean.setBTHconstruction(rs.getString("BTHconstruction"));
						needBean.setEconoyServing(rs.getString("EconoyServing"));;
						needBean.setXueke(rs.getString("xueke"));
						needBean.setYituoCompany(rs.getString("YituoCompany"));;
						needBean.setDanweiDaima(rs.getString("DanweiDaima"));;
						needBean.setBangongPhone(rs.getString("BangongPhone"));
						needBean.setYituorenName(rs.getString("YituorenName"));
						needBean.setYituoType(rs.getString("YituoType"));
						needBean.setGongjianCompany(rs.getString("GongjianCompany"));
						needBean.setTaizhangName(rs.getString("TaizhangName"));
						needBean.setTaizhangSex(rs.getString("TaizhangSex"));
						needBean.setTaizhangBrith(rs.getString("TaizhangBrith"));
						needBean.setTaizhangZhicheng(rs.getString("TaizhangZhicheng"));
						needBean.setTaizhangZhuanye(rs.getString("TaizhangZhuanye"));
						needBean.setTaizhangXueli(rs.getString("TaizhangXueli"));
						needBean.setTaizhangXuewei(rs.getString("TaizhangXuewei"));
						needBean.setTaizhangBangong(rs.getString("TaizhangBangong"));
						needBean.setTaizhangShouji(rs.getString("TaizhangShouji"));
						needBean.setTaizhangEmail(rs.getString("TaizhangEmail"));
						needBean.setPingtaiWebName(rs.getString("PingtaiWebName"));
						needBean.setPingtaiWebaddress(rs.getString("PingtaiWebaddress"));
						needBean.setPingtaiTongxunDizhi(rs.getString("PingtaiTongxunDizhi"));
						needBean.setMail(rs.getString("mail"));
						needBeans.add(needBean);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				finally{
					DBUtil.close(rs, state, conn);
				}
				return needBeans;
			}else if(n==22){//依托其他
				String sql = "select * from xuqiuvalue where xueke='其他'";
				Connection conn =DBUtil.getConnection();
				Statement state =null;
				ResultSet rs = null;
				Mes needBean =null;
				try{
					state=conn.createStatement();
					rs=state.executeQuery(sql);
					while(rs.next()){
						needBean = new Mes();
						needBean.setPlatname(rs.getString("platname"));
						needBean.setPingtaiLevel(rs.getString("PingtaiLevel"));
						needBean.setLocation(rs.getString("location"));
						needBean.setPingtaiShape(rs.getString("PingtaiShape"));
						needBean.setBTHconstruction(rs.getString("BTHconstruction"));
						needBean.setEconoyServing(rs.getString("EconoyServing"));;
						needBean.setXueke(rs.getString("xueke"));
						needBean.setYituoCompany(rs.getString("YituoCompany"));;
						needBean.setDanweiDaima(rs.getString("DanweiDaima"));;
						needBean.setBangongPhone(rs.getString("BangongPhone"));
						needBean.setYituorenName(rs.getString("YituorenName"));
						needBean.setYituoType(rs.getString("YituoType"));
						needBean.setGongjianCompany(rs.getString("GongjianCompany"));
						needBean.setTaizhangName(rs.getString("TaizhangName"));
						needBean.setTaizhangSex(rs.getString("TaizhangSex"));
						needBean.setTaizhangBrith(rs.getString("TaizhangBrith"));
						needBean.setTaizhangZhicheng(rs.getString("TaizhangZhicheng"));
						needBean.setTaizhangZhuanye(rs.getString("TaizhangZhuanye"));
						needBean.setTaizhangXueli(rs.getString("TaizhangXueli"));
						needBean.setTaizhangXuewei(rs.getString("TaizhangXuewei"));
						needBean.setTaizhangBangong(rs.getString("TaizhangBangong"));
						needBean.setTaizhangShouji(rs.getString("TaizhangShouji"));
						needBean.setTaizhangEmail(rs.getString("TaizhangEmail"));
						needBean.setPingtaiWebName(rs.getString("PingtaiWebName"));
						needBean.setPingtaiWebaddress(rs.getString("PingtaiWebaddress"));
						needBean.setPingtaiTongxunDizhi(rs.getString("PingtaiTongxunDizhi"));
						needBean.setMail(rs.getString("mail"));
						needBeans.add(needBean);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				finally{
					DBUtil.close(rs, state, conn);
				}
				return needBeans;
			}else if(n==23){//金融
				String sql = "select * from xuqiuvalue where xueke='金融'";
				Connection conn =DBUtil.getConnection();
				Statement state =null;
				ResultSet rs = null;
				Mes needBean =null;
				try{
					state=conn.createStatement();
					rs=state.executeQuery(sql);
					while(rs.next()){
						needBean = new Mes();
						needBean.setPlatname(rs.getString("platname"));
						needBean.setPingtaiLevel(rs.getString("PingtaiLevel"));
						needBean.setLocation(rs.getString("location"));
						needBean.setPingtaiShape(rs.getString("PingtaiShape"));
						needBean.setBTHconstruction(rs.getString("BTHconstruction"));
						needBean.setEconoyServing(rs.getString("EconoyServing"));;
						needBean.setXueke(rs.getString("xueke"));
						needBean.setYituoCompany(rs.getString("YituoCompany"));;
						needBean.setDanweiDaima(rs.getString("DanweiDaima"));;
						needBean.setBangongPhone(rs.getString("BangongPhone"));
						needBean.setYituorenName(rs.getString("YituorenName"));
						needBean.setYituoType(rs.getString("YituoType"));
						needBean.setGongjianCompany(rs.getString("GongjianCompany"));
						needBean.setTaizhangName(rs.getString("TaizhangName"));
						needBean.setTaizhangSex(rs.getString("TaizhangSex"));
						needBean.setTaizhangBrith(rs.getString("TaizhangBrith"));
						needBean.setTaizhangZhicheng(rs.getString("TaizhangZhicheng"));
						needBean.setTaizhangZhuanye(rs.getString("TaizhangZhuanye"));
						needBean.setTaizhangXueli(rs.getString("TaizhangXueli"));
						needBean.setTaizhangXuewei(rs.getString("TaizhangXuewei"));
						needBean.setTaizhangBangong(rs.getString("TaizhangBangong"));
						needBean.setTaizhangShouji(rs.getString("TaizhangShouji"));
						needBean.setTaizhangEmail(rs.getString("TaizhangEmail"));
						needBean.setPingtaiWebName(rs.getString("PingtaiWebName"));
						needBean.setPingtaiWebaddress(rs.getString("PingtaiWebaddress"));
						needBean.setPingtaiTongxunDizhi(rs.getString("PingtaiTongxunDizhi"));
						needBean.setMail(rs.getString("mail"));
						needBeans.add(needBean);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				finally{
					DBUtil.close(rs, state, conn);
				}
				return needBeans;
			}else if(n==24){//文史
				String sql = "select * from xuqiuvalue where xueke='文史'";
				Connection conn =DBUtil.getConnection();
				Statement state =null;
				ResultSet rs = null;
				Mes needBean =null;
				try{
					state=conn.createStatement();
					rs=state.executeQuery(sql);
					while(rs.next()){
						needBean = new Mes();
						needBean.setPlatname(rs.getString("platname"));
						needBean.setPingtaiLevel(rs.getString("PingtaiLevel"));
						needBean.setLocation(rs.getString("location"));
						needBean.setPingtaiShape(rs.getString("PingtaiShape"));
						needBean.setBTHconstruction(rs.getString("BTHconstruction"));
						needBean.setEconoyServing(rs.getString("EconoyServing"));;
						needBean.setXueke(rs.getString("xueke"));
						needBean.setYituoCompany(rs.getString("YituoCompany"));;
						needBean.setDanweiDaima(rs.getString("DanweiDaima"));;
						needBean.setBangongPhone(rs.getString("BangongPhone"));
						needBean.setYituorenName(rs.getString("YituorenName"));
						needBean.setYituoType(rs.getString("YituoType"));
						needBean.setGongjianCompany(rs.getString("GongjianCompany"));
						needBean.setTaizhangName(rs.getString("TaizhangName"));
						needBean.setTaizhangSex(rs.getString("TaizhangSex"));
						needBean.setTaizhangBrith(rs.getString("TaizhangBrith"));
						needBean.setTaizhangZhicheng(rs.getString("TaizhangZhicheng"));
						needBean.setTaizhangZhuanye(rs.getString("TaizhangZhuanye"));
						needBean.setTaizhangXueli(rs.getString("TaizhangXueli"));
						needBean.setTaizhangXuewei(rs.getString("TaizhangXuewei"));
						needBean.setTaizhangBangong(rs.getString("TaizhangBangong"));
						needBean.setTaizhangShouji(rs.getString("TaizhangShouji"));
						needBean.setTaizhangEmail(rs.getString("TaizhangEmail"));
						needBean.setPingtaiWebName(rs.getString("PingtaiWebName"));
						needBean.setPingtaiWebaddress(rs.getString("PingtaiWebaddress"));
						needBean.setPingtaiTongxunDizhi(rs.getString("PingtaiTongxunDizhi"));
						needBean.setMail(rs.getString("mail"));
						needBeans.add(needBean);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				finally{
					DBUtil.close(rs, state, conn);
				}
				return needBeans;
			}else if(n==33){//教育
				String sql = "select * from xuqiuvalue where EconoyServing='教育'";
				Connection conn =DBUtil.getConnection();
				Statement state =null;
				ResultSet rs = null;
				Mes needBean =null;
				try{
					state=conn.createStatement();
					rs=state.executeQuery(sql);
					while(rs.next()){
						needBean = new Mes();
						needBean.setPlatname(rs.getString("platname"));
						needBean.setPingtaiLevel(rs.getString("PingtaiLevel"));
						needBean.setLocation(rs.getString("location"));
						needBean.setPingtaiShape(rs.getString("PingtaiShape"));
						needBean.setBTHconstruction(rs.getString("BTHconstruction"));
						needBean.setEconoyServing(rs.getString("EconoyServing"));;
						needBean.setXueke(rs.getString("xueke"));
						needBean.setYituoCompany(rs.getString("YituoCompany"));;
						needBean.setDanweiDaima(rs.getString("DanweiDaima"));;
						needBean.setBangongPhone(rs.getString("BangongPhone"));
						needBean.setYituorenName(rs.getString("YituorenName"));
						needBean.setYituoType(rs.getString("YituoType"));
						needBean.setGongjianCompany(rs.getString("GongjianCompany"));
						needBean.setTaizhangName(rs.getString("TaizhangName"));
						needBean.setTaizhangSex(rs.getString("TaizhangSex"));
						needBean.setTaizhangBrith(rs.getString("TaizhangBrith"));
						needBean.setTaizhangZhicheng(rs.getString("TaizhangZhicheng"));
						needBean.setTaizhangZhuanye(rs.getString("TaizhangZhuanye"));
						needBean.setTaizhangXueli(rs.getString("TaizhangXueli"));
						needBean.setTaizhangXuewei(rs.getString("TaizhangXuewei"));
						needBean.setTaizhangBangong(rs.getString("TaizhangBangong"));
						needBean.setTaizhangShouji(rs.getString("TaizhangShouji"));
						needBean.setTaizhangEmail(rs.getString("TaizhangEmail"));
						needBean.setPingtaiWebName(rs.getString("PingtaiWebName"));
						needBean.setPingtaiWebaddress(rs.getString("PingtaiWebaddress"));
						needBean.setPingtaiTongxunDizhi(rs.getString("PingtaiTongxunDizhi"));
						needBean.setMail(rs.getString("mail"));
						needBeans.add(needBean);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				finally{
					DBUtil.close(rs, state, conn);
				}
				return needBeans;
			}else if(n==25){//服务经济行业
				String sql = "select * from xuqiuvalue";
				Connection conn =DBUtil.getConnection();
				Statement state =null;
				ResultSet rs = null;
				Mes needBean =null;
				try{
					state=conn.createStatement();
					rs=state.executeQuery(sql);
					while(rs.next()){
						needBean = new Mes();
						needBean.setPlatname(rs.getString("platname"));
						needBean.setPingtaiLevel(rs.getString("PingtaiLevel"));
						needBean.setLocation(rs.getString("location"));
						needBean.setPingtaiShape(rs.getString("PingtaiShape"));
						needBean.setBTHconstruction(rs.getString("BTHconstruction"));
						needBean.setEconoyServing(rs.getString("EconoyServing"));;
						needBean.setXueke(rs.getString("xueke"));
						needBean.setYituoCompany(rs.getString("YituoCompany"));;
						needBean.setDanweiDaima(rs.getString("DanweiDaima"));;
						needBean.setBangongPhone(rs.getString("BangongPhone"));
						needBean.setYituorenName(rs.getString("YituorenName"));
						needBean.setYituoType(rs.getString("YituoType"));
						needBean.setGongjianCompany(rs.getString("GongjianCompany"));
						needBean.setTaizhangName(rs.getString("TaizhangName"));
						needBean.setTaizhangSex(rs.getString("TaizhangSex"));
						needBean.setTaizhangBrith(rs.getString("TaizhangBrith"));
						needBean.setTaizhangZhicheng(rs.getString("TaizhangZhicheng"));
						needBean.setTaizhangZhuanye(rs.getString("TaizhangZhuanye"));
						needBean.setTaizhangXueli(rs.getString("TaizhangXueli"));
						needBean.setTaizhangXuewei(rs.getString("TaizhangXuewei"));
						needBean.setTaizhangBangong(rs.getString("TaizhangBangong"));
						needBean.setTaizhangShouji(rs.getString("TaizhangShouji"));
						needBean.setTaizhangEmail(rs.getString("TaizhangEmail"));
						needBean.setPingtaiWebName(rs.getString("PingtaiWebName"));
						needBean.setPingtaiWebaddress(rs.getString("PingtaiWebaddress"));
						needBean.setPingtaiTongxunDizhi(rs.getString("PingtaiTongxunDizhi"));
						needBean.setMail(rs.getString("mail"));
						needBeans.add(needBean);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				finally{
					DBUtil.close(rs, state, conn);
				}
				return needBeans;
			}else if(n==26){//金融
				String sql = "select * from xuqiuvalue where EconoyServing='金融'";
				Connection conn =DBUtil.getConnection();
				Statement state =null;
				ResultSet rs = null;
				Mes needBean =null;
				try{
					state=conn.createStatement();
					rs=state.executeQuery(sql);
					while(rs.next()){
						needBean = new Mes();
						needBean.setPlatname(rs.getString("platname"));
						needBean.setPingtaiLevel(rs.getString("PingtaiLevel"));
						needBean.setLocation(rs.getString("location"));
						needBean.setPingtaiShape(rs.getString("PingtaiShape"));
						needBean.setBTHconstruction(rs.getString("BTHconstruction"));
						needBean.setEconoyServing(rs.getString("EconoyServing"));;
						needBean.setXueke(rs.getString("xueke"));
						needBean.setYituoCompany(rs.getString("YituoCompany"));;
						needBean.setDanweiDaima(rs.getString("DanweiDaima"));;
						needBean.setBangongPhone(rs.getString("BangongPhone"));
						needBean.setYituorenName(rs.getString("YituorenName"));
						needBean.setYituoType(rs.getString("YituoType"));
						needBean.setGongjianCompany(rs.getString("GongjianCompany"));
						needBean.setTaizhangName(rs.getString("TaizhangName"));
						needBean.setTaizhangSex(rs.getString("TaizhangSex"));
						needBean.setTaizhangBrith(rs.getString("TaizhangBrith"));
						needBean.setTaizhangZhicheng(rs.getString("TaizhangZhicheng"));
						needBean.setTaizhangZhuanye(rs.getString("TaizhangZhuanye"));
						needBean.setTaizhangXueli(rs.getString("TaizhangXueli"));
						needBean.setTaizhangXuewei(rs.getString("TaizhangXuewei"));
						needBean.setTaizhangBangong(rs.getString("TaizhangBangong"));
						needBean.setTaizhangShouji(rs.getString("TaizhangShouji"));
						needBean.setTaizhangEmail(rs.getString("TaizhangEmail"));
						needBean.setPingtaiWebName(rs.getString("PingtaiWebName"));
						needBean.setPingtaiWebaddress(rs.getString("PingtaiWebaddress"));
						needBean.setPingtaiTongxunDizhi(rs.getString("PingtaiTongxunDizhi"));
						needBean.setMail(rs.getString("mail"));
						needBeans.add(needBean);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				finally{
					DBUtil.close(rs, state, conn);
				}
				return needBeans;
			}else if(n==27){//房地产
				String sql = "select * from xuqiuvalue where EconoyServing='房地产'";
				Connection conn =DBUtil.getConnection();
				Statement state =null;
				ResultSet rs = null;
				Mes needBean =null;
				try{
					state=conn.createStatement();
					rs=state.executeQuery(sql);
					while(rs.next()){
						needBean = new Mes();
						needBean.setPlatname(rs.getString("platname"));
						needBean.setPingtaiLevel(rs.getString("PingtaiLevel"));
						needBean.setLocation(rs.getString("location"));
						needBean.setPingtaiShape(rs.getString("PingtaiShape"));
						needBean.setBTHconstruction(rs.getString("BTHconstruction"));
						needBean.setEconoyServing(rs.getString("EconoyServing"));;
						needBean.setXueke(rs.getString("xueke"));
						needBean.setYituoCompany(rs.getString("YituoCompany"));;
						needBean.setDanweiDaima(rs.getString("DanweiDaima"));;
						needBean.setBangongPhone(rs.getString("BangongPhone"));
						needBean.setYituorenName(rs.getString("YituorenName"));
						needBean.setYituoType(rs.getString("YituoType"));
						needBean.setGongjianCompany(rs.getString("GongjianCompany"));
						needBean.setTaizhangName(rs.getString("TaizhangName"));
						needBean.setTaizhangSex(rs.getString("TaizhangSex"));
						needBean.setTaizhangBrith(rs.getString("TaizhangBrith"));
						needBean.setTaizhangZhicheng(rs.getString("TaizhangZhicheng"));
						needBean.setTaizhangZhuanye(rs.getString("TaizhangZhuanye"));
						needBean.setTaizhangXueli(rs.getString("TaizhangXueli"));
						needBean.setTaizhangXuewei(rs.getString("TaizhangXuewei"));
						needBean.setTaizhangBangong(rs.getString("TaizhangBangong"));
						needBean.setTaizhangShouji(rs.getString("TaizhangShouji"));
						needBean.setTaizhangEmail(rs.getString("TaizhangEmail"));
						needBean.setPingtaiWebName(rs.getString("PingtaiWebName"));
						needBean.setPingtaiWebaddress(rs.getString("PingtaiWebaddress"));
						needBean.setPingtaiTongxunDizhi(rs.getString("PingtaiTongxunDizhi"));
						needBean.setMail(rs.getString("mail"));
						needBeans.add(needBean);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				finally{
					DBUtil.close(rs, state, conn);
				}
				return needBeans;
			}else if(n==28){//餐饮住宿
				String sql = "select * from xuqiuvalue where EconoyServing='餐饮住宿'";
				Connection conn =DBUtil.getConnection();
				Statement state =null;
				ResultSet rs = null;
				Mes needBean =null;
				try{
					state=conn.createStatement();
					rs=state.executeQuery(sql);
					while(rs.next()){
						needBean = new Mes();
						needBean.setPlatname(rs.getString("platname"));
						needBean.setPingtaiLevel(rs.getString("PingtaiLevel"));
						needBean.setLocation(rs.getString("location"));
						needBean.setPingtaiShape(rs.getString("PingtaiShape"));
						needBean.setBTHconstruction(rs.getString("BTHconstruction"));
						needBean.setEconoyServing(rs.getString("EconoyServing"));;
						needBean.setXueke(rs.getString("xueke"));
						needBean.setYituoCompany(rs.getString("YituoCompany"));;
						needBean.setDanweiDaima(rs.getString("DanweiDaima"));;
						needBean.setBangongPhone(rs.getString("BangongPhone"));
						needBean.setYituorenName(rs.getString("YituorenName"));
						needBean.setYituoType(rs.getString("YituoType"));
						needBean.setGongjianCompany(rs.getString("GongjianCompany"));
						needBean.setTaizhangName(rs.getString("TaizhangName"));
						needBean.setTaizhangSex(rs.getString("TaizhangSex"));
						needBean.setTaizhangBrith(rs.getString("TaizhangBrith"));
						needBean.setTaizhangZhicheng(rs.getString("TaizhangZhicheng"));
						needBean.setTaizhangZhuanye(rs.getString("TaizhangZhuanye"));
						needBean.setTaizhangXueli(rs.getString("TaizhangXueli"));
						needBean.setTaizhangXuewei(rs.getString("TaizhangXuewei"));
						needBean.setTaizhangBangong(rs.getString("TaizhangBangong"));
						needBean.setTaizhangShouji(rs.getString("TaizhangShouji"));
						needBean.setTaizhangEmail(rs.getString("TaizhangEmail"));
						needBean.setPingtaiWebName(rs.getString("PingtaiWebName"));
						needBean.setPingtaiWebaddress(rs.getString("PingtaiWebaddress"));
						needBean.setPingtaiTongxunDizhi(rs.getString("PingtaiTongxunDizhi"));
						needBean.setMail(rs.getString("mail"));
						needBeans.add(needBean);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				finally{
					DBUtil.close(rs, state, conn);
				}
				return needBeans;
			}else if(n==29){//医疗
				String sql = "select * from xuqiuvalue where EconoyServing='医疗'";
				Connection conn =DBUtil.getConnection();
				Statement state =null;
				ResultSet rs = null;
				Mes needBean =null;
				try{
					state=conn.createStatement();
					rs=state.executeQuery(sql);
					while(rs.next()){
						needBean = new Mes();
						needBean.setPlatname(rs.getString("platname"));
						needBean.setPingtaiLevel(rs.getString("PingtaiLevel"));
						needBean.setLocation(rs.getString("location"));
						needBean.setPingtaiShape(rs.getString("PingtaiShape"));
						needBean.setBTHconstruction(rs.getString("BTHconstruction"));
						needBean.setEconoyServing(rs.getString("EconoyServing"));;
						needBean.setXueke(rs.getString("xueke"));
						needBean.setYituoCompany(rs.getString("YituoCompany"));;
						needBean.setDanweiDaima(rs.getString("DanweiDaima"));;
						needBean.setBangongPhone(rs.getString("BangongPhone"));
						needBean.setYituorenName(rs.getString("YituorenName"));
						needBean.setYituoType(rs.getString("YituoType"));
						needBean.setGongjianCompany(rs.getString("GongjianCompany"));
						needBean.setTaizhangName(rs.getString("TaizhangName"));
						needBean.setTaizhangSex(rs.getString("TaizhangSex"));
						needBean.setTaizhangBrith(rs.getString("TaizhangBrith"));
						needBean.setTaizhangZhicheng(rs.getString("TaizhangZhicheng"));
						needBean.setTaizhangZhuanye(rs.getString("TaizhangZhuanye"));
						needBean.setTaizhangXueli(rs.getString("TaizhangXueli"));
						needBean.setTaizhangXuewei(rs.getString("TaizhangXuewei"));
						needBean.setTaizhangBangong(rs.getString("TaizhangBangong"));
						needBean.setTaizhangShouji(rs.getString("TaizhangShouji"));
						needBean.setTaizhangEmail(rs.getString("TaizhangEmail"));
						needBean.setPingtaiWebName(rs.getString("PingtaiWebName"));
						needBean.setPingtaiWebaddress(rs.getString("PingtaiWebaddress"));
						needBean.setPingtaiTongxunDizhi(rs.getString("PingtaiTongxunDizhi"));
						needBean.setMail(rs.getString("mail"));
						needBeans.add(needBean);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				finally{
					DBUtil.close(rs, state, conn);
				}
				return needBeans;
			}else if(n==30){//科学技术
				String sql = "select * from xuqiuvalue where EconoyServing='科学技术'";
				Connection conn =DBUtil.getConnection();
				Statement state =null;
				ResultSet rs = null;
				Mes needBean =null;
				try{
					state=conn.createStatement();
					rs=state.executeQuery(sql);
					while(rs.next()){
						needBean = new Mes();
						needBean.setPlatname(rs.getString("platname"));
						needBean.setPingtaiLevel(rs.getString("PingtaiLevel"));
						needBean.setLocation(rs.getString("location"));
						needBean.setPingtaiShape(rs.getString("PingtaiShape"));
						needBean.setBTHconstruction(rs.getString("BTHconstruction"));
						needBean.setEconoyServing(rs.getString("EconoyServing"));;
						needBean.setXueke(rs.getString("xueke"));
						needBean.setYituoCompany(rs.getString("YituoCompany"));;
						needBean.setDanweiDaima(rs.getString("DanweiDaima"));;
						needBean.setBangongPhone(rs.getString("BangongPhone"));
						needBean.setYituorenName(rs.getString("YituorenName"));
						needBean.setYituoType(rs.getString("YituoType"));
						needBean.setGongjianCompany(rs.getString("GongjianCompany"));
						needBean.setTaizhangName(rs.getString("TaizhangName"));
						needBean.setTaizhangSex(rs.getString("TaizhangSex"));
						needBean.setTaizhangBrith(rs.getString("TaizhangBrith"));
						needBean.setTaizhangZhicheng(rs.getString("TaizhangZhicheng"));
						needBean.setTaizhangZhuanye(rs.getString("TaizhangZhuanye"));
						needBean.setTaizhangXueli(rs.getString("TaizhangXueli"));
						needBean.setTaizhangXuewei(rs.getString("TaizhangXuewei"));
						needBean.setTaizhangBangong(rs.getString("TaizhangBangong"));
						needBean.setTaizhangShouji(rs.getString("TaizhangShouji"));
						needBean.setTaizhangEmail(rs.getString("TaizhangEmail"));
						needBean.setPingtaiWebName(rs.getString("PingtaiWebName"));
						needBean.setPingtaiWebaddress(rs.getString("PingtaiWebaddress"));
						needBean.setPingtaiTongxunDizhi(rs.getString("PingtaiTongxunDizhi"));
						needBean.setMail(rs.getString("mail"));
						needBeans.add(needBean);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				finally{
					DBUtil.close(rs, state, conn);
				}
				return needBeans;
			}else if(n==31){//环境经济
				String sql = "select * from xuqiuvalue where EconoyServing='环境经济'";
				Connection conn =DBUtil.getConnection();
				Statement state =null;
				ResultSet rs = null;
				Mes needBean =null;
				try{
					state=conn.createStatement();
					rs=state.executeQuery(sql);
					while(rs.next()){
						needBean = new Mes();
						needBean.setPlatname(rs.getString("platname"));
						needBean.setPingtaiLevel(rs.getString("PingtaiLevel"));
						needBean.setLocation(rs.getString("location"));
						needBean.setPingtaiShape(rs.getString("PingtaiShape"));
						needBean.setBTHconstruction(rs.getString("BTHconstruction"));
						needBean.setEconoyServing(rs.getString("EconoyServing"));;
						needBean.setXueke(rs.getString("xueke"));
						needBean.setYituoCompany(rs.getString("YituoCompany"));;
						needBean.setDanweiDaima(rs.getString("DanweiDaima"));;
						needBean.setBangongPhone(rs.getString("BangongPhone"));
						needBean.setYituorenName(rs.getString("YituorenName"));
						needBean.setYituoType(rs.getString("YituoType"));
						needBean.setGongjianCompany(rs.getString("GongjianCompany"));
						needBean.setTaizhangName(rs.getString("TaizhangName"));
						needBean.setTaizhangSex(rs.getString("TaizhangSex"));
						needBean.setTaizhangBrith(rs.getString("TaizhangBrith"));
						needBean.setTaizhangZhicheng(rs.getString("TaizhangZhicheng"));
						needBean.setTaizhangZhuanye(rs.getString("TaizhangZhuanye"));
						needBean.setTaizhangXueli(rs.getString("TaizhangXueli"));
						needBean.setTaizhangXuewei(rs.getString("TaizhangXuewei"));
						needBean.setTaizhangBangong(rs.getString("TaizhangBangong"));
						needBean.setTaizhangShouji(rs.getString("TaizhangShouji"));
						needBean.setTaizhangEmail(rs.getString("TaizhangEmail"));
						needBean.setPingtaiWebName(rs.getString("PingtaiWebName"));
						needBean.setPingtaiWebaddress(rs.getString("PingtaiWebaddress"));
						needBean.setPingtaiTongxunDizhi(rs.getString("PingtaiTongxunDizhi"));
						needBean.setMail(rs.getString("mail"));
						needBeans.add(needBean);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				finally{
					DBUtil.close(rs, state, conn);
				}
				return needBeans;
			}else if(n==32){//文史
				String sql = "select * from xuqiuvalue where xueke='其他'";
				Connection conn =DBUtil.getConnection();
				Statement state =null;
				ResultSet rs = null;
				Mes needBean =null;
				try{
					state=conn.createStatement();
					rs=state.executeQuery(sql);
					while(rs.next()){
						needBean = new Mes();
						needBean.setPlatname(rs.getString("platname"));
						needBean.setPingtaiLevel(rs.getString("PingtaiLevel"));
						needBean.setLocation(rs.getString("location"));
						needBean.setPingtaiShape(rs.getString("PingtaiShape"));
						needBean.setBTHconstruction(rs.getString("BTHconstruction"));
						needBean.setEconoyServing(rs.getString("EconoyServing"));;
						needBean.setXueke(rs.getString("xueke"));
						needBean.setYituoCompany(rs.getString("YituoCompany"));;
						needBean.setDanweiDaima(rs.getString("DanweiDaima"));;
						needBean.setBangongPhone(rs.getString("BangongPhone"));
						needBean.setYituorenName(rs.getString("YituorenName"));
						needBean.setYituoType(rs.getString("YituoType"));
						needBean.setGongjianCompany(rs.getString("GongjianCompany"));
						needBean.setTaizhangName(rs.getString("TaizhangName"));
						needBean.setTaizhangSex(rs.getString("TaizhangSex"));
						needBean.setTaizhangBrith(rs.getString("TaizhangBrith"));
						needBean.setTaizhangZhicheng(rs.getString("TaizhangZhicheng"));
						needBean.setTaizhangZhuanye(rs.getString("TaizhangZhuanye"));
						needBean.setTaizhangXueli(rs.getString("TaizhangXueli"));
						needBean.setTaizhangXuewei(rs.getString("TaizhangXuewei"));
						needBean.setTaizhangBangong(rs.getString("TaizhangBangong"));
						needBean.setTaizhangShouji(rs.getString("TaizhangShouji"));
						needBean.setTaizhangEmail(rs.getString("TaizhangEmail"));
						needBean.setPingtaiWebName(rs.getString("PingtaiWebName"));
						needBean.setPingtaiWebaddress(rs.getString("PingtaiWebaddress"));
						needBean.setPingtaiTongxunDizhi(rs.getString("PingtaiTongxunDizhi"));
						needBean.setMail(rs.getString("mail"));
						needBeans.add(needBean);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				finally{
					DBUtil.close(rs, state, conn);
				}
				return needBeans;
			}else if(n==24){//文史
				String sql = "select * from xuqiuvalue where xueke='文史'";
				Connection conn =DBUtil.getConnection();
				Statement state =null;
				ResultSet rs = null;
				Mes needBean =null;
				try{
					state=conn.createStatement();
					rs=state.executeQuery(sql);
					while(rs.next()){
						needBean = new Mes();
						needBean.setPlatname(rs.getString("platname"));
						needBean.setPingtaiLevel(rs.getString("PingtaiLevel"));
						needBean.setLocation(rs.getString("location"));
						needBean.setPingtaiShape(rs.getString("PingtaiShape"));
						needBean.setBTHconstruction(rs.getString("BTHconstruction"));
						needBean.setEconoyServing(rs.getString("EconoyServing"));;
						needBean.setXueke(rs.getString("xueke"));
						needBean.setYituoCompany(rs.getString("YituoCompany"));;
						needBean.setDanweiDaima(rs.getString("DanweiDaima"));;
						needBean.setBangongPhone(rs.getString("BangongPhone"));
						needBean.setYituorenName(rs.getString("YituorenName"));
						needBean.setYituoType(rs.getString("YituoType"));
						needBean.setGongjianCompany(rs.getString("GongjianCompany"));
						needBean.setTaizhangName(rs.getString("TaizhangName"));
						needBean.setTaizhangSex(rs.getString("TaizhangSex"));
						needBean.setTaizhangBrith(rs.getString("TaizhangBrith"));
						needBean.setTaizhangZhicheng(rs.getString("TaizhangZhicheng"));
						needBean.setTaizhangZhuanye(rs.getString("TaizhangZhuanye"));
						needBean.setTaizhangXueli(rs.getString("TaizhangXueli"));
						needBean.setTaizhangXuewei(rs.getString("TaizhangXuewei"));
						needBean.setTaizhangBangong(rs.getString("TaizhangBangong"));
						needBean.setTaizhangShouji(rs.getString("TaizhangShouji"));
						needBean.setTaizhangEmail(rs.getString("TaizhangEmail"));
						needBean.setPingtaiWebName(rs.getString("PingtaiWebName"));
						needBean.setPingtaiWebaddress(rs.getString("PingtaiWebaddress"));
						needBean.setPingtaiTongxunDizhi(rs.getString("PingtaiTongxunDizhi"));
						needBean.setMail(rs.getString("mail"));
						needBeans.add(needBean);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				finally{
					DBUtil.close(rs, state, conn);
				}
				return needBeans;
			}
				else{
					return null;
				}
			}
	
}

