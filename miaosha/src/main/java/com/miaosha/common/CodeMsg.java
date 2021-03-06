package com.miaosha.common;

import java.io.Serializable;

/**
 * 响应状态码对应异常信息封装
 * 
 * @创建时间：2018年6月18日
 */
public class CodeMsg implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8374377780158590660L;
	
	private int code;
	private String msg;
	
	// 通用状态码	5001XX
	public static final CodeMsg SUCCESS = new CodeMsg(0, "success");
	public static final CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务端异常");
	public static final CodeMsg BIND_ERROR = new CodeMsg(500101, "参数校验异常: %s");
	public static final CodeMsg REQUEST_ILLEGAL = new CodeMsg(500102, "请求非法");
	public static final CodeMsg ACCESS_LIMIT = new CodeMsg(500103, "访问太频繁");

	// 登录模块	5002XX
	public static final CodeMsg SESSION_ERROR = new CodeMsg(500210, "session不存在或已失效");
	public static final CodeMsg PASSWORD_EMPTY = new CodeMsg(500211, "密码不能为空");
	public static final CodeMsg MOBILE_EMPTY = new CodeMsg(500212, "手机号不能为空");
	public static final CodeMsg MOBILE_ERROR = new CodeMsg(500213, "手机号格式错误");
	public static final CodeMsg MOBILE_NOT_EXIST = new CodeMsg(500214, "手机号未注册");
	public static final CodeMsg PASSWORD_ERROR = new CodeMsg(500215, "密码错误");
	
	// 商品模块	5003XX
	
	// 订单模块	5004XX
	
	// 秒杀模块	5005XX
	public static final CodeMsg MIAO_SHA_OVER = new CodeMsg(500500, "商品已经秒杀完毕");
	public static final CodeMsg REPEATE_MIAOSHA = new CodeMsg(500501, "不能重复秒杀");
	
	public CodeMsg fillArgs(Object... args) {
		this.msg = String.format(this.msg, args);
		return this;
	}
	
	private CodeMsg(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public CodeMsg() {}
	
	public int getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
	
}
