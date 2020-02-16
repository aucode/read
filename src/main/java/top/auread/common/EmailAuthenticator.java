package top.auread.common;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 *	邮箱的封装账号密码的类
 * @author Administrator
 *
 */
public class EmailAuthenticator extends Authenticator{

	String userName = null;
    String password = null;
    
    
    public EmailAuthenticator() {
    }
    
    public EmailAuthenticator(String username, String password) {
        this.userName = username;
        this.password = password;
    }
    
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(userName, password);
    }
}
