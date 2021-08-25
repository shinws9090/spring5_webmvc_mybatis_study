package spring5_webmvc_mybatis_study.service;

import java.util.List;

import spring5_webmvc_mybatis_study.dto.Member;
import spring5_webmvc_mybatis_study.spring.ListCommand;

public interface ListService {


	List<Member> selectByRegdate(ListCommand listCommand);
}
