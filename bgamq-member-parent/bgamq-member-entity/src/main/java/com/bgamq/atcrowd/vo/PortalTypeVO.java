package com.bgamq.atcrowd.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class PortalTypeVO implements Serializable {

    private Integer id;

    private String name;
    private String remark;

    private List<PortalProjectVO> portalProjectVOList;
}
