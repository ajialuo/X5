package com.highdataX5.service;

import java.util.List;
import com.highdataX5.entity.User;

public interface UserService extends BaseService{

    
    /**
     * 所有用户进行分页查询
     * @return
     */
    public List<User> findUserList();
    
    public List<User> queryUserInfo(String param);

    public int selectCount();
}
