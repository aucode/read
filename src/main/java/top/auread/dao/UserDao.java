package top.auread.dao;

import java.util.List;

import top.auread.entity.Users;

public interface UserDao {
	
	
	// 查询所有用户 
	List<Users> queryAllUser();
	
	//根据用户名查询用户是否存在 
	int selectUserByUserName(Users user);
	
	//根据用户名 和 密码查询用户
	Users queryUserByUserNameAndPwd(Users user);
	
	//4.添加一条记录 
	Boolean addUser(Users users);
	//4.激活
	Boolean updUser(Users users);
	
}
