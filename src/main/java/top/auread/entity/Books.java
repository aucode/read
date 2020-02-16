package top.auread.entity;

import lombok.Data;

@Data
public class Books {
	private Integer id ;//int  auto_increment primary key comment 'id唯一值',
	private String books_title;// varchar(50) comment '书名',
	private String books_time;// varchar(50) comment '创建时间',
	private String author;// varchar(50) comment '作者',
	private String books_Introduction;//	text comment '简介',
	private Integer books_action;// int comment '状态，❨1连载中，0完结❩',
	private Integer books_count;// int comment '点击次数',
	private Integer collect_count;// int comment '收藏次数',
	private Integer users_id;// comment '用户id',
	private String booksinfo_id;// int comment '图片',
	private Integer category_id;// int	comment '类别id'
	
	
	
	
	public Books() {
	}




	public Books(Integer id, String books_title, String books_time, String books_Introduction, Integer books_action,
			Integer books_count, Integer collect_count, Integer users_id, String booksinfo_id, Integer category_id) {
		super();
		this.id = id;
		this.books_title = books_title;
		this.books_time = books_time;
		this.books_Introduction = books_Introduction;
		this.books_action = books_action;
		this.books_count = books_count;
		this.collect_count = collect_count;
		this.users_id = users_id;
		this.booksinfo_id = booksinfo_id;
		this.category_id = category_id;
	}
	
	
	
	
	
	
	
	
	
	
	
}
