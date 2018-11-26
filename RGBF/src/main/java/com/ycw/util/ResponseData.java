package com.ycw.util;

/**
 *Description:接口统一返回格式
 */
public class ResponseData {

	/** 是否成功 */
	private boolean success;
	/** 返回码 */
	private String code;
	/** 返回信息 */
	private String msg;
	/** 返回数据 */
	private Object data;

	/**
	 * 自定义返回结果 建议使用统一的返回结果，特殊情况可以使用此方法
	 * 
	 * @param success
	 * @param code
	 * @param msg
	 * @param data
	 * @return
	 */
	public static ResponseData markCustom(boolean success, String code, String msg, Object data) {
		ResponseData responseWrapper = new ResponseData();
		responseWrapper.setSuccess(success);
		responseWrapper.setCode(code);
		responseWrapper.setMsg(msg);
		responseWrapper.setData(data);
		return responseWrapper;
	}

	/**
	 * 参数为空或者参数格式错误
	 * 
	 * @return
	 */
	public static ResponseData markParamError() {
		ResponseData responseWrapper = new ResponseData();
		responseWrapper.setSuccess(false);
		responseWrapper.setCode(ReturnCode.PARAMS_ERROR.getCode());
		responseWrapper.setMsg(ReturnCode.PARAMS_ERROR.getMsg());
		return responseWrapper;
	}

	/**
	 * 查询失败
	 * 
	 * @return
	 */
	public static ResponseData markError() {
		ResponseData responseWrapper = new ResponseData();
		responseWrapper.setSuccess(false);
		responseWrapper.setCode(ReturnCode.FEAILED.getCode());
		responseWrapper.setMsg(ReturnCode.FEAILED.getMsg());
		responseWrapper.setData(null);
		return responseWrapper;
	}

	/**
	 * 查询成功但无数据
	 * 
	 * @return
	 */
	public static ResponseData markSuccessButNoData() {
		ResponseData responseWrapper = new ResponseData();
		responseWrapper.setSuccess(true);
		responseWrapper.setCode(ReturnCode.NODATA.getCode());
		responseWrapper.setMsg(ReturnCode.NODATA.getMsg());
		responseWrapper.setData(null);
		return responseWrapper;
	}

	/**
	 * 查询成功且有数据
	 * 
	 * @param data
	 * @return
	 */
	public static ResponseData markSuccess(Object data) {
		ResponseData responseWrapper = new ResponseData();
		responseWrapper.setSuccess(true);
		responseWrapper.setCode(ReturnCode.SUCCESS.getCode());
		responseWrapper.setMsg(ReturnCode.SUCCESS.getMsg());
		responseWrapper.setData(data);
		return responseWrapper;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "{" + "success=" + success + ", code='" + code + '\'' + ", msg='" + msg + '\'' + ", data="
				+ data + '}';
	}
}
