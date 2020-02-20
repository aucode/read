package top.auread.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import top.auread.common.HigherReaponse;
import top.auread.entity.Users;
import top.auread.service.UserService;
import top.auread.utils.CodeUtil;

/**
 *  //用户控制器
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/web/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/testlogin.do")
	public HigherReaponse<Users> testadmin(HttpServletRequest request){
		HttpSession session = request.getSession();
		Users attribute = (Users) session.getAttribute("user");
		return HigherReaponse.getHigherReaponseSuccess(attribute);
		
	}
	
	
	//退出登录 
	@RequestMapping("/sigout.do")
	public HigherReaponse<Object> signOut(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.setAttribute("user",null);
		return HigherReaponse.getHigherReaponseSuccess("");
	}
	
//	private String textCode;
	//登录接口 
	@RequestMapping("/login.do")
	public HigherReaponse<Users> login(Users user,HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		HigherReaponse<Users> queryUser = userService.queryUserByUserNameAndPwd(user,session);
		return queryUser;
	}
	
	//用户分页 
	@RequestMapping("/list.do")
	public HigherReaponse<Object> pageUserList(@RequestParam(required = true,defaultValue = "1") Integer pageNum, @RequestParam(required = true,defaultValue = "4")Integer pageSize){
		return userService.pageQueryUser(pageNum, pageSize);
	}
	
	 /**
	  * 获取验证码
	  * @param req
	  * @param resp
	  * @return
	  */
	@RequestMapping("/getCode.do")
    @ResponseBody
    public void getCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
       /*
        1.生成验证码
        2.把验证码上的文本存在session中
        3.把验证码图片发送给客户端
        */
		CodeUtil ivc = new CodeUtil();     //用我们的验证码类，生成验证码类对象
		BufferedImage image = ivc.getImage();  //获取验证码
		request.getSession().setAttribute("textCode", ivc.getText()); //将验证码的文本存在session中 
		ivc.output(image, response.getOutputStream());//将验证码图片响应给客户端
    }
	@RequestMapping("/verificationCode.do")
	public HigherReaponse<String> verificationCode(@RequestParam("code")String codeString,HttpServletRequest request){
		//验证码 
		HttpSession session = request.getSession();
		String textCode = (String) session.getAttribute("textCode");
		if(null == codeString) {
			return HigherReaponse.getHigherReaponseFailed("请输入验证码...");
		}
		if(!textCode.equalsIgnoreCase(codeString)) {//不区分大小写比较字符串
		return HigherReaponse.getHigherReaponseFailed("验证不正确...");
		}
		return HigherReaponse.getHigherReaponseSuccess("验证成功。");
	}
	
	//注册用户
	@RequestMapping("/reg.do")
	public HigherReaponse<Object> regUser(Users user) throws AddressException, IOException, MessagingException{
		return userService.addUser(user);
		
	}
	
	
	//更新用户
	@RequestMapping("/update_user.do")
	public HigherReaponse<Object> updateUser(Users user){
		
		return userService.updUser(user);
		
	}
	//激活账户 
	@RequestMapping("/isactivate.do")
	public String isactivate(Users user){
		user.setUses_isactivate(1);
		 System.out.println("Controller激活账户"+user.toString());
		 userService.isactivate(user);
		 return "<!DOCTYPE html>\r\n" + 
		 		"<html>\r\n" + 
		 		"<head>\r\n" + 
		 		"<meta charset=\"gbk\">\r\n" + 
		 		"<title>Insert title here</title>\r\n" + 
		 		"</head>\r\n" + 
		 		"<body>\r\n" + 
		 		"	<h3 style='color:green;font-size: 30px;'><center>Account activation succeeded</center></h3>\r\n" + 
		 		"</body>\r\n" + 
		 		"</html>";
		
	}
	
	
	
	
	
	
	
}
