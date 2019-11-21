package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

@RestController
public class PushController {
		/*
		 * 微信测试账号推送
		 * */
		@GetMapping("/push")
		public void push() {
			//1，配置
			WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
			wxStorage.setAppId("wxa960b5e0bc47dbcd");
			wxStorage.setSecret("096acbbb560a369fc24cc67ebb683eb0");
			WxMpService wxMpService = new WxMpServiceImpl();
			wxMpService.setWxMpConfigStorage(wxStorage);

			//2,推送消息
			WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
					.toUser("oosPTvrVcpQmZVSs7hcwnfjbxloU")//要推送的用户openid
					.templateId("niE00kikHUvBK-FvcJiRQn12D_pMPZmFlzSqUqYX2Pg")//模版id
					.url("https://baidu.com/")//点击模版消息要访问的网址
					.build();
			try {
				wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
				System.out.println("推送成功！"+templateMessage.getUrl());
			} catch (Exception e) {
				System.out.println("推送失败：" + e.getMessage());
				e.printStackTrace();
			}

		}
		
	
	  @ResponseBody
	  @RequestMapping("/hello") 
	  public String hello() { return "hello"; }
	 

	}
