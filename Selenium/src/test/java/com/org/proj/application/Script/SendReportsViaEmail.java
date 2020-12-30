package com.org.proj.application.Script;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Map;
import java.util.Date;
import java.util.HashMap;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.credential.WebCredentials;
import microsoft.exchange.webservices.data.property.complex.MessageBody;
import microsoft.exchange.webservices.data.property.complex.EmailAddress;
import microsoft.exchange.webservices.data.core.service.item.EmailMessage;
import microsoft.exchange.webservices.data.credential.ExchangeCredentials;
import microsoft.exchange.webservices.data.core.enumeration.misc.ExchangeVersion;

public class SendReportsViaEmail {

	public static String getExecutionTime(String startDate, String endDate) throws ParseException{
		
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss z");
        Date fromDate = sdf.parse(startDate);
        Date toDate = sdf.parse(endDate);

        long diff = toDate.getTime() - fromDate.getTime();
        String dateFormat="";
        int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
        if(diffDays>0){
            dateFormat += diffDays +"d ";
        }
        diff -= diffDays * (24 * 60 * 60 * 1000);

        int diffhours = (int) (diff / (60 * 60 * 1000));
        if(diffhours>0){
            dateFormat+=diffhours+"h ";
        }
        diff -= diffhours * (60 * 60 * 1000);

        int diffmin = (int) (diff / (60 * 1000));
        if(diffmin>0){
            dateFormat+=diffmin+"m ";
        }
        diff -= diffmin * (60 * 1000);

        int diffsec = (int) (diff / (1000));
        if(diffsec>0){
            dateFormat+=diffsec+"s";
        }
       // System.out.println(dateFormat);
		
		return dateFormat;
	}
	
	public static HashMap<String, Integer> getFilesListFromFolder(String folderName){
		
		File folder = new File(folderName);
		File[] listOfFiles = folder.listFiles();
		HashMap<String, String> results = new HashMap<String, String>();
		for (File file : listOfFiles) {
		    if (file.isFile()) {
		    	String fileName = file.getName();
		    	if(fileName.endsWith(".html")) {
		    		HashMap<String, String> info = getTestResultsDetails(folderName + "/" + fileName);
		    		if(results.size() > 0){
		    			for(Map.Entry<String, String> entry : info.entrySet()){
		    				String key = entry.getKey();
		    				String value = entry.getValue();
		    				results.put(key, value);
		    			}
		    		}else results.putAll(info);
		    	}
		    }
		}
		
		HashMap<String, Integer> resultsFinal = new HashMap<String, Integer>();
		for(Map.Entry<String, String> entry : results.entrySet()){
			String value = entry.getValue();
			if(resultsFinal.containsKey(value))resultsFinal.put(value, (resultsFinal.get(value)+1));
			else resultsFinal.put(value, 1);
		}
		return resultsFinal;
	}
	
