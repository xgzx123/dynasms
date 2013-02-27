package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.opensymphony.xwork2.ActionSupport;

public class SMSMessageHandler extends ActionSupport {
	
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		if(echostr != null){
			message = echostr;
			return "message";
		}else{
			SAXReader reader = new SAXReader();  
		    try {  
		        Document doc = reader.read(request.getInputStream());  
		        Node root = doc.selectSingleNode("/books");  
		        List list = root.selectNodes("book[@url='dom4j.com']");  
		         
		        for(Object o:list){  
		             
		            Element e = (Element) o;  
		            String show=e.attributeValue("show");  
		            System.out.println("show = " + show);  
		        }  
		        
		    } catch (Exception e) {  
		        e.printStackTrace();  
		    }  
		    message = "success";
			return "message";
		}
		
		
    }

    /**
     * Provide default valuie for Message property.
     */
    public static final String MESSAGE = "HelloWorld.message";

    /**
     * Field for Message property.
     */
    private String message;

    /**
     * Return Message property.
     *
     * @return Message property
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set Message property.
     *
     * @param message Text to display on HelloWorld page.
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
