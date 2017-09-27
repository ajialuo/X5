package com.highdata.controller;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.highdata.entity.User;

@Controller
public class HomeController {

    private final Logger logger = Logger.getLogger(HomeController.class);
    
    @RequestMapping(value= "/")
    public String home(ModelMap mmap,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            logger.debug("系统未登录");
            return "/login";
        }
        return "/userinfo";
    }
}
