package spring5_webmvc_mybatis_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import spring5_webmvc_mybatis_study.dto.Member;
import spring5_webmvc_mybatis_study.service.DetailService;
import spring5_webmvc_mybatis_study.spring.MemberNotFoundException;

@Controller
public class MemeberDerailController {
	
	@Autowired
	private DetailService service;
	
	@GetMapping("/members/{id}")
	public ModelAndView detail(@PathVariable("id")Long memId) { //@PathVariable get방식의 값을 가져오는것
		Member member = service.selectById(memId);
		if(member ==null) {
			throw new MemberNotFoundException();
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("member",member);
		mav.setViewName("member/memberDetail");
		return mav;
	}
}
