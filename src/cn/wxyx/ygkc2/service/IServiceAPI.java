package cn.wxyx.ygkc2.service;

public interface IServiceAPI {
	public String login(String strUrl, String name, String password);

	public String contService(String strUrl, String name, String password);
	
	public String signIn(String strUrl, String mobileSign);
	
	public String conServiceSignIn(String strUrl, String mobileSign);
	
	public String checkEqu(String strUrl, String scanResult);
	
	public String conServiceCheckEqu(String strUrl, String scanResult);
	
	public String checkEquTwo(String strUrl, String scanResult);
	
	public String conServiceCheckEquTwo(String strUrl, String scanResult);
	
	public String sendClientInfo(String strUrl, String cName, String cNum, String repairC);
	
	public String conServiceSendClientInfo(String strUrl, String cName, String cNum, String repairC);
	
	

}
