package com.bgamq.atcrowd.service.impl;

import com.bgamq.atcrowd.mapper.AddressPOMapper;
import com.bgamq.atcrowd.mapper.OrderPOMapper;
import com.bgamq.atcrowd.mapper.OrderProjectPOMapper;
import com.bgamq.atcrowd.po.AddressPO;
import com.bgamq.atcrowd.po.AddressPOExample;
import com.bgamq.atcrowd.po.OrderPO;
import com.bgamq.atcrowd.po.OrderProjectPO;
import com.bgamq.atcrowd.service.api.OrderService;
import com.bgamq.atcrowd.util.ResultEntity;
import com.bgamq.atcrowd.vo.AddressVO;
import com.bgamq.atcrowd.vo.OrderProjectVO;
import com.bgamq.atcrowd.vo.OrderVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderProjectPOMapper orderProjectPOMapper;

    @Autowired
    private OrderPOMapper orderPOMapper;

    @Autowired
    private AddressPOMapper addressPOMapper;


    @Override
    public OrderProjectVO getOrderProjectVORemote(Integer projectId, Integer returnId) {
        return orderProjectPOMapper.selectOrderProjectVO(returnId,projectId);
    }

    @Override
    public List<AddressVO> getAddressVOList(Integer memberId) {

        AddressPOExample addressPOExample = new AddressPOExample();
        AddressPOExample.Criteria criteria = addressPOExample.createCriteria();
        criteria.andMemberIdEqualTo(memberId);
        List<AddressPO> addressPOList = addressPOMapper.selectByExample(addressPOExample);

        List<AddressVO> list = new ArrayList<>();
        for (AddressPO addressPO : addressPOList) {
            AddressVO addressVO = new AddressVO();
            BeanUtils.copyProperties(addressPO,addressVO);
            list.add(addressVO);
        }

        return list;
    }

    @Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    @Override
    public void saveAddress(AddressVO addressVO) {
        AddressPO addressPO = new AddressPO();
        BeanUtils.copyProperties(addressVO,addressPO);
        addressPOMapper.insert(addressPO);
    }

    @Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    @Override
    public void saveOrder(OrderVO orderVO) {

        OrderPO orderPO = new OrderPO();
        BeanUtils.copyProperties(orderVO,orderPO);

        OrderProjectPO orderProjectPO = new OrderProjectPO();
        BeanUtils.copyProperties(orderVO.getOrderProjectVO(),orderProjectPO);

        orderPOMapper.insert(orderPO);

        Integer id = orderPO.getId();
        orderProjectPO.setOrderId(id);
        orderProjectPOMapper.insert(orderProjectPO);
    }
}
