package com.caramel.apple.comments;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.caramel.apple.post.Post;
import com.caramel.apple.user.Users;

import lombok.Data;

@Entity
@Table (name = "comnts", schema = "public")
public @Data class Comments {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "contnt")
	private String content;
	
	@Column(name = "dat")
	private String date;
	
	@ManyToOne
	@JoinColumn(name = "userid")
	private Users user;
	
	@ManyToOne
	@JoinColumn(name = "postid")
	private Post post;
	
	

}
