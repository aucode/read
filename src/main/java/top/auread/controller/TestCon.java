package top.auread.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import top.auread.entity.Users;
import top.auread.service.UserService;

//注解 标明是SpringMCV的 Controller 层
@Controller
public class TestCon {

	@Autowired //注解  @Autowired 再容器里自动找UserDao对象
	private UserService userService;
	
	@RequestMapping("/test.do")
	public List<Users> test() {
		List<Users> queryAllUser = userService.queryAllUser();
		System.out.println(queryAllUser.toString());
		return queryAllUser;
	}
	
}
