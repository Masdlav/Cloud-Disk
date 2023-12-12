package com.networkDisk.utils;

import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailUtils {

    //邮件发送器
    private JavaMailSenderImpl mailSender;
    Logger logger;

    public MailUtils(JavaMailSenderImpl mailSender){
        this.mailSender = mailSender;
    }

    /**
     * 发送简单邮件
     * @param title 邮件标题
     * @param text 邮件内容（简单邮件不支持HTML标签）
     * @param acceptEmail 接收方邮件
     */
    public void sendSimpleMailMessage(String title,String text,String acceptEmail){
        logger.info("开始发送简单邮件...");
        logger.info("mailSender对象为:"+mailSender);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(title);
        message.setText(text);
        // 配置邮箱发送地址
        message.setFrom("1065394472@qq.com");
        message.setTo(acceptEmail);
        System.out.println(mailSender);
        logger.info("message对象为:"+message);
        mailSender.send(message);
    }

    /**
     * 发送复杂邮件（支持邮件内容HTML解析）
     * @param title 邮件标题
     * @param text 邮件内容（简单邮件不支持HTML标签）
     * @param acceptEmail 接收方邮件
     */
    public void sentComplexMailMessage(String title,String text,String acceptEmail){
        logger.info("开始发送复杂邮件...");
        logger.info("mailSender对象为:"+mailSender);
        jakarta.mail.internet.MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        try {
            helper.setSubject(title);
            helper.setText(text,true);
            //配置邮箱发送地址
            helper.setFrom("1065394472@qq.com");
            helper.setTo(acceptEmail);
        } catch (jakarta.mail.MessagingException e) {
            e.printStackTrace();
        }
        logger.info("mimeMessage对象为:"+mimeMessage);
        mailSender.send(mimeMessage);
    }

    // 发送验证码
    public String sendCode(String email,String userName,String password){
        int code = (int) ((Math.random() * 9 + 1) * 100000);
        logger.info("开始发送复杂邮件...");
        logger.info("mailSender对象为:"+mailSender);
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        try {
            helper.setSubject("课程项目邮箱邮箱验证");
            helper.setText("<h2 >课程项目云盘</h2>" +
                    "<h3>用户注册-邮箱验证<h3/>" +
                    "您现在正在注册云盘账号<br>" +
                    "验证码: <span style='color : red'>"+code+"</span><br>" +
                    "用户名 :"+userName+
                    "<br>密码 :"+password+
                    "<hr>"+
                    "<h5 style='color : red'>如果并非本人操作,请忽略本邮件</h5>",true);
            // 配置邮箱发送地址
            helper.setFrom("1065394472@qq.com");
            helper.setTo(email);
        } catch (jakarta.mail.MessagingException e) {
            e.printStackTrace();
        }
        logger.info("mimeMessage对象为:"+mimeMessage);
        mailSender.send(mimeMessage);
        return String.valueOf(code);
    }
}
