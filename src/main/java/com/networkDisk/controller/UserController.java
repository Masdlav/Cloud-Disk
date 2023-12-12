package com.networkDisk.controller;

import com.networkDisk.entity.FileStore;
import com.networkDisk.entity.User;
import com.networkDisk.utils.LogUtils;
import com.networkDisk.utils.MailUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@Controller
@Slf4j
public class UserController extends BaseController {
    private final Logger logger = LogUtils.getInstance(Controller.class);

    @GetMapping("/login")
    public String login(){
        log.info("进入登录页面");
        return "login";
    }

    @GetMapping("/index")
    public String index(){
        log.info("进入主页面");
        return "index";
    }
    @ResponseBody
    @RequestMapping("/sendCode")
    public String sendCode(String userName, String email, String password) {
        User userByEmail = userService.getUserByEmail(email);
        if (userByEmail != null) {
            logger.error("发送验证码失败！邮箱已被注册！");
            return "exitEmail";
        }
        logger.info("开始发送邮件.../n" + "获取的到邮件发送对象为:" + mailSender);
        mailUtils = new MailUtils(mailSender);
        String code = mailUtils.sendCode(email, userName, password);
        session.setAttribute(email + "_code", code);
        return "success";
    }

    @PostMapping("/register")
    public String register(User user, String code, Map<String, Object> map) {
        String uCode = (String) session.getAttribute(user.getEmail() + "_code");
        if (!code.equals(uCode)) {
            map.put("errorMsg", "验证码错误");
            return "index";
        }
        // 用户名去空格
        user.setUserName(user.getUserName().trim());
        user.setImagePath("https://p.qpic.cn/qqconnect/0/app_101851241_1582451550/100?max-age=2592000&t=0");
        user.setRole(1);
        if (userService.insert(user)) {
            FileStore store = FileStore.builder().userId(user.getUserId()).currentSize(0).build();
            fileStoreService.addFileStore(store);
            user.setFileStoreId(store.getFileStoreId());
            userService.update(user);
            logger.info("注册用户成功！当前注册用户" + user);
            logger.info("注册仓库成功！当前注册仓库" + store);
        } else {
            map.put("errorMsg", "服务器发生错误，注册失败");
            return "index";
        }
        session.removeAttribute(user.getEmail() + "_code");
        session.setAttribute("loginUser", user);
        return "redirect:/index";
    }
}
