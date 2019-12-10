package com.test.mapper;

import com.test.model.T_file;
import com.test.model.T_fileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface T_fileMapper {

  int countByExample(T_fileExample example);

  int deleteByExample(T_fileExample example);

  int deleteByPrimaryKey(Integer fno);

  int insert(T_file record);

  int insertSelective(T_file record);

  List<T_file> selectByExample(T_fileExample example);

  T_file selectByPrimaryKey(Integer fno);

  int updateByExampleSelective(@Param("record") T_file record,
      @Param("example") T_fileExample example);

  int updateByExample(@Param("record") T_file record, @Param("example") T_fileExample example);

  int updateByPrimaryKeySelective(T_file record);

  int updateByPrimaryKey(T_file record);
}