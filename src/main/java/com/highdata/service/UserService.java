package com.highdata.service;

import java.util.List;
import com.highdata.entity.User;

public interface UserService extends BaseService{

    
    /**
     * 所有用户进行分页查询
     * @return
     */
    public List<User> findUserList();
    
    public List<User> queryUserInfo(String param);

    public int selectCount();
}
