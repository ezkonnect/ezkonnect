package service;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import java.io.BufferedReader;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.ez_konnect.v1.*;
import model.ResponsePayLoad;
import common.*;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

@Service
public class VConnectService implements CommandLineRunner {
	
	public static String sampleResponsePayload = "";
	
	@Value("${ACCOUNT_SID}")
	public String ACCOUNT_SID = "";
	
	@Value("${AUTH_TOKEN}")
	public String AUTH_TOKEN = "";
	
	@Value("${sample.xml.location}")
	private String sampleFileLocation;
	
	@Value("${businessdetail.json.location}")
	private String businessdetailFileLoc;
	
	@Value("${businessmsgs.json.location}")
	private String businessmsgsFileLoc;
	
	@Value("${userresponse.json.location}")
	private String userresponseFileLoc;
	
	@Value("${pendingsubs.json.location}")
	private String pendingsubsFileLoc;
	
	@Value("${subscription.json.location}")
	private String subsFileLoc;
	
	@Value("${mainmenu.json.location}")
	private String mainFileLoc;
	
	@Value("${authentication.json.location}")
	private String authenticationFileLoc;
	
	@Value("${verification.json.location}")
	private String verificationFileLoc;
		
	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println ("Sample File Location.." + sampleFileLocation);	
		loadFile ();
	}
	
	
	public String sendSms (String phoneNumber) {
		System.out.println ("Phone_Number.." + phoneNumber);	
		System.out.println ("ACCOUNT_SID.." + ACCOUNT_SID);	
		System.out.println ("AUTH_TOKEN.." + AUTH_TOKEN);
		
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

	    Message message = Message.creator(new PhoneNumber(phoneNumber),
	        new PhoneNumber("+18563176791"), 
	        "vConnect Tiwilo Integration in Progress..").create();
	    
		return message.getSid();	

	}
	
	
	public String authenticateUser (String phoneNumber) {
		return loadJsonFile (authenticationFileLoc);
		
		/*
		System.out.println ("Phone_Number.." + phoneNumber);	
		System.out.println ("ACCOUNT_SID.." + ACCOUNT_SID);	
		System.out.println ("AUTH_TOKEN.." + AUTH_TOKEN);
		
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

	    Message message = Message.creator(new PhoneNumber(phoneNumber),
	        new PhoneNumber("+18563176791"), 
	        "vConnect Tiwilo Integration in Progress..").create();
	    
	    //System.out.println();
		
		return message.getSid();	
		*/
	}
	
	public String verifyToken (String id) {
		return loadJsonFile (verificationFileLoc);	
	}
	
	public String getMainMenuResponse (String id) {
		return loadJsonFile (mainFileLoc);	
	}
	
	public String getSubscriptionsResponse (String id) {
		return loadJsonFile (subsFileLoc);	
	}
	
	public String getUserResponse (String id) {
		return loadJsonFile (userresponseFileLoc);	
	}
	
	public String getBusinessMsgs (String id) {
		return loadJsonFile (businessmsgsFileLoc);	
	}
	
	public String getBusinessDetail (String id) {
		return loadJsonFile (businessdetailFileLoc);	
	}
	
	public String getPendingSubs (String id) {
		return loadJsonFile (pendingsubsFileLoc);	
	}
	
	public ResponsePayLoad processRequest (String  id) {
		
		ResponsePayLoad res = new ResponsePayLoad ();
		res.setUserId(id);
		res.setUserLocation("jersey city");		
		return res;
	}
	
	public String processVconnectRequestAll (EntityRequestType req) { 	    
    	
	    if ( req!=null ) { 
	    	     String reqId =  req.getActionData().getRequestGlobalID();
	    	     String userId = req.getActionData().getUserLoginId();  	   
	    	     String action = req.getActionData().getUserAction().getOperation();    	    
	    }
	    return sampleResponsePayload;	
     }
	   
    public EntityResponseType processVconnectRequest (EntityRequestType req) { 	    
    	
    	    if ( req!=null ) { 
    	    	
    	    	     String reqId =  req.getActionData().getRequestGlobalID();
    	    	     String userId = req.getActionData().getUserLoginId();  	   
    	    	     String action = req.getActionData().getUserAction().getOperation();
    	    	     
    	    	     if ( action!=null &&  action.contentEquals(Constants.GET_USER_SUBSCRIPTIONS) ) {
    	    	          EntityResponseType res = processUserSubscriptions (userId);
    	    	          res.setActionData(req.getActionData());
    	    	          return res;
	    	    	 }
    	    }
			
		return null;	
	}
    
    public EntityResponseType processUserSubscriptions (String userId) { 	    
	 	    	         
      	 EntityResponseType res = new EntityResponseType ();      	
         UserType user = new UserType ();
         res.setUser(user);
         
         UserGeneralInfoType userInfo = new UserGeneralInfoType ();
         NameType userName = new NameType ();
         userInfo.setUserName(userName);
         user.setUserGeneralInfo(userInfo);  
         
         //Populate UserGeneral Info
         userInfo.setUserID("0001");    
         userName.setLastName("Qadir");
         
         //Populate Associated Business Subscriptions
         
         AssociatedBusinessesListType bList = new AssociatedBusinessesListType ();
         AssociatedBusinessGeneralInfoType bInfo = new AssociatedBusinessGeneralInfoType ();       
         bList.getAssociatedBusinessGeneralInfo().add(bInfo);
         BusinessGeneralInfoType busInfo = new BusinessGeneralInfoType ();
         MsgListType msgTypeList = new MsgListType ();
         bInfo.getMsgList().add(msgTypeList);
         bInfo.setBusinessGeneralInfo(busInfo);
         
         //Set Business Info
         busInfo.setBusinessID("Costco-001");
         busInfo.setBusinessName("Costco Inc.");
         
         //Set Msgs
         msgTypeList.setMsgSubject("Awesome Deal...");        
         
         user.setAssociatedBusinessSubscriptions(bList);
               
	     return res;
    }
    
    private String loadJsonFile (String fileLoc) {
       	return getFileContent (fileLoc);     	   
    }
    
    private void loadFile () {
         	
       	String xml = getFileContent (sampleFileLocation);     	   
       	sampleResponsePayload = converXMLtoJSON (xml);     	
    }
    
    public static EntityResponseType converXMLtoPOJO (String xml) {
       	EntityResponseType res;
      	StringReader reader = new StringReader(xml);
        //initialize jaxb classes
       	try {
	        JAXBContext context = JAXBContext.newInstance(EntityResponseType.class);
		    Unmarshaller un = context.createUnmarshaller();
		        //convert to desired object
		     res = (EntityResponseType)un.unmarshal(reader);
		    
		     System.out.println ("Object>>>>>>" + res.getActionData().getRequestGlobalID());
		     
		     return res;
		    
       	}catch (Exception e) {
       	     System.out.println ("Exp>>>>>>" + e.toString());
       	}
       	return null;
    }
    
    public static String converXMLtoJSON (String xml) {
    	   
    	try {
            JSONObject xmlJSONObj = org.json.XML.toJSONObject(xml);
            String jsonPrettyPrintString = xmlJSONObj.toString(4);
            System.out.println(jsonPrettyPrintString);
            return jsonPrettyPrintString;
        } catch (JSONException je) {
            System.out.println(je.toString());
        }
    	    return "";
    }
    
    public static String getFileContent(String filePath) {
       	try {
       		InputStream is = new FileInputStream(filePath);     	
	      	BufferedReader buf = new BufferedReader(new InputStreamReader(is));
	      	String line = buf.readLine(); 
	      	StringBuilder sb = new StringBuilder();
	      	while(line != null){ 
	      		 sb.append(line).append("\n"); line = buf.readLine();
	      	}
	      	String fileAsString = sb.toString(); 
	      	return fileAsString;
       	}catch (Exception e) {
       		
       	}
       	return "";
    	}
    
    
    
   
}
