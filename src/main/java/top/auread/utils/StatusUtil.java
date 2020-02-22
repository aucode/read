package top.auread.utils;

/**
 * status状态码常量类
 * @author Administrator
 *
 */
public class StatusUtil {
	/**
	 *	 成功状态码  1 (200)
	 */
	public final static Integer SUCCESS_STATUS =1; 
	
	/**
	 * 	失败状态码 0 (400)
	 */
	public final static Integer FAILED_STATUS =0;
	
	/**
	 * 	未登录状态码204
	 */
	public final static Integer FAILED_NOT_LOGGED_IN_STATUS = 204;
	
	/**
	 * 	服务器错误 500
	 */
	public final static Integer FAILED_SERVER_ERROR_STATUS = 204;
	
	/**
	 * 	服务端请求超时 499	
	 */
	public final static Integer FAILED_REQUEST_TIMEOUT_STATUS = 499;
	
	/**
	 * 	文件类型错误415
	 */
	public final static Integer FAILED_FILE_TYPE_ERROR_STATUS = 415;
	
	/**
	 * 	文件过大413
	 */
	public final static Integer FAILED_FILE_SIZE_ERROR_STATUS = 413;
	
	
}
