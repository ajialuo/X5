package com.highdata.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.highdata.entity.User;
import com.highdata.service.UserService;
import com.highdata.util.exception.CustomException;


@Controller
public class UserController {

    private final Logger logger =
            Logger.getLogger(UserController.class.getName());

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/login")
    public String login(ModelMap mmap, HttpServletRequest request) {
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        if (StringUtils.isEmpty(name) == true
                || StringUtils.isEmpty(pwd) == true) {
            return "/login";
        }
        String[] params = new String[] {
            name,
            pwd
        };
        User user = (User) userService.findOneEntity(params);
        if (user == null) {
            logger.debug("没有此用户");
            mmap.addAttribute("message", "账户不存在，请重新登录");
            return "/login";
        }
        mmap.addAttribute("user", user);
        System.out.println(user);
        return "/userinfo";
    }


    @RequestMapping(value = "/getUserList")
    public String getUserList(ModelMap mmap, HttpServletRequest request) {
        String pageNumStr = request.getParameter("pageNum");
        // 默认第一页
        int pageNum = 1;
        if(StringUtils.isEmpty(pageNumStr) == true){
            pageNum = 1;
        }else{
            pageNum = Integer.valueOf(pageNumStr);
        }
        // 默认每页显示的数目
        int pageSize = 10;
        PageHelper.startPage(pageNum, pageSize);
        List users = userService.findUserList();
        PageInfo<User> page = new PageInfo<User>(users);
        mmap.addAttribute("userList", page.getList());
        mmap.addAttribute("pagehelper", page);
        return "/userlist";
    }


    @RequestMapping(value = "/count")
    @ResponseBody
    public int selectCount() {
        // PageHelper.startPage(1, 1,"id asc");
        int count = userService.selectCount();
        System.out.println(count);
        return count;
    }


    @RequestMapping(value = "/selectByPrimaryKey")
    @ResponseBody
    public User selectByPrimaryKey(@RequestParam String id) throws Exception {
        User user = (User) userService.selectByPrimaryKey(Integer.valueOf(id));
        if (user == null) {
            logger.debug("数据库此用户不存在");
            throw new CustomException("该用户不存在");
        }
        System.out.println(user);
        return user;
    }


    @RequestMapping(value = "/selectOne")
    @ResponseBody
    public User selectOne(@RequestParam String name) {
        User record = new User();
        record.setId(1);
        record.setName(name);
        record.setPwd("123");
        User user = (User) userService.selectOne(record);
        System.out.println(user);
        return user;
    }


    @RequestMapping(value = "/select")
    @ResponseBody
    public List<User> select(@RequestParam String name) {
        User record = new User();
        record.setId(1);
        record.setName(name);
        record.setPwd("123");
        List<User> userList = userService.select(record);
        System.out.println(userList);
        return userList;
    }


    @RequestMapping(value = "/selectByExample")
    @ResponseBody
    public List<User> selectByExample() {
        PageHelper.startPage(1, 10);
        List<User> userList = userService.selectByExample();
        PageInfo<User> p = new PageInfo<User>(userList);
        System.out.println(p);
        return userList;
    }


    @RequestMapping(value = "/queryUserInfo")
    @ResponseBody
    public List<User> queryUserInfo() {
        String param = "zhangs";
        List<User> userList = userService.queryUserInfo(param);
        System.out.println(userList);
        return userList;
    }
}
