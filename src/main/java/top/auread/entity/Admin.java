package top.auread.entity;

import lombok.Data;

/**
 * 管理员实体类
 * @author Administrator
 *
 */
@Data
public class Admin {
	
	
	public Admin() {
		
	}
	
	
	public Admin(Integer admin_id, String admin_name, String admin_password, Integer admin_authority,
			String admin_birthday) {
		super();
		this.admin_id = admin_id;
		this.admin_name = admin_name;
		this.admin_password = admin_password;
		this.admin_authority = admin_authority;
		this.admin_birthday = admin_birthday;
	}


	private Integer admin_id ;//int auto_increment primary key comment '管理员id唯一值',
	private String admin_name ;//varchar(50) comment '管理员昵称',
	private String admin_password ;//varchar(50) comment '管理员密码',
	private Integer admin_authority ;//int comment '权限1正常，0移除',
	private String admin_birthday ;//varchar(50) comment '注册时间'
	
}
