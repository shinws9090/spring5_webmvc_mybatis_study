package spring5_webmvc_mybatis_study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5_webmvc_mybatis_study.dto.Member;
import spring5_webmvc_mybatis_study.mapper.MemberMapper;
import spring5_webmvc_mybatis_study.service.DetailService;

@Service
public class DetailServiceImpl implements DetailService {

	@Autowired
	private MemberMapper mapper;
	
	@Override
	public Member selectById(Long memid) {
		return mapper.selectById(memid);
	}
}
