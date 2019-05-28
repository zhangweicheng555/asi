package com.boot.kaizen.util.httpip;

public class HttpIp {

	private Integer code;
	private HttpIpDataInfo data;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public HttpIpDataInfo getData() {
		return data;
	}

	public void setData(HttpIpDataInfo data) {
		this.data = data;
	}

	public HttpIp(Integer code, HttpIpDataInfo data) {
		super();
		this.code = code;
		this.data = data;
	}

	public HttpIp() {
		super();
	}

}
