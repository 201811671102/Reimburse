package com.cs.mapper;

import com.cs.pojo.Reimburse;
import com.cs.pojo.ReimburseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface ReimburseMapper {
    long countByExample(ReimburseExample example);

    int deleteByExample(ReimburseExample example);

    int deleteByPrimaryKey(Integer rid);

    int insert(Reimburse record);

    int insertSelective(Reimburse record);

    List<Reimburse> selectByExample(ReimburseExample example);

    Reimburse selectByPrimaryKey(Integer rid);

    int updateByExampleSelective(@Param("record") Reimburse record, @Param("example") ReimburseExample example);

    int updateByExample(@Param("record") Reimburse record, @Param("example") ReimburseExample example);

    int updateByPrimaryKeySelective(Reimburse record);

    int updateByPrimaryKey(Reimburse record);
}