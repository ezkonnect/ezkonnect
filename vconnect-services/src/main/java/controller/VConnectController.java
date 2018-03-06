package controller;

import org.springframework.web.bind.annotation.*;
import model.ResponsePayLoad;
import org.springframework.beans.factory.annotation.Autowired;
import service.VConnectService;
import service.VConnectService;
import model.*;
import com.ez_konnect.v1.*;

@RestController
@RequestMapping("/vconnect")
public class VConnectController {
	
      @Autowired
      VConnectService srvc;
      
      @RequestMapping("/get/user/{id}")
      public ResponsePayLoad getResponse(@PathVariable("id") String id) {
    	          return srvc.processRequest(id);
      }    
          
      @RequestMapping(value = "/post/processrequest",
              method = RequestMethod.POST,
              consumes = {"application/json", "application/xml"},
              produces = {"application/json", "application/xml"})
      public EntityResponseType processRequest(@RequestBody EntityRequestType req) {
    	         return srvc.processVconnectRequest(req);
      }
      
      @RequestMapping(value = "/post/all/processrequest",
              method = RequestMethod.POST,
              consumes = {"application/json", "application/xml"},
              produces = {"application/json", "application/xml"})
      public String processrequestAll(@RequestBody EntityRequestType req) {
    	         return srvc.processVconnectRequestAll(req);
      }    
      
      @RequestMapping("/businessdetail/{id}")
      public String getBusinessDetail(@PathVariable("id") String id) {   	          
    	          return srvc.getBusinessDetail(id);
      }
      
      @RequestMapping("/businessmsgs/{id}")
      public String getBusinessMsgs(@PathVariable("id") String id) {   	          
    	          return srvc.getBusinessMsgs(id);
      }
      
      @RequestMapping("/userresponse/{id}")
      public String getUserResponse(@PathVariable("id") String id) {   	          
    	          return srvc.getUserResponse(id);
      }
      
      @RequestMapping("/pendingsubs/{id}")
      public String getPendingSubs(@PathVariable("id") String id) {   	          
    	          return srvc.getPendingSubs(id);
      }
      
      @RequestMapping("/subs/{id}")
      public String getSubscriptionsResponse(@PathVariable("id") String id) {   	          
    	          return srvc.getSubscriptionsResponse(id);
      }
      
      @RequestMapping("/mainmenu/{id}")
      public String getMainMenu(@PathVariable("id") String id) {   	          
    	          return srvc.getMainMenuResponse(id);
      }
      
      @RequestMapping("/authenticateuser/{phonenumber}")
      public String authenticateUser(@PathVariable("phonenumber") String phonenumber) {   	          
    	          return srvc.authenticateUser(phonenumber);
      }
      
      @RequestMapping("/verifytoken/{token}")
      public String verifyToken(@PathVariable("token") String token) {   
    	          return srvc.verifyToken(token);
      }   
      
      @RequestMapping("/sendsms/{phonenumber}")
      public String sendSms(@PathVariable("phonenumber") String phonenumber) {   
    	          return srvc.sendSms(phonenumber);
      }   
      
}
    
      
      

