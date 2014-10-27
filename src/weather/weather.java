package weather;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class weather {
private static String SERVICES_HOST = "www.webxml.com.cn";

private static String WEATHER_SERVICES_URL = "http://webservice.webxml.com.cn/WebServices/WeatherWS.asmx/";

private static String WEATHER_QUERY_URL = WEATHER_SERVICES_URL + "getWeather?theUserID=&theCityCode=";

private static int CITICODE = 1954;

public static void main(String[] args) throws Exception {
 String desc = "今天是" +DateUtils.getYear() + "," + DateUtils.getWeekOfDate(new Date());
 desc += new weather().getWeatherStr();
 System.out.println(desc);
 }

public InputStream getSoapInputStream(String url) {
 InputStream inputStream = null;
 try {
 URL urlObj = new URL(url);
 URLConnection urlConn = urlObj.openConnection();
 urlConn.setRequestProperty("Host", SERVICES_HOST); // 具体webService相关
urlConn.connect();
 inputStream = urlConn.getInputStream();
 } catch (MalformedURLException e) {
 e.printStackTrace();
 } catch (IOException e) {
 e.printStackTrace();
 }
 return inputStream;
 }

public String getWeatherStr() {
 String desc = "";
 try {
 List<String> weatherList = getWeather(CITICODE);

if (weatherList != null && weatherList.size() > 7) {
 String tianqi = weatherList.get(7);
 if (tianqi.contains("日")) {
tianqi = tianqi.substring(tianqi.indexOf("日") + 1);
 }
 String wendu = weatherList.get(8);
 desc += ",天气" + tianqi;
 desc += " ,";
 desc += wendu.replace("℃", "度").replace("/", "--");
 }
 } catch (Exception e) {
 e.printStackTrace();
 return desc;
 }
 return desc;
 }

public List<String> getWeather(int cityCode) {
 List<String> weatherList = new ArrayList<String>();
 Document document;
 DocumentBuilderFactory documentBF = DocumentBuilderFactory.newInstance();
 documentBF.setNamespaceAware(true);
 try {
 DocumentBuilder documentB = documentBF.newDocumentBuilder();
 InputStream inputStream = getSoapInputStream(WEATHER_QUERY_URL + cityCode);
 document = documentB.parse(inputStream);
 NodeList nl = document.getElementsByTagName("string");
 int len = nl.getLength();
 for (int i = 0; i < len; i++) {
 Node n = nl.item(i);
 String weather = n.getFirstChild().getNodeValue();
 weatherList.add(weather);
 }
 inputStream.close();
 } catch (UnsupportedEncodingException e) {
 e.printStackTrace();
 } catch (DOMException e) {
 e.printStackTrace();
 } catch (ParserConfigurationException e) {
 e.printStackTrace();
 } catch (SAXException e) {
 e.printStackTrace();
 } catch (IOException e) {
 e.printStackTrace();
 }
 return weatherList;
 }
}

