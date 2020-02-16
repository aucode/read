package top.auread.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.auread.common.HigherReaponse;
import top.auread.common.MailContents;
import top.auread.dao.BooksDao;
import top.auread.entity.Books;
import top.auread.entity.Category;
import top.auread.entity.Users;
import top.auread.service.BooksService;
import top.auread.utils.UUIDUtils;

@Service
public class BooksServiceImpl implements BooksService {

	@Autowired // 注解 @Autowired 再容器里自动找UserDao对象
	private BooksDao booksDao;

	@Override
	public HigherReaponse<Object> pageQueryBooksUser(Integer pageNum, Integer pageSize) {

		PageHelper.startPage(pageNum, pageSize);
		List<Books> queryAllBkoos = booksDao.queryAllBkoos();
		PageInfo<Books> pageInfo = new PageInfo<>(queryAllBkoos);
		if (null == pageInfo) {
			return HigherReaponse.getHigherReaponseFailed("数据查询失败");
		} else {
			return HigherReaponse.getHigherReaponseSuccess(pageInfo);
		}

	}

	@Override
	public HigherReaponse<Object> getBooksNew() {

		if (null == booksDao) {
			return HigherReaponse.getHigherReaponseFailed("服务器出小差了。。。");
		}
		List<Books> newBooks = booksDao.getBooksNew();
		if (null == newBooks) {
			return HigherReaponse.getHigherReaponseFailed("数据查询失败");
		}
		return HigherReaponse.getHigherReaponseSuccess(newBooks);
	}

	@Override
	public HigherReaponse<Object> getBooksClickCount() {

		if (null == booksDao) {
			return HigherReaponse.getHigherReaponseFailed("服务器出小差了。。。");
		}
		List<Books> newBooks = booksDao.getBooksClickCount();
		if (null == newBooks) {
			return HigherReaponse.getHigherReaponseFailed("数据查询失败");
		}
		return HigherReaponse.getHigherReaponseSuccess(newBooks);

	}

	@Override
	public HigherReaponse<Object> getBooksCollectCount() {
		if (null == booksDao) {
			return HigherReaponse.getHigherReaponseFailed("服务器出小差了。。。");
		}
		List<Books> newBooks = booksDao.getBooksCollectCount();
		if (null == newBooks) {
			return HigherReaponse.getHigherReaponseFailed("数据查询失败");
		}
		return HigherReaponse.getHigherReaponseSuccess(newBooks);
	}

	@Override
	public HigherReaponse<Object> getBooksCategoryId(int id) {

		if (id == 0) {
			return HigherReaponse.getHigherReaponseFailed("类型出错。。");
		}
		if (null == booksDao) {
			return HigherReaponse.getHigherReaponseFailed("服务器出小差了。。。");
		}
		List<Books> newBooks = booksDao.getBooksCategoryId(id);
		if (null == newBooks) {
			return HigherReaponse.getHigherReaponseFailed("数据查询失败");
		}
		return HigherReaponse.getHigherReaponseSuccess(newBooks);

	}

	@Override
	public HigherReaponse<Object> searchBooksByPage(Integer pageNum, Integer pageSize, Books books) {
		if (null == books) {
			return HigherReaponse.getHigherReaponseFailed("服务器异常！！！");
		}
		System.out.println(books.toString());
		PageHelper.startPage(pageNum, pageSize);
		List<Books> queryProByCIdAndKeyWord = booksDao.searchBooksByPage(books);
		if (null == queryProByCIdAndKeyWord) {
			return HigherReaponse.getHigherReaponseFailed("没有查到任何数据！！！");
		}
		PageInfo<Books> pageInfo = new PageInfo<>(queryProByCIdAndKeyWord);
		return HigherReaponse.getHigherReaponseSuccess(pageInfo);
	}

	@Override
	public HigherReaponse<Object> updateBooksStatus(Books books) {
		if (null == books) {
			return HigherReaponse.getHigherReaponseFailed("服务器异常。。。");
		}
		Boolean updateBooksStatus = booksDao.updateBooksStatus(books);
		if (null == updateBooksStatus) {
			return HigherReaponse.getHigherReaponseFailed("更新失败。。。");
		}
		return HigherReaponse.getHigherReaponseSuccess("更新成功");
	}

