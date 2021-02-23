package com.bgamq.atcrowd.service.impl;

import com.bgamq.atcrowd.mapper.MemberPOMapper;
import com.bgamq.atcrowd.po.MemberPO;
import com.bgamq.atcrowd.po.MemberPOExample;
import com.bgamq.atcrowd.service.api.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
public class MemberServiceImpl implements MemberService {


    @Autowired
    private  MemberPOMapper memberPOMapper;

    @Override
    public MemberPO getMemberPOByLoginAcct(String loginacct) {

        MemberPOExample example = new MemberPOExample();
        MemberPOExample.Criteria criteria = example.createCriteria();
        criteria.andLoginacctEqualTo(loginacct);

        List<MemberPO> memberPOS = memberPOMapper.selectByExample(example);

        if(memberPOS == null || memberPOS.size() == 0){
            return  null;
        }

        MemberPO memberPO = memberPOS.get(0);

        return memberPO;
    }
}
