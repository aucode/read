package top.auread.entity;

import lombok.Data;

@Data
public class Booksinfo {

	
	
	private Integer id;// int  auto_increment primary key comment 'id唯一值',
	private String booksinfo_title;//  longtext  comment '内容',
	private String booksinfo_context;//  longtext  comment '内容',
	private Integer books_id;// int comment '书籍id,',
	private Integer users_id;// int comment '用户id,'
	
	
	
	
	
	
	public Booksinfo() {
	}






	public Booksinfo(Integer id, String booksinfo_title, String booksinfo_context, Integer books_id, Integer users_id) {
		super();
		this.id = id;
		this.booksinfo_title = booksinfo_title;
		this.booksinfo_context = booksinfo_context;
		this.books_id = books_id;
		this.users_id = users_id;
	}






	
	
	
	
	
	
	
	
}
