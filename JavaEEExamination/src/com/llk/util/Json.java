package com.llk.util;
/**
 * JSON模型
 * 
 * @author 
 * 
 */
public class Json implements java.io.Serializable {
	private Integer code= 0;
	private String msg = "";
	private Object obj = null;
	private boolean success = false;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}
