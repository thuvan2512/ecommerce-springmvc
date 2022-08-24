/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.service.impl;

import com.thunv.service.MailService;
import freemarker.template.Configuration;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import javax.mail.internet.MimeMessage;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 *
 * @author thu.nv2512
 */
@Service
@PropertySource("classpath:messages.properties")
public class MailServiceImpl implements MailService {
    @Autowired
    private Environment env;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private Configuration freemarkerConfiguration;
    private String mailTo = "";
    private String subject ="";
    private String title = "";
    private String content = "";
    private String mailTemplate = "mail";
    private String items = "";
    public void setInfo(String mailTo,String subject,String title, String content,String items, String mailTemplate){
        this.content = content;
        this.mailTo = mailTo;
        this.subject =subject;
        this.mailTemplate = mailTemplate;
        this.title = title;
        this.items = items;
    }
    @Override
    public void sendMail(String mailTo,String subject,String title, String content,String items, String mailTemplate) {
        this.setInfo(mailTo, subject, title, content,items, mailTemplate);
        MimeMessagePreparator preparator = getMessagePreparator();
        try {
            javaMailSender.send(preparator);
            System.out.println("Message has been sent...");
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private MimeMessagePreparator getMessagePreparator() {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {

            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

                helper.setSubject(subject);
                helper.setFrom(env.getProperty("sendmailconfig.email").toString());
                helper.setTo(mailTo);

                Map<String, String> model = new HashMap<>();
                model.put("title", title);
                model.put("content", content);
                model.put("items", items);

                String text = geFreeMarkerTemplateContent(model);
//                helper.setText(text, true);
                helper.getMimeMessage().setContent(text,"text/html;charset=utf-8");
            }
        };
        return preparator;
    }

    public String geFreeMarkerTemplateContent(Map<String, String> model) {
        StringBuffer content = new StringBuffer();
        try {
            content.append(FreeMarkerTemplateUtils.processTemplateIntoString(freemarkerConfiguration.getTemplate(mailTemplate.strip() + ".html"), model));

            return content.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