	@Override
	public HigherReaponse<Object> addBooks(Books books,MultipartFile file, HttpServletRequest request) throws IllegalStateException, IOException {

		HttpSession session = request.getSession();
		Users attribute = (Users) session.getAttribute("user");
		if (null == attribute) {
			return HigherReaponse.getHigherReaponseFailed("未登录。。。");
		}
		if (null == booksDao) {
			return HigherReaponse.getHigherReaponseFailed("服务器异常。。。");
		}
		if(null == file) {
			return HigherReaponse.getHigherReaponseFailed("图片为空。。。");
		}
		if (null == books) {
			return HigherReaponse.getHigherReaponseFailed("数据错误。。。");
		}
		// 生成图片路径
		//String url = request.getSession().getServletContext().getRealPath("/upload"+"/");
		// 生成图片名
		String imgName = UUIDUtils.getUUID();

		// 获取后缀名
		String originalFilename = file.getOriginalFilename();
		int lastIndexOf = originalFilename.lastIndexOf(".");
		String suffixName = originalFilename.substring(lastIndexOf);
		// 判断是否为图片
		if (!".jpg".equalsIgnoreCase(suffixName) && !".png".equalsIgnoreCase(suffixName)) {
			return HigherReaponse.getHigherReaponseFailed("生成格式有误");
		}
		imgName += suffixName;
		// 设置图片名
		books.setBooksinfo_id(imgName);
		//设置用户id 
		books.setUsers_id(attribute.getUses_id());
		System.out.println(books.toString());
		Boolean addActivity = booksDao.addBooks(books);
		if (false == addActivity) {
			return HigherReaponse.getHigherReaponseFailed("添加失败。。。");
		}
		// 生成图片
		
		// String url = request.getSession().getServletContext().getRealPath("/upload");
		file.transferTo(new File(MailContents.IMG_URL+"/"+imgName));

		return HigherReaponse.getHigherReaponseSuccess(addActivity);
	}

	@Override
	public HigherReaponse<Books> queryBkoosByID(Books books) {
		// TODO Auto-generated method stub 
		if (null == booksDao) {
			return HigherReaponse.getHigherReaponseFailed("服务器异常。。。");
		}
		if (null == books) {
			return HigherReaponse.getHigherReaponseFailed("数据错误。。。");
		}
		List<Books> queryBkoosByID = booksDao.queryBkoosByID(books);
		if (null == queryBkoosByID) {
			return HigherReaponse.getHigherReaponseFailed("读取数据失败。");
		}
		return HigherReaponse.getHigherReaponseSuccess(queryBkoosByID);
	}

	@Override
	public HigherReaponse<Object> getCategoryIdCount(Books books) {
		// TODO Auto-generated method stub
		if (null == booksDao) {
			return HigherReaponse.getHigherReaponseFailed("服务器异常。。。");
		}
		if (null == books) {
			return HigherReaponse.getHigherReaponseFailed("数据错误。。。");
		}
		int categoryIdCount = booksDao.getCategoryIdCount(books);
		return HigherReaponse.getHigherReaponseSuccess(categoryIdCount);
	}

	@Override
	public HigherReaponse<Books> getbookbyid(Books books,Integer pageNum, Integer pageSize) {
		if (null == booksDao) {
			return HigherReaponse.getHigherReaponseFailed("服务器异常。。。");
		}
		if (null == books) {
			return HigherReaponse.getHigherReaponseFailed("数据错误。。。");
		}
		PageHelper.startPage(pageNum, pageSize);
		List<Books> getbookbyid = booksDao.getbookbyid(books);
		if(null == getbookbyid || getbookbyid.size() == 0) {
			return HigherReaponse.getHigherReaponseFailed("无数据数据。");
		}
		PageInfo<Books> pageInfo = new PageInfo<>(getbookbyid);
		
		return HigherReaponse.getHigherReaponseSuccess(pageInfo);
	}

}
