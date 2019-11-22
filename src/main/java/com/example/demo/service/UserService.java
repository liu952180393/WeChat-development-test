package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.UserVo;

public interface UserService {

	List<UserVo> findById(int id);
	
}
