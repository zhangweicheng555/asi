package com.boot.kaizen.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonFormat;

public abstract class BaseEntity<T extends Serializable> implements Serializable {

	private static final long serialVersionUID = 2054813493011812469L;

	private T id;// 主键ID 自增
	private Date createTime=new Date();// 创建时间
	private Date updateTime;// 修改时间
	private T projId;// 项目ID
	private T createAt;// 添加人

	public T getId() {
		return id;
	}

	public T getCreateAt() {
		return createAt;
	}

	public void setCreateAt(T createAt) {
		this.createAt = createAt;
	}

	public T getProjId() {
		return projId;
	}

	public void setProjId(T projId) {
		this.projId = projId;
	}

	public void setId(T id) {
		this.id = id;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.reflectionToString(this);
	}

	public String toSimpleString() {
		return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}

	@Override
	public boolean equals(Object o) {
		return EqualsBuilder.reflectionEquals(this, o);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
}
