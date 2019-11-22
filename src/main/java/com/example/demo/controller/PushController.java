package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
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
			
			 List<WxMpTemplateData> templateDataList = new ArrayList<>(2);
			 WxMpTemplateData data1 = new WxMpTemplateData("keyword1", "你好，很高兴认识你！");
			 WxMpTemplateData data2 = new WxMpTemplateData("keyword2", "439602");
		        templateDataList.add(data1);
		        templateDataList.add(data2);
			
			//2,推送消息
			WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
					.data(templateDataList)
					.toUser("oosPTvrVcpQmZVSs7hcwnfjbxloU")//要推送的用户openid
					.templateId("urJ76xTH3NiXI_yuuoL1FbdrJBWqmxKqQLIaC0D6JYQ")//模版id
					.url("https://baidu.com/")//点击模版消息要访问的网址
					.build();
			
			try {
				String msg = wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
				System.out.println("推送成功！"+msg);
			} catch (Exception e) {
				System.out.println("推送失败：" + e.getMessage());
				e.printStackTrace();
			}

		}
		
	  @ResponseBody
	  @RequestMapping("/hello")
	  public String hello() { return "hello"; }
	}
