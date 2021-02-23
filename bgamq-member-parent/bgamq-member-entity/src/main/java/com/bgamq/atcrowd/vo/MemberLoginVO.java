package com.bgamq.atcrowd.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberLoginVO implements Serializable {

    private Integer id;
    private String username;
    private String email;

}
