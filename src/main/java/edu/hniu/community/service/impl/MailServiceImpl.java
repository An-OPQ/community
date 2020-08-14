package edu.hniu.community.service.impl;

import edu.hniu.community.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    String formMail;

    @Override
    public boolean sendSimpleMail(String to, String subject, String content) {
        boolean falg=false;
        SimpleMailMessage messege=new SimpleMailMessage();
        messege.setFrom(formMail);
        messege.setTo(to);
        messege.setSubject(subject);
        messege.setText(content);
        try {
            logger.info("邮件发送成功！");
            mailSender.send(messege);
            falg=true;
        }catch (Exception e){
            logger.info("邮件发送失败！");
            e.printStackTrace();
        }
        return falg;
    }

    @Override
    public void sendHtmlMail(String to, String subject, String content) {

    }

    @Override
    public void sendAttachmentMail(String to, String subject, String content, String filePath) {

    }

    @Override
    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId) {

    }
}
