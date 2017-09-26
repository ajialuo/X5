package com.highdataX5;

import java.util.List;
import javax.servlet.ServletException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.highdataX5.entity.User;
import com.highdataX5.service.UserService;


public class UserTest extends BaseTest{

    @Autowired
    private UserService userService;


    @Test
    public void test1() {
        List<User> list = userService.findUserList();
        for (User user : list) {
            System.out.println(user.getName() + ":" + user.getPwd());
        }
    }


    @Test
    public void test2() throws ServletException {
        String param = "zhangs";
        List<User> userList = userService.queryUserInfo(param);
        System.out.println(userList);
    }
}
