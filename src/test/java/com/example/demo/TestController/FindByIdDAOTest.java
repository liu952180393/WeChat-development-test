package com.example.demo.TestController;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.vo.UserVo;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FindByIdDAOTest {
	
	@Autowired 
	private UserDao userDao;
	
	@Test
	public void findByOpendID() {
		List<UserVo> list = 
		userDao.findById(1);
				System.out.println(list);
	}
}
