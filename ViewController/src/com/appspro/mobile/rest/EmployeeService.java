package com.appspro.mobile.rest;

import com.appspro.mobile.bean.EmployeeInfo;

import com.appspro.mobile.model.module.EBSMobileAMImpl;

import java.awt.image.BufferedImage;

import java.io.IOException;

import java.io.UnsupportedEncodingException;

import oracle.jbo.client.Configuration;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.Response;

import oracle.jbo.Row;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

@Path("employee")
public class EmployeeService {
    public EmployeeService() {
        super();
    }


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getName() {
        return "amro";
    }


    @GET
    @Path("{userName}")
    @Produces("application/json")
    public EmployeeInfo getEmployeeByUserName(@PathParam("userName")
        String userName) {
        EmployeeInfo employee = null;
        String amDef = "com.appspro.mobile.model.module.EBSMobileAMImpl";
        String config = "EBSMobileAMLocal";

        EBSMobileAMImpl am =
            (EBSMobileAMImpl)Configuration.createRootApplicationModule(amDef,
                                                                       config);
        Row employeeRow = am.getEmployeeByUserName(userName);
        if (employeeRow != null) {
            employee = new EmployeeInfo();
            employee.setUserName(userName);
            employee.setFullName((String)employeeRow.getAttribute("FullName"));
            employee.setEmployeeNumber((String)employeeRow.getAttribute("EmployeeNumber"));
            employee.setEmailAddress((String)employeeRow.getAttribute("EmailAddress"));
            employee.setGradeName((String)employeeRow.getAttribute("GradeName"));
            employee.setOrgName((String)employeeRow.getAttribute("OgrName"));
            employee.setPositionName((String)employeeRow.getAttribute("PositionName"));
            employee.setSupervisor((String)employeeRow.getAttribute("Supervisor"));
            oracle.jbo.domain.BlobDomain d =
                (oracle.jbo.domain.BlobDomain)employeeRow.getAttribute("Image");

            byte[] bytes = null;
            try {
                bytes = IOUtils.toByteArray(d.getBinaryStream());
            } catch (IOException e) {
            }
            byte[] encodedBytes = Base64.encodeBase64(bytes);
            String str = null;
            try {
                str = new String(encodedBytes, "UTF-8");
            } catch (UnsupportedEncodingException e) {
            }
            employee.setImage(str);
        }

        Configuration.releaseRootApplicationModule(am, true);
        return employee;

    }


    @GET
    @Path("{userName}/{password}")
    @Produces("application/json")
    public EmployeeInfo login(@PathParam("userName")
        String userName, @PathParam("password")
        String password) {
        EmployeeInfo employee = null;
        String amDef = "com.appspro.mobile.model.module.EBSMobileAMImpl";
        String config = "EBSMobileAMLocal";

        EBSMobileAMImpl am =
            (EBSMobileAMImpl)Configuration.createRootApplicationModule(amDef,
                                                                       config);
        Row employeeRow = am.login(userName, password);
        if (employeeRow != null) {
            employee = new EmployeeInfo();
            employee.setUserName(userName);
            employee.setFullName((String)employeeRow.getAttribute("FullName"));
            employee.setEmployeeNumber((String)employeeRow.getAttribute("EmployeeNumber"));
            employee.setEmailAddress((String)employeeRow.getAttribute("EmailAddress"));
            employee.setGradeName((String)employeeRow.getAttribute("GradeName"));
            employee.setOrgName((String)employeeRow.getAttribute("OgrName"));
            employee.setPositionName((String)employeeRow.getAttribute("PositionName"));
            employee.setSupervisor((String)employeeRow.getAttribute("Supervisor"));
            oracle.jbo.domain.BlobDomain d =
                (oracle.jbo.domain.BlobDomain)employeeRow.getAttribute("Image");

            byte[] bytes = null;
            try {
                bytes = IOUtils.toByteArray(d.getBinaryStream());
            } catch (IOException e) {
            }
            byte[] encodedBytes = Base64.encodeBase64(bytes);
            String str = null;
            try {
                str = new String(encodedBytes, "UTF-8");
            } catch (UnsupportedEncodingException e) {
            }
            employee.setImage(str);
        }

        Configuration.releaseRootApplicationModule(am, true);
        return employee;

    }


    @GET
    @Path("/image/{userName}")
    @Produces("image/png")
    public Response getEmployeeImage(@PathParam("userName")
        String userName) {
        
        byte[] imageBytes = null;
        String amDef = "com.appspro.mobile.model.module.EBSMobileAMImpl";
        String config = "EBSMobileAMLocal";

        EBSMobileAMImpl am =
            (EBSMobileAMImpl)Configuration.createRootApplicationModule(amDef,
                                                                       config);
        Row employeeRow = am.getEmployeeImage(userName);
        if (employeeRow != null) {
          
            oracle.jbo.domain.BlobDomain imageBlob =
                (oracle.jbo.domain.BlobDomain)employeeRow.getAttribute("Image");

           
            String str = null;
            try {
                imageBytes = IOUtils.toByteArray(imageBlob.getBinaryStream());
//                byte[] encodedBytes = Base64.encodeBase64(bytes);
//                str = new String(encodedBytes, "UTF-8");
            } catch (IOException e) {
            }
           
    

        }

         return Response.ok(imageBytes).build();

        // uncomment line below to send streamed
        // return Response.ok(new ByteArrayInputStream(imageData)).build();
    }

}
