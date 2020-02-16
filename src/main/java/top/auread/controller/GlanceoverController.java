package top.auread.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import top.auread.common.HigherReaponse;
import top.auread.entity.Booksinfo;
import top.auread.entity.Glanceover;
import top.auread.service.GlanceoverService;

//注解 标明是SpringMCV的 Controller 层
@Controller
@RequestMapping("/manage/glanceover")
public class GlanceoverController {

	
	@Autowired //注解  @Autowired 再容器里自动找UserDao对象
	private GlanceoverService  glanceoverService;
	
	
	@ResponseBody
	@RequestMapping("/addGlanceover.do")
	public HigherReaponse<Object> addGlanceover(Glanceover glanceover){
		HigherReaponse<Object> addGlanceover = glanceoverService.addGlanceover(glanceover);
		System.out.println("返回页面："+addGlanceover);
		return addGlanceover;
		
	}
	
	
	
	@ResponseBody
	@RequestMapping("/selectGlantitle.do")
	public HigherReaponse<Booksinfo> selectGlantitle(Glanceover glanceover){
		HigherReaponse<Booksinfo> selectGlantitle = glanceoverService.selectGlantitle(glanceover);
		System.out.println(selectGlantitle);
		return selectGlantitle;
		
	}
	
	
	
	
	
}
