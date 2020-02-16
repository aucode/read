package top.auread.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.auread.common.HigherReaponse;
import top.auread.common.MailContents;
import top.auread.dao.ActivityDao;
import top.auread.entity.Activity;
import top.auread.entity.Admin;
import top.auread.service.ActivityService;
import top.auread.utils.UUIDUtils;

@Service
public class ActivityServiceImpl implements ActivityService {

	
	
	
	
	@Autowired //注解  @Autowired 再容器里自动找UserDao对象
	private ActivityDao activityDao;
	
	
	
	
	
	
	
	
	@Override
	public HigherReaponse<Activity> queryAllActivity(Integer pageNum, Integer pageSize) {
		
		PageHelper.startPage(pageNum,pageSize);
		List<Activity> queryAllActivity = activityDao.queryAllActivity();
		PageInfo<Activity> pageInfo = new PageInfo<>(queryAllActivity);
		if(null == pageInfo) {
			return HigherReaponse.getHigherReaponseFailed("数据查询失败");
		}
		else {
			return HigherReaponse.getHigherReaponseSuccess(pageInfo);
		}
		
		
		
		
		
	}

	@Override
	public HigherReaponse<Activity> queryNewActivity() {

	
		if(null == activityDao) {
			return HigherReaponse.getHigherReaponseFailed("服务器出小差了。。。");
		}
		List<Activity> newActivity = activityDao.queryNewActivity();
		if (null == newActivity) {
			return HigherReaponse.getHigherReaponseFailed("数据查询失败");
		}
		return HigherReaponse.getHigherReaponseSuccess(newActivity);
	
	
	
	}

	@Override
	public HigherReaponse<Object> addActivity(Activity activity,MultipartFile file,HttpServletRequest request) throws Exception, IOException {
		
		if(null == activity) {
			return HigherReaponse.getHigherReaponseFailed("服务器异常。。。");
		}
		if(null == activityDao) {
			return HigherReaponse.getHigherReaponseFailed("请求失败。。。");
		}
		System.out.println("图片 :=> "+file);
		if(null == file) {
			return HigherReaponse.getHigherReaponseFailed("图片为空。。。");
		}
		HttpSession session = request.getSession();
		Admin attribute = (Admin) session.getAttribute("admin");
		if(null == attribute) {
			return HigherReaponse.getHigherReaponseFailed("未登录。。。");
		}
		//生成图片名 
		String imgName = UUIDUtils.getUUID();
		//获取后缀名
		String originalFilename = file.getOriginalFilename();
		int lastIndexOf = originalFilename.lastIndexOf(".");
		String suffixName = originalFilename.substring(lastIndexOf);
		//判断是否为图片
		if (!".jpg".equalsIgnoreCase(suffixName) && !".png".equalsIgnoreCase(suffixName)) {
			return HigherReaponse.getHigherReaponseFailed("生成格式有误");
		}
		imgName += suffixName;
		//设置图片名 
		activity.setActivity_ing(imgName);
		Boolean addActivity = activityDao.addActivity(activity);
		if(false == addActivity) {
			return HigherReaponse.getHigherReaponseFailed("添加失败。。。");
		}
		//生成图片
		file.transferTo(new File(MailContents.IMG_URL+"/"+imgName));
		return HigherReaponse.getHigherReaponseSuccess(addActivity);	
	}

	@Override
	public HigherReaponse<Object> deleteActivity(Activity activity) {

		if(null == activityDao) {
			return HigherReaponse.getHigherReaponseFailed("删除失败...请稍后重试。");
		}
		Activity collectByid = activityDao.getActivityByid(activity.getId());
		System.out.println(collectByid);
		if(null == collectByid) {
			return HigherReaponse.getHigherReaponseFailed("数据不存在！！");
		}
		Boolean deleteboolean = activityDao.deleteActivity(activity);
		if(deleteboolean) {
			return HigherReaponse.getHigherReaponseSuccess("删除成功");	
		}else {
			return HigherReaponse.getHigherReaponseFailed("失败。。。。");
		}
	}

	@Override
	public HigherReaponse<Activity> getActivityByid(int id) {

	
	
		if(null == activityDao) {
			return HigherReaponse.getHigherReaponseFailed("服务器出小差了。。。");
		}
		Activity activityByid = activityDao.getActivityByid(id);
		if (null == activityByid) {
			return HigherReaponse.getHigherReaponseFailed("数据查询失败");
		}
		return HigherReaponse.getHigherReaponseSuccess(activityByid);
	
	
	
	
	
	
	
	
	
	}

}
