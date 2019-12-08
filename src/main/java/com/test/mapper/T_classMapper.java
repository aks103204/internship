package com.test.mapper;

import com.test.model.T_class;
import com.test.model.T_classExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface T_classMapper {
    int countByExample(T_classExample example);

    int deleteByExample(T_classExample example);

    int deleteByPrimaryKey(String cno);

    int insert(T_class record);

    int insertSelective(T_class record);

    List<T_class> selectByExample(T_classExample example);

    T_class selectByPrimaryKey(String cno);

    int updateByExampleSelective(@Param("record") T_class record, @Param("example") T_classExample example);

    int updateByExample(@Param("record") T_class record, @Param("example") T_classExample example);

    int updateByPrimaryKeySelective(T_class record);

    int updateByPrimaryKey(T_class record);
}