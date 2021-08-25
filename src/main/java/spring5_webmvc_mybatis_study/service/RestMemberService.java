package spring5_webmvc_mybatis_study.service;

import java.util.List;

import spring5_webmvc_mybatis_study.dto.Member;

public interface RestMemberService {

	   Member selectById(Long memid);

	List<Member> selectAll();
}
