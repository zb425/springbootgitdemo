package com.bgamq.atcrowd.service.api;

import com.bgamq.atcrowd.util.ResultEntity;
import com.bgamq.atcrowd.vo.AddressVO;
import com.bgamq.atcrowd.vo.OrderProjectVO;
import com.bgamq.atcrowd.vo.OrderVO;

import java.util.List;

public interface OrderService {
    OrderProjectVO getOrderProjectVORemote(Integer projectId, Integer returnId);

    List<AddressVO> getAddressVOList(Integer memberId);

    void saveAddress(AddressVO addressVO);

    void saveOrder(OrderVO orderVO);
}
