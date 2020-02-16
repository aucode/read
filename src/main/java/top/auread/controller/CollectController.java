package top.auread.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import top.auread.common.HigherReaponse;
import top.auread.entity.Collect;
import top.auread.service.CollectService;

/**
 * Collect控制器
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/manage/Collect")
public class CollectController {
	@Autowired
	private CollectService collectService;
	
	
	//1.分页查找全部数据 
	@RequestMapping("/all_list.do")
	public HigherReaponse<Collect> allList(@RequestParam(required = true,defaultValue = "1") Integer pageNum, @RequestParam(required = true,defaultValue = "4")Integer pageSize){
		return collectService.getListCollect(pageNum,pageSize);
	}
	//2.分页根据用户id查找 
	@RequestMapping("/getlist_byuserid.do")
	public HigherReaponse<Collect> getlist_byuserid(@RequestParam(required = true) int id,@RequestParam(required = true,defaultValue = "1") Integer pageNum, @RequestParam(required = true,defaultValue = "4")Integer pageSize){
		return collectService.getListCollectByUserid(id,pageNum,pageSize);
	}
	//3.分页根据书籍id查找 
	@RequestMapping("/getlist_bybookid.do")
	public HigherReaponse<Collect> getlist_bybookid(@RequestParam(required = true) int id,@RequestParam(required = true,defaultValue = "1") Integer pageNum, @RequestParam(required = true,defaultValue = "4")Integer pageSize){
		return collectService.getListCollectByBooksid(id,pageNum,pageSize);
	}
	//4.添加一条记录 
	@RequestMapping("/addcollect.do")
	public HigherReaponse<Object> addCollect(@RequestParam(required = true) int usesId,@RequestParam(required = true) int booksId,@RequestParam(required = true) int booksinfoId,HttpServletRequest request ){
		Collect collect = new Collect(null, usesId, booksId, booksinfoId);
		return collectService.addCollect(collect,request);
	}
	//5.删除一条记录 
	@RequestMapping("/delete.do")
	public HigherReaponse<Object> deleteCollect(Collect collect){
		//Collect collect = new Collect(id, usesId, booksId, booksinfoId);
		return collectService.deleteCollect(collect);
	}
	//5.删除一条记录 
	@RequestMapping("/collect_byuidandbookid.do")
	public HigherReaponse<Collect> collect_byuidandbookid(Collect collect){
		
		return collectService.collect_byuidandbookid(collect);
	}
	//5.删除一条记录 
	@RequestMapping("/collect_update.do")
	public HigherReaponse<Object> collect_update(Collect collect){
		
		return collectService.collect_update(collect);
	}

}
