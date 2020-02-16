package top.auread.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.auread.common.HigherReaponse;
import top.auread.dao.CategoryDao;
import top.auread.entity.Category;
import top.auread.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	
	@Autowired
	private CategoryDao ategoryDao;
	
	@Override
	public HigherReaponse<Category> getListCategory(Integer pageNum, Integer pageSize) {

		if(null == ategoryDao) {
			return HigherReaponse.getHigherReaponseFailed("服务器出小差了。。。");
		}
		 
		 PageHelper.startPage(pageNum,pageSize);
		 List<Category> getAllCategory = ategoryDao.getAllCategory();
		 PageInfo<Category> pageInfo = new PageInfo<>(getAllCategory);
		 if(null == pageInfo) {
			 return HigherReaponse.getHigherReaponseFailed("数据查询失败");
		 }else {
			 return HigherReaponse.getHigherReaponseSuccess(pageInfo);
		 }
		
		
		//return HigherReaponse.getHigherReaponseSuccess(allCategory);
	}
	
	
	@Override
	public HigherReaponse<Category> getAllCategory() {

		if(null == ategoryDao) {
			return HigherReaponse.getHigherReaponseFailed("服务器出小差了。。。");
		}
		List<Category> allCategory = ategoryDao.getAllCategory();
		if (null == allCategory) {
			return HigherReaponse.getHigherReaponseFailed("数据查询失败");
		}
		return HigherReaponse.getHigherReaponseSuccess(allCategory);
	}


	@Override
	public HigherReaponse<Object> addcategory(Category category) {
		if(null == ategoryDao) {
			return HigherReaponse.getHigherReaponseFailed("服务器出小差了。。。");
		}
		if(null == category) {
			return HigherReaponse.getHigherReaponseFailed("数据错误。");
		}
		Boolean addcategory = ategoryDao.addcategory(category);
		if(false == addcategory) {
			return HigherReaponse.getHigherReaponseFailed("添加失败。");
		}
		return HigherReaponse.getHigherReaponseSuccess(addcategory);
	}


	@Override
	public HigherReaponse<Object> deletecategory(Category category) {
		if(null == ategoryDao) {
			return HigherReaponse.getHigherReaponseFailed("服务器出小差了。。。");
		}
		if(null == category) {
			return HigherReaponse.getHigherReaponseFailed("数据错误。");
		}
		Boolean addcategory = ategoryDao.deletecategory(category);
		if(false == addcategory) {
			return HigherReaponse.getHigherReaponseFailed("删除失败。");
		}
		return HigherReaponse.getHigherReaponseSuccess(addcategory);
	}

}
