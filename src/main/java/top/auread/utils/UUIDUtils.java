package top.auread.utils;

import java.util.UUID;

/**
 * UUID 生成唯一标识符工具类
 * @author Administrator
 *
 */
public class UUIDUtils {

	
	
	public static String getUUID() {
		UUID randomUUID = UUID.randomUUID();
		return randomUUID.toString();
	}
}
