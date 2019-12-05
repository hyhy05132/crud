package com.cos.crud.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Post {

	private int id;
	private String title;
	private String content;
	private int userId;// fk
	
	private Timestamp createDate;
	
}
