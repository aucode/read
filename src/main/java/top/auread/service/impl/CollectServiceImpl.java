package top.auread.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.auread.common.HigherReaponse;
import top.auread.dao.CollectDao;
import top.auread.entity.Admin;
import top.auread.entity.Collect;
import top.auread.entity.Users;
import top.auread.service.CollectService;
/**
 * Collect业务层接口实现类
 * @author Administrator
 *
 */
//注解Service
@Service
public class CollectServiceImpl implements CollectService{

	
	
	@Autowired //注解  @Autowired 再容器里自动找UserDao对象
	private CollectDao collectDao;
	
	
	
	
	
	
	
	
	
	
	@Override
	public HigherReaponse<Collect> getListCollect(Integer pageNum, Integer pageSize) {

		
		
		//开启分页查询 
		PageHelper.startPage(pageNum,pageSize);
		//调用所有查询用户的方法
		List<Collect> allCollect = collectDao.getAllCollect();
		PageInfo<Collect> pageInfo= new PageInfo<>(allCollect);
		if(null == pageInfo) {
			return HigherReaponse.getHigherReaponseFailed("数据查询失败");
		}else {
			return HigherReaponse.getHigherReaponseSuccess(pageInfo);			
		}
		 
		
		
		
		
		
		
		
		
		
	}

	@Override
	public HigherReaponse<Collect> getListCollectByUserid(int id, Integer pageNum, Integer pageSize) {

		
		
		
		//开启分页查询 
		PageHelper.startPage(pageNum,pageSize);
		//调用所有查询用户的方法
		List<Collect> allCollect = collectDao.getCollectByUserid(id);
		PageInfo<Collect> pageInfo= new PageInfo<>(allCollect);
		if(null == pageInfo) {
			return HigherReaponse.getHigherReaponseFailed("数据查询失败");
		}else {
			return HigherReaponse.getHigherReaponseSuccess(pageInfo);			
		}

		
		
		
		
	}

	@Override
	public HigherReaponse<Collect> getListCollectByBooksid(int id, Integer pageNum, Integer pageSize) {

		//开启分页查询 
		PageHelper.startPage(pageNum,pageSize);
		//调用所有查询用户的方法
		List<Collect> allCollect = collectDao.getCollectByBooksid(id);
		PageInfo<Collect> pageInfo= new PageInfo<>(allCollect);
		if(null == pageInfo) {
			return HigherReaponse.getHigherReaponseFailed("数据查询失败");
		}else {
			return HigherReaponse.getHigherReaponseSuccess(pageInfo);			
		}
	}

	@Override
	public HigherReaponse<Object> addCollect(Collect collect,HttpServletRequest request) {

		
		if(null == collect) {
			return HigherReaponse.getHigherReaponseFailed("添加失败。。。");
		}

		
		
		HttpSession session = request.getSession();
		Users attribute = (Users) session.getAttribute("user");
		
		
		
		
		
		
		if(null == attribute) {
			return HigherReaponse.getHigherReaponseFailed("未登录。。。");
		}
			return HigherReaponse.getHigherReaponseSuccess(collectDao.addCollect(collect));			
		
	}

	@Override
	public HigherReaponse<Object> deleteCollect(Collect collect) {
		if(null == collect) {
			return HigherReaponse.getHigherReaponseFailed("删除失败...请稍后重试。");
		}
		int collectByid = collectDao.getCollectByid(collect.getId());
		if(collectByid != 1) {
			return HigherReaponse.getHigherReaponseFailed("数据不存在！！");
		}
		return HigherReaponse.getHigherReaponseSuccess(collectDao.deleteCollect(collect));	
	}

	@Override
	public HigherReaponse<Collect> collect_byuidandbookid(Collect collect) {
		// TODO Auto-generated method stub
		if(null == collect) {
			return HigherReaponse.getHigherReaponseFailed("数据错误。");
		}
		if(null == collectDao) {
			return HigherReaponse.getHigherReaponseFailed("服务器错误。");
		}
		Collect collect_byuidandbookid = collectDao.collect_byuidandbookid(collect);
		if(null == collect_byuidandbookid) {
			return HigherReaponse.getHigherReaponseFailed("数据不存在！！");
		}
		
		return HigherReaponse.getHigherReaponseSuccess(collect_byuidandbookid);
	}

	@Override
	public HigherReaponse<Object> collect_update(Collect collect) {
		// TODO Auto-generated method stub
		if(null == collect) {
			return HigherReaponse.getHigherReaponseFailed("数据错误。");
		}
		if(null == collectDao) {
			return HigherReaponse.getHigherReaponseFailed("服务器错误。");
		}
		Boolean collect_update = collectDao.collect_update(collect);
		if(collect_update == false) {
			return HigherReaponse.getHigherReaponseFailed("更新失败。");
		}
		return HigherReaponse.getHigherReaponseSuccess(collect_update);
	}

}
