package com.bgamq.atcrowd.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberConfirmInfoVO implements Serializable {

    // 易付宝账号
    private String paynum;
    // 法人身份证号
    private String cardnum;

}
