package top.auread.service;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import top.auread.common.HigherReaponse;
import top.auread.entity.Activity;

public interface ActivityService {

	
	
	
	//1.分页获取全部 活动
	HigherReaponse<Activity> queryAllActivity(Integer pageNum, Integer pageSize);
	
	//2.获取最新的5条
	HigherReaponse<Activity> queryNewActivity();
	
	//3.添加一条数据
	HigherReaponse<Object> addActivity(Activity activity,MultipartFile file ,HttpServletRequest request)throws Exception, IOException;
	
	//4.删除一条数据
	HigherReaponse<Object> deleteActivity(Activity activity);
	
	
	//6.根据id查找 
	HigherReaponse<Activity> getActivityByid(int id);

}
