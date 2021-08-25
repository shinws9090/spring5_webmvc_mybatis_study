package spring5_webmvc_mybatis_study.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5_webmvc_mybatis_study.dto.Member;
import spring5_webmvc_mybatis_study.mapper.MemberMapper;
import spring5_webmvc_mybatis_study.service.RestMemberService;
@Service
public class RestMemberServiceImpl implements RestMemberService{
	
	@Autowired
	private MemberMapper mapper;
	
	@Override
	public Member selectById(Long memid) {
		return mapper.selectById(memid);
	}
	@Override
	public List<Member> selectAll() {
		return mapper.selectAll();
	}
	
}
