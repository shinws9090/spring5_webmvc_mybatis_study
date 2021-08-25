package spring5_webmvc_mybatis_study.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring5_webmvc_mybatis_study.dto.Member;
import spring5_webmvc_mybatis_study.service.MemberRegisterService;
import spring5_webmvc_mybatis_study.service.RestMemberService;
import spring5_webmvc_mybatis_study.spring.DuplicateMemberException;
import spring5_webmvc_mybatis_study.spring.ErrorResponce;
import spring5_webmvc_mybatis_study.spring.MemberNotFoundException;
import spring5_webmvc_mybatis_study.spring.RegisterRequest;
import spring5_webmvc_mybatis_study.spring.RegisterRequestValidator;

@RestController
public class RestMemberController {
	@Autowired
	private RestMemberService service;

	@Autowired
	private MemberRegisterService sservice;

	@GetMapping("api/members")
	public List<Member> members() {
		return service.selectAll();
	}

	@GetMapping("api/members/{id}")
	public ResponseEntity<Object> member(@PathVariable Long id, HttpServletResponse response) throws IOException {
		Member member = service.selectById(id);
		if (member == null) {
//			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			throw new MemberNotFoundException();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponce("no member"));
	}
	@ExceptionHandler(MemberNotFoundException.class)
	public ResponseEntity<Object> noMember(){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponce("no member"));
	}

	@PostMapping("/api/members")
	public void newMember(@Valid @RequestBody RegisterRequest regReq, Errors errors, HttpServletResponse response)
			throws IOException {

		try {
			new RegisterRequestValidator().validate(regReq, errors);
			if (errors.hasErrors()) {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST);
				return;
			}
			Long newMemberId = sservice.regist(regReq);
			response.setHeader("Location", "/api/members/" + newMemberId);
			response.setStatus(HttpServletResponse.SC_CREATED);
		} catch (DuplicateMemberException e) {
			response.sendError(HttpServletResponse.SC_CONFLICT);
		}

	}
}
