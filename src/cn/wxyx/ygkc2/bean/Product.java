package cn.wxyx.ygkc2.bean;

import cn.wxyx.ygkc2.bean.base.BaseBean;

/**
 * 产品表
 *
 * @author 潘琦 侯杰
 *
 *         2015-3-26 14:29:22
 */
public class Product extends BaseBean {
	/**
	 * 产品名称 类似于计算机服务器
	 *
	 */
	private String name;
	/**
	 * 产品名称全拼写
	 *
	 */
	private String fullName;
	/**
	 * 产品名称拼音简写
	 *
	 */
	private String shortName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public Product() {

	}
}