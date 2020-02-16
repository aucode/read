package top.auread.service;



import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import top.auread.common.HigherReaponse;
import top.auread.entity.Books;

/**
 * Books 业务层接口类
 * @author Administrator
 *
 */
public interface BooksService {
	
	
	//分页查询所有用户
	HigherReaponse<Object> pageQueryBooksUser(Integer pageNum,Integer pageSize);
	
	
	//获得最新8条 记录
	HigherReaponse<Object> getBooksNew();
	//获得点击高8条 记录
	HigherReaponse<Object> getBooksClickCount();
	//获得收藏最高8条 记录
	HigherReaponse<Object> getBooksCollectCount();
	//类别查找
	HigherReaponse<Object> getBooksCategoryId(int id);
	//类别查找
	HigherReaponse<Object> searchBooksByPage(Integer pageNum, Integer pageSize, Books books);
	
	
	//类别查找（返回条数）
	HigherReaponse<Object> getCategoryIdCount(Books books);
	
	
	//根据id查看详情
	HigherReaponse<Books> queryBkoosByID(Books books);
	
	HigherReaponse<Books> getbookbyid(Books books,Integer pageNum,Integer pageSize);
	
	//更新书籍状态
	HigherReaponse<Object> updateBooksStatus(Books books);
	
	HigherReaponse<Object> addBooks(Books books,MultipartFile file,HttpServletRequest request)throws IllegalStateException, IOException ;

}
