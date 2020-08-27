package edu.hniu.community;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class taskApplicationTests {
    @Autowired
    JavaMailSenderImpl mailSender;

    @Value("${spring.mail.username}")
    String fromMail;


    @Test
    public void contextLoads3() {
    }

    @Test
    public void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("今晚开会");
        message.setText("大家，好！\n今晚7:30在教学楼201开班委会，请各位班委准时参加！ \n谢谢！");
        message.setTo("liuxian07286010@163.com");
        message.setFrom("liuxian0728@foxmail.com");

        mailSender.send(message);
    }

    @Test
    public void test2() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setSubject("今晚开会");
        helper.setText("大家，好！<br> &nbsp;&nbsp;<b style='color:red'>今晚7:30在教学楼201开班委会，请各位班委准时参加！</b> <br>谢谢！", true);
        helper.setTo("indexman@126.com");
        helper.setFrom("836491384@qq.com");

//        //添加附件
//        helper.addAttachment("会议说明.txt",new File("C:\\Users\\Dylan\\Pictures\\会议说明.txt"));
//        helper.addAttachment("会议图片.jpg",new File("C:\\Users\\Dylan\\Pictures\\会议图片.jpg"));

        mailSender.send(mimeMessage);
    }

}