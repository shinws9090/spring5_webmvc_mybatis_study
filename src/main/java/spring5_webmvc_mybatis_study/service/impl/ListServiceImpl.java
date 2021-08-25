package spring5_webmvc_mybatis_study.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5_webmvc_mybatis_study.dto.Member;
import spring5_webmvc_mybatis_study.mapper.MemberMapper;
import spring5_webmvc_mybatis_study.service.ListService;
import spring5_webmvc_mybatis_study.spring.ListCommand;

@Service
public class ListServiceImpl implements ListService{

	
	@Autowired
   private MemberMapper mapper;
	@Override
   public List<Member> selectByRegdate(ListCommand listCommand) {  //요기안에 Member로 안하는 이유: 폼에서 등록안했으면 레지스터리퀘스트 쓰고 정식으로 등록된거만 멤버로 할거다. 등록안된애는 멤버로 받지않겠다. (한번더 나눠서 세분화한거임 이게 유지보수에 더 좋다. 헷갈리지 않음)
     return mapper.selectByRegdate(listCommand);
   }
   
   
}