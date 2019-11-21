package com.example.demo.TestController;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Service {
	@Autowired
	private UserService userService;
	@Test
	public void testFindById() {
		User user = 
		userService.findById(1);
		System.out.println(user);
	}
}
