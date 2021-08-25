package spring5_webmvc_mybatis_study.mapper;

import java.util.List;

import spring5_webmvc_mybatis_study.dto.Member;
import spring5_webmvc_mybatis_study.spring.ListCommand;

public interface MemberMapper {
	public void insert(Member member);
	public void update(Member member);
	public Member selectByEmail(String email);
	public List<Member> selectByRegdate(ListCommand listCommand);
	public Member selectById(Long memId);
	List<Member> selectAll();
}