	public static HashMap<String, String> getTestResultsDetails(String fileName) {
		
		HashMap<String, String> testCases = new HashMap<String, String>();
		try {
	    	int count = 0;
	        BufferedReader in = new BufferedReader(new FileReader(fileName));
	        String str;
	        String testCase = "";
	        while ((str = in.readLine()) != null) {
	        	str = str.replaceAll("^\\s+", "");
	        	if(str.trim().contains("<span class='test-name'>") ||  str.trim().contains("<span class='test-status label right outline capitalize")){
	            	if(str.trim().contains("<span class='test-name'>")){
	            		count = count + 1;
	            		str = str.replaceAll("<span class='test-name'>","");
	            		testCase = str.replaceAll("</span>","").trim();
	            	}else {
	            		str =str.replace("</span>", "").trim();
	            		str =str.substring(str.indexOf(">")+1,  str.length());
	            		if(!testCase.equals(""))testCases.put(testCase, str);
	            	}
	            }
	         }
	        in.close();
	    } catch (IOException e) {
	    	//logger.error(className, "Unable to read contents from '" + fileName + "'.\n" + ExceptionUtils.getStackTrace(e));
	    }
		return testCases;
	}
	
	
	public static String getPercentageAsString(int status, int total){
		
		String percentage = "";
		double val = (double) (status * 100)/total;
		if(String.valueOf(val).endsWith(".00") || String.valueOf(val).endsWith(".0"))percentage = String.valueOf(val).substring(0, String.valueOf(val).indexOf("."));
		else percentage = String.valueOf(val);
		percentage = percentage + "%";
		return percentage;
	}
	
	
	public static boolean sendEmail(HashMap<String, Object> info, String subject, String bodyContent, String to, String cc, String applicationName) throws Exception {
        
		int passed = 0, failed = 0, warning = 0, error = 0, unknown = 0;
		String endedAt = info.get("endedAt").toString();
		String startedAt = info.get("startedAt").toString();
		String executionTime = getExecutionTime(startedAt, endedAt);
		String reportsLocation = info.get("reportsLocation").toString();
		int executed = Integer.parseInt(info.get("executed").toString());
		int totalTestCases = Integer.parseInt(info.get("total").toString());
		
		HashMap<String, Integer> executionResults = getFilesListFromFolder(reportsLocation);
		if(executionResults.containsKey("pass"))passed = executionResults.get("pass");
		if(executionResults.containsKey("fail"))failed = executionResults.get("fail");
		if(executionResults.containsKey("warning"))warning = executionResults.get("warning");
		if(executionResults.containsKey("error"))error = executionResults.get("error");
		if(executionResults.containsKey("unknown"))unknown = executionResults.get("unknown");
		
		String passedPercentage = "", failedPercentage = "", skippedPercentage = "", waringPercentage = "", errorPercentage = "", unknownPercentage = "";
		if(passed > 0) passedPercentage = getPercentageAsString(passed, totalTestCases);
		if(failed > 0) failedPercentage = getPercentageAsString(failed, totalTestCases);
		if(warning > 0) waringPercentage = getPercentageAsString(warning, totalTestCases);
		if(error > 0) errorPercentage =     getPercentageAsString(error, totalTestCases);  
		if(unknown > 0) unknownPercentage = getPercentageAsString(unknown, totalTestCases);
		if((totalTestCases - executed) > 0) skippedPercentage = getPercentageAsString((totalTestCases - executed), totalTestCases);
	
		String reportName = reportsLocation + "//ExecutionReports.zip";
		ZipReportsFolder.zipExecutionReports(reportName, reportsLocation);
		Thread.sleep(2000);
    	try{
    		
        	ExchangeService service = new ExchangeService(ExchangeVersion.Exchange2010_SP2);
    		EmailMessage msg = null;
    		ExchangeCredentials credentials = null;
    		String domain = GlobalVariables.g_Domain;
    		credentials =new WebCredentials(GlobalVariables.g_Mailusername,GlobalVariables.g_MailPaswword,domain);   
    		service.setCredentials(credentials);
    		service.setUrl(new URI(GlobalVariables.g_ExchageURI));
    		msg = new EmailMessage(service);
    		msg.setSubject(subject); 
    		
    		/*bodyContent = bodyContent + "<br/> <b><h3>Execution Summary Results :</h3></b> </br>"; 
    		bodyContent = bodyContent + "Total test case(s) : " + totalTestCases + "</br>"; 
    		bodyContent = bodyContent + "Test case(s) executed : " + executed + " </br>"; 
    		if(passed > 0) bodyContent = bodyContent + "<b><h4 style=\"color:green;\">Passed : " + passed + " (" + passedPercentage + "%)</h4>"; 
    		if(failed > 0) bodyContent = bodyContent + "<b><h4 style=\"color:red;\">Failed : " + failed +  " (" + failedPercentage + "%)</h4>"; 
    		if(warning > 0) bodyContent = bodyContent + "<b><h4 style=\"color:orange;\">Warnings : " + warning + " (" + waringPercentage + "%)</h4>"; 
    		if(totalTestCases - executed > 0) bodyContent = bodyContent + "<b><h4 style=\"color:grey;\">Not Run : " + (totalTestCases - executed) +" (" + skippedPercentage + "%)</h4>"; 
    		bodyContent = bodyContent + "Execution Time : " + executionTime + " </br>"; 
    		bodyContent = bodyContent + "</br><b>Note : </b>This is an auto generated e-mail."; */
    		
    		bodyContent = bodyContent + "<b>Execution Summary Results :</b></br>"; 
    		bodyContent = bodyContent + "Total test case(s) : " + totalTestCases + "</br>"; 
    		if(totalTestCases - executed > 0)bodyContent = bodyContent + "Test case(s) executed : " + executed + "</br>"; 
    		if(passed > 0) bodyContent = bodyContent + "Passed : " + passed + " (" + passedPercentage + ")</br>"; 
    		if(failed > 0) bodyContent = bodyContent + "Failed : " + failed +  " (" + failedPercentage + ")</br>"; 
    		if(warning > 0) bodyContent = bodyContent + "Warnings : " + warning + " (" + waringPercentage + ")</br>"; 
    		if(error > 0) bodyContent = bodyContent + "Error : " + error + " (" + errorPercentage + ")</br>"; 
    		if(unknown > 0) bodyContent = bodyContent + "Unknown : " + unknown + " (" + unknownPercentage + ")</br>"; 
    		
    		if(totalTestCases - executed > 0) bodyContent = bodyContent + "Not Run : " + (totalTestCases - executed) +" (" + skippedPercentage + ")</br>"; 
    		bodyContent = bodyContent + "Execution completed in : " + executionTime + "</br>"; 
    		bodyContent = bodyContent + "</br><b>Note : </b>This is an auto generated e-mail."; 
    		
    		bodyContent = bodyContent + "</br></br>Regards,</br>";
    		bodyContent = bodyContent + applicationName + " Team";
    		
    		msg.setBody(MessageBody.getMessageBodyFromText(bodyContent));
    		msg.setFrom(EmailAddress.getEmailAddressFromString(GlobalVariables.g_From));
    		msg.getAttachments().addFileAttachment(reportName);
			if (to == null || to.equals("")) {
				System.out.println("To distribution list is empty. Could not send the mail ");
			} else {
				String[] mailTos = to.split(";");
				for (String mailTo : mailTos) {
					if (mailTo != null && !mailTo.isEmpty()) msg.getToRecipients().add(mailTo);
				}
				if(cc != null && !cc.isEmpty()) {
                    String[] mailCCs = cc.split(";");
                    for(String mailCc : mailCCs) {
                    	if(mailCc != null && !mailCc.equals("")) msg.getCcRecipients().add(mailCc);
                    }
                }
				//msg.send();
				System.out.println("Execution report sent succesfully");
			}
			return true;
        }catch(Exception e){
        	e.printStackTrace();
        }
        return false;
    }
	
	
	
}
