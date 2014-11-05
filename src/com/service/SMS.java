package com.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SMS {

	private static final String addr = "http://api.sms.cn/mt/";
	private static final String userId = "lujx1994";
	
	/*
	 * 如uid是：test，登录密码是：123123 
	   pwd=md5(123123test),即
       pwd=b9887c5ebb23ebb294acab183ecf0769
                  在线生成地址：http://www.sms.cn/password
	 */
	private static final String pwd = "189d2feb40ca6d4b20242d5b56c3a29b";   

	public static void send(String msgContent, String mobile) throws Exception {
		
		//组建请求
		String straddr = addr + 
						"?uid="+userId+
						"&pwd="+pwd+
						"&mobile="+mobile+
						"&content=" + msgContent;
		
		StringBuffer sb = new StringBuffer(straddr);
		System.out.println("URL:"+sb);
		
		//发送请求
		URL url = new URL(sb.toString());
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		BufferedReader in = new BufferedReader(new InputStreamReader(
				url.openStream()));
		
		//返回结果
		String inputline = in.readLine();
		System.out.println("Response:"+inputline);
		
	}
}

