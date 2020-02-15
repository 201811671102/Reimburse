package com.cs.mapper;

import com.cs.pojo.Worker;
import com.cs.pojo.WorkerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface WorkerMapper {
    long countByExample(WorkerExample example);

    int deleteByExample(WorkerExample example);

    int deleteByPrimaryKey(Integer wid);

    int insert(Worker record);

    int insertSelective(Worker record);

    List<Worker> selectByExample(WorkerExample example);

    Worker selectByPrimaryKey(Integer wid);

    int updateByExampleSelective(@Param("record") Worker record, @Param("example") WorkerExample example);

    int updateByExample(@Param("record") Worker record, @Param("example") WorkerExample example);

    int updateByPrimaryKeySelective(Worker record);

    int updateByPrimaryKey(Worker record);
}