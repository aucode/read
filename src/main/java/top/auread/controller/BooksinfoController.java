package top.auread.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import top.auread.common.HigherReaponse;
import top.auread.entity.Booksinfo;
import top.auread.service.BooksinfoService;

@RestController
@RequestMapping("/manage/booksinfo")
public class BooksinfoController {

	
	@Autowired
	private BooksinfoService booksinfoService; 
	
	@RequestMapping("/getbooksinfo_bybookid.do")
	public HigherReaponse<Booksinfo> getBooksinfoBybookid(@RequestParam(required = true)Integer id) {
		return booksinfoService.getBooksinfoBybookid(id);
	}
	@RequestMapping("/getbooksinfo_byid.do")
	public HigherReaponse<Booksinfo> getBooksinfoById(@RequestParam(required = true)Integer id) {
		return booksinfoService.getBooksinfoById(id);
	}
	@RequestMapping("/addbooksinfo.do")
	public HigherReaponse<Object> addBooksinfo(Booksinfo booksinfo,HttpServletRequest request) {
		return booksinfoService.addBooksinfo(booksinfo,request);
	}
	@RequestMapping("/getIdByBookid.do")
	public HigherReaponse<Booksinfo> getIdByBookid(Booksinfo booksinfo) {
		System.out.println(booksinfo.toString());
		return booksinfoService.getIdByBookid(booksinfo);
	}
	
	
	
	
}
