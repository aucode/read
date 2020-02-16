package top.auread.service;

import top.auread.common.HigherReaponse;
import top.auread.entity.Category;

public interface CategoryService {

	
	
	
	
	//分页查询所有类
	HigherReaponse<Category> getListCategory(Integer pageNum, Integer pageSize);
	//查询所有类
	HigherReaponse<Category> getAllCategory();
	
	HigherReaponse<Object> addcategory(Category category);
	HigherReaponse<Object> deletecategory(Category category);
}
