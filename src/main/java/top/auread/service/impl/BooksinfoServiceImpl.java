package top.auread.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.auread.common.HigherReaponse;
import top.auread.dao.BooksinfoDao;
import top.auread.entity.Booksinfo;
import top.auread.entity.Users;
import top.auread.service.BooksinfoService;

@Service
public class BooksinfoServiceImpl implements BooksinfoService {

	
	@Autowired //注解  @Autowired 再容器里自动找UserDao对象
	private BooksinfoDao ooksinfoDao;
	
	
	
	
	@Override
	public HigherReaponse<Booksinfo> getBooksinfoBybookid(int id) {
		if(null == ooksinfoDao) {
			return HigherReaponse.getHigherReaponseFailed("服务器错误。。");
		}
		List<Booksinfo> booksinfoBybookid = ooksinfoDao.getBooksinfoBybookid(id);
		if(null == booksinfoBybookid) {
			return HigherReaponse.getHigherReaponseFailed("查不到数据。。");
		}
		return HigherReaponse.getHigherReaponseSuccess(booksinfoBybookid);
	}

	@Override
	public HigherReaponse<Booksinfo> getBooksinfoById(int id) {
		if(null == ooksinfoDao) {
			return HigherReaponse.getHigherReaponseFailed("服务器错误。。");
		}
		List<Booksinfo> booksinfoBybookid = ooksinfoDao.getBooksinfoById(id);
		if(null == booksinfoBybookid) {
			return HigherReaponse.getHigherReaponseFailed("查不到数据。。");
		}
		return HigherReaponse.getHigherReaponseSuccess(booksinfoBybookid);
	}

	@Override
	public HigherReaponse<Object> addBooksinfo(Booksinfo booksinfo,HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Users attribute = (Users) session.getAttribute("user");
		
		
		if(null == attribute) {
			return HigherReaponse.getHigherReaponseFailed("未登录。。");
		}
		
		if(null == ooksinfoDao) {
			return HigherReaponse.getHigherReaponseFailed("服务器错误。。");
		}
		if(null == booksinfo) {
			return HigherReaponse.getHigherReaponseFailed("数据错误。。");
		}
		Boolean addbooksinfo = ooksinfoDao.addbooksinfo(booksinfo);
		if(null == addbooksinfo) {
			return HigherReaponse.getHigherReaponseFailed("添加失败。。");
		}
		
		
		return HigherReaponse.getHigherReaponseSuccess("添加成功。。");
	}

	@Override
	public HigherReaponse<Booksinfo> getIdByBookid(Booksinfo booksinfo) {
		if(null == ooksinfoDao) {
			return HigherReaponse.getHigherReaponseFailed("服务器错误。。");
		}
		List<Booksinfo> booksinfoBybookid = ooksinfoDao.getIdByBookid(booksinfo);
		if(null == booksinfoBybookid) {
			return HigherReaponse.getHigherReaponseFailed("查不到数据。。");
		}
		return HigherReaponse.getHigherReaponseSuccess(booksinfoBybookid);
	}

}
