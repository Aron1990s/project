package cn.wxyx.ygkc2.bean.base;

/**
 * 用于向服务器发送数据的封装类
 */
public class ConnMessage {
	private String message;// 向服务器发送的信息
	private String url;// 服务器发送的url
	private Object bean;

	public ConnMessage(String url) {
		this.message = "";
		this.url = url;
	}

	public ConnMessage() {
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Object getBean() {
		return bean;
	}

	public void setBean(Object bean) {
		this.bean = bean;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
