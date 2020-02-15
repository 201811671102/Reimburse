package com.cs.mapper;

import com.cs.pojo.SWR;
import com.cs.pojo.SWRExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface SWRMapper {
    long countByExample(SWRExample example);

    int deleteByExample(SWRExample example);

    int insert(SWR record);

    int insertSelective(SWR record);

    List<SWR> selectByExample(SWRExample example);

    int updateByExampleSelective(@Param("record") SWR record, @Param("example") SWRExample example);

    int updateByExample(@Param("record") SWR record, @Param("example") SWRExample example);
}