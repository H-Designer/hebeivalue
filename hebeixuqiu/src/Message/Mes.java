package Message;
public class Mes {
	private String username;//用户名
	private String password1;//第一次密码
	private String password2;//第二次密码
	private String platname;//平台名称
	private String platnum;//平台编号
	private String pizhuntime;//批准年月
	private String pizhunwenhao;//批准文号
	private String jishulingyu ;//技术领域
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getPlatname() {
		return platname;
	}
	public void setPlatname(String platname) {
		this.platname = platname;
	}
	public String getPlatnum() {
		return platnum;
	}
	public void setPlatnum(String platnum) {
		this.platnum = platnum;
	}
	public String getPizhuntime() {
		return pizhuntime;
	}
	public void setPizhuntime(String pizhuntime) {
		this.pizhuntime = pizhuntime;
	}
	public String getPizhunwenhao() {
		return pizhunwenhao;
	}
	public void setPizhunwenhao(String pizhunwenhao) {
		this.pizhunwenhao = pizhunwenhao;
	}
	public String getJishulingyu() {
		return jishulingyu;
	}
	public void setJishulingyu(String jishulingyu) {
		this.jishulingyu = jishulingyu;
	}
//填报信息
	private String PingtaiLevel;//平台级别
	private String location;//所在市县；
	private String PingtaiShape;//平台组织形态；
	private String EconoyServing;//服务的经济行业；
	private String xueke;//所属学科；
	private String YituoCompany;//依托单位；
	private String DanweiDaima;//依托单位的组织机构代码
	private String YituorenName;//依托人的姓名；
	private String BangongPhone;//办公电话
	private String YituoType;//依托单位类型
	private String GongjianCompany;//共建单位
	private String TaizhangName;//台长姓名
	private String TaizhangSex;//台长性别
	private String TaizhangBrith;//台长出生年月
	private String TaizhangZhicheng;//台长职称
	private String TaizhangZhuanye;//台长专业
	private String TaizhangXueli;//台长学历
	private String TaizhangXuewei;//台长学位
	private String TaizhangBangong;//台长办公电话
	private String TaizhangShouji;//台长手机
	private String TaizhangEmail;//台长邮箱
	private String PingtaiWebName;//平台网站名称
	public String getPingtaiLevel() {
		return PingtaiLevel;
	}
	public void setPingtaiLevel(String pingtaiLevel) {
		PingtaiLevel = pingtaiLevel;
	}
	public String getPingtaiWebaddress() {
		return PingtaiWebaddress;
	}
	public void setPingtaiWebaddress(String pingtaiWebaddress) {
		PingtaiWebaddress = pingtaiWebaddress;
	}
	private String BTHconstruction;//京津共建
	public String getBTHconstruction() {
		return BTHconstruction;
	}
	public void setBTHconstruction(String bTHconstruction) {
		BTHconstruction = bTHconstruction;
	}
	private String PingtaiWebaddress;//平台网址
	private String PingtaiTongxunDizhi;//平台通讯地址
	private String mail;//邮编
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPingtaiShape() {
		return PingtaiShape;
	}
	public void setPingtaiShape(String pingtaiShape) {
		PingtaiShape = pingtaiShape;
	}
	public String getEconoyServing() {
		return EconoyServing;
	}
	public void setEconoyServing(String econoyServing) {
		EconoyServing = econoyServing;
	}
	public String getXueke() {
		return xueke;
	}
	public void setXueke(String xueke) {
		this.xueke = xueke;
	}
	public String getYituoCompany() {
		return YituoCompany;
	}
	public void setYituoCompany(String yituoCompany) {
		YituoCompany = yituoCompany;
	}
	public String getDanweiDaima() {
		return DanweiDaima;
	}
	public void setDanweiDaima(String danweiDaima) {
		DanweiDaima = danweiDaima;
	}
	public String getYituorenName() {
		return YituorenName;
	}
	public void setYituorenName(String yituorenName) {
		YituorenName = yituorenName;
	}
	public String getBangongPhone() {
		return BangongPhone;
	}
	public void setBangongPhone(String bangongPhone) {
		BangongPhone = bangongPhone;
	}
	public String getYituoType() {
		return YituoType;
	}
	public void setYituoType(String yituoType) {
		YituoType = yituoType;
	}
	public String getGongjianCompany() {
		return GongjianCompany;
	}
	public void setGongjianCompany(String gongjianCompany) {
		GongjianCompany = gongjianCompany;
	}
	public String getTaizhangName() {
		return TaizhangName;
	}
	public void setTaizhangName(String taizhangName) {
		TaizhangName = taizhangName;
	}
	public String getTaizhangSex() {
		return TaizhangSex;
	}
	public void setTaizhangSex(String taizhangSex) {
		TaizhangSex = taizhangSex;
	}
	public String getTaizhangBrith() {
		return TaizhangBrith;
	}
	public void setTaizhangBrith(String taizhangBrith) {
		TaizhangBrith = taizhangBrith;
	}
	public String getTaizhangZhicheng() {
		return TaizhangZhicheng;
	}
	public void setTaizhangZhicheng(String taizhangZhicheng) {
		TaizhangZhicheng = taizhangZhicheng;
	}
	public String getTaizhangZhuanye() {
		return TaizhangZhuanye;
	}
	public void setTaizhangZhuanye(String taizhangZhuanye) {
		TaizhangZhuanye = taizhangZhuanye;
	}
	public String getTaizhangXueli() {
		return TaizhangXueli;
	}
	public void setTaizhangXueli(String taizhangXueli) {
		TaizhangXueli = taizhangXueli;
	}
	public String getTaizhangXuewei() {
		return TaizhangXuewei;
	}
	public void setTaizhangXuewei(String taizhangXuewei) {
		TaizhangXuewei = taizhangXuewei;
	}
	public String getTaizhangBangong() {
		return TaizhangBangong;
	}
	public void setTaizhangBangong(String taizhangBangong) {
		TaizhangBangong = taizhangBangong;
	}
	public String getTaizhangShouji() {
		return TaizhangShouji;
	}
	public void setTaizhangShouji(String taizhangShouji) {
		TaizhangShouji = taizhangShouji;
	}
	public String getTaizhangEmail() {
		return TaizhangEmail;
	}
	public void setTaizhangEmail(String taizhangEmail) {
		TaizhangEmail = taizhangEmail;
	}
	public String getPingtaiWebName() {
		return PingtaiWebName;
	}
	public void setPingtaiWebName(String pingtaiWebName) {
		PingtaiWebName = pingtaiWebName;
	}
	public String getPingtaiTongxunDizhi() {
		return PingtaiTongxunDizhi;
	}
	public void setPingtaiTongxunDizhi(String pingtaiTongxunDizhi) {
		PingtaiTongxunDizhi = pingtaiTongxunDizhi;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
}
