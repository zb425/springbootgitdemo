package com.bgamq.atcrowd.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class PortalProjectVO implements Serializable {

    private Integer projectId;
    private String projectName;
    private String headerPicturePath;
    private Long money;
    private String deployDate;

    private Integer percentage;
    private Integer supporter;
}
