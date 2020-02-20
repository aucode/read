package top.auread.service.impl;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.auread.common.HigherReaponse;
import top.auread.common.MailContents;
import top.auread.dao.DebateDao;
import top.auread.dao.UserDao;
import top.auread.entity.Users;
import top.auread.service.UserService;
import top.auread.utils.MailUtils;
import top.auread.utils.Md5Tools;

/**
 * User业务层接口实现类
 * @author Administrator
 *
 */
//注解Service
@Service
public class UserServiceImpl implements UserService{

	@Autowired //注解  @Autowired 再容器里自动找UserDao对象
	private UserDao userDao;
	@Autowired //注解  @Autowired 再容器里自动找UserDao对象
	private  DebateDao debateDao;
	
	private HttpServletRequest request;
	
	// 查询所有用户 
	public List<Users> queryAllUser() {
		return userDao.queryAllUser();
	}

	public int selectUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return 0;
	}

	public HigherReaponse<Users> queryUserByUserNameAndPwd(Users user,HttpSession session) {
		if(null == user) {
			return HigherReaponse.getHigherReaponseFailed("用户名或密码不为空！！");
		}
		
		String md5 = Md5Tools.MD5(user.getUses_password());
		user.setUses_password(md5);
		//查找用户是否存在
		int i = userDao.selectUserByUserName(user);
		if(i == 0) {
			return HigherReaponse.getHigherReaponseFailed("用户不存在！！");		
		}
		if(null == user.getUses_password() || "".equals(user.getUses_password())) {
			return HigherReaponse.getHigherReaponseFailed("密码不为空！！");		
		}
		//System.out.println(user);
		Users queryUserByUserNameAndPwd = userDao.queryUserByUserNameAndPwd(user);
		if(null == queryUserByUserNameAndPwd) {
			return HigherReaponse.getHigherReaponseFailed("用户名或密码错误。");
		}
		
		if(queryUserByUserNameAndPwd.getUses_isactivate() == 0) {
			return HigherReaponse.getHigherReaponseFailed("账号未激活，请前往邮箱激活账号。");
		}
		
		session.setAttribute("user", queryUserByUserNameAndPwd);
		debateDao.updateDebate();
		return HigherReaponse.getHigherReaponseSuccess(queryUserByUserNameAndPwd);
	}
	/**
	 * pagehelper分页插件 分页查询所有数据列表
	 */
	public HigherReaponse<Object> pageQueryUser(Integer pageNum, Integer pageSize) {
		/**
		 * 原理 把所有数据给 pagehelper 插件自动帮分
		 */
		//开启分页查询 
		PageHelper.startPage(pageNum,pageSize);
		//调用所有查询用户的方法
		List<Users> queryAllUser = userDao.queryAllUser();
		PageInfo<Users> pageInfo= new PageInfo<>(queryAllUser);
		if(null == pageInfo) {
			return HigherReaponse.getHigherReaponseFailed("数据查询失败");
		}else {
			return HigherReaponse.getHigherReaponseSuccess(pageInfo);			
		}
		
	}

	@Override
	public HigherReaponse<Object> addUser(Users users) throws AddressException, IOException, MessagingException {

		
		
		if(null == userDao) {
			return HigherReaponse.getHigherReaponseFailed("服务器异常。。。");
		}
		if(null == users) {
			return HigherReaponse.getHigherReaponseFailed("数据错误。。。");
		}
		String md5 = Md5Tools.MD5(users.getUses_password());
		if(null == md5) {
			return HigherReaponse.getHigherReaponseFailed("加密失败。");
		}
		users.setUses_password(md5);
		int selectUserByUserName = userDao.selectUserByUserName(users);
		System.out.println(selectUserByUserName);
		System.out.println(selectUserByUserName != 1);
		if(selectUserByUserName != 0) {
			return HigherReaponse.getHigherReaponseFailed("用户名已存在....");
		}
		Boolean addUser = userDao.addUser(users);
		
		if(addUser) {
			//发送邮件待激活  
			Users queryUserByUserNameAndPwd = userDao.queryUserByUserNameAndPwd(users);
			System.out.println(queryUserByUserNameAndPwd.getUses_id());
			String contents = "要完成 AUREAD 帐户注册，请先确认您的电子邮件地址。\r\n" + 
					"<a href='"+MailContents.MAIL_LOST+"?uses_id="+queryUserByUserNameAndPwd.getUses_id()+"'>确认电子邮件地址</a>\r\n" ;
			MailUtils.send_email(users.getUses_mail(), MailContents.MAIL_TITLE, contents);
			
			return HigherReaponse.getHigherReaponseSuccess("添加成功");
		}else {
			return HigherReaponse.getHigherReaponseFailed("添加失败。。。");
		}

	}

	@Override
	public HigherReaponse<Object> updUser(Users users) {

		
		
		if(null == userDao) {
			return HigherReaponse.getHigherReaponseFailed("服务器异常。。。");
		}
		int selectUserByUserName = userDao.selectUserByUserName(users);
		if(selectUserByUserName != 0) {
			return HigherReaponse.getHigherReaponseFailed("用户名或邮箱重复。");
		}
		if(null == users.getUses_id()) {
			return HigherReaponse.getHigherReaponseFailed("数据错误。。。");
		}
		String md5 = Md5Tools.MD5(users.getUses_password());
		if(null == md5) {
			return HigherReaponse.getHigherReaponseFailed("密码空，加密失败。");
		}
		users.setUses_password(md5);
		Boolean updUser = userDao.updUser(users);
		
		if(updUser) {
			return HigherReaponse.getHigherReaponseSuccess("更新成功");
		}else {
			return HigherReaponse.getHigherReaponseFailed("更新失败。。。");
			
		}
		
		
		
	}


}
