package top.auread.service;

import javax.servlet.http.HttpSession;

import top.auread.common.HigherReaponse;
import top.auread.entity.Admin;

/**
 * Admin 业务层接口类
 * @author Administrator
 *
 */
public interface AdminService {
	
	
	//分页查询所有用户
	HigherReaponse<Object> pageQueryAdminUser(Integer pageNum,Integer pageSize);
	
	
	//根据管理员用户名密码查询用户
	HigherReaponse<Admin> queryAdminByAdminNameAndPwd(Admin admin,HttpSession session);
	
	HigherReaponse<Object> addAdmin(Admin admin);
	
	HigherReaponse<Object> deleteAdmin(Admin admin);
	
	
	
}
