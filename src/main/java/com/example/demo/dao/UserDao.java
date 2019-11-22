package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.vo.UserVo;


@Mapper
public interface UserDao {
	@Select("select * from login where id=#{id}")
	List<UserVo> findById(int id);
}
