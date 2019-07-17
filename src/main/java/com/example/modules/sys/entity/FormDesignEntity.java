package com.example.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 自定义表单
 *
 * @author lanxinghua
 * @email lanxinghua@2dfire.com
 * @date 2019-07-17 21:34:56
 */
@TableName("form_design")
public class FormDesignEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private Long id;
	/**
	 * 表单名
	 */
	private String formName;
	/**
	 * 页面编辑好的原始html
	 */
	private String template;
	/**
	 * 反解析出来的页面html代码
	 */
	private String html;
	/**
	 * 自定义的各个控件字段的jsonarray格式存储
	 */
	private String dataStr;
	/**
	 *
	 */
	private String parse;
	/**
	 *
	 */
	private Long fields;
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
	 * 设置：表单名
	 */
	public void setFormName(String formName) {
		this.formName = formName;
	}
	/**
	 * 获取：表单名
	 */
	public String getFormName() {
		return formName;
	}
	/**
	 * 设置：页面编辑好的原始html
	 */
	public void setTemplate(String template) {
		this.template = template;
	}
	/**
	 * 获取：页面编辑好的原始html
	 */
	public String getTemplate() {
		return template;
	}
	/**
	 * 设置：反解析出来的页面html代码
	 */
	public void setHtml(String html) {
		this.html = html;
	}
	/**
	 * 获取：反解析出来的页面html代码
	 */
	public String getHtml() {
		return html;
	}
	/**
	 * 设置：自定义的各个控件字段的jsonarray格式存储
	 */
	public void setDataStr(String dataStr) {
		this.dataStr = dataStr;
	}
	/**
	 * 获取：自定义的各个控件字段的jsonarray格式存储
	 */
	public String getDataStr() {
		return dataStr;
	}
	/**
	 * 设置：
	 */
	public void setParse(String parse) {
		this.parse = parse;
	}
	/**
	 * 获取：
	 */
	public String getParse() {
		return parse;
	}
	/**
	 * 设置：
	 */
	public void setFields(Long fields) {
		this.fields = fields;
	}
	/**
	 * 获取：
	 */
	public Long getFields() {
		return fields;
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
