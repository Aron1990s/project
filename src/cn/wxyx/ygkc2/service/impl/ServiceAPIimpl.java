package cn.wxyx.ygkc2.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import cn.wxyx.ygkc2.service.IServiceAPI;

public class ServiceAPIimpl implements IServiceAPI {
	String strUrl;

	/**
	 * This method is for login
	 */
	@Override
	public String login(String strUrl, String name, String password) {
		return contService(strUrl, name, password);
	}
	
	@Override
	public String signIn(String strUrl, String mobileSign) {
		return conServiceSignIn(strUrl, mobileSign);
	}
	
	@Override
	public String checkEqu(String strUrl, String scanResult) {
		return conServiceCheckEqu(strUrl, scanResult);
	}
	
	@Override
	public String checkEquTwo(String strUrl, String scanResult) {
		return conServiceCheckEquTwo(strUrl, scanResult);
	}
	
	@Override
	public String sendClientInfo(String strUrl, String cName, String cNum,
			String repairC) {
		return conServiceSendClientInfo(strUrl, cName, cNum, repairC);
	}

	@Override
	public String contService(String strUrl, String name, String password) {
		String strResult = "";
		HttpPost httpRequest = new HttpPost(strUrl);
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("name", name));
		params.add(new BasicNameValuePair("pazzwd", password));
		HttpEntity httpentity = null;
		try {
			httpentity = new UrlEncodedFormEntity(params, "utf-8");
			httpRequest.setEntity(httpentity);
			HttpClient httpclient = new DefaultHttpClient();
			HttpResponse httpResponse = httpclient.execute(httpRequest);
			// InputStream in = httpResponse.getEntity().getContent();
			// InputStreamReader reader = new InputStreamReader(in,"utf-8");
			// BufferedReader br = new BufferedReader(reader);
			// String rs = null;
			// while ((rs = br.readLine()) != null) {
			// strResult += rs;
			// }
			// br.close();
			// reader.close();
			// in.close();
			strResult = EntityUtils.toString(httpResponse.getEntity());
		} catch (Exception e) {
			e.printStackTrace();
			strResult = "exception";
		}
		System.out.println(strResult);
		return strResult;
	}



	@Override
	public String conServiceSignIn(String strUrl, String mobileSign) {
		String strResult = "";
		HttpPost httpRequest = new HttpPost(strUrl);
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("json", mobileSign));
		HttpEntity httpentity = null;
		try {
			httpentity = new UrlEncodedFormEntity(params, "utf-8");
			httpRequest.setEntity(httpentity);
			HttpClient httpclient = new DefaultHttpClient();
			HttpResponse httpResponse = httpclient.execute(httpRequest);
			strResult = EntityUtils.toString(httpResponse.getEntity());
		} catch (Exception e) {
			e.printStackTrace();
			strResult = "exception";
		}
		System.out.println(strResult);
		return strResult;
	}



	@Override
	public String conServiceCheckEqu(String strUrl, String scanResult) {
		String strResult = "";
		HttpPost httpRequest = new HttpPost(strUrl);
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("scan", scanResult));
		HttpEntity httpentity = null;
		try {
			httpentity = new UrlEncodedFormEntity(params, "utf-8");
			httpRequest.setEntity(httpentity);
			HttpClient httpclient = new DefaultHttpClient();
			HttpResponse httpResponse = httpclient.execute(httpRequest);
			strResult = EntityUtils.toString(httpResponse.getEntity());
		} catch (Exception e) {
			e.printStackTrace();
			strResult = "exception";
		}
		System.out.println(strResult);
		return strResult;
	}



	@Override
	public String conServiceCheckEquTwo(String strUrl, String scanResult) {
		String strResult = "";
		HttpPost httpRequest = new HttpPost(strUrl);
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("scanTwo", scanResult));
		HttpEntity httpentity = null;
		try {
			httpentity = new UrlEncodedFormEntity(params, "utf-8");
			httpRequest.setEntity(httpentity);
			HttpClient httpclient = new DefaultHttpClient();
			HttpResponse httpResponse = httpclient.execute(httpRequest);
			strResult = EntityUtils.toString(httpResponse.getEntity());
		} catch (Exception e) {
			e.printStackTrace();
			strResult = "exception";
		}
		System.out.println(strResult);
		return strResult;
	}



	@Override
	public String conServiceSendClientInfo(String strUrl, String cName,
			String cNum, String repairC) {
		String strResult = "";
		HttpPost httpRequest = new HttpPost(strUrl);
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		String sendInfo=cName+"\n"+cNum+"\n"+repairC;
		
		params.add(new BasicNameValuePair("Send", sendInfo));
		HttpEntity httpentity = null;
		try {
			httpentity = new UrlEncodedFormEntity(params, "utf-8");
			httpRequest.setEntity(httpentity);
			HttpClient httpclient = new DefaultHttpClient();
			HttpResponse httpResponse = httpclient.execute(httpRequest);
			strResult = EntityUtils.toString(httpResponse.getEntity());
		} catch (Exception e) {
			e.printStackTrace();
			strResult = "exception";
		}
		System.out.println(strResult);
		return strResult;
	}

}
