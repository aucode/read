package top.auread.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import top.auread.common.HigherReaponse;
import top.auread.entity.Admin;
import top.auread.service.AdminService;

/**
 * Admin类 控制器
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/manage/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/testlogin.do")
	public HigherReaponse<Admin> testadmin(HttpServletRequest request){
		HttpSession session = request.getSession();
		Admin attribute = (Admin) session.getAttribute("admin");
		System.out.println(attribute);
		return HigherReaponse.getHigherReaponseSuccess(attribute);
		
	}
	//登录接口 
	@RequestMapping("/login.do")
	public HigherReaponse<Admin> adminlogin(@RequestParam("name") String name,@RequestParam("password") String password,HttpServletRequest request){
		Admin admin = new Admin();
		admin.setAdmin_name(name);
		admin.setAdmin_password(password);
		HttpSession session = request.getSession();
		HigherReaponse<Admin> queryAdminByAdminNameAndPwd = adminService.queryAdminByAdminNameAndPwd(admin,session);
		return queryAdminByAdminNameAndPwd;
		
	}
	
	
	
	//退出登录 
	@RequestMapping("/signut.do")
	public HigherReaponse<Object> signOut(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.setAttribute("admin",null);
		return HigherReaponse.getHigherReaponseSuccess("");
	}
	//用户分页 
	@RequestMapping("/list.do")
	public HigherReaponse<Object> pageAdminList(@RequestParam(required = true,defaultValue = "1") Integer pageNum, @RequestParam(required = true,defaultValue = "4")Integer pageSize){
		return adminService.pageQueryAdminUser(pageNum, pageSize);
	}
	
	//4.添加一条记录 
		@RequestMapping("/addadmin.do")
		public HigherReaponse<Object> addAdmin(@RequestParam(required = true) String admin_name,@RequestParam(required = true) String pwd){
			Admin admin = new Admin(null, admin_name, pwd, 1, null);
			return adminService.addAdmin(admin);
		}
		//5.删除一条记录 
		@RequestMapping("/deleteAdmin.do")
		public HigherReaponse<Object> deleteAdmin(@RequestParam(required = true) int id){
			Admin admin = new Admin(id, null, null, null, null);
			return adminService.deleteAdmin(admin);
		}
	

}
