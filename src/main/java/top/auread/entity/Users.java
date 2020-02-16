package top.auread.entity;

import lombok.Data;

/**
 * User 实体类
 * @author Administrator
 * 
 */

//注解 @Data 自动生成get set 方法
@Data
public class Users {
	
	
	
	@Override
	public String toString() {
		return "Users [uses_id=" + uses_id + ", uses_name=" + uses_name + ", uses_password=" + uses_password
				+ ", uses_mail=" + uses_mail + ", uses_isactivate=" + uses_isactivate + ", sex=" + sex
				+ ", uses_birthday=" + uses_birthday + "]";
	}

	public Users(Integer uses_id, String uses_name, String uses_password, String uses_mail, Integer uses_isactivate,
			String sex, String uses_birthday) {
		super();
		this.uses_id = uses_id;
		this.uses_name = uses_name;
		this.uses_password = uses_password;
		this.uses_mail = uses_mail;
		this.uses_isactivate = uses_isactivate;
		this.sex = sex;
		this.uses_birthday = uses_birthday;
	}

	public Users() {
		
	}
	
	private Integer uses_id;
	
	private String uses_name;
	
	private String uses_password;
	
	private String uses_mail;// varchar(50) comment '邮箱',
	
	private Integer uses_isactivate;// int comment '是否激活❨0未激活，1激活❩',
	
	private String sex;//int comment '性别',
	
	private String uses_birthday;// varchar(50) comment '注册时间'
	
}
