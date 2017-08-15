package com.appspro.mobile.rest;

import com.appspro.mobile.bean.RequestBean;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("request")
public class RequestService {
    public RequestService() {
        super();
    }
    
    
    

    @GET
    @Produces("application/json"+ ";charset=utf-8")
    public ArrayList<RequestBean> getAllRequests(){
        ArrayList<RequestBean> requestsList = new ArrayList<RequestBean> ();
        
        RequestBean r1 = new RequestBean();
        r1.setRequestId(1);
        r1.setRequestNameEn("Employee Certifcate");
        r1.setRequestNameAr("??? ?????");
        
//        RequestBean r2 = new RequestBean();
//        r2.setRequestId(1);
//        r2.setRequestNameEn("Employee Certifcate");
        
        requestsList.add(r1);
        return requestsList;
    }
}
