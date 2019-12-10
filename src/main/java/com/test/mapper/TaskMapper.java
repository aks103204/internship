package com.test.mapper;

import com.test.model.Task;
import com.test.model.TaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskMapper {

  int countByExample(TaskExample example);

  int deleteByExample(TaskExample example);

  int deleteByPrimaryKey(Integer taskNo);

  int insert(Task record);

  int insertSelective(Task record);

  List<Task> selectByExample(TaskExample example);

  Task selectByPrimaryKey(Integer taskNo);

  int updateByExampleSelective(@Param("record") Task record, @Param("example") TaskExample example);

  int updateByExample(@Param("record") Task record, @Param("example") TaskExample example);

  int updateByPrimaryKeySelective(Task record);

  int updateByPrimaryKey(Task record);
}