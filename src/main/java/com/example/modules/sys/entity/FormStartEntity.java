package com.example.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 发起表单
 *
 * @author lanxinghua
 * @email lanxinghua@2dfire.com
 * @date 2019-07-17 21:34:56
 */
@TableName("form_start")
public class FormStartEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private Long id;
	/**
	 * 表单ID
	 */
	private Long formId;
	/**
	 * 存储此次填写的动态表单数据Json
	 */
	private String formValue;
	/**
	 * 是否有效
	 */
	private Integer isValid;
	/**
	 * 登录者
	 */
	private String createUser;
	/**
	 * 登录时间
	 */
	private Long createTime;
	/**
	 * 更新者
	 */
	private String opUser;
	/**
	 * 更新时间
	 */
	private Long opTime;
	/**
	 * 版本号
	 */
	private Integer lastVer;

	/**
	 * 设置：ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：ID
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：表单ID
	 */
	public void setFormId(Long formId) {
		this.formId = formId;
	}
	/**
	 * 获取：表单ID
	 */
	public Long getFormId() {
		return formId;
	}
	/**
	 * 设置：存储此次填写的动态表单数据Json
	 */
	public void setFormValue(String formValue) {
		this.formValue = formValue;
	}
	/**
	 * 获取：存储此次填写的动态表单数据Json
	 */
	public String getFormValue() {
		return formValue;
	}
	/**
	 * 设置：是否有效
	 */
	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}
	/**
	 * 获取：是否有效
	 */
	public Integer getIsValid() {
		return isValid;
	}
	/**
	 * 设置：登录者
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：登录者
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：登录时间
	 */
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：登录时间
	 */
	public Long getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：更新者
	 */
	public void setOpUser(String opUser) {
		this.opUser = opUser;
	}
	/**
	 * 获取：更新者
	 */
	public String getOpUser() {
		return opUser;
	}
	/**
	 * 设置：更新时间
	 */
	public void setOpTime(Long opTime) {
		this.opTime = opTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Long getOpTime() {
		return opTime;
	}
	/**
	 * 设置：版本号
	 */
	public void setLastVer(Integer lastVer) {
		this.lastVer = lastVer;
	}
	/**
	 * 获取：版本号
	 */
	public Integer getLastVer() {
		return lastVer;
	}
}
