package com.lbq.dao;

import com.lbq.bean.FlowUser;
import com.lbq.bean.FlowUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FlowUserMapper {
    long countByExample(FlowUserExample example);

    int deleteByExample(FlowUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FlowUser record);

    int insertSelective(FlowUser record);

    List<FlowUser> selectByExample(FlowUserExample example);

    FlowUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FlowUser record, @Param("example") FlowUserExample example);

    int updateByExample(@Param("record") FlowUser record, @Param("example") FlowUserExample example);

    int updateByPrimaryKeySelective(FlowUser record);

    int updateByPrimaryKey(FlowUser record);
}