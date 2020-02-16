package top.auread.dao;

import java.util.List;

import top.auread.entity.Category;

/**
 * Category  Dao类
 * @author Administrator
 *
 */
public interface CategoryDao {

	
	
	//查询所有类
	List<Category> getAllCategory();
	Boolean addcategory(Category category);
	Boolean deletecategory(Category category);
}
