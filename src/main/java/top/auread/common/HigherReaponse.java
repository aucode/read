package top.auread.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import top.auread.utils.StatusUtil;

/**
 * 封装一个高复用响应对象（前后端分离数据处理  所有接口都返回Json数据）
 * @author Administrator
 *
 */
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonInclude(value=Include.NON_NULL)//返回的json数据不为null 
@Data //自动生成get set 方法
public class HigherReaponse<T> {
	//状态码
	private Integer status;
	//返回数据
	private T data;
	//提示信息
	private String msg;
	

	private HigherReaponse() {
		
	}

	

	public HigherReaponse(Integer status) {
		this.status = status;
	}



	public HigherReaponse(Integer status, T data) {
		this.status = status;
		this.data = data;
	}


	public HigherReaponse(Integer status, String msg) {
		this.status = status;
		this.msg = msg;
	}


	public HigherReaponse(Integer status, T data, String msg) {
		this.status = status;
		this.data = data;
		this.msg = msg;
	}
	

	 /**
	  *  提供对外公开的使用方法 
	  */

	// Success 成功 
	//判断是否成功
	@JsonIgnore
	public Boolean isReaponseSuccess() {
		return this.status == StatusUtil.SUCCESS_STATUS;
	}

	public static HigherReaponse getHigherReaponseSuccess() {
		return new HigherReaponse(StatusUtil.SUCCESS_STATUS);
	}
	
	public static HigherReaponse getHigherReaponseSuccess(String msg) {
		return new HigherReaponse(StatusUtil.SUCCESS_STATUS,msg);
	}
	
	public static <T> HigherReaponse getHigherReaponseSuccess(T t) {
		return new HigherReaponse(StatusUtil.SUCCESS_STATUS,t);
	}
	
	public static <T> HigherReaponse getHigherReaponseSuccess(T t,String msg) {
		return new HigherReaponse(StatusUtil.SUCCESS_STATUS,t,msg);
	}
	
	
	//Failed 失败的方法
	@JsonIgnore
	public Boolean isReaponseFailed() {
		return this.status == StatusUtil.FAILED_STATUS;
	}
	
	public static HigherReaponse getHigherReaponseFailed() {
		return new HigherReaponse(StatusUtil.FAILED_STATUS);
	}
	
	public static HigherReaponse getHigherReaponseFailed(String msg) {
		return new HigherReaponse(StatusUtil.FAILED_STATUS,msg);
	}





	
	
	
}
