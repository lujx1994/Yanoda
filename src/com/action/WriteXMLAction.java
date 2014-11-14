package com.action;
 
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 







import org.apache.struts2.ServletActionContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.dao.FormDao;
import com.dao.UserDao;
import com.entity.Form;
import com.entity.Tuser;
import com.opensymphony.xwork2.ActionSupport;
import com.service.SMS;
 
public class WriteXMLAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String reportName;
	private String reportPerson;
	private String reportText;
	private String uploadFileFileName;
	private String xmldownload;

	public String getXmldownload() {
		return xmldownload;
	}
	public void setXmldownload(String xmldownload) {
		this.xmldownload = xmldownload;
	}
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public String getReportPerson() {
		return reportPerson;
	}
	public void setReportPerson(String reportPerson) {
		this.reportPerson = reportPerson;
	}
	public String getReportText() {
		return reportText;
	}
	public void setReportText(String reportText) {
		this.reportText = reportText;
	}

	public String writeXMLFile(){
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		String username = (String) session.getAttribute("username");	
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String uploadFileDate = simpleDateFormat.format(date);
		uploadFileFileName = username + uploadFileDate + ".xml";
		try {
 
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
 
		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("report");
		doc.appendChild(rootElement);
 
		// staff elements
		Element reportperson = doc.createElement("reportperson");
		reportperson.appendChild(doc.createTextNode(reportPerson));
		rootElement.appendChild(reportperson);
		
		Element reportname = doc.createElement("reportname");
		reportname.appendChild(doc.createTextNode(reportName));
		rootElement.appendChild(reportname);
		
		Element reporttext = doc.createElement("reporttext");
		reporttext.appendChild(doc.createTextNode(reportText));
		rootElement.appendChild(reporttext);
 
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		File checkFile = new File("C:\\Users\\Junxing\\Documents\\GitHub\\Yanoda\\WebContent\\XMLstorage\\"+uploadFileFileName);
		if (checkFile.exists()){
			checkFile.delete();
			StreamResult result = new StreamResult(new File("C:\\Users\\Junxing\\Documents\\GitHub\\Yanoda\\WebContent\\XMLstorage\\"+uploadFileFileName));
			transformer.transform(source, result);
			new FormDao().updateFormConfirm(uploadFileFileName);
			this.addFieldError("uploadError", "操作成功");
			return SUCCESS;
		}
		else {
		StreamResult result = new StreamResult(new File("C:\\Users\\Junxing\\Documents\\GitHub\\Yanoda\\WebContent\\XMLstorage\\"+uploadFileFileName));
 
		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);
 
		transformer.transform(source, result);
		System.out.println("File saved!");
		
		String download = "C:\\Users\\Junxing\\Documents\\GitHub\\Yanoda\\WebContent\\XMLstorage\\"+uploadFileFileName;
		Form form = new Form();
		form.setForm_date(uploadFileDate);
		form.setForm_name(uploadFileFileName);
		form.setForm_realpath("C:\\Users\\Junxing\\Documents\\GitHub\\Yanoda\\WebContent\\XMLstorage\\");
		form.setPoster_name(username);
		form.setConfirm(null);
		form.setDownload(download);
		new FormDao().saveForm(form);
		Tuser smsUser = UserDao.getUser(username);
		String higer_users = smsUser.getHiger_users();
		Tuser smsHigh = UserDao.getUser(higer_users);
		String moblieSMS = smsHigh.getMoblie();
			try {
				SMS.send("您下属的报表已提交，请及时审阅。", moblieSMS);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		} catch (ParserConfigurationException pce) {
		pce.printStackTrace();
		} catch (TransformerException tfe) {
		tfe.printStackTrace();
		}
	this.addFieldError("uploadError", "操作成功");
	return SUCCESS;
	}
	
	public String readXML() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("xmldownload", xmldownload);
		return SUCCESS;
		
	}
}