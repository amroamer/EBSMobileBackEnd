package com.appspro.mobile.rest;

import com.appspro.mobile.bean.EmployeeCertificate;
import com.appspro.mobile.bean.EmployeeInfo;

import com.appspro.mobile.model.module.EBSMobileAMImpl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.Response;

import oracle.jbo.Row;
import oracle.jbo.client.Configuration;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

@Path("approval")
public class ApprovalService {
    public ApprovalService() {
        super();
    }

    @GET
    @Path("{requestId}")
    @Produces("application/json")
    public ArrayList<EmployeeInfo> getApproversByRequestId(@PathParam("requestId")
        int requestId) {
        ArrayList<EmployeeInfo> approversList = new ArrayList<EmployeeInfo>();

        String amDef = "com.appspro.mobile.model.module.EBSMobileAMImpl";
        String config = "EBSMobileAMLocal";

        EBSMobileAMImpl am =
            (EBSMobileAMImpl)Configuration.createRootApplicationModule(amDef,
                                                                       config);
        ArrayList<Row> approvers = am.getApproversList(requestId);
        for (Row employeeRow : approvers) {
            if (employeeRow != null) {
                EmployeeInfo employee = new EmployeeInfo();
                employee.setUserName((String)employeeRow.getAttribute("UserName"));
                employee.setFullName((String)employeeRow.getAttribute("FullName"));
                employee.setEmployeeNumber((String)employeeRow.getAttribute("EmployeeNumber"));
                employee.setEmailAddress((String)employeeRow.getAttribute("EmailAddress"));
                employee.setGradeName((String)employeeRow.getAttribute("GradeName"));
                employee.setOrgName((String)employeeRow.getAttribute("OgrName"));
                employee.setPositionName((String)employeeRow.getAttribute("PositionName"));
                employee.setSupervisor((String)employeeRow.getAttribute("Supervisor"));
                //                oracle.jbo.domain.BlobDomain d =
                //                    (oracle.jbo.domain.BlobDomain)employeeRow.getAttribute("Image");
                //                if(d!=null){
                //                    byte[] bytes = null;
                //                    try {
                //                        bytes = IOUtils.toByteArray(d.getBinaryStream());
                //                    } catch (IOException e) {
                //                    }
                //                    byte[] encodedBytes = Base64.encodeBase64(bytes);
                //                    String str = null;
                //                    try {
                //                        str = new String(encodedBytes, "UTF-8");
                //                    } catch (UnsupportedEncodingException e) {
                //                    }
                //                    employee.setImage(str);
                //                }else {
                employee.setImage(null);
                //                }


                approversList.add(employee);
            }
        }


        return new ArrayList<EmployeeInfo>(approversList.subList(0, 3));
    }


    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createEmployeeCertificate(EmployeeCertificate employeeCertificate) {

        
        return Response.status(201).entity(employeeCertificate).build();

    }
    
    @GET
    @Path("/getEmpCertificate")
    @Produces(MediaType.APPLICATION_JSON)
    public EmployeeCertificate getEmpCertificate(EmployeeCertificate employeeCertificate) {

//        String result = "Track saved : " + employeeCertificate;
        return new EmployeeCertificate();

    }
    
    @GET
    @Path("/getEmpCertificateHistory/{requestId}/{userName}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<EmployeeCertificate> getEmpCertificateHistory(@PathParam("requestId")int requestId ,@PathParam("userName") String userName) {
        ArrayList<EmployeeCertificate>  list = new ArrayList<EmployeeCertificate> ();
            
    //        String result = "Track saved : " + employeeCertificate;
        return list;

    }
    
    
    
}
