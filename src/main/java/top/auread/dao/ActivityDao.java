package top.auread.dao;

import java.util.List;

import top.auread.entity.Activity;

public interface ActivityDao {

	
	
	
	//1.获取全部 活动
	List<Activity> queryAllActivity();
	
	//2.获取最新的5条
	List<Activity> queryNewActivity();
	
	//3.添加一条数据
	Boolean addActivity(Activity activity);
	
	//4.删除一条数据
	Boolean deleteActivity(Activity activity);
	
	//6.根据id查找 
	Activity getActivityByid(int id);
	
}
