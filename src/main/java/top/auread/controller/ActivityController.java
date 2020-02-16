package top.auread.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import top.auread.common.HigherReaponse;
import top.auread.entity.Activity;
import top.auread.entity.Admin;
import top.auread.service.ActivityService;

/**
 * Activity类 控制器
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/manage/activity")
public class ActivityController {

	
	@Autowired
	private ActivityService activityService;
	
	@RequestMapping("/testlogin.do")
	public HigherReaponse<Admin> testadmin(HttpServletRequest request,int id){
		HttpSession session = request.getSession();
		Admin attribute = (Admin) session.getAttribute("admin");
		System.out.println(attribute);
		return HigherReaponse.getHigherReaponseSuccess(attribute);
		
	}
	
	//1.分页查找全部数据 
	@RequestMapping("/all_list.do")
	public HigherReaponse<Activity> allList(@RequestParam(required = true,defaultValue = "1") Integer pageNum, @RequestParam(required = true,defaultValue = "4")Integer pageSize){
		return activityService.queryAllActivity(pageNum,pageSize);
	}
	//2.最新5条
	@RequestMapping("/getnew_activity.do")
	public HigherReaponse<Activity> queryNewActivity(){
		return activityService.queryNewActivity();
	}

	//4.添加一条记录 
	@RequestMapping("/add_activity.do")
	public HigherReaponse<Object> addActivity(HttpServletRequest request,Activity activity,MultipartFile file) throws IOException, Exception{
		
		return activityService.addActivity(activity,file,request);
	}
	//5.删除一条记录 
	@RequestMapping("/delete.do")
	public HigherReaponse<Object> deleteActivity(@RequestParam(required = true)Integer id){
		Activity activity = new Activity(id, null, null, null);
		return activityService.deleteActivity(activity);
	}
	//c查看详情
	@RequestMapping("/detail.do")
	public HigherReaponse<Activity> getActivityByid(@RequestParam(required = true)Integer id){
		return activityService.getActivityByid(id);
	}
	//文件上传
	@RequestMapping("/upload.do")
	public HigherReaponse<Object> upload(MultipartFile file){
		System.out.println(file.getOriginalFilename());
		try {
			file.transferTo(new File("D:/Downloads/001/"+file.getOriginalFilename()));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
}
