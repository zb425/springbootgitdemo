package com.bgamq.atcrowd.mapper;

import com.bgamq.atcrowd.po.OrderProjectPO;
import com.bgamq.atcrowd.po.OrderProjectPOExample;
import java.util.List;

import com.bgamq.atcrowd.util.ResultEntity;
import com.bgamq.atcrowd.vo.OrderProjectVO;
import org.apache.ibatis.annotations.Param;

public interface OrderProjectPOMapper {
    long countByExample(OrderProjectPOExample example);

    int deleteByExample(OrderProjectPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderProjectPO record);

    int insertSelective(OrderProjectPO record);

    List<OrderProjectPO> selectByExample(OrderProjectPOExample example);

    OrderProjectPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderProjectPO record, @Param("example") OrderProjectPOExample example);

    int updateByExample(@Param("record") OrderProjectPO record, @Param("example") OrderProjectPOExample example);

    int updateByPrimaryKeySelective(OrderProjectPO record);

    int updateByPrimaryKey(OrderProjectPO record);

    OrderProjectVO selectOrderProjectVO(@Param("returnId") Integer returnId,@Param("projectId") Integer projectId);
}