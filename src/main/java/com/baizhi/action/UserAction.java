package com.baizhi.action;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.util.SecurityCode;
import com.baizhi.util.SecurityImage;
import com.opensymphony.xwork2.Action;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller("userAction")
@Scope("prototype")
public class UserAction {
    private String number;
    private User user;
    @Autowired
    private UserService userService;
    private String message;

    //获取验证码
    public String getImg() {
        //先获取随机数字
        String code = SecurityCode.getSecurityCode();
        System.out.println(code);
        //再根据数字生成对应的图片
        BufferedImage image = SecurityImage.createImage(code);
        //创建输出流
        try {
            ServletOutputStream outputStream = ServletActionContext.getResponse().getOutputStream();

            //设置图片格式
            ServletActionContext.getResponse().setContentType("image/gif");
            //传送
            ImageIO.write(image, "gif", outputStream);
            //存入session
            ServletActionContext.getRequest().getSession().setAttribute("code", code);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Action.NONE;
    }

    //注册
    public String register() {
        String code = (String) ServletActionContext.getRequest().getSession().getAttribute("code");
        //先判断验证码是否正确
        if (code.equals(number)) {
            userService.register(user);
            message = "注册成功";
            return "login";
        }
        message = "验证码错误";
        return "register";
    }

    //登录
    public String login() {
        User user1 = userService.login(user.getUsername());
        if (user1 == null) {
            message = "用户名输入错误";
            return "login";
        } else if (user.getPassword().equals(user1.getPassword())) {
            message = "登录成功";
            ServletActionContext.getRequest().getSession().setAttribute("user", user1);
            return "selectAll";
        } else {
            message = "真实姓名或密码或性别输入错误";
            return "login";
        }

    }

    //退出
    public String out() {
        ServletActionContext.getRequest().getSession().removeAttribute("user");
        return "login";
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    /*public void setUserService(UserService userService) {
        this.userService = userService;
    }*/

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
