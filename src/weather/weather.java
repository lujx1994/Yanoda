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
	        	set = GetWeather("����").toString();//����ط�������ȡֵ������
	        } catch (NullPointerException e) {
	            e.printStackTrace(); 
	        }
		  return SUCCESS;
	}
	//��ȡ������Ϣ
		public static String GetWeather(String city) {
	    WeatherUtil wu=new WeatherUtil();
	    String buffstr=null;
	    try {
	        String xml= wu.GetXmlCode(URLEncoder.encode(city, "utf-8"));  //����������еı��룬������ٶ�����api��Ҫ
	        buffstr=wu.readStringXml(xml,city);//����xml��������
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    	return  buffstr;
	    }
		
	    public String GetXmlCode(String city) throws UnsupportedEncodingException{
		    String requestUrl = "http://api.map.baidu.com/telematics/v3/weather?location="+city+"&output=xml&ak=5cc3366cfa09aeaff2c049c79f797abf";  
		    StringBuffer buffer = null;  
		    try {  
			    // ��������  
			    URL url = new URL(requestUrl);
			    HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();  
			    httpUrlConn.setDoInput(true);  
			    httpUrlConn.setRequestMethod("GET");
			    System.out.println("��������");
			    // ��ȡ������  
			    InputStream inputStream = httpUrlConn.getInputStream();  
			    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");  
			    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			    System.out.println("��ȡ������");
			    // ��ȡ���ؽ��  
			    buffer = new StringBuffer();  
			    String str = null;  
			    while ((str = bufferedReader.readLine()) != null) {  
			      buffer.append(str);
			    } 
			    System.out.println("��ȡ���ؽ��");
			  
			    // �ͷ���Դ  
			    bufferedReader.close();  
			    inputStreamReader.close();  
			    inputStream.close();  
			    httpUrlConn.disconnect();  
		    } catch (Exception e) {  
		    e.printStackTrace();  
		    }  
		    System.out.println("�����ַ���");
		    return buffer.toString();  //���ػ�ȡ��xml�ַ���
	    }
	    
	    public String readStringXml(String xml,String ifcity) {
			StringBuffer buff=new StringBuffer();  //����ƴ��������Ϣ��
			Document doc = null;
			List listdate=null;  //���ڼ�ʵʱ����
			List listweather=null;//������Ϣ
			List listwind=null;//����
			List listtem=null;//�¶�
			try {
		    doc = DocumentHelper.parseText(xml); // ���ַ���תΪXML  
		    Element rootElt = doc.getRootElement(); // ��ȡ���ڵ�    
		    Iterator iter = rootElt.elementIterator("results"); // ��ȡ���ڵ��µ��ӽڵ�results
		    String status=rootElt.elementText("status"); //��ȡ״̬���������success,��ʾ������
		    if(!status.equals("success"))
		    	return "��������";  //������������ݣ�ֱ�ӷ���
		    String date= rootElt.elementText("date");  //��ȡ���ڵ��µģ���������
		    buff.append(date+"\n");
		    //����results�ڵ�
			while (iter.hasNext()) {
				Element recordEle = (Element) iter.next();
				Iterator iters = recordEle.elementIterator("weather_data"); //
			    //����results�ڵ��µ�weather_data�ڵ�
				while (iters.hasNext()) {
			        Element itemEle = (Element) iters.next();  
			        listdate=itemEle.elements("date");
			    	//��date���Ϸŵ�listdate��
			        listweather=itemEle.elements("weather");
			        listwind=itemEle.elements("wind");
			        listtem=itemEle.elements("temperature");
				}
			  	for(int i=0;i<listdate.size();i++){  //����ÿһ��list.size����ȣ�����ͳһ����
			    	Element eledate=(Element)listdate.get(i); //����ȡ��date
			    	Element eleweather=(Element)listweather.get(i);
			    	Element elewind=(Element)listwind.get(i);
			    	Element eletem=(Element)listtem.get(i);
			    	buff.append(eledate.getText()+" "+eleweather.getText()+" "+elewind.getText()+" "+eletem.getText()+"\n");  //ƴ����Ϣ
			    } 
//				Element eledate=(Element)listdate.get(0); //����ȡ��������������
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
			//����
			System.out.println(GetWeather("����").toString());
		}
}	 


