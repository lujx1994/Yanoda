package com.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class WeatherUtil {
	
	String showdate;
  	String showweather;
  	String showwind;
  	String showtem;
  	String dataset;

    public String getShowdate() {
		return showdate;
	}
	public String getShowweather() {
		return showweather;
	}
	public String getShowwind() {
		return showwind;
	}
	public String getShowtem() {
		return showtem;
	}
    public String getDataset() {
		return dataset;
	}

	public static String GetWeather(String city) {
    WeatherUtil wu=new WeatherUtil();
    String buffstr=null;
    try {
        String xml= wu.GetXmlCode(URLEncoder.encode(city, "utf-8"));
        buffstr=wu.readStringXml(xml,city);
    } catch (Exception e) {
    	e.printStackTrace();
    }
    	return  buffstr;
    }
	
    public String GetXmlCode(String city) throws UnsupportedEncodingException{
	    String requestUrl = "http://api.map.baidu.com/telematics/v3/weather?location="+city+"&output=xml&ak=5cc3366cfa09aeaff2c049c79f797abf";  
	    StringBuffer buffer = null;  
	    try {  
	    URL url = new URL(requestUrl);
	    HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();  
	    httpUrlConn.setDoInput(true);  
	    httpUrlConn.setRequestMethod("GET");  
	    InputStream inputStream = httpUrlConn.getInputStream();  
	    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");  
	    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  
	    buffer = new StringBuffer();  
	    String str = null;  
	    while ((str = bufferedReader.readLine()) != null) {  
	      buffer.append(str);  
	    }  
	    bufferedReader.close();  
	    inputStreamReader.close();  
	    inputStream.close();  
	    httpUrlConn.disconnect();  
	    } catch (Exception e) {  
	    e.printStackTrace();  
	    }  
	    return buffer.toString();
    }
    
    public String readStringXml(String xml,String ifcity) {
		StringBuffer buff=new StringBuffer();
		Document doc = null;
		List listdate=null;
		List listweather=null;
		List listwind=null;
		List listtem=null;
		try {
	    doc = DocumentHelper.parseText(xml);
	    Element rootElt = doc.getRootElement();  
	    Iterator iter = rootElt.elementIterator("results");
	    String status=rootElt.elementText("status");
	    if(!status.equals("success"))
	    	return "success";
	    String date= rootElt.elementText("date");
	    buff.append(date+"\n");
		while (iter.hasNext()) {
			Element recordEle = (Element) iter.next();
			Iterator iters = recordEle.elementIterator("weather_data");
			while (iters.hasNext()) {
		        Element itemEle = (Element) iters.next();  
		        listdate=itemEle.elements("date");
		        listweather=itemEle.elements("weather");
		        listwind=itemEle.elements("wind");
		        listtem=itemEle.elements("temperature");
			}
			Element eledate=(Element)listdate.get(0);
	    	Element eleweather=(Element)listweather.get(0);
	    	Element elewind=(Element)listwind.get(0);
	    	Element eletem=(Element)listtem.get(0);
		  	showdate = eledate.getText();System.out.println(showdate);
		  	showweather = eleweather.getText();System.out.println(showweather);
		  	showwind = elewind.getText();System.out.println(showwind);
		  	showtem = eletem.getText();System.out.println(showtem);
		  	HttpSession session = ServletActionContext.getRequest().getSession();
		  	session.setAttribute("date", showdate);
		  	session.setAttribute("showweather", showweather);
		  	session.setAttribute("showwind", showwind);
		  	session.setAttribute("showtem", showtem);
	    }
	    } catch (DocumentException e) {
	    	e.printStackTrace();
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    	return buff.toString();  
    }
}


