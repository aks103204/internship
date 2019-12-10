package com.test.mapper;

import com.test.model.T_admin;
import com.test.model.T_adminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface T_adminMapper {

  int countByExample(T_adminExample example);

  int deleteByExample(T_adminExample example);

  int deleteByPrimaryKey(String ano);

  int insert(T_admin record);

  int insertSelective(T_admin record);

  List<T_admin> selectByExample(T_adminExample example);

  T_admin selectByPrimaryKey(String ano);

  int updateByExampleSelective(@Param("record") T_admin record,
      @Param("example") T_adminExample example);

  int updateByExample(@Param("record") T_admin record, @Param("example") T_adminExample example);

  int updateByPrimaryKeySelective(T_admin record);

  int updateByPrimaryKey(T_admin record);
}