package top.auread.dao;

import java.util.List;

import top.auread.entity.Books;


public interface BooksDao {

	//查询所有管理员用户 
		List<Books> queryAllBkoos();
		
		//获得最新8条 
		List<Books> getBooksNew();
		//点击最新8条 
		List<Books> getBooksClickCount();
		//收藏量最高8条
		List<Books> getBooksCollectCount();
		//类别查找
		List<Books> getBooksCategoryId(int id);
		//类别查找（返回条数）
		int getCategoryIdCount(Books books);
		//根据id查看详情
		List<Books> queryBkoosByID(Books books);
		//搜索列表分页查询
		List<Books> searchBooksByPage(Books books);
		List<Books> getbookbyid(Books books);
		
		//更新书籍状态
		Boolean updateBooksStatus(Books books);
		//添加新书籍
		Boolean addBooks(Books books);
}
