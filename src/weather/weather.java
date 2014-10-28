package weather;

import java.util.Iterator;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException; 
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.opensymphony.xwork2.ActionSupport;
import weather.WeatherUtil;

public class weather extends ActionSupport {
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String showdate;
	private String showweather;
	private String showwind;
	private String showtem;
	private String set;
	 
	public String getShowdate() {
		return showdate;
	}
	public void setShowdate(String showdate) {
		this.showdate = showdate;
	}
	public String getShowweather() {
		return showweather;
	}
	public void setShowweather(String showweather) {
		this.showweather = showweather;
	}
	public String getShowwind() {
		return showwind;
	}
	public void setShowwind(String showwind) {
		this.showwind = showwind;
	}
	public String getShowtem() {
		return showtem;
	}
	public void setShowtem(String showtem) {
		this.showtem = showtem;
	}
	public String getSet() {
		return set;
	}
	public void setSet(String set) {
		this.set = set;
	}
	public String execute() throws IOException{
	        try { 
	        	set = GetWeather("三亚").toString();//这个地方变量的取值有问题
	        } catch (NullPointerException e) {
	            e.printStackTrace(); 
	        }
		  return SUCCESS;
	}
	//获取天气信息
		public static String GetWeather(String city) {
	    WeatherUtil wu=new WeatherUtil();
	    String buffstr=null;
	    try {
	        String xml= wu.GetXmlCode(URLEncoder.encode(city, "utf-8"));  //设置输入城市的编码，以满足百度天气api需要
	        buffstr=wu.readStringXml(xml,city);//调用xml解析函数
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    	return  buffstr;
	    }
		
	    public String GetXmlCode(String city) throws UnsupportedEncodingException{
		    String requestUrl = "http://api.map.baidu.com/telematics/v3/weather?location="+city+"&output=xml&ak=5cc3366cfa09aeaff2c049c79f797abf";  
		    StringBuffer buffer = null;  
		    try {  
			    // 建立连接  
			    URL url = new URL(requestUrl);
			    HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();  
			    httpUrlConn.setDoInput(true);  
			    httpUrlConn.setRequestMethod("GET");
			    System.out.println("建立连接");
			    // 获取输入流  
			    InputStream inputStream = httpUrlConn.getInputStream();  
			    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");  
			    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			    System.out.println("获取输入流");
			    // 读取返回结果  
			    buffer = new StringBuffer();  
			    String str = null;  
			    while ((str = bufferedReader.readLine()) != null) {  
			      buffer.append(str);
			    } 
			    System.out.println("读取返回结果");
			  
			    // 释放资源  
			    bufferedReader.close();  
			    inputStreamReader.close();  
			    inputStream.close();  
			    httpUrlConn.disconnect();  
		    } catch (Exception e) {  
		    e.printStackTrace();  
		    }  
		    System.out.println("返回字符串");
		    return buffer.toString();  //返回获取的xml字符串
	    }
	    
	    public String readStringXml(String xml,String ifcity) {
			StringBuffer buff=new StringBuffer();  //用来拼接天气信息的
			Document doc = null;
			List listdate=null;  //日期及实时天气
			List listweather=null;//文字信息
			List listwind=null;//风力
			List listtem=null;//温度
			try {
		    doc = DocumentHelper.parseText(xml); // 将字符串转为XML  
		    Element rootElt = doc.getRootElement(); // 获取根节点    
		    Iterator iter = rootElt.elementIterator("results"); // 获取根节点下的子节点results
		    String status=rootElt.elementText("status"); //获取状态，如果等于success,表示有数据
		    if(!status.equals("success"))
		    	return "暂无数据";  //如果不存在数据，直接返回
		    String date= rootElt.elementText("date");  //获取根节点下的，当天日期
		    buff.append(date+"\n");
		    //遍历results节点
			while (iter.hasNext()) {
				Element recordEle = (Element) iter.next();
				Iterator iters = recordEle.elementIterator("weather_data"); //
			    //遍历results节点下的weather_data节点
				while (iters.hasNext()) {
			        Element itemEle = (Element) iters.next();  
			        listdate=itemEle.elements("date");
			    	//将date集合放到listdate中
			        listweather=itemEle.elements("weather");
			        listwind=itemEle.elements("wind");
			        listtem=itemEle.elements("temperature");
				}
			  	for(int i=0;i<listdate.size();i++){  //由于每一个list.size都相等，这里统一处理
			    	Element eledate=(Element)listdate.get(i); //依次取出date
			    	Element eleweather=(Element)listweather.get(i);
			    	Element elewind=(Element)listwind.get(i);
			    	Element eletem=(Element)listtem.get(i);
			    	buff.append(eledate.getText()+" "+eleweather.getText()+" "+elewind.getText()+" "+eletem.getText()+"\n");  //拼接信息
			    } 
//				Element eledate=(Element)listdate.get(0); //依次取出今日天气数据
//		    	Element eleweather=(Element)listweather.get(0);
//		    	Element elewind=(Element)listwind.get(0);
//		    	Element eletem=(Element)listtem.get(0);
//			  	showdate = eledate.getText();System.out.println(showdate);
//			  	showweather = eleweather.getText();System.out.println(showweather);
//			  	showwind = elewind.getText();System.out.println(showwind);
//			  	showtem = eletem.getText();System.out.println(showtem);
		    }
		    } catch (DocumentException e) {
		    	e.printStackTrace();
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
		    	return buff.toString();  
	    }

		public static void main(String[] args) throws IOException{
			//测试
			System.out.println(GetWeather("三亚").toString());
		}
}	 


