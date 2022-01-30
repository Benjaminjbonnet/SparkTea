package com.caramel.apple.post;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.caramel.apple.user.Users;

import lombok.Data;

@Entity
@Data
@Table (name = "posts", schema = "public")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "contnt")
	private String content;
	
	@Column(name = "dat")
	private String date;
	@Column(name = "username")
	private String username;
	
	@Column(name = "userid")
	private int userid;

	
	
}
