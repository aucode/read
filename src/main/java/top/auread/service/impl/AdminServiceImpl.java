package top.auread.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.auread.common.HigherReaponse;
import top.auread.dao.AdminDao;
import top.auread.entity.Admin;
import top.auread.entity.Users;
import top.auread.service.AdminService;
import top.auread.utils.Md5Tools;

/**
 * Admin 业务层接口实现类
 * @author Administrator
 *
 */
//注解Service
@Service
public class AdminServiceImpl implements AdminService{
	
	
	@Autowired //注解  @Autowired 再容器里自动找UserDao对象
	private AdminDao adminDao;
	
	
	
	
	
	
	@Override
	public HigherReaponse<Object> pageQueryAdminUser(Integer pageNum, Integer pageSize) {
		
		PageHelper.startPage(pageNum,pageSize);
		List<Admin> queryAllAdmin = adminDao.queryAllAdmin();
		PageInfo<Admin> pageInfo = new PageInfo<>(queryAllAdmin);
		if(null == pageInfo) {
			return HigherReaponse.getHigherReaponseFailed("数据查询失败");
		}
		else {
			return HigherReaponse.getHigherReaponseSuccess(pageInfo);
		}
	}






	@Override
	public HigherReaponse<Admin> queryAdminByAdminNameAndPwd(Admin admin,HttpSession session) {
		if(null == admin) {
			return HigherReaponse.getHigherReaponseFailed("用户名或密码不为空！！");
		}
		if(null == admin.getAdmin_name() || "".equals(admin.getAdmin_name())) {
			return HigherReaponse.getHigherReaponseFailed("用户名不为空！！");		
		}
		if(null == admin.getAdmin_password() || "".equals(admin.getAdmin_password())) {
			return HigherReaponse.getHigherReaponseFailed("密码不为空！！");		
		}
		String md5 = Md5Tools.MD5(admin.getAdmin_password());
		admin.setAdmin_password(md5);
		Admin queryAdminByAdminNameAndPwd = adminDao.queryAdminByAdminNameAndPwd(admin);
		if(null == queryAdminByAdminNameAndPwd) {
			return HigherReaponse.getHigherReaponseFailed("用户名或密码错误");
		}
		session.setAttribute("admin", queryAdminByAdminNameAndPwd);
		
		return HigherReaponse.getHigherReaponseSuccess(queryAdminByAdminNameAndPwd);
	}






	@Override
	public HigherReaponse<Object> addAdmin(Admin admin) {

	
	
	
		if(null == admin) {
			return HigherReaponse.getHigherReaponseFailed("服务器异常。");
		}
		String md5 = Md5Tools.MD5(admin.getAdmin_password());
		if(null == md5) {
			return HigherReaponse.getHigherReaponseFailed("加密。");
		}
		admin.setAdmin_password(md5);
		Boolean addAdmin = adminDao.addAdmin(admin);
		if(addAdmin) {
			return HigherReaponse.getHigherReaponseSuccess("添加成功");			
			
		}
		return HigherReaponse.getHigherReaponseFailed("添加失败。");

	
	
	
	
	}






	@Override
	public HigherReaponse<Object> deleteAdmin(Admin admin) {
		if(null == admin) {
			return HigherReaponse.getHigherReaponseFailed("删除失败...请稍后重试。");
		}
		Boolean isAdmin = adminDao.deleteAdmin(admin);
		System.out.println("时间"+isAdmin);
		if(isAdmin) {
			return HigherReaponse.getHigherReaponseSuccess("删除成功");	
		}
		return HigherReaponse.getHigherReaponseFailed("删除失败");
	}

}
