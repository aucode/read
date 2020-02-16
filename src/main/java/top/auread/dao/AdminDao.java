package top.auread.dao;

import java.util.List;

import top.auread.entity.Admin;

public interface AdminDao {

	//查询所有管理员用户 
	List<Admin> queryAllAdmin();
	
	//根据管理员用户名密码查询用户
	Admin queryAdminByAdminNameAndPwd(Admin admin);
	
	Boolean addAdmin(Admin admin);
	Boolean deleteAdmin(Admin admin);
	
}
