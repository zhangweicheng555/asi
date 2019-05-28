package com.boot.kaizen.util;

import java.util.Date;

/**
 * json结构实体类
 * 
 * @author weichengz
 * @date 2018年9月1日 上午8:24:45
 */
public class JsonMsgUtil {

	private boolean success = false;
	private String message;// 提示信息
	private Long time = new Date().getTime();// 相应的时间
	private Integer code = 200;// 状态码
	private Object object = null;// 返回的对象 这个就是返回的存储信息的地方

	/*** app使用 */
	private Integer resultCode;
	private String mMessage;
	private Long newTimestamp = new Date().getTime();
	private Object dataSource;

	private String token = "";

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public JsonMsgUtil(Integer code, String message, Integer resultCode, String mMessage) {
		super();
		this.message = message;
		this.code = code;
		this.resultCode = resultCode;
		this.mMessage = mMessage;
	}

	public JsonMsgUtil(Integer resultCode, String mMessage, Long newTimestamp, Object dataSource) {
		super();
		this.resultCode = resultCode;
		this.mMessage = mMessage;
		this.newTimestamp = newTimestamp;
		this.dataSource = dataSource;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getResultCode() {
		return resultCode;
	}

	public void setResultCode(Integer resultCode) {
		this.resultCode = resultCode;
	}

	public String getmMessage() {
		return mMessage;
	}

	public void setmMessage(String mMessage) {
		this.mMessage = mMessage;
	}

	public Long getNewTimestamp() {
		return newTimestamp;
	}

	public void setNewTimestamp(Long newTimestamp) {
		this.newTimestamp = newTimestamp;
	}

	public Object getDataSource() {
		return dataSource;
	}

	public void setDataSource(Object dataSource) {
		this.dataSource = dataSource;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public JsonMsgUtil(Integer code, String msg) {
		super();
		this.message = msg;
		this.code = code;
	}

	public JsonMsgUtil(boolean success, String msg, Object object) {
		super();
		this.success = success;
		this.message = msg;
		this.object = object;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public JsonMsgUtil() {
		super();
	}

	public JsonMsgUtil(boolean success) {
		super();
		this.success = success;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return message;
	}

	public void setMsg(String msg) {
		this.message = msg;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
}
