package cn.wxyx.common;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import cn.molos.tool.ToolFactory;
import cn.molos.tool.validators.INPValidator;

/**
 * Http请求工具对象
 * 
 * @author molos 2015年4月22日下午12:33:47
 */
public class HttpHelper {

	private INPValidator npv = ToolFactory.getNPV();

	private static HttpHelper instance;

	private HttpHelper() {
	}

	public static HttpHelper getHelper() {
		if (instance == null) {
			instance = new HttpHelper();
		}
		return instance;
	}

	/**
	 * 发起HTTP请求的方法
	 * 
	 * @param url
	 *            请求的地址
	 * @param method
	 *            请求方式，GET,POST
	 * @param time
	 *            请求超时时间，单位：毫秒
	 * @param content
	 *            额外请求的内容
	 * @param prop
	 *            请求的mime类型设置,key为类型名称，value为类型值
	 * @return 响应的结果字符串形式，如果无内容返回，则返回为null
	 * @throws IOException
	 */
	public String httpReq(String url, String method, int time, String content,
			Map<String, String> prop) throws IOException {
		HttpURLConnection conn = (HttpURLConnection) new URL(url)
				.openConnection();
		conn.setReadTimeout(time);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		if (npv.isNull(method)) {
			method = "GET";
		}
		conn.setRequestMethod(method);
		conn.setUseCaches(false);
		if (!npv.isNull(prop)) {
			Set<String> keySet = prop.keySet();
			for (String s : keySet) {
				conn.setRequestProperty(s, prop.get(s));
			}
		}
		conn.connect();
		DataOutputStream dop = new DataOutputStream(conn.getOutputStream());
		dop.writeBytes(URLEncoder.encode(content, "UTF-8"));
		dop.flush();
		dop.close();
		String result = ToolFactory.getMsgTool().read(conn.getInputStream(),
				"UTF-8");
		conn.disconnect();
		return result;
	}

	/**
	 * HTTP POST请求
	 * 
	 * @param url
	 *            请求地址
	 * @param content
	 *            请求的内容
	 * @return
	 * @throws IOException
	 */
	public String httpReq(String url, String content) throws IOException {
		return httpReq(url, "POST", 30000, content,
				new HashMap<String, String>() {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					{
						put("charset", "UTF-8");
						put("Content-Type", "application/x-www-form-urlencoded");
					}
				});
	}

	/**
	 * HTTP POST请求
	 * 
	 * @param url
	 *            请求地址
	 * @param content
	 *            请求的内容,key=value
	 * @return
	 * @throws IOException
	 */
	public String httpReq(String url, Map<String, Object> content)
			throws IOException {
		StringBuffer sb = new StringBuffer();
		Set<String> keys = content.keySet();
		if (url.contains("?")) {
			for (String s : keys) {
				sb.append("&" + s + "=" + content.get(s));
			}
		} else {
			for (String s : keys) {
				sb.append("&" + s + "=" + content.get(s));
			}
		}

		return httpReq(url, sb.toString());
	}
}
