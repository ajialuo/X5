package com.highdata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.highdata.dao.UserDao;
import com.highdata.entity.User;
import com.highdata.service.UserService;

@Service
public class UserServiceImpl
    implements UserService {

    @Autowired
    private UserDao userDao;
    
    @Override
    public List<User> findUserList() {
        List<User> userList = userDao.findUserList();
        return userList;
    }

    @Override
    public int selectCount() {
        int count = userDao.selectCount();
        return 0;
    }

    public User selectOne(User record) {
        User user = userDao.selectOne(record);
        return user;
    }

    public List<User> select(User record) {
        List<User> userList = userDao.select(record);
        return userList;
    }

    @Override
    public List<User> selectByExample() {
        List<User> userList = userDao.selectByExample();
        return userList;
    }

    @Override
    public List<User> queryUserInfo(String param) {
        List<User> userList = userDao.queryUserInfo(param);
        return userList;
    }


    @Override
    public Object selectOne(Object record) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List select(Object record) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User selectByPrimaryKey(Object key) {
        User user = userDao.selectByPrimaryKey((int) key);
        return user;
    }

    @Override
    public User findOneEntity(Object[] params) {
        User user = userDao.findOneEntity(params);
        return user;
    }

}
