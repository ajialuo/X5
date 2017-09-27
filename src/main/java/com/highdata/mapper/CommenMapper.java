package com.highdata.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.github.abel533.mapper.Mapper;
import com.github.abel533.mapper.MySqlMapper;

/**
 * 通用Mapper,继承BaseMapper
 * @author jiakaisheng
 *
 * @param <T>
 */
public interface CommenMapper<T> extends Mapper<T>, MySqlMapper<T> {
	
    /**
     * 根据sql语句查询多条数据 
     * @param sql
     * @return
     */
	public List<Map<String,Object>> findManyData(@Param("sql") String sql);
//	public int executeSqlInsert(@Param("sql") String sql);
//	public int executeSqlUpdate(@Param("sql") String sql);
//	public int executeSqlDelete(@Param("sql") String sql);
}
