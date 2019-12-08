package com.test.mapper;

import com.test.model.T_teacher;
import com.test.model.T_teacherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface T_teacherMapper {
    int countByExample(T_teacherExample example);

    int deleteByExample(T_teacherExample example);

    int deleteByPrimaryKey(String tno);

    int insert(T_teacher record);

    int insertSelective(T_teacher record);

    List<T_teacher> selectByExample(T_teacherExample example);

    T_teacher selectByPrimaryKey(String tno);

    int updateByExampleSelective(@Param("record") T_teacher record, @Param("example") T_teacherExample example);

    int updateByExample(@Param("record") T_teacher record, @Param("example") T_teacherExample example);

    int updateByPrimaryKeySelective(T_teacher record);

    int updateByPrimaryKey(T_teacher record);
}