package org.sfa.infomanage.controller;

import org.sfa.infomanage.bean.User;
import org.sfa.infomanage.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@Controller
public class LoginController {

    private UserMapper userMapper = new UserMapper();

    @RequestMapping("/")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpServletResponse response, HttpServletRequest request){
        //根据用户名在数据库中查询用户
        User realUser = userMapper.getUserByUsername(username);
        //没有查到相应用户
        if(realUser == null){
            model.addAttribute("msg", "用户名或密码错误！");
            return "login";
        }
        //用户密码输入错误
        if(!realUser.getPassword().equals(password)){
            model.addAttribute("msg", "用户名或密码错误！");
            return "login";
        }
        // 验证成功，设置Cookie，并在Session域对象中设置用户信息
        Cookie cookie = new Cookie("token", username);
        cookie.setMaxAge(60 * 60);     //设置cookie销毁时间为1小时
        cookie.setPath("/");
        response.addCookie(cookie);

        HttpSession session = request.getSession();
        session.setAttribute("user", realUser);
        model.addAttribute("user", realUser);
        return "index";
    }
}
