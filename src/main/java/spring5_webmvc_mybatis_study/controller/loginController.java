package spring5_webmvc_mybatis_study.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring5_webmvc_mybatis_study.service.AuthService;
import spring5_webmvc_mybatis_study.spring.AuthInfo;
import spring5_webmvc_mybatis_study.spring.LoginCommand;
import spring5_webmvc_mybatis_study.spring.LoginCommandValidator;
import spring5_webmvc_mybatis_study.spring.WrongIdPasswordException;

@Controller
@RequestMapping("/login")
public class loginController {
	@Autowired
	private AuthService service;
	
	@GetMapping
	public String form(LoginCommand loginCommand) {
		return "/login/loginForm";
	}
	@PostMapping
	public String submit(LoginCommand loginCommand,Errors errors, HttpSession session) {
		new LoginCommandValidator().validate(loginCommand, errors);
		if(errors.hasErrors()) {
			return "/login/loginForm";
		}
		try {
			AuthInfo authInfo = service.authenicate(loginCommand.getEmail(), loginCommand.getPassword());
			session.setAttribute("authInfo", authInfo);
			return "/login/loginSuccess";
		}catch(WrongIdPasswordException e) {
			errors.reject("idPasswordNotMatching");
			return "/login/loginForm";
		}
	}
}
