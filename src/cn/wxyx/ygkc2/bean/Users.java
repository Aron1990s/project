package cn.wxyx.ygkc2.bean;

import java.util.Date;

import cn.wxyx.ygkc2.bean.base.BaseBean;

/**
 * 用户表
 * 
 * @author 薛强
 * 
 *         2015-3-26 14:29:22
 */
public class Users extends BaseBean {
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 用户名
	 */
	private String name;
	/**
	 * 密码
	 */
	private String passwd;
	/**
	 * 真实名字
	 */
	private String realName;
	/**
	 * 对应的角色id（外键）
	 */
	private Integer roleId;
	/**
	 * 部门名
	 */
	private String deptName;
	/**
	 * 职位id
	 */
	private Integer postId;
	/**
	 * 对应的分店id（外键）
	 */
	private Integer shopId;
	/**
	 * 座右铭，格言
	 */
	private String motto;
	/**
	 * 照片
	 */
	private String photo;
	/**
	 * 推荐人
	 */
	private String recommend;
	/**
	 * 特长
	 */
	private String specialty;
	/**
	 * 0：离职，1:在职
	 */
	private Integer status;
	/**
	 * 用户级别
	 */
	private String userLevel;
	/**
	 * 是否删除
	 */
	private Integer isDel;
	/**
	 * 部门ID（外键）
	 */
	private Integer deptId;
	/**
	 * 拼音
	 */
	private String chinese;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * QQ号
	 */
	private String qqNum;
	/**
	 * 性别
	 */
	private Integer sex;

	public Date getCreateTime() {
		return createTime;
	}

	public String getName() {
		return name;
	}

	public String getPasswd() {
		return passwd;
	}

	public String getRealName() {
		return realName;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public String getDeptName() {
		return deptName;
	}

	public Integer getPostId() {
		return postId;
	}

	public Integer getShopId() {
		return shopId;
	}

	public String getMotto() {
		return motto;
	}

	public String getPhoto() {
		return photo;
	}

	public String getRecommend() {
		return recommend;
	}

	public String getSpecialty() {
		return specialty;
	}

	public Integer getStatus() {
		return status;
	}

	public String getUserLevel() {
		return userLevel;
	}

	public Integer getIsDel() {
		return isDel;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public String getChinese() {
		return chinese;
	}

	public String getPhone() {
		return phone;
	}

	public String getQqNum() {
		return qqNum;
	}

	public Integer getSex() {
		return sex;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public void setMotto(String motto) {
		this.motto = motto;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public void setChinese(String chinese) {
		this.chinese = chinese;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setQqNum(String qqNum) {
		this.qqNum = qqNum;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Users() {
	}
}