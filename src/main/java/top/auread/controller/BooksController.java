package top.auread.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import top.auread.common.HigherReaponse;
import top.auread.entity.Books;
import top.auread.service.BooksService;

/**
 * Books类 控制器
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/manage/books")
public class BooksController {
	@Autowired
	private BooksService booksService;
	

	
	@RequestMapping("/search.do")
	public HigherReaponse<Object> searchQueryBookByPage(String keywork,
			@RequestParam(required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = "4") Integer pageSize) {
		Books books = new Books();
		books.setBooks_title(keywork);
		
		return booksService.searchBooksByPage( pageNum, pageSize,books);
	}
	
	
	//分页 
	@RequestMapping("/list.do")
	public HigherReaponse<Object> pageBooksList(@RequestParam(required = true,defaultValue = "1") Integer pageNum, @RequestParam(required = true,defaultValue = "4")Integer pageSize){
		return booksService.pageQueryBooksUser(pageNum, pageSize);
	}
	

	//最新
	@RequestMapping("/newbooks.do")
	public HigherReaponse<Object> getNewBooks(){
		return booksService.getBooksNew();
	}
	//点击
	@RequestMapping("/getbooks_clickcount.do")
	public HigherReaponse<Object> getBooksClickCount(){
		return booksService.getBooksClickCount();
	}
	//收藏
	@RequestMapping("/getbooks_collectcount.do")
	public HigherReaponse<Object> getBooksCollectCount(){
		return booksService.getBooksCollectCount();
	}
	//收藏
	@RequestMapping("/get_bookscategoryid.do")
	public HigherReaponse<Object> getBooksCategoryId(@RequestParam("id")int id){
		return booksService.getBooksCategoryId(id);
	}
	//收藏
	@RequestMapping("/updateBooksStatus.do")
	public HigherReaponse<Object> updateBooksStatus(Books books){
		//Books books = new Books(id, null, null, null, 0, null, null, null, null, null);
		return booksService.updateBooksStatus(books);
	}
	
	
	
	
	
	
	
	//4.添加一条记录 
	@RequestMapping("/add_book.do")
	public HigherReaponse<Object> addActivity(HttpServletRequest request,Books books,MultipartFile file) throws IOException, Exception{
		return booksService.addBooks(books, file, request);
		
	}
	
	
	
	
	
	//4.id查看详情
	@RequestMapping("/queryBkoos.do")
	public HigherReaponse<Books> queryBkoosByID(Books books){
		return booksService.queryBkoosByID(books);
		
	}
	//4.id查看详情
	@RequestMapping("/getCategoryIdCount.do")
	public HigherReaponse<Object> getCategoryIdCount(Books books){
		return booksService.getCategoryIdCount(books);
		
	}
	@RequestMapping("/getbookbyid.do")
	public HigherReaponse<Books> getbookbyid(Books books,@RequestParam(required = true,defaultValue = "1") Integer pageNum, @RequestParam(required = true,defaultValue = "4")Integer pageSize){
		return booksService.getbookbyid(books,pageNum,pageSize);
		
	}

	
	
	
	
	
	

}
