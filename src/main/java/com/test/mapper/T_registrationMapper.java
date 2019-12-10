package com.test.mapper;

import com.test.model.T_registration;
import com.test.model.T_registrationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface T_registrationMapper {

  int countByExample(T_registrationExample example);

  int deleteByExample(T_registrationExample example);

  int deleteByPrimaryKey(String rno);

  int insert(T_registration record);

  int insertSelective(T_registration record);

  List<T_registration> selectByExample(T_registrationExample example);

  T_registration selectByPrimaryKey(String rno);

  int updateByExampleSelective(@Param("record") T_registration record,
      @Param("example") T_registrationExample example);

  int updateByExample(@Param("record") T_registration record,
      @Param("example") T_registrationExample example);

  int updateByPrimaryKeySelective(T_registration record);

  int updateByPrimaryKey(T_registration record);
}