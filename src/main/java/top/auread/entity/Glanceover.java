package top.auread.entity;

import lombok.Data;

/**
 * 浏览记录表
 * @author Administrator
 *
 */
@Data
public class Glanceover {

	
	
	
	private Integer id;// int auto_increment primary key comment 'id唯一值',
	private Integer users_id;// int comment '用户id',
	private Integer books_id;// int comment '书籍id',
	private String books_title;// varchar(50)	comment '书籍名',
	private Integer booksinfo_id;// int comment '观看到第几章节'
	public Glanceover(Integer id, Integer users_id, Integer books_id, String books_title, Integer booksinfo_id) {
		this.id = id;
		this.users_id = users_id;
		this.books_id = books_id;
		this.books_title = books_title;
		this.booksinfo_id = booksinfo_id;
	}
	public Glanceover() {
		
	}
	
	
	
}
