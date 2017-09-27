package com.highdata.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.github.abel533.entity.Example;
import com.highdata.entity.User;
import com.highdata.mapper.UserMapper;

@Repository
public class UserDao{


    @Autowired
    private UserMapper userMapper;
    
    public User selectByPrimaryKey(int id){
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }
    
    public User selectOne(User record){
        User user = userMapper.selectOne(record);
        return user;
    }
    
    public List<User> select(User record){
        List<User> userList = userMapper.select(record);
        return userList;
    }
    
    public List<User> selectByExample(){
        Example example = new Example(User.class);
        List<User> userList = userMapper.selectByExample(example);
        return userList;
    }
    
    public List<User> findUserList() {
        List<User> userList = userMapper.findUserList();
        return userList;
    }
    
    public int selectCount() {
        int count = userMapper.selectCount(new User());
        return count;
    }

    public List<User> queryUserInfo(String param) {
        List<User> userList = userMapper.queryUserInfo(param);
        return userList;
    }

    public User findOneEntity(Object[] params) {
        String name = (String) params[0];
        String pwd = (String) params[1];
        User user = userMapper.findOneUser(name,pwd);
        return user;
    }
    
    
    /** 
     * 查询多条语句 
     *  
     * @param sql 操作的sql语句 
     * @return 
     */  
}
