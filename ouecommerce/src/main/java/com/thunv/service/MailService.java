package com.thunv.service;

public interface MailService{
    void sendMail(String mailTo,String subject,String title, String content, String mailTemplate);
}
