package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{
	private static final long serialVersionUID = 8037415525611733265L;
	private Integer id;
	private String nickName;
	private String title;
	private String content;
	private Date createTime;
	
}
