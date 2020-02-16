package top.auread.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import top.auread.common.HigherReaponse;
import top.auread.entity.Critic;
import top.auread.service.CriticService;

@Controller
@RequestMapping("/manage/critic")
public class CriticController {

	@Autowired // 注解 @Autowired 再容器里自动找UserDao对象
	private CriticService criticService;

	@ResponseBody
	@RequestMapping("/addCritic.do")
	public HigherReaponse<Object> addCritic(Critic critic,HttpServletRequest request) {
		return criticService.addCritic(critic,request);

	}

	@ResponseBody
	@RequestMapping("/selectbydebateid.do")
	public HigherReaponse<Critic> selectbydebateid(Critic critic) {
		return criticService.selectbydebateid(critic);

	}

}
