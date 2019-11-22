package com.example.demo.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.assertj.core.util.Arrays;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.util.HttpClientUtil;

@RestController
@RequestMapping("/wxAuth")
public class WXLoginController {

    @RequestMapping("/login")
    public void wxLogin(HttpServletResponse response) throws IOException {
        //请求获取code的回调地址
        //用内网穿透
        String callBack = "http://dc1ded5f.ngrok.io/wxAuth/callBack";
        //请求地址
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize" +
                "?appid=" + "wxa960b5e0bc47dbcd" +
                "&redirect_uri=" + URLEncoder.encode(callBack) +
                "&response_type=code" +
                "&scope=snsapi_userinfo" +
                "&state=STATE#wechat_redirect";
        //重定向
        response.sendRedirect(url);
    }
    
    @RequestMapping("/callBack")
    public void wxCallBack(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String code = request.getParameter("code");

		//获取access_token
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token" +
                "?appid=" + "wxa960b5e0bc47dbcd" +
                "&secret=" + "096acbbb560a369fc24cc67ebb683eb0" +
                "&code=" + code +
                "&grant_type=authorization_code";

        String result = HttpClientUtil.doGet(url);

        System.out.println("请求获取access_token:" + result);
		//返回结果的json对象
        JSONObject resultObject = JSON.parseObject(result);

		//请求获取userInfo
        String infoUrl = "https://api.weixin.qq.com/sns/userinfo" +
                "?access_token=" + resultObject.getString("access_token") +
                "&openid=" + resultObject.getString("openid") +
                "&lang=zh_CN";

        String resultInfo = HttpClientUtil.doGet(infoUrl);

		//此时已获取到userInfo，再根据业务进行处理
        System.out.println("请求获取userInfo:" + resultInfo);
        System.out.println("openid="+resultObject.getString("openid"));
    }
}