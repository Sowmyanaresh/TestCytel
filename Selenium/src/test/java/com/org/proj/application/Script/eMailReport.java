package com.org.proj.application.Script;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class eMailReport {
	public static void EmailWithReport(String m_hostName, int m_portSMTP, String m_username, String m_password, String m_senderEmailId, String m_emailSubject, String m_emailMessage, String m_reportPath, String m_receiverEmailId) throws Exception
{

	try{
		  // Create the attachment
	  EmailAttachment attachment = new EmailAttachment();

	  attachment.setPath(m_reportPath);
	  attachment.setDisposition(EmailAttachment.ATTACHMENT);
	  attachment.setDescription("Test results report");
	  attachment.setName("OpenMRS Automated Execution Report.html");
		
	  	MultiPartEmail  email = new MultiPartEmail();
		email.setHostName(m_hostName);
		email.setSmtpPort(m_portSMTP);
		email.setAuthenticator(new DefaultAuthenticator(m_username, m_password));
		email.setSSLOnConnect(true);
		email.setFrom(m_senderEmailId);
		email.setSubject(m_emailSubject);

		email.setMsg(m_emailMessage);
		//email.setMsg(m_reportPath);
		email.addTo(m_receiverEmailId);
		// add the attachment
		email.attach(attachment);
		//Send email 
		email.send();
		System.out.print("Email send successfully");
	//	logger4j.info("Send email with test report="+m_emailSubject);
		
	}catch(Exception e){
	//	logger4j.error("sendEmailOfReport has thrown exception");
			e.printStackTrace();
	}
}

}
