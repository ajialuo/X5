package com.highdata.service;

import java.util.List;

public interface BaseService<T> {

    /**
     * 通过主键查找单条实体
     * @param key
     * @return
     */
    public T selectByPrimaryKey(Object key);
    
    /**
     * 通过实体的详细信息查找表中是否存在记录(唯一)，表中存在唯一约束
     * @param record
     * @return
     */
    public T selectOne(T record);
    
    /**
     * 通过实体的详细信息查找表中是否存在记录(存在多条),表中没有唯一约束
     * @param record
     * @return
     */
    public List<T> select(T record);
    
    /**
     * 查询表中所有信息
     * @return
     */
    public List<T> selectByExample();
    
    /**
     * 查询单个实体
     * @return
     */
    public T findOneEntity(Object[] params);
}
