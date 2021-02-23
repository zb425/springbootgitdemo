package com.bgamq.atcrowd.service.api;

import com.bgamq.atcrowd.po.MemberPO;

public interface MemberService {
    MemberPO getMemberPOByLoginAcct(String loginacct);
}
