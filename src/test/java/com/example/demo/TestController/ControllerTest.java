package com.example.demo.TestController;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.UserService;
import com.example.demo.vo.JsonResult;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTest {
	@Autowired
	private UserService userService;
	@Test
	@GetMapping("doFindUser")
	public void doFindUser() {
		System.out.println(new JsonResult(userService.findById(1)));
	}
}
