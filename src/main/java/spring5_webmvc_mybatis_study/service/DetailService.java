package spring5_webmvc_mybatis_study.service;

import spring5_webmvc_mybatis_study.dto.Member;

public interface DetailService {

	   Member selectById(Long memid);
}
