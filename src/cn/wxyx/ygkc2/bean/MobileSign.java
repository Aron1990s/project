package cn.wxyx.ygkc2.bean;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

import cn.wxyx.ygkc2.bean.base.BaseBean;

/**
 * 打卡签到表
 * 
 * @author 夏晨俊
 * 
 *         2015-3-26 14:15:20
 */
public class MobileSign extends BaseBean {

	@SerializedName("userId")
	/**
	 * 打卡用户
	 */
	private Integer userId;
	/**
	 * 打卡时间
	 */
	private Date signTime;
	/**
	 * 打卡地点纬度
	 */
	private Double latitude;
	/**
	 * 打卡地点经度
	 */
	private Double longitude;

	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 签到状态,0：已签到未审核，1：审核通过，2审核不通过
	 */
	private Integer status;

	public Integer getuserId() {
		return userId;
	}

	public void setuserId(Integer userId) {
		this.userId = userId;
	}

	public Date getSignTime() {
		return signTime;
	}

	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public MobileSign() {
	}
}