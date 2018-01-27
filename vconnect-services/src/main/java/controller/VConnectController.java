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
      
}
    
      
      

