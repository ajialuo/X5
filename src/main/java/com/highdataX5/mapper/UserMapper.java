package com.highdataX5.mapper;

import java.util.List;
import com.highdataX5.entity.User;

/**
 * commenMapper中的方法不需要在配置文件中配置
 * 此接口便于灵活设置sql语句来实现我们的要求，方法需配置在对应的
 * Mapper.xml文件中
 * @author jiakaisheng
 *
 */
public interface UserMapper extends CommenMapper<User>{
    
    // 查询所有用户
    public List<User> findUserList();
    
    //例如：通过某个字段查找某条记录或多条记录
    public List<User> queryUserInfo(String param);

    // 查询用户
    public User findOneUser(String name, String pwd);
    
    
}
