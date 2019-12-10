package com.test.mapper;

import com.test.model.T_student;
import com.test.model.T_studentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface T_studentMapper {

  int countByExample(T_studentExample example);

  int deleteByExample(T_studentExample example);

  int deleteByPrimaryKey(String sno);

  int insert(T_student record);

  int insertSelective(T_student record);

  List<T_student> selectByExample(T_studentExample example);

  T_student selectByPrimaryKey(String sno);

  int updateByExampleSelective(@Param("record") T_student record,
      @Param("example") T_studentExample example);

  int updateByExample(@Param("record") T_student record,
      @Param("example") T_studentExample example);

  int updateByPrimaryKeySelective(T_student record);

  int updateByPrimaryKey(T_student record);

  List<T_student> queryAllStudentInfo();
}