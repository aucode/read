package top.auread.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import top.auread.common.HigherReaponse;
import top.auread.entity.Debate;
import top.auread.service.DebateService;

@Controller
@RequestMapping("/manage/debate")
public class DebateController {
	
	
	
	@Autowired // 注解 @Autowired 再容器里自动找UserDao对象
	private DebateService debateService;
	
	@ResponseBody
	@RequestMapping("/updateDebate.do")
	public void updateDebate() { 
		debateService.updateDebate();
	}
	@ResponseBody
	@RequestMapping("/getDebatesAll.do")
	public HigherReaponse<Debate> getDebatesAll() {
		return debateService.getDebatesAll();
		
	}
	
	
	
	
	
	

}
