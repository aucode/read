package top.auread.service;


import javax.servlet.http.HttpServletRequest;

import top.auread.common.HigherReaponse;
import top.auread.entity.Booksinfo;

public interface BooksinfoService {

	
	//1.书籍ID查看全部
	HigherReaponse<Booksinfo> getBooksinfoBybookid(int id);
	//2.根据ID查看详情
	HigherReaponse<Booksinfo> getBooksinfoById(int id);
	
	HigherReaponse<Booksinfo> getIdByBookid(Booksinfo booksinfo);
	//2.根据ID查看详情
	HigherReaponse<Object> addBooksinfo(Booksinfo booksinfo,HttpServletRequest request);
	
}
