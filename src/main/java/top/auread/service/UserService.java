package top.auread.service;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpSession;

import top.auread.common.HigherReaponse;
import top.auread.entity.Users;

/**
 * User业务层接口
 * @author Administrator
 *
 */
public interface UserService {
	//查询所有用用户
	List<Users> queryAllUser();
	//分页查询所有用户
	HigherReaponse<Object> pageQueryUser(Integer pageNum,Integer pageSize);
	//根据用户名查询用户是否存在 
	int selectUserByUserName(String userName);
	
	//根据用户名密码查询用户
	HigherReaponse<Users> queryUserByUserNameAndPwd(Users user,HttpSession session);
	
	//4.添加一条记录 
	HigherReaponse<Object> addUser(Users users)throws AddressException, IOException, MessagingException ;
	//4.更新
	HigherReaponse<Object> updUser(Users users);
}
