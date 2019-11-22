package com.example.demo.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo implements Serializable{
	private static final long serialVersionUID = 9062618162414195268L;
	private Integer id;
	private String nickName;
	private String title;
	private String content;
	private Date createTime;
}
