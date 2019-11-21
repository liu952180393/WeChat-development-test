package com.example.demo.TestController;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.controller.PushController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Testtest {

	    @Autowired
	    PushController testController;

	    @Test
	    public void push() {
	        testController.push();
	    }
	}
