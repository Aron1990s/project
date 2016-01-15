package cn.wxyx.ygkc2.bean.base;



/**
 * 
 * 只包含ID注解的基础bean对象
 * 
 * @author YangH
 * 
 */
public abstract class BaseBean {
	/**
	 * 主键ID
	 */
	protected Integer id;

	public BaseBean() {
	}

	public BaseBean(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}