package com.bgamq.atcrowd.service.api;

import com.bgamq.atcrowd.vo.DetailProjectVO;
import com.bgamq.atcrowd.vo.PortalTypeVO;
import com.bgamq.atcrowd.vo.ProjectVO;

import java.util.List;

public interface ProjectService {
    void saveProject(ProjectVO projectVO, Integer memberId);

    List<PortalTypeVO> getPortalTypeVO();

    DetailProjectVO getDetailProjectVO(Integer projectId);
}
