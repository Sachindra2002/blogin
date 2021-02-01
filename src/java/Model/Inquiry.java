/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Lahiru De silva
 */
public class Inquiry {
    int inquiryId, phoneNo;
    String userName, email, message,status;
    String submittedDate;

    public Inquiry(int phoneNo, String userName, String email, String message, String submittedDate, String status) {
        this.phoneNo = phoneNo;
        this.userName = userName;
        this.email = email;
        this.message = message;
        this.submittedDate = submittedDate;
        this.status = status;
    }

    public Inquiry(int inquiryId, String userName, String email, int phoneNo, String message, String status, String submittedDate) {
        this.inquiryId = inquiryId;
        this.phoneNo = phoneNo;
        this.userName = userName;
        this.email = email;
        this.message = message;
        this.status = status;
        this.submittedDate = submittedDate;
    }

    public Inquiry(String userName, String email,int phoneNo, String message, String submittedDate,int inquiryId) {
        
        this.userName = userName;
        this.email = email;
        this.phoneNo = phoneNo;
        this.message = message;
        this.submittedDate = submittedDate;
        this.inquiryId = inquiryId;
    }

    
    

    

    public int getInquiryId() {
        return inquiryId;
    }

    public void setInquiryId(int inquiryId) {
        this.inquiryId = inquiryId;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(String submittedDate) {
        this.submittedDate = submittedDate;
    }

   
    
    
    

    

    
    
    
    
}
