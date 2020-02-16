package top.auread.dao;

import java.util.List;

import top.auread.entity.Booksinfo;

public interface BooksinfoDao {

	//1.书籍ID查看全部
	List<Booksinfo> getBooksinfoBybookid(int id);
	//2.根据ID查看详情
	List<Booksinfo> getBooksinfoById(int id);
	
	List<Booksinfo> getIdByBookid(Booksinfo booksinfo);
	
	Boolean addbooksinfo(Booksinfo booksinfo);
}
