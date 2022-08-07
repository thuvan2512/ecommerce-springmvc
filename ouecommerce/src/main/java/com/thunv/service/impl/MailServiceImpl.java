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
import org.springframework.stereotype.Service;

/**
 *
 * @author thu.nv2512
 */
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private Configuration freemarkerConfiguration;

    @Override
    public void sendMail() {
        MimeMessagePreparator preparator = getMessagePreparator();

        try {
            javaMailSender.send(preparator);
            System.out.println("Message has been sent.............................");
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private MimeMessagePreparator getMessagePreparator() {

        MimeMessagePreparator preparator = new MimeMessagePreparator() {

            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

                helper.setSubject("Gui email demo voi template ne!!!");
                helper.setFrom("travel.agency.ou.management@gmail.com");
                helper.setTo("1951050080thu@ou.edu.vn");

                Map<String, String> model = new HashMap<>();
                model.put("subject", "Thu Nguyen Van");
                model.put("content", "Ho Chi Minh City Open University");

                String text = geFreeMarkerTemplateContent(model);

                System.out.println("Template content : " + text);
                helper.setText(text, true);
            }
        };
        return preparator;
    }

    public String geFreeMarkerTemplateContent(Map<String, String> model) {
        StringBuffer content = new StringBuffer();
        try {
            content.append(FreeMarkerTemplateUtils.processTemplateIntoString(freemarkerConfiguration.getTemplate("mail.html"), model));

            return content.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
