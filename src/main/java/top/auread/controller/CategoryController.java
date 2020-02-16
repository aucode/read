package top.auread.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import top.auread.common.HigherReaponse;
import top.auread.entity.Category;
import top.auread.service.CategoryService;

@RestController
@RequestMapping("/manage/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService; 
	@RequestMapping("/addcategory.do")
	public HigherReaponse<Object> addcategory(Category category){
		return categoryService.addcategory(category);
		
	}
	@RequestMapping("/deletecategory.do")
	public HigherReaponse<Object> deletecategory(Category category){
		return categoryService.deletecategory(category);
		
	}
	@RequestMapping("/list.do")
	public HigherReaponse<Category> getListCategory(@RequestParam(required = true,defaultValue = "1") Integer pageNum, @RequestParam(required = true,defaultValue = "4")Integer pageSize) {
		return categoryService.getListCategory(pageNum,pageSize);
	}
	
	@RequestMapping("/get_allcategory.do")
	public HigherReaponse<Category> getAllCategory() {
		return categoryService.getAllCategory();
	}
}
