package com.test.mapper;

import com.test.model.T_tcExample;
import com.test.model.T_tcKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface T_tcMapper {

  int countByExample(T_tcExample example);

  int deleteByExample(T_tcExample example);

  int deleteByPrimaryKey(T_tcKey key);

  int insert(T_tcKey record);

  int insertSelective(T_tcKey record);

  List<T_tcKey> selectByExample(T_tcExample example);

  int updateByExampleSelective(@Param("record") T_tcKey record,
      @Param("example") T_tcExample example);

  int updateByExample(@Param("record") T_tcKey record, @Param("example") T_tcExample example);
}