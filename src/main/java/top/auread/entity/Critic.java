package top.auread.entity;

import lombok.Data;

/***
 * # tb_critic 评论表
 * @author Administrator
 *
 */
@Data
public class Critic {

	
	private Integer id;// int  auto_increment primary key comment 'id唯一值',
	private Integer books_id;//  longtext  comment '书籍id',
	private Integer user_id;//  int comment '用户名',
	private String user_name;//  int comment '用户名',
	private String critic_context;// longtext comment '评论内容'


	
	public Critic() {
		// TODO Auto-generated constructor stub
	}



	public Critic(Integer id, Integer books_id, Integer user_id, String user_name, String critic_context) {
		this.id = id;
		this.books_id = books_id;
		this.user_id = user_id;
		this.user_name = user_name;
		this.critic_context = critic_context;
	}




	
	
	
}
